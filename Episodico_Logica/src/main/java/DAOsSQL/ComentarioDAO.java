package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Comentario;
import interfaces.IComentarioDAO;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 *
 * @author tacot
 */
public class ComentarioDAO implements IComentarioDAO {

    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public ComentarioDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    @Override
    public void guardar(Comentario comentario) {
        entityManager.getTransaction().begin();
        entityManager.persist(comentario);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Comentario> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comentario> query = cb.createQuery(Comentario.class);
        Root<Comentario> root = query.from(Comentario.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void actualizar(Comentario comentario) {
        entityManager.getTransaction().begin();
        entityManager.merge(comentario);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(String contenido) {
        entityManager.getTransaction().begin();
        Comentario comentario = buscarPorContenido(contenido);
        if (comentario != null) {
            entityManager.remove(comentario);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Comentario buscarPorContenido(String contenido) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comentario> query = cb.createQuery(Comentario.class);
        Root<Comentario> root = query.from(Comentario.class);
        query.select(root).where(cb.equal(root.get("contenido"), contenido));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Comentario> buscarPorPostID(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comentario> query = cb.createQuery(Comentario.class);
        Root<Comentario> root = query.from(Comentario.class);
        query.select(root).where(cb.equal(root.get("post_id"), id));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Comentario> buscarPorComentarioID(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comentario> query = cb.createQuery(Comentario.class);
        Root<Comentario> root = query.from(Comentario.class);
        query.select(root).where(cb.equal(root.get("comentario_padre_id"), id));
        return entityManager.createQuery(query).getResultList();
    }
    
    @Override
    public List<Comentario> buscarPorUsuarioID(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comentario> query = cb.createQuery(Comentario.class);
        Root<Comentario> root = query.from(Comentario.class);
        query.select(root).where(cb.equal(root.get("usuario_id"), id));
        return entityManager.createQuery(query).getResultList();
    }
}
