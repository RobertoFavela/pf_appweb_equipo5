/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPerfil;

import Beans.ComunBean;
import Beans.NormalBean;
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
     private ComunBean comunBean;

     @Override
     public void init() throws ServletException {
          normalBean = NormalBean.getInstancia();
          comunBean = ComunBean.getInstancia();
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
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
               String titulo = request.getParameter("titulo");
               String contenido = request.getParameter("contenido");
               String nombreSerie = request.getParameter("nombre");

               System.out.println("Titulo: " + titulo); // Verifica que el título se recibe
               System.out.println("Contenido: " + contenido); // Verifica que el contenido se recibe
               System.out.println("Nombre Serie: " + nombreSerie); // Verifica que el nombre de la serie se recibe

               Comun comun = new Comun();
               comun.setTitulo(titulo);
               comun.setContenido(contenido);
               comun.setFechaHoraCreacion(new Date());
               Usuario usuario = normalBean.getUsuarioEnSesion();
               comun.setUsuarioId(usuario);

               comunBean.guardar(comun);

               response.getWriter().write("Reseña guardada correctamente");
          } catch (Exception e) {
               e.printStackTrace();
               response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al guardar la reseña.");
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
