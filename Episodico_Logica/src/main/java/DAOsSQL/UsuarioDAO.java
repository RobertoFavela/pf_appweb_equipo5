package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Usuario;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 *
 * @author tacot
 */
public class UsuarioDAO {
    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public UsuarioDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    public void guardar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }

    public List<Usuario> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Usuario buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root).where(cb.like(root.get("nombreCompleto"), "%" + nombre + "%"));
        return entityManager.createQuery(query).getResultList();
    }

    public void actualizar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
        entityManager.getTransaction().commit();
    }
}
