package DAOsSQL;
import EntidadesSQL.Estado;
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
    private EntityManager entityManager;

    public EstadoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    
    public List<Estado> BuscarTodosLosEstados() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estado> query = cb.createQuery(Estado.class);
        Root<Estado> root = query.from(Estado.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Estado BuscarEstadoPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estado> query = cb.createQuery(Estado.class);
        Root<Estado> root = query.from(Estado.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }
    
    public Estado BuscarEstadoPorNombre(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estado> query = cb.createQuery(Estado.class);
        Root<Estado> root = query.from(Estado.class);
        query.select(root).where(cb.equal(root.get("nombre"), nombre));
        return entityManager.createQuery(query).getSingleResult();
    }
    
}
