package DAOsSQL;
import ConexionSQL.ConexionDB;
import EntidadesSQL.Normal;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author tacot
 */
public class NormalDAO {
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public NormalDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    public void guardar(Normal normal) {
        entityManager.getTransaction().begin();
        entityManager.persist(normal);
        entityManager.getTransaction().commit();
    }

    public List<Normal> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Normal> query = cb.createQuery(Normal.class);
        Root<Normal> root = query.from(Normal.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Normal buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Normal> query = cb.createQuery(Normal.class);
        Root<Normal> root = query.from(Normal.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public void actualizar(Normal normal) {
        entityManager.getTransaction().begin();
        entityManager.merge(normal);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Normal normal = buscarPorId(id);
        if (normal != null) {
            entityManager.remove(normal);
        }
        entityManager.getTransaction().commit();
    }
}
