/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPerfil;

import Beans.ComunBean;
import Beans.NormalBean;
import Beans.SerieBean;
import EntidadesSQL.Comun;
import EntidadesSQL.Serie;
import EntidadesSQL.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author favel
 */
public class ResenaController extends HttpServlet {

     private NormalBean normalBean;
     private SerieBean serieBean;
     private ComunBean comunBean;

     @Override
     public void init() throws ServletException {
          serieBean = SerieBean.getInstancia();
          normalBean = NormalBean.getInstancia();
          comunBean = ComunBean.getInstancia();
     }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          request.getRequestDispatcher("/UserProfileView.jsp").forward(request, response);
     }
     
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");

          String titulo = request.getParameter("txtTitulo");
          String contenido = request.getParameter("txtContenido");
          String nombreSerie = request.getParameter("txtNombre");

          try {

               Comun comun = new Comun();
               comun.setTitulo(titulo);
               comun.setContenido(contenido);
               comun.setFechaHoraCreacion(new Date());
               
               Serie serie = serieBean.buscarPorTitulo(nombreSerie);
               int serieId = serie.getId();
               comun.setSerieId(serie);
               
               Usuario usuario = normalBean.getUsuarioEnSesion();
               comun.setUsuarioId(usuario);

               comunBean.guardar(comun);

               response.setStatus(HttpServletResponse.SC_OK);
               response.getWriter().write("{\"message\": \"Post registrado exitosamente.\"}");
          } catch (Exception e) {
               e.printStackTrace();
               response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
               response.getWriter().write("{\"error\": \"Error al registrar el post: " + e.getMessage() + "\"}");
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
