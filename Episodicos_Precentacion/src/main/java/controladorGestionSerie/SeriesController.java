/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorGestionSerie;

import Beans.AdminBean;
import Beans.SerieBean;
import EntidadesSQL.Comun;
import EntidadesSQL.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class SeriesController extends HttpServlet {

     private AdminBean adminBean;
     private SerieBean serieBean;

     public SeriesController() {
          serieBean = SerieBean.getInstancia();
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

          adminBean = AdminBean.getInstancia();

          boolean esAdmin = adminBean.getAdminEnSesion() != null;

          request.setAttribute("esAdmin", esAdmin);

          List<Serie> series = serieBean.buscarTodas();

          for (Serie serie : series) {
               if (serie.getId() != null) {
                    // Generar una URL para la imagen de cada serie
                    String imageUrl = "getSerieImage?id=" + serie.getId();
                    request.setAttribute("imageUrl_" + serie.getId(), imageUrl);
               }
          }

          request.setAttribute("series", series);

          request.getRequestDispatcher("/Series.jsp").forward(request, response);
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
          String titulo = request.getParameter("titulo");
          Serie serie = serieBean.buscarPorTitulo(titulo); 

          // No sabia que el buscar por titulo solo retornaba una serie, asi que la meti a una lista a fuerzas
          List<Serie> seriesFiltradas = new ArrayList<>();
          if (serie != null) {
               seriesFiltradas.add(serie);
          }

          request.setAttribute("series", seriesFiltradas);

          request.getRequestDispatcher("/Series.jsp").forward(request, response);
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
