package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Anclado;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author tacot
 */
public class AncladoDAO {
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public AncladoDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    public void guardar(Anclado anclado) {
        entityManager.getTransaction().begin();
        entityManager.persist(anclado);
        entityManager.getTransaction().commit();
    }

    public List<Anclado> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Anclado> query = cb.createQuery(Anclado.class);
        Root<Anclado> root = query.from(Anclado.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Anclado buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Anclado> query = cb.createQuery(Anclado.class);
        Root<Anclado> root = query.from(Anclado.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public void actualizar(Anclado anclado) {
        entityManager.getTransaction().begin();
        entityManager.merge(anclado);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Anclado anclado = buscarPorId(id);
        if (anclado != null) {
            entityManager.remove(anclado);
        }
        entityManager.getTransaction().commit();
    }
}
