package DAOsSQL;

import EntidadesSQL.Municipio;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class MunicipioDAO {

    private EntityManager entityManager;

    public MunicipioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Municipio> BuscarTodosLosMunicipios() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Municipio BuscarMunicipiosPorId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }
    
    public Municipio BuscarMunicipiosPorNombre(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> query = cb.createQuery(Municipio.class);
        Root<Municipio> root = query.from(Municipio.class);
        query.select(root).where(cb.equal(root.get("nombre"), nombre));
        return entityManager.createQuery(query).getSingleResult();
    }
}
