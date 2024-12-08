/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPost;

import Beans.AdminBean;
import Beans.ComentarioBean;
import Beans.ComunBean;
import Beans.NormalBean;
import EntidadesSQL.Comentario;
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

    private NormalBean normalBean;

    private ComunBean comunBean;
    private ComentarioBean comentarioBean;

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

        // Verificar si es admin
        adminBean = AdminBean.getInstancia();
        boolean esAdmin = adminBean.getAdminEnSesion() != null;
        request.setAttribute("esAdmin", esAdmin);

        comunBean = ComunBean.getInstancia();
        normalBean = NormalBean.getInstancia();
        comentarioBean = ComentarioBean.getInstancia();

        // Obtener todas las reseñas
        List<Comun> posts = comunBean.buscarTodos();

        // Mapear comentarios por post ID
        List<Comentario> comentarioCollection = comentarioBean.buscarTodos();

        // Pasar los datos al JSP
        request.setAttribute("posts", posts);
        request.setAttribute("comentariosPorPost", comentarioCollection);

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String id = request.getParameter("id");
        if ("eliminar".equals(accion)) {
            try {
                comunBean = ComunBean.getInstancia();
                comunBean.eliminarPost(Integer.parseInt(id));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"success\": true}");
            } catch (IOException | NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
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
