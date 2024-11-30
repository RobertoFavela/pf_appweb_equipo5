/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoInicioSesion;

import Beans.AdminBean;
import Beans.NormalBean;
import EntidadesSQL.Admin;
import EntidadesSQL.Normal;
import EntidadesSQL.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales Ronjas - 00000245335
 */
public class LogInController extends HttpServlet {

    private NormalBean normalBean;
    private AdminBean adminBean;

    public LogInController() {
        normalBean = NormalBean.getInstancia();
        adminBean = AdminBean.getInstancia();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/LogInView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/LogInView.jsp";
        String accion = request.getParameter("AccionIniciarSesion");

        if (accion != null && accion.equalsIgnoreCase("IniciarSesion")) {
            String correo = request.getParameter("txtUsuario");
            String contrasena = request.getParameter("txtContrasena");

            AdminBean adminBean = AdminBean.getInstancia();
            NormalBean normalBean = NormalBean.getInstancia();

            Admin adminEnSesion = AdminBean.getInstancia().buscarPorCredenciales(correo, contrasena);
            Normal normalEnSesion = NormalBean.getInstancia().buscarPorCredenciales(correo, contrasena);

            if (adminEnSesion != null) {
                request.getSession().setAttribute("usuario", adminEnSesion);
                
                adminBean.setAdminEnSesion(adminEnSesion);
                
                response.sendRedirect("FeedController");
            } else if (normalEnSesion != null) {
                request.getSession().setAttribute("usuario", normalEnSesion);
                normalBean.setUsuarioEnSesion(normalEnSesion);
                response.sendRedirect("FeedController");
            } else {
                request.setAttribute("error", "Correo o contraseña incorrectos.");
                this.getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
