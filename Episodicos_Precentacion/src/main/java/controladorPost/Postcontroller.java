/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPost;

import Beans.AdminBean;
import Beans.ComunBean;
import Beans.NormalBean;
import EntidadesSQL.Comun;
import EntidadesSQL.Normal;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author favel
 */
public class Postcontroller extends HttpServlet {

     private AdminBean adminBean;

     private ComunBean comunBean;
     private NormalBean normalBean;

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

          // Para verificar si es admin
          adminBean = AdminBean.getInstancia();
          boolean esAdmin = adminBean.getAdminEnSesion() != null;
          request.setAttribute("esAdmin", esAdmin);

          comunBean = ComunBean.getInstancia();
          normalBean = NormalBean.getInstancia();

          // Obtener todas las reseñas
          List<Comun> posts = comunBean.buscarTodos();

          // Obtener todos los usuarios para mapear idUsuario a nombreCompleto
          List<Normal> usuarios = normalBean.buscarTodos();
          Map<Integer, String> usuariosPorId = usuarios.stream()
                  .collect(Collectors.toMap(Normal::getId, Normal::getNombreCompleto));

          // Pasar los datos al JSP
          request.setAttribute("posts", posts);
          request.setAttribute("usuariosPorId", usuariosPorId);

          // Redirigir al JSP de reseñas
          request.getRequestDispatcher("/Post.jsp").forward(request, response);
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
          String accion = request.getParameter("accion");

          if ("eliminar".equals(accion)) {
               int postId = Integer.parseInt(request.getParameter("id"));

               // Verificar si el usuario en sesión es admin
               adminBean = AdminBean.getInstancia();
               if (adminBean.getAdminEnSesion() == null) {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().write("{\"success\": false, \"message\": \"No autorizado\"}");
                    return;
               }

               // Lógica para eliminar el post
               comunBean = ComunBean.getInstancia();
               boolean eliminado = comunBean.eliminarPost(postId);

               response.setContentType("application/json");
               if (eliminado) {
                    response.getWriter().write("{\"success\": true}");
               } else {
                    response.getWriter().write("{\"success\": false, \"message\": \"No se pudo eliminar el post\"}");
               }
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
