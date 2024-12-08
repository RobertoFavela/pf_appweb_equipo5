/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.AncladoDAO;
import EntidadesSQL.Anclado;
import EntidadesSQL.Post;
import interfaces.IAncladoDAO;
import java.util.List;

public class AncladoBean {
    
    private static AncladoBean instancia;
    private final IAncladoDAO ancladoDAO;
    
    public static synchronized AncladoBean getInstancia() {
        if (instancia == null) {
            instancia = new AncladoBean();
        }
        return instancia;
    }
    
    private AncladoBean() {
        ancladoDAO = new AncladoDAO();
    }
    
    public void guardar(Anclado anclado) {
        ancladoDAO.guardar(anclado);
    }
    
    public void eliminar(String nombre) {
        ancladoDAO.eliminar(nombre);
    }
    
    public Anclado buscarPorTitulo(String nombre) {
        return ancladoDAO.buscarPorTitulo(nombre);
    }
    
    public List<Anclado> buscarTodos() {
        return ancladoDAO.buscarTodos();
    }
    
    public void actualizar(Anclado anclado) {
        
        ancladoDAO.actualizar(anclado);
        
    }
    
    
}
