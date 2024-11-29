/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoInicioSesion;

import Beans.AdminBean;
import Beans.NormalBean;
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
public class LogInController extends HttpServlet {

      private NormalBean normalBean;
      private AdminBean adminBean;

      public LogInController() {
          
      }

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
      }

      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
            processRequest(request, response);
      }

      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
            String url = "/LogInView.jsp";

            String accion = request.getParameter("AccionIniciarSesion");

            if (accion != null && accion.equalsIgnoreCase("IniciarSesion")) {
                  String correo = request.getParameter("txtUsuario");
                  String contrasena = request.getParameter("txtContrasena");

                  
                  
            }

            this.getServletContext().getRequestDispatcher(url).forward(request, response);
      }

      @Override
      public String getServletInfo() {
            return "Short description";
      }
}
