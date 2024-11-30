/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPerfil;

import Beans.NormalBean;
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
          normalBean = NormalBean.getInstancia();
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
          request.getRequestDispatcher("/UserProfileModView.jsp").forward(request, response);
          Normal usuarioActual = normalBean.getUsuarioEnSesion();
          System.out.println("Usuario en sesión: " + usuarioActual);

          if (usuarioActual != null) {
               String nombreCompleto = usuarioActual.getNombreCompleto();
               System.out.println(nombreCompleto);
               request.setAttribute("nombreCompleto", usuarioActual.getNombreCompleto());
               request.setAttribute("telefono", usuarioActual.getTelefono());
               request.setAttribute("ciudad", usuarioActual.getCiudad());
               request.setAttribute("genero", usuarioActual.getGenero());
               request.setAttribute("fechaNacimiento", usuarioActual.getFechaNacimiento());
               request.setAttribute("municipioId", usuarioActual.getMunicipioId());
          }
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
               String telefono = request.getParameter("telefono");
               String ciudad = request.getParameter("ciudad");
               String municipioId = request.getParameter("municipioId");
               String genero = request.getParameter("genero");
               String fechaNacimiento = request.getParameter("fechaNacimiento");

               Normal usuarioActual = normalBean.getUsuarioEnSesion();

               if (usuarioActual != null) {
                    usuarioActual.setNombreCompleto(nombreCompleto);
                    usuarioActual.setTelefono(telefono);
                    usuarioActual.setCiudad(ciudad);
                    usuarioActual.setGenero(genero);
                    usuarioActual.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));

                    normalBean.actualizar(usuarioActual);
                    normalBean.setUsuarioEnSesion(usuarioActual);
               }
               response.sendRedirect("GestionPerfil.jsp");
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

