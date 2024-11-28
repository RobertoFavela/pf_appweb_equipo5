package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Post;
import interfaces.IPostDAO;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author tacot
 */
public class PostDAO implements IPostDAO{
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public PostDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }
    
    @Override
    public void guardar(Post post) {
        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Post> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = cb.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Post buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = cb.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Post> buscarPorTitulo(String titulo) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = cb.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root).where(cb.like(root.get("titulo"), "%" + titulo + "%"));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void actualizar(Post post) {
        entityManager.getTransaction().begin();
        entityManager.merge(post);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Post post = buscarPorId(id);
        if (post != null) {
            entityManager.remove(post);
        }
        entityManager.getTransaction().commit();
    }
}