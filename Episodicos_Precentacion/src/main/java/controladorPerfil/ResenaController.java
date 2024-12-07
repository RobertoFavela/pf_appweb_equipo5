/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPerfil;

import Beans.ComunBean;
import EntidadesSQL.Comun;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 *
 * @author favel
 */
public class ResenaController extends HttpServlet {

     private ComunBean comunBean;

     @Override
     public void init() throws ServletException {
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
          // Obtener los datos del formulario
          String titulo = request.getParameter("titulo");
          String contenido = request.getParameter("contenido");

          // Crear la instancia de Comun
          Comun comun = new Comun();
          comun.setTitulo(titulo);
          comun.setContenido(contenido);

          // Guardar en la base de datos
          ComunBean comunBean = ComunBean.getInstancia();
          comunBean.guardar(comun);

          // Respuesta
          response.getWriter().write("Reseña guardada correctamente");
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
