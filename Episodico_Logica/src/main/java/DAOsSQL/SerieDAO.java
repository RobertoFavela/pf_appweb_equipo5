package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Serie;
import interfaces.ISerieDAO;
import java.util.Date;
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
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Serie> query = cb.createQuery(Serie.class);
            Root<Serie> root = query.from(Serie.class);
            query.select(root);
            return entityManager.createQuery(query).getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
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

        Serie serieAux = buscarPorTitulo(serie.getTitulo());
        
        Serie serieExistente = entityManager.find(Serie.class, serieAux.getId());

        if (serie.getTitulo() != null) {
            serieExistente.setTitulo(serie.getTitulo());
        }
        if (serie.getDescripcion() != null) {
            serieExistente.setDescripcion(serie.getDescripcion());
        }
        if (serie.getGenero() != null) {
            serieExistente.setGenero(serie.getGenero());
        }
        if (serie.getFechaEstreno() != null) {
            serieExistente.setFechaEstreno(serie.getFechaEstreno());
        }
        if (serie.getImagen() != null) {
            serieExistente.setImagen(serie.getImagen());
        }

        entityManager.getTransaction().begin();
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(String nombre) {
        entityManager.getTransaction().begin();
        Serie serie = buscarPorTitulo(nombre);
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
        query.select(root).where(cb.like(root.get("genero"), genero));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Serie> buscarSeriesPorPeriodoDeTiempo(Date fechaInicio, Date fechaFin) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Serie> cq = cb.createQuery(Serie.class);

        Root<Serie> root = cq.from(Serie.class);

        Predicate condicion = cb.between(root.get("fechaEstreno"), fechaInicio, fechaFin);

        cq.select(root).where(condicion);

        TypedQuery<Serie> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
