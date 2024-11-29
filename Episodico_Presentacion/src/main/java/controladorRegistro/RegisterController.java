/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorRegistro;

import Beans.NormalBean;
import Beans.UsuarioBean;
import EntidadesSQL.Normal;
import EntidadesSQL.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class RegisterController extends HttpServlet {

     private final UsuarioBean usuarioBean;
     private final NormalBean normalBean;
     
    public RegisterController() {
         usuarioBean = UsuarioBean.getInstancia();
         normalBean = NormalBean.getInstancia();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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

        String accion = request.getParameter("RegistrarUsuario");

                String correo = request.getParameter("txtCorreo");
                String nombre = request.getParameter("txtUsuario");
                String contra = request.getParameter("txtContra");

                Usuario usuario = new Usuario();
                usuario.setCorreo(correo);
                usuario.setNombreCompleto(nombre);
                usuario.setContrasenia(contra);
                
//                usuarioBean.setUsuario(usuario);
//                usuarioBean.guardar();
                
                Normal normal = new Normal();
                normal.setNombreCompleto(nombre);
                normal.setCorreo(correo);
                normal.setContrasenia(contra);
                normalBean.setNormal(normal);
                normalBean.guardar();

                
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
