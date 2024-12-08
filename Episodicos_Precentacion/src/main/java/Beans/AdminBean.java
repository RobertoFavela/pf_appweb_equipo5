/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.AdminDAO;
import EntidadesSQL.Admin;
import interfaces.IAdminDAO;
import java.util.List;

public class AdminBean {

     private static AdminBean instancia;
     private IAdminDAO adminDAO;
     private Admin adminEnSesion;

     public static synchronized AdminBean getInstancia() {
          if (instancia == null) {
               instancia = new AdminBean();
          }
          return instancia;
     }

     private AdminBean() {
          adminDAO = new AdminDAO();
     }

     public void guardar(Admin admin) {
          adminDAO.guardar(admin);
     }

     public void eliminar(String nombre) {
          adminDAO.eliminar(nombre);
     }

     public Admin buscarPorCredenciales(String correo, String contrasena) {
          List<Admin> admins = adminDAO.buscarPorCorreo(correo);
          for (Admin admin : admins) {
               if (admin.getContrasenia().equals(contrasena)) {
                    return admin;
               }
          }
          return null;
     }

     public Admin buscarPorId(String nombre) {
          return adminDAO.buscarPorNombre(nombre);
     }

     public List<Admin> buscarTodos() {
          return adminDAO.buscarTodos();
     }

     public void actualizar(Admin admin) {
          adminDAO.actualizar(admin);
     }

     public void setAdminEnSesion(Admin admin) {
          this.adminEnSesion = admin;
     }

     public Admin getAdminEnSesion() {
          return adminEnSesion;
     }

     public void agregarSerieFavorita(Integer serieId) {
          if (adminEnSesion != null) {
               adminDAO.agregarSerieFavorita(adminEnSesion, serieId);
          } else {
               throw new IllegalStateException("No hay un administrador en sesión.");
          }
     }

     public void eliminarSerieFavorita(Integer serieId) {
          if (adminEnSesion != null) {
               adminDAO.eliminarSerieFavorita(adminEnSesion, serieId);
          } else {
               throw new IllegalStateException("No hay un administrador en sesión.");
          }
     }

     public List<Integer> obtenerSeriesFavoritas() {
          if (adminEnSesion != null) {
               return adminDAO.obtenerSeriesFavoritas(adminEnSesion);
          } else {
               throw new IllegalStateException("No hay un administrador en sesión.");
          }
     }
}
