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

     public UserProfileModController() {

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
          normalBean = NormalBean.getInstancia();
          Normal normalActual = normalBean.getUsuarioEnSesion();

          if (normalActual != null) {
               request.setAttribute("nombreCompleto", normalActual.getNombreCompleto());
               request.setAttribute("descripcion", normalActual.getDescripcion());
               request.setAttribute("telefono", normalActual.getTelefono());
               request.setAttribute("ciudad", normalActual.getCiudad());
               request.setAttribute("genero", normalActual.getGenero());
               request.setAttribute("fechaNacimiento", normalActual.getFechaNacimiento());
               request.setAttribute("municipioId", normalActual.getMunicipioId());
          }
          response.sendRedirect("/UserProfileModView.jsp");
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

               if (normalActual != null) {
                    normalActual.setNombreCompleto(nombreCompleto);
                    normalActual.setDescripcion(descripcion);
                    normalActual.setTelefono(telefono);
                    normalActual.setCiudad(ciudad);
                    normalActual.setGenero(genero);
                    normalActual.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));

                    normalBean.actualizar(normalActual);
                    normalBean.setUsuarioEnSesion(normalActual);
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
