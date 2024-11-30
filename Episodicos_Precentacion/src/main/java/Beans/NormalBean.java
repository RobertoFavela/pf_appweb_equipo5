package Beans;

import DAOsSQL.NormalDAO;
import EntidadesSQL.Normal;
import interfaces.INormalDAO;
import java.util.List;

public class NormalBean {

     private static NormalBean instancia;
     private final INormalDAO normalDAO;

     private NormalBean() {
          normalDAO = new NormalDAO();
     }

     public static synchronized NormalBean getInstancia() {
          if (instancia == null) {
               instancia = new NormalBean();
          }
          return instancia;
     }

     public void guardar(Normal normal) {
          normalDAO.guardar(normal);
     }

     public List<Normal> buscarTodos() {
          return normalDAO.buscarTodos();
     }

     public Normal buscarPorCredenciales(String correo, String contrasena) {
          List<Normal> normales = normalDAO.buscarPorCorreo(correo);
          for (Normal normal : normales) {
               if (normal.getContrasenia().equals(contrasena)) {
                    return normal;
               }
          }
          return null;
     }

     public Normal buscarPorNombre(String nombre) {
          return normalDAO.buscarPorNombre(nombre);
     }

     public void actualizar(Normal normal) {
          normalDAO.actualizar(normal);
     }

     public void eliminar(String nombre) {
          normalDAO.eliminar(nombre);
     }
}
