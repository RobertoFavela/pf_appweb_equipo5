package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Usuario;
import interfaces.IUsuarioDAO;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 *
 * @author tacot
 */
public class UsuarioDAO implements IUsuarioDAO {

     private final EntityManager entityManager;
     private final ConexionDB conexion;

     public UsuarioDAO() {
          this.conexion = ConexionDB.getInstancia();
          this.entityManager = conexion.getEntityManager();
     }

     @Override
     public void guardar(Usuario usuario) {
          entityManager.getTransaction().begin();
          entityManager.persist(usuario);
          entityManager.getTransaction().commit();
     }
     @Override
     public boolean autenticacion(Usuario usuario) {
          try {
               CriteriaBuilder cb = entityManager.getCriteriaBuilder();
               CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
               Root<Usuario> root = query.from(Usuario.class);

               Predicate correoPredicate = cb.equal(root.get("correo"), usuario.getCorreo());
               Predicate contraseniaPredicate = cb.equal(root.get("contrasenia"), usuario.getContrasenia());

               query.select(root).where(cb.and(correoPredicate, contraseniaPredicate));

               List<Usuario> usuarios = entityManager.createQuery(query).getResultList();

               return !usuarios.isEmpty();
          } catch (Exception e) {
               e.printStackTrace();
               return false;
          }
     }

     @Override
     public List<Usuario> buscarTodos() {
          CriteriaBuilder cb = entityManager.getCriteriaBuilder();
          CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
          Root<Usuario> root = query.from(Usuario.class);
          query.select(root);
          return entityManager.createQuery(query).getResultList();
     }

     @Override
     public Usuario buscarPorId(Integer id) {
          CriteriaBuilder cb = entityManager.getCriteriaBuilder();
          CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
          Root<Usuario> root = query.from(Usuario.class);
          query.select(root).where(cb.equal(root.get("id"), id));
          return entityManager.createQuery(query).getSingleResult();
     }

     @Override
     public Usuario buscarPorNombre(String nombre) {
          CriteriaBuilder cb = entityManager.getCriteriaBuilder();
          CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
          Root<Usuario> root = query.from(Usuario.class);
          query.select(root).where(cb.like(root.get("nombreCompleto"), "%" + nombre + "%"));
          return entityManager.createQuery(query).getSingleResult();
     }

     @Override
     public void actualizar(Usuario usuario) {
          entityManager.getTransaction().begin();
          entityManager.merge(usuario);
          entityManager.getTransaction().commit();
     }

     @Override
     public void eliminar(Integer id) {
          entityManager.getTransaction().begin();
          Usuario usuario = buscarPorId(id);
          if (usuario != null) {
               entityManager.remove(usuario);
          }
          entityManager.getTransaction().commit();
     }

}
