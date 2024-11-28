package DAOsSQL;
import ConexionSQL.ConexionDB;
import EntidadesSQL.Admin;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author tacot
 */
public class AdminDAO {
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public AdminDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    public void guardar(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
    }

    public List<Admin> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Admin> query = cb.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Admin buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Admin> query = cb.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public void actualizar(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.merge(admin);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Admin admin = buscarPorId(id);
        if (admin != null) {
            entityManager.remove(admin);
        }
        entityManager.getTransaction().commit();
    }
}
