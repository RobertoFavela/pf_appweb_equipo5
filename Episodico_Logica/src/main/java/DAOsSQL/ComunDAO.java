package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Comun;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author tacot
 */
public class ComunDAO {
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public ComunDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    public void guardar(Comun comun) {
        entityManager.getTransaction().begin();
        entityManager.persist(comun);
        entityManager.getTransaction().commit();
    }

    public List<Comun> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comun> query = cb.createQuery(Comun.class);
        Root<Comun> root = query.from(Comun.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Comun buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comun> query = cb.createQuery(Comun.class);
        Root<Comun> root = query.from(Comun.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public void actualizar(Comun comun) {
        entityManager.getTransaction().begin();
        entityManager.merge(comun);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Comun comun = buscarPorId(id);
        if (comun != null) {
            entityManager.remove(comun);
        }
        entityManager.getTransaction().commit();
    }
}
