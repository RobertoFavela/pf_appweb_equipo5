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
public class ComentarioDAO implements IComentarioDAO{
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
    public Comentario buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comentario> query = cb.createQuery(Comentario.class);
        Root<Comentario> root = query.from(Comentario.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void actualizar(Comentario comentario) {
        entityManager.getTransaction().begin();
        entityManager.merge(comentario);
        entityManager.getTransaction().commit();
    }
    
    @Override
    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Comentario comentario = buscarPorId(id);
        if (comentario != null) {
            entityManager.remove(comentario);
        }
        entityManager.getTransaction().commit();
    }
}