package controladorFeed;

import Beans.AncladoBean;
import Beans.ComentarioBean;
import Beans.ComunBean;
import Beans.NormalBean;
import Beans.SerieBean;
import EntidadesSQL.Anclado;
import EntidadesSQL.Comentario;
import EntidadesSQL.Comun;
import EntidadesSQL.Post;
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
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales Rojas
 * - 00000245335
 */
public class FeedController extends HttpServlet {

     private SerieBean serieBean;
     private AncladoBean ancladoBean;
     private ComentarioBean comentarioBean;
     private ComunBean comunBean;

     public FeedController() {
          serieBean = SerieBean.getInstancia();
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
//
//          ancladoBean = AncladoBean.getInstancia();
//          comentarioBean = ComentarioBean.getInstancia();
//          comunBean = ComunBean.getInstancia();
//          serieBean = SerieBean.getInstancia();
//
//          List<Anclado> postsA = ancladoBean.buscarTodos();
//
//          for (Anclado post : postsA) {
//               List<Comentario> comentarios = comentarioBean.buscarPorPostID(post.getId());
//               post.setComentarioCollection(comentarios);
//          }
//
//          List<Comun> postsC = comunBean.buscarTodos();
//
//          for (Comun post : postsC) {
//               List<Comentario> comentarios = comentarioBean.buscarPorPostID(post.getId());
//               post.setComentarioCollection(comentarios);
//
//               for (Comentario comentario : comentarios) {
//                    List<Comentario> comentariosDeComentarios = comentarioBean.buscarPorComentarioID(comentario.getId());
//                    comentario.setComentarioCollection(comentariosDeComentarios);
//               }
//          }
//
//          List<Post> posts = new ArrayList<>();
//
//          posts.addAll(postsA);
//          posts.addAll(postsC);
//
//          request.setAttribute("posts", posts != null ? posts : new ArrayList<>());
//
//          List<Serie> series = serieBean.buscarTodas();
//
//          request.setAttribute("series", series != null ? series : new ArrayList<>());

          response.sendRedirect("/FeedView.jsp");

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
                    response.sendRedirect("FeedController");
                    break;
               case "buscar":
                    response.sendRedirect("");
                    break;
               case "favoritas":
                    response.sendRedirect("SeriesController");
                    break;
               case "perfil":
                    response.sendRedirect("UserProfileController");
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
