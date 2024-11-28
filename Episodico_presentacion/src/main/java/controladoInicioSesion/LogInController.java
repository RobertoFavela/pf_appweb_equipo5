/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoInicioSesion;

import Beans.UsuarioBean;
import EntidadesSQL.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales
 * Ronjas - 00000245335
 */
@WebServlet(name = "LogInController", urlPatterns = {"/LogInController"})
public class LogInController extends HttpServlet {

     private UsuarioBean usuarioBean;
     
     public LogInController() {
          usuarioBean = new UsuarioBean();
     }

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
          String url = "/LogInView.jsp";

          String accion = request.getParameter("AccionIniciarSesion");

          if (accion != null && accion.equalsIgnoreCase("IniciarSesion")) {
               String correo = request.getParameter("txtUsuario");
               String contrasena = request.getParameter("txtContrasena");

               Usuario usuario = new Usuario();
               usuario.setCorreo(correo);
               usuario.setContrasenia(contrasena);
               
               usuarioBean.setUsuario(usuario);
               boolean respuesta = usuarioBean.autenticacion(usuario);
               
               if (respuesta) {
                   
                    response.sendRedirect("FeedView.jsp");
                    return;
               } else {
                    request.setAttribute("error", "Credenciales incorrectas.");
               }
          }

          this.getServletContext().getRequestDispatcher(url).forward(request, response);
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
