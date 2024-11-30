/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorRegistro;

import Beans.NormalBean;
import EntidadesSQL.Normal;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author tacot
 */
public class RegisterController extends HttpServlet {

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
          String accion = request.getParameter("accion"); 

          if ("RegistrarUsuario".equalsIgnoreCase(accion)) {
               String correo = request.getParameter("txtCorreo");
               String nombre = request.getParameter("txtUsuario");
               String contra = request.getParameter("txtContra");

               try {
                    Normal normal = new Normal(nombre, correo, contra); 
                    NormalBean normalBean = NormalBean.getInstancia();
                    normalBean.guardar(normal);

                    request.setAttribute("exitoMensaje", "Usuario registrado exitosamente.");
                    url = "/LogInView.jsp";
               } catch (Exception e) {
                    request.setAttribute("errorMensaje", "Error al registrar usuario: " + e.getMessage());
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
