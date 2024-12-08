/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorRegistro;

import Beans.AdminBean;
import Beans.NormalBean;
import EntidadesSQL.Admin;
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
          request.getRequestDispatcher("/LogInView.jsp").forward(request, response);
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");

          String correo = request.getParameter("txtCorreo");
          String nombre = request.getParameter("txtUsuario");
          String contra = request.getParameter("txtContra");

          try {
//               Normal normal = new Normal(nombre, correo, contra);
//               NormalBean normalBean = NormalBean.getInstancia();
//               normalBean.guardar(normal);
               
               Admin admin = new Admin(nombre, correo, contra);
               AdminBean adminbean = AdminBean.getInstancia();
               adminbean.guardar(admin);

               response.setStatus(HttpServletResponse.SC_OK);
               response.getWriter().write("{\"message\": \"Usuario registrado exitosamente.\"}");
          } catch (Exception e) {
               response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
               response.getWriter().write("{\"error\": \"Error al registrar usuario: " + e.getMessage() + "\"}");
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
