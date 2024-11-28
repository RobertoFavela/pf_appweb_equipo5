package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Serie;
import interfaces.ISerieDAO;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 *
 * @author tacot
 */
public class SerieDAO implements ISerieDAO {

    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public SerieDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    @Override
    public void guardar(Serie serie) {
        entityManager.getTransaction().begin();
        entityManager.persist(serie);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Serie> buscarTodas() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
        Root<Serie> root = query.from(Serie.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Serie buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
        Root<Serie> root = query.from(Serie.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public Serie buscarPorTitulo(String titulo) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
        Root<Serie> root = query.from(Serie.class);
        query.select(root).where(cb.like(root.get("titulo"), "%" + titulo + "%"));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void actualizar(Serie serie) {
        entityManager.getTransaction().begin();
        entityManager.merge(serie);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Serie serie = buscarPorId(id);
        if (serie != null) {
            entityManager.remove(serie);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Serie> buscarPorGeneros(String genero) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
        Root<Serie> root = query.from(Serie.class);
        query.select(root).where(cb.like(root.get("genero"),genero));
        return entityManager.createQuery(query).getResultList();
    }
}