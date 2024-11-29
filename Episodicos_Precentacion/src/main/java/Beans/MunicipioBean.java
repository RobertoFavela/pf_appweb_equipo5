package Beans;

import DAOsSQL.MunicipioDAO;
import EntidadesSQL.Municipio;
import interfaces.IMunicipioDAO;
import java.util.List;

/**
 *
 * @author tacot
 */
public class MunicipioBean {
    
    private static MunicipioBean instancia;
    private final IMunicipioDAO municipioDAO;
    
    public static synchronized MunicipioBean getInstancia() {
        if (instancia == null) {
            instancia = new MunicipioBean();
        }
        return instancia;
    }
    
    private MunicipioBean() {
        municipioDAO = new MunicipioDAO();
    }
    
    public void guardar(Municipio municipio) {
        municipioDAO.guardar(municipio);
    }
    
    public List<Municipio> buscarTodos() {
        return municipioDAO.buscarTodos();
    }
    
    public void eliminar(String nombre) {
        municipioDAO.eliminar(nombre);
    }
    
    public Municipio buscarPorId(int id) {
        return municipioDAO.buscarPorId(id);
    }
    
    public Municipio buscarPorNombre(String nombre) {
        return municipioDAO.buscarPorNombre(nombre);
    }
    
    public void actualizar(Municipio municipio) {
        municipioDAO.actualizar(municipio);
    }
}
