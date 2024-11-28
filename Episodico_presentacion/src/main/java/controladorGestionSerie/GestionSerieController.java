/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorGestionSerie;

import Beans.SerieBean;
import EntidadesSQL.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class GestionSerieController extends HttpServlet {

     private final SerieBean serieBean;

     public GestionSerieController() {
          serieBean = new SerieBean();
     }

     /**
      * Procesa las solicitudes HTTP GET y POST.
      *
      * @param request solicitud HTTP
      * @param response respuesta HTTP
      * @throws ServletException si ocurre un error específico de servlets
      * @throws IOException si ocurre un error de entrada/salida
      */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
     }

     // <editor-fold defaultstate="collapsed" desc="Métodos HTTP GET y POST">
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          processRequest(request, response);
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          processRequest(request, response);
          String url = "/GestionSerie.jsp";
          
          
          String action = request.getParameter("RegistrarSerie"); 

          String nombre = request.getParameter("nombre");
          String descripcion = request.getParameter("descripcion");
          String genero = request.getParameter("genero");
          int lanzamiento = Integer.parseInt(request.getParameter("lanzamiento"));

          Serie nuevaSerie = new Serie();
          nuevaSerie.setTitulo(nombre);
          nuevaSerie.setDescripcion(descripcion);
          serieBean.setSerie(nuevaSerie);
          
          serieBean.guardar();

//          if (exito) {
//               response.sendRedirect("GestionSerie.jsp?mensaje=Serie agregada con éxito");
//
//          } else {
//               response.sendRedirect("gestionSerie.jsp?error=Error al agregar la serie");
//          }
     }

     // </editor-fold>
     @Override
     public String getServletInfo() {
          return "Controlador para gestionar las series";
     }
}
