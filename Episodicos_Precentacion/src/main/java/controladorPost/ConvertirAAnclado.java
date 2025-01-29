/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPost;

import Beans.AncladoBean;
import Beans.ComunBean;
import EntidadesSQL.Anclado;
import EntidadesSQL.Comun;
import EntidadesSQL.Post;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author favel
 */
public class ConvertirAAnclado extends HttpServlet {

     private ComunBean comunBean;
     private AncladoBean ancladoBean;

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
          comunBean = ComunBean.getInstancia();
          ancladoBean = AncladoBean.getInstancia();
          
          
          // Obtener el id del post común desde el formulario
          String postId = request.getParameter("id");
          int postIdInt = Integer.parseInt(postId);

         Comun  postComun = comunBean.buscarPorId(postIdInt);
         
         

          if (postComun != null) {
               // Crear un nuevo anclado a partir de los atributos del post común
               Anclado anclado = new Anclado();
               anclado.setTitulo(postComun.getTitulo());
               anclado.setContenido(postComun.getContenido());
               anclado.setFechaHoraCreacion(postComun.getFechaHoraCreacion());

               // Guardar el anclado en la base de datos
               ancladoBean.guardar(anclado);

               // Eliminar el post común de la base de datos
//               comunBean.eliminarPost(postComun.getId());
          }

          // Redirigir al feed o página de anclados después de la conversión
          response.sendRedirect("FeedController");
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
