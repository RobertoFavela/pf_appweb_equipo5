/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.NormalDAO;
import EntidadesSQL.Normal;
import interfaces.INormalDAO;
import java.util.List;

public class NormalBean {

     private static NormalBean instancia;
     private INormalDAO normalDAO;
     private Normal normal;
     private List<Normal> listaNormales;

     public static synchronized NormalBean getInstancia() {
          if (instancia == null) {
               instancia = new NormalBean();
          }
          return instancia;
     }

     public void init() {
          normalDAO = new NormalDAO();
          normal = new Normal();
          listaNormales = normalDAO.buscarTodos();
     }

     public void guardar() {
          normalDAO.guardar(normal);
          normal = new Normal();
          listaNormales = normalDAO.buscarTodos();
     }

     public void eliminar(int id) {
          normalDAO.eliminar(id);
          listaNormales = normalDAO.buscarTodos();
     }

     public Normal buscarPorId(int id) {
          return normalDAO.buscarPorId(id);
     }

     public List<Normal> getListaNormales() {
          return listaNormales;
     }

     public Normal getNormal() {
          return normal;
     }

     public void setNormal(Normal normal) {
          this.normal = normal;
     }
}
