/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.ComunDAO;
import EntidadesSQL.Comun;
import interfaces.IComunDAO;
import java.util.List;

/**
 *
 * @author tacot
 */
public class ComunBean {

     private static ComunBean instancia;
     private IComunDAO comunDAO;

     public static synchronized ComunBean getInstancia() {
          if (instancia == null) {
               instancia = new ComunBean();
          }
          return instancia;
     }

     private ComunBean() {
          comunDAO = new ComunDAO();
     }

     public void guardar(Comun comun) {
          comunDAO.guardar(comun);
     }

     public List<Comun> buscarTodos(){
         return comunDAO.buscarTodos();
     }
     
     public Comun buscarPorTitulo(String nombre){
         return comunDAO.buscarPorTitulo(nombre);
     }
     
     public void actualizar(Comun comun){
         comunDAO.actualizar(comun);
     }
     
     public void eliminar(String nombre) {
          comunDAO.eliminar(nombre);
     }

}
