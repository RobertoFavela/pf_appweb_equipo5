package Beans;

import DAOsSQL.EstadoDAO;
import EntidadesSQL.Estado;
import interfaces.IEstadoDAO;
import java.util.List;

public class EstadoBean {

    private static EstadoBean instancia;
    private IEstadoDAO estadoDAO;

    public static synchronized EstadoBean getInstancia() {
        if (instancia == null) {
            instancia = new EstadoBean();
        }
        return instancia;
    }

    private EstadoBean() {
        estadoDAO = new EstadoDAO();
    }

    public void guardar(Estado estado) {
        estadoDAO.guardar(estado);
    }

    public void eliminar(String nombre) {
        estadoDAO.eliminar(nombre);
    }

    public Estado buscarPorId(int id) {
        return estadoDAO.buscarEstadoPorId(id);
    }

    public Estado buscarPorNombre(String nombre) {
        return estadoDAO.buscarEstadoPorNombre(nombre);
    }

    public void actualizar(Estado estado) {
        estadoDAO.actualizar(estado);
    }

    public List<Estado> buscarTodosLosEstados() {
        return estadoDAO.buscarTodosLosEstados();
    }

}
