/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package Beans;
import DAOsSQL.EstadoDAO;
import EntidadesSQL.Estado;
import interfaces.IEstadoDAO;
import java.util.List;

public class EstadoBean {
    private IEstadoDAO estadoDAO;
    private Estado estado;
    private List<Estado> listaEstados;
    
    public void init() {
        estadoDAO = new EstadoDAO();
        estado = new Estado();
        listaEstados = estadoDAO.buscarTodosLosEstados();
    }

    public void guardar() {
        estadoDAO.guardar(estado);
        estado = new Estado();
        listaEstados = estadoDAO.buscarTodosLosEstados(); 
    }

    public void eliminar(int id) {
        estadoDAO.eliminar(id);
        listaEstados = estadoDAO.buscarTodosLosEstados(); 
    }

    public Estado buscarPorId(int id) {
        return estadoDAO.buscarEstadoPorId(id);
    }

    public Estado buscarPorNombre(String nombre) {
        return estadoDAO.buscarEstadoPorNombre(nombre);
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
