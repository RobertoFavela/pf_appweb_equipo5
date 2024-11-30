package DAOsSQL;

import ConexionSQL.ConexionDB;
import EntidadesSQL.Municipio;
import interfaces.IMunicipioDAO;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class MunicipioDAO implements IMunicipioDAO{

    private final EntityManager entityManager;
    private final ConexionDB conexion;

    public MunicipioDAO() {
        this.conexion = ConexionDB.getInstancia();
        this.entityManager = conexion.getEntityManager();
    }

    @Override
    public void guardar(Municipio municipio) {
        entityManager.getTransaction().begin();
        entityManager.persist(municipio);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Municipio> buscarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Municipio buscarPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public Municipio buscarPorNombre(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root).where(cb.like(root.get("nombre"), "%" + nombre + "%"));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void actualizar(Municipio municipio) {
        entityManager.getTransaction().begin();
        entityManager.merge(municipio);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(String nombre) {
        entityManager.getTransaction().begin();
        Municipio municipio = buscarPorNombre(nombre);
        if (municipio != null) {
            entityManager.remove(municipio);
        }
        entityManager.getTransaction().commit();
    }
}
