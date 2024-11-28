/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
     private IMunicipioDAO municipioDAO;
     private Municipio municipio;
     private List<Municipio> listaMunicipios;

     public static synchronized MunicipioBean getInstancia() {
          if (instancia == null) {
               instancia = new MunicipioBean();
          }
          return instancia;
     }

     public void init() {
          municipioDAO = new MunicipioDAO();
          municipio = new Municipio();
          listaMunicipios = municipioDAO.buscarTodos();
     }

     public void guardar() {
          municipioDAO.guardar(municipio);
          municipio = new Municipio();
          listaMunicipios = municipioDAO.buscarTodos();
     }

     public void eliminar(int id) {
          municipioDAO.eliminar(id);
          listaMunicipios = municipioDAO.buscarTodos();
     }

     public Municipio buscarPorId(int id) {
          return municipioDAO.buscarPorId(id);
     }

     public Municipio buscarPorNombre(String nombre) {
          return municipioDAO.buscarPorNombre(nombre);
     }

     public List<Municipio> getListaMunicipios() {
          return listaMunicipios;
     }

     public Municipio getMunicipio() {
          return municipio;
     }

     public void setMunicipio(Municipio municipio) {
          this.municipio = municipio;
     }
}
