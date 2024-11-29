package ConexionSQL;

/**
 *
 *
 * @author tacot
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class ConexionDB {

    private static ConexionDB instancia;
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private ConexionDB() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ConexionPU");

            this.entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    public static synchronized ConexionDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void cerrarConexion() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    public CriteriaBuilder obtenerCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }
}
