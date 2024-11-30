package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Normal;
import EntidadesSQL.Usuario;
import interfaces.INormalDAO;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 *
 * @author tacot
 */
public class NormalDAO implements INormalDAO {

     private final EntityManager entityManager;
     private final ConexionDB conexion;

     public NormalDAO() {
          this.conexion = ConexionDB.getInstancia();
          this.entityManager = conexion.getEntityManager();
     }

     @Override
     public void guardar(Normal normal) {
          entityManager.getTransaction().begin();
          Usuario usuario = new Usuario(
                  normal.getNombreCompleto(),
                  normal.getCorreo(),
                  normal.getContrasenia(),
                  normal.getTelefono(),
                  normal.getCiudad(),
                  normal.getFechaNacimiento(),
                  normal.getGenero(),
                  normal.getMunicipioId()
          );
          entityManager.persist(usuario);
          entityManager.getTransaction().commit();
     }

     @Override
     public List<Normal> buscarTodos() {
          CriteriaBuilder cb = entityManager.getCriteriaBuilder();
          CriteriaQuery<Normal> query = cb.createQuery(Normal.class);
          Root<Normal> root = query.from(Normal.class);
          query.select(root);
          return entityManager.createQuery(query).getResultList();
     }

     @Override
     public Normal buscarPorNombre(String nombre) {
          CriteriaBuilder cb = entityManager.getCriteriaBuilder();
          CriteriaQuery<Normal> query = cb.createQuery(Normal.class);
          Root<Normal> root = query.from(Normal.class);
          query.select(root).where(cb.equal(root.get("nombreCompleto"), nombre));
          return entityManager.createQuery(query).getSingleResult();
     }

     public List<Normal> buscarPorCorreo(String correo) {
          CriteriaBuilder cb = entityManager.getCriteriaBuilder();
          CriteriaQuery<Normal> query = cb.createQuery(Normal.class);
          Root<Normal> root = query.from(Normal.class);
          query.select(root).where(cb.equal(root.get("correo"), correo));
          return entityManager.createQuery(query).getResultList();
     }

     @Override
     public void actualizar(Normal normal) {
          entityManager.getTransaction().begin();
          entityManager.merge(normal);
          entityManager.getTransaction().commit();
     }

     @Override
     public void eliminar(String nombre) {
          entityManager.getTransaction().begin();
          Normal normal = buscarPorNombre(nombre);
          if (normal != null) {
               entityManager.remove(normal);
          }
          entityManager.getTransaction().commit();
     }
}
