/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPost;

import Beans.AdminBean;
import Beans.ComentarioBean;
import Beans.ComunBean;
import Beans.NormalBean;
import Beans.SerieBean;
import EntidadesSQL.Comentario;
import EntidadesSQL.Comun;
import EntidadesSQL.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author favel
 */
public class ComentarioController extends HttpServlet {

     private NormalBean normalBean;
     private AdminBean adminBean;

     private SerieBean serieBean;
     private ComunBean comunBean;
     private ComentarioBean comentarioBean;

     @Override
     public void init() throws ServletException {
          serieBean = SerieBean.getInstancia();

          normalBean = NormalBean.getInstancia();
          adminBean = AdminBean.getInstancia();

          comunBean = ComunBean.getInstancia();
          comentarioBean = ComentarioBean.getInstancia();
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
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");

          String tituloPost = request.getParameter("txtTitulo");
          String contenido = request.getParameter("txtContenido");
          String postId = request.getParameter("postId");

          try {
               Usuario usuario = null;

               if (adminBean.getAdminEnSesion() != null) {
                    usuario = adminBean.getAdminEnSesion();  // Si es admin, se usa el admin en sesión
               } else if (normalBean.getUsuarioEnSesion() != null) {
                    usuario = normalBean.getUsuarioEnSesion();  // Si es normal, se usa el usuario normal en sesión
               }

               if (usuario == null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("{\"error\": \"Debe iniciar sesión para comentar.\"}");
                    return;
               }

               Comun post = comunBean.buscarPorTitulo(tituloPost);

               if (post == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\": \"El post no existe.\"}");
                    return;
               }

               // Crear el objeto Comentario
               Comentario comentario = new Comentario();
               comentario.setContenido(contenido);
               comentario.setFechaHora(new Date());
               comentario.setPostId(post);
               comentario.setUsuarioId(usuario);

               comentarioBean.guardar(comentario);

               response.setStatus(HttpServletResponse.SC_OK);
               response.getWriter().write("{\"message\": \"Comentario registrado exitosamente.\"}");

          } catch (Exception e) {
               e.printStackTrace();
               response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
               response.getWriter().write("{\"error\": \"Error al registrar el comentario: " + e.getMessage() + "\"}");
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
