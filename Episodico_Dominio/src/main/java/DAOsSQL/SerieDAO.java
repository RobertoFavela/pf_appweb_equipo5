package DAOsSQL;
import ConexionSQL.ConexionDB;
import EntidadesSQL.Serie;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author tacot
 */
public class SerieDAO {
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public SerieDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    public void guardar(Serie serie) {
        entityManager.getTransaction().begin();
        entityManager.persist(serie);
        entityManager.getTransaction().commit();
    }

    public List<Serie> buscarTodas() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
        Root<Serie> root = query.from(Serie.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Serie buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
        Root<Serie> root = query.from(Serie.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Serie> buscarPorTitulo(String titulo) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
        Root<Serie> root = query.from(Serie.class);
        query.select(root).where(cb.like(root.get("titulo"), "%" + titulo + "%"));
        return entityManager.createQuery(query).getResultList();
    }

    public void actualizar(Serie serie) {
        entityManager.getTransaction().begin();
        entityManager.merge(serie);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Serie serie = buscarPorId(id);
        if (serie != null) {
            entityManager.remove(serie);
        }
        entityManager.getTransaction().commit();
    }
}