package DAOsSQL;
import ConexionSQL.ConexionDB;
import EntidadesSQL.Estado;
import EntidadesSQL.Municipio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author tacot
 */
public class EstadoDAO {
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public EstadoDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }
 
    public void guardar(Estado estado) {
        entityManager.getTransaction().begin();
        entityManager.persist(estado);
        entityManager.getTransaction().commit();
    }
    
    public List<Estado> buscarTodosLosEstados() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estado> query = cb.createQuery(Estado.class);
        Root<Estado> root = query.from(Estado.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Estado buscarEstadoPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estado> query = cb.createQuery(Estado.class);
        Root<Estado> root = query.from(Estado.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }
    
    public Estado buscarEstadoPorNombre(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estado> query = cb.createQuery(Estado.class);
        Root<Estado> root = query.from(Estado.class);
        query.select(root).where(cb.equal(root.get("nombre"), nombre));
        return entityManager.createQuery(query).getSingleResult();
    }
    
    public void actualizar(Estado estado) {
        entityManager.getTransaction().begin();
        entityManager.merge(estado);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Estado estado = buscarEstadoPorId(id);
        if (estado != null) {
            entityManager.remove(estado);
        }
        entityManager.getTransaction().commit();
    }
    
}
