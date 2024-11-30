/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPerfil;

import Beans.AdminBean;
import Beans.NormalBean;
import EntidadesSQL.Admin;
import EntidadesSQL.Normal;
import EntidadesSQL.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author favel
 */
public class UserProfileModController extends HttpServlet {

     private NormalBean normalBean;
     private AdminBean adminBean;

     public UserProfileModController() {
          normalBean = NormalBean.getInstancia();
          adminBean = AdminBean.getInstancia();
     }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     /**
      * Handles the HTTP <code>GET</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

          Normal normalActual = normalBean.getUsuarioEnSesion();
          Admin adminActual = adminBean.getAdminEnSesion();

          if (normalActual != null) {
               request.setAttribute("nombreCompleto", normalActual.getNombreCompleto());
               request.setAttribute("descripcion", normalActual.getDescripcion());
               request.setAttribute("telefono", normalActual.getTelefono());
               request.setAttribute("ciudad", normalActual.getCiudad());
               request.setAttribute("genero", normalActual.getGenero());
               request.setAttribute("fechaNacimiento", normalActual.getFechaNacimiento());
               request.setAttribute("municipioId", normalActual.getMunicipioId());
          } else if (adminActual != null) {
               request.setAttribute("nombreCompleto", adminActual.getNombreCompleto());
               request.setAttribute("descripcion", adminActual.getDescripcion());
               request.setAttribute("telefono", adminActual.getTelefono());
               request.setAttribute("ciudad", adminActual.getCiudad());
               request.setAttribute("genero", adminActual.getGenero());
               request.setAttribute("fechaNacimiento", adminActual.getFechaNacimiento());
               request.setAttribute("municipioId", adminActual.getMunicipioId());
          }
         response.sendRedirect("UserProfileController");
     }

     /**
      * Handles the HTTP <code>POST</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

          String accion = request.getParameter("actualizar");

          if ("actualizar".equals(accion)) {
               String nombreCompleto = request.getParameter("nombreCompleto");
               String descripcion = request.getParameter("descripcion");
               String telefono = request.getParameter("telefono");
               String ciudad = request.getParameter("ciudad");
               String municipioId = request.getParameter("municipioId");
               String genero = request.getParameter("genero");
               String fechaNacimiento = request.getParameter("fechaNacimiento");

               Normal normalActual = normalBean.getUsuarioEnSesion();
               Admin adminActual = adminBean.getAdminEnSesion();

               if (normalActual != null) {
                    normalActual.setNombreCompleto(nombreCompleto);
                    normalActual.setDescripcion(descripcion);
                    normalActual.setTelefono(telefono);
                    normalActual.setCiudad(ciudad);
                    normalActual.setGenero(genero);
                    normalActual.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));

                    normalBean.actualizar(normalActual);
                    normalBean.setUsuarioEnSesion(normalActual);
               } else if (adminActual != null) {
                    adminActual.setNombreCompleto(nombreCompleto);
                    adminActual.setDescripcion(descripcion);
                    adminActual.setTelefono(telefono);
                    adminActual.setCiudad(ciudad);
                    adminActual.setGenero(genero);
                    adminActual.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));

                    adminBean.actualizar(adminActual);
                    adminBean.setAdminEnSesion(adminActual);
               }
               response.sendRedirect("UserProfileController");
          }
     }

     /**
      * Returns a short description of the servlet.
      *
      * @return a String containing servlet description
      */
     @Override
     public String getServletInfo() {
          return "Short description";
     }// </editor-fold>

}
