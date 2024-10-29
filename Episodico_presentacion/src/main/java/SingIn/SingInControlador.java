/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SingIn;

import dtos.UsuarioDto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import observers.IEventoRespuestaRegistro;

/**
 *
 * @author tacot
 */
public class SingInControlador extends HttpServlet {

    SingInModel modelo = SingInModel.getInstance();

    public SingInControlador() {
        
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
        
    }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String accion = request.getParameter("RegistrarUsuario");
        if (accion.equalsIgnoreCase("Registrarse")) {
            String correo = request.getParameter("txtCorreo");
            String usuario = request.getParameter("txtUsuario");
            String contra = request.getParameter("txtContra");
            
            modelo.agregarEventoRespuesta(new ObtenerRespuesta(request,response));
            
            modelo.notificarSolicitudRegistro(new UsuarioDto(correo, usuario, contra));
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

    
    public class ObtenerRespuesta implements IEventoRespuestaRegistro {
        
        HttpServletRequest request;
        HttpServletResponse response;
        
        public ObtenerRespuesta(HttpServletRequest request, HttpServletResponse response) {
            this.request = request;
            this.response = response;
        }

        @Override
        public void actualizar(boolean respuesta)  {

            if (respuesta) {
                try {
                    request.getRequestDispatcher("LogInView.jsp").forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(SingInControlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SingInControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    request.getRequestDispatcher("SingInView.jsp").forward(request, response);
                    System.out.println("no jalo");
                } catch (ServletException ex) {
                    Logger.getLogger(SingInControlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SingInControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
