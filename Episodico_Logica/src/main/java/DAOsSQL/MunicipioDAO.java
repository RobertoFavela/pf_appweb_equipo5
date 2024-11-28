package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Municipio;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class MunicipioDAO {

    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public MunicipioDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    public void guardar(Municipio municipio) {
        entityManager.getTransaction().begin();
        entityManager.persist(municipio);
        entityManager.getTransaction().commit();
    }

    public List<Municipio> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Municipio buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Municipio> buscarPorNombre(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root).where(cb.like(root.get("nombre"), "%" + nombre + "%"));
        return entityManager.createQuery(query).getResultList();
    }

    public void actualizar(Municipio municipio) {
        entityManager.getTransaction().begin();
        entityManager.merge(municipio);
        entityManager.getTransaction().commit();
    }

    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Municipio municipio = buscarPorId(id);
        if (municipio != null) {
            entityManager.remove(municipio);
        }
        entityManager.getTransaction().commit();
    }
}
