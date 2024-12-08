/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorGestionSerie;

import Beans.AdminBean;
import Beans.ComunBean;
import Beans.NormalBean;
import Beans.SerieBean;
import EntidadesSQL.Admin;
import EntidadesSQL.Comun;
import EntidadesSQL.Normal;
import EntidadesSQL.Post;
import EntidadesSQL.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author favel
 */
public class SerieProfileController extends HttpServlet {

     NormalBean normalBean;
     AdminBean adminBean;
     SerieBean serieBean;

     ComunBean comunBean;

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
          String serieId = request.getParameter("id");

          serieBean = SerieBean.getInstancia();
          adminBean = AdminBean.getInstancia();
          Admin adminActual = adminBean.getAdminEnSesion();
          normalBean = NormalBean.getInstancia();
          Normal normalActual = normalBean.getUsuarioEnSesion();

          boolean esAdmin = adminBean.getAdminEnSesion() != null;
          request.setAttribute("esAdmin", esAdmin);

          if (serieId == null || serieId.isEmpty()) {
               response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro 'id' de la serie.");
               return;
          }

          try {
               int id = Integer.parseInt(serieId);
               Serie serie = serieBean.buscarPorId(id);

               if (serie == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Serie no encontrada.");
                    return;
               }

               comunBean = ComunBean.getInstancia();
               List<Comun> posts = comunBean.buscarTodos();

               List<Serie> seriesSimilares = serieBean.buscarPorGeneros(serie.getGenero()); 
               
               request.setAttribute("serie", serie);
               request.setAttribute("posts", posts);
               request.setAttribute("seriesSimilares", seriesSimilares); 

               request.getRequestDispatcher("/SeriesProfileView.jsp").forward(request, response);

          } catch (NumberFormatException e) {
               response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El parámetro 'id' debe ser un número entero.");
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
          String serieId = request.getParameter("id");
          String accion = request.getParameter("accion"); // para agregar o eliminar

          normalBean = NormalBean.getInstancia();
          Normal normalActual = normalBean.getUsuarioEnSesion();
          adminBean = AdminBean.getInstancia();
          Admin adminActual = adminBean.getAdminEnSesion();

          if (normalActual == null) {
               response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Debe iniciar sesión para agregar una serie a favoritas."); // este es porque no le puedo meter el if al jsp, no le quiero mover mas al front
               return;
          }

          if (serieId == null || serieId.isEmpty()) {
               response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro 'id' de la serie.");
               return;
          }

          try {
               int id = Integer.parseInt(serieId);

               if ("agregar".equals(accion)) {
                    normalBean.agregarSerieFavorita(id);  // Llamamos al método para agregar la serie a favoritas
               } else if ("eliminar".equals(accion)) {
                    normalBean.eliminarSerieFavorita(id);  // Llamamos al método para eliminarla de favoritas
               } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida.");
                    return;
               }

          } catch (NumberFormatException e) {
               // Manejo de error en caso de que el ID de la serie no sea un número válido
               response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El parámetro 'id' debe ser un número entero.");
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
