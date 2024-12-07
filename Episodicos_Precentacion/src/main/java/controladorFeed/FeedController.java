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
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales Rojas - 00000245335
 */
public class FeedController extends HttpServlet {

    private SerieBean serieBean;
    private ComunBean comunBean;

    public FeedController() {
        serieBean = SerieBean.getInstancia();
        comunBean = ComunBean.getInstancia();
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

        List<Serie> series = serieBean.buscarTodas();
        List<Comun> posts = comunBean.buscarTodos();

        for (Serie serie : series) {
            if (serie.getId() != null) {
                // Generar una URL para la imagen de cada serie
                String imageUrl = "getSerieImage?id=" + serie.getId();
                request.setAttribute("imageUrl_" + serie.getId(), imageUrl);
            }
        }

        request.setAttribute("series", series);
        request.setAttribute("posts", posts);

        request.getRequestDispatcher("/FeedView.jsp").forward(request, response);
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
