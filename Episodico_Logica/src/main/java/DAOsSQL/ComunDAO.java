package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Comun;
import interfaces.IComunDAO;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author tacot
 */
public class ComunDAO implements IComunDAO{
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public ComunDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    @Override
    public void guardar(Comun comun) {
        entityManager.getTransaction().begin();
        entityManager.persist(comun);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Comun> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comun> query = cb.createQuery(Comun.class);
        Root<Comun> root = query.from(Comun.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Comun buscarPorTitulo(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comun> query = cb.createQuery(Comun.class);
        Root<Comun> root = query.from(Comun.class);
        query.select(root).where(cb.equal(root.get("titulo"), nombre));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void actualizar(Comun comun) {
        entityManager.getTransaction().begin();
        entityManager.merge(comun);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(String nombre) {
        entityManager.getTransaction().begin();
        Comun comun = buscarPorTitulo(nombre);
        if (comun != null) {
            entityManager.remove(comun);
        }
        entityManager.getTransaction().commit();
    }
}
