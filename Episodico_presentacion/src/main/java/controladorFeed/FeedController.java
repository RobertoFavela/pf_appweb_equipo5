/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorFeed;

import Beans.SerieBean;
import EntidadesSQL.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales Rojas
 * - 00000245335
 */
@WebServlet(name = "FeedController", urlPatterns = {"/FeedController"})
public class FeedController extends HttpServlet {

     private final SerieBean serieBean = new SerieBean();

     /**
      * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
      * methods.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");

          List<Serie> seriesRecientes = serieBean.getListaSeries();
          System.out.println("Series recientes: " + seriesRecientes);

//        List<Serie> seriesMejorCalificadas = serieBean.obtenerSeriesPorCalificacion();
          request.setAttribute("seriesRecientes", seriesRecientes);
//        request.setAttribute("seriesMejorCalificadas", seriesMejorCalificadas);

          request.getRequestDispatcher("/FeedView.jsp").forward(request, response);

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
          processRequest(request, response);

          List<Serie> seriesRecientes = serieBean.getListaSeries();
          System.out.println("Series recientes: " + seriesRecientes);

//        List<Serie> seriesMejorCalificadas = serieBean.obtenerSeriesPorCalificacion();
          request.setAttribute("seriesRecientes", seriesRecientes);
//        request.setAttribute("seriesMejorCalificadas", seriesMejorCalificadas);

          request.getRequestDispatcher("/FeedView.jsp").forward(request, response);

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
          String selectedId = request.getParameter("rad");

          if (selectedId == null) {
               response.getWriter().write("No se seleccionó ninguna opción.");
               return;
          }

          switch (selectedId) {
               case "Inicio":
                    response.sendRedirect("FeedView.jsp");
                    break;
               case "buscar":
                    response.sendRedirect("BuscarView.jsp");
                    break;
               case "favoritas":
                    response.sendRedirect("FavoritasView.jsp");
                    break;
               case "perfil":
                    response.sendRedirect("UserProfileView.jsp");
                    break;
               default:
                    response.getWriter().write("Opción seleccionada no es válida.");
                    break;
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
