/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPerfil;

import Beans.AdminBean;
import Beans.ComunBean;
import Beans.NormalBean;
import Beans.SerieBean;
import EntidadesSQL.Admin;
import EntidadesSQL.Comun;
import EntidadesSQL.Normal;
import EntidadesSQL.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tacot
 */
public class UserProfileController extends HttpServlet {

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

          // Obtener la sesión y rellenar los campos
          adminBean = AdminBean.getInstancia();
          Admin adminActual = adminBean.getAdminEnSesion();
          normalBean = NormalBean.getInstancia();
          Normal normalActual = normalBean.getUsuarioEnSesion();
          serieBean = SerieBean.getInstancia();

          // Verificar si es admin
          boolean esAdmin = adminBean.getAdminEnSesion() != null;
          request.setAttribute("esAdmin", esAdmin);

          if (normalActual != null) {
               request.setAttribute("nombreCompleto", normalActual.getNombreCompleto());
               request.setAttribute("descripcion", normalActual.getDescripcion());
          } else if (adminActual != null) {
               request.setAttribute("nombreCompleto", adminActual.getNombreCompleto());
               request.setAttribute("descripcion", adminActual.getDescripcion());
          }

          // Buscar todos los objetos para los posts
          comunBean = ComunBean.getInstancia();
          List<Comun> todosLosComun = comunBean.buscarTodos();

          // Filtrar los posts del usuario en sesión
          int usuarioId = (normalActual != null) ? normalActual.getId() : adminActual.getId();
          List<Comun> post = todosLosComun.stream()
                  .filter(comun -> comun.getId() == usuarioId)
                  .collect(Collectors.toList());

          List<Integer> seriesFavoritasIds;
          if (esAdmin) {
               seriesFavoritasIds = adminBean.obtenerSeriesFavoritas(); // Obtener series favoritas del admin
          } else {
               seriesFavoritasIds = normalBean.obtenerSeriesFavoritas(); // Obtener series favoritas del normal
          }

          List<Serie> todasLasSeries = serieBean.buscarTodas();
          List<Serie> seriesFavoritas = todasLasSeries.stream()
                  .filter(serie -> seriesFavoritasIds.contains(serie.getId()))
                  .collect(Collectors.toList());

          
          // Pasar la lista de series favoritas como atributo a la JSP
          request.setAttribute("seriesFavoritas", seriesFavoritas);

          // Pasar la lista completa de Comun como atributo a la JSP
          request.setAttribute("comunDelUsuario", post);

          // Redirigir a la vista JSP
          request.getRequestDispatcher("/UserProfileView.jsp").forward(request, response);
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
          response.sendRedirect("UserProfileModController");
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
