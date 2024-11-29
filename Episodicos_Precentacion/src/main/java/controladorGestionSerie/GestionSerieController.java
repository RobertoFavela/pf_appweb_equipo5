/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorGestionSerie;

import Beans.SerieBean;
import EntidadesSQL.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales Ronjas - 00000245335
 */
@MultipartConfig
public class GestionSerieController extends HttpServlet {

    private SerieBean serieBean;

    public GestionSerieController() {
    }

    /**
     * Procesa las solicitudes HTTP GET y POST.
     *
     * @param request solicitud HTTP
     * @param response respuesta HTTP
     * @throws ServletException si ocurre un error específico de servlets
     * @throws IOException si ocurre un error de entrada/salida
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos HTTP GET y POST">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/FeedView.jsp";
        
        serieBean = SerieBean.getInstancia();

        String accion = request.getParameter("accion");

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String genero = request.getParameter("genero");
        String lanzamiento = request.getParameter("lanzamiento");
        LocalDate fLanzamiento = LocalDate.parse(lanzamiento);

        Date fechaLanzamiento = Date.from(fLanzamiento.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Part portadaPart = request.getPart("portada");
        byte[] portadaBytes = null;
        if (portadaPart != null && portadaPart.getSize() > 0) {
            portadaBytes = portadaPart.getInputStream().readAllBytes();
        }

        Serie nuevaSerie = new Serie();
        nuevaSerie.setTitulo(nombre);
        nuevaSerie.setDescripcion(descripcion);
        nuevaSerie.setGenero(genero);
        nuevaSerie.setFechaEstreno(fechaLanzamiento);
        nuevaSerie.setImagen(portadaBytes);

        switch (accion) {
            case "agregar":
                serieBean.guardar(nuevaSerie);
                break;

            case "modificar":

                serieBean.actualizar(nuevaSerie);
                break;

            case "eliminar":
                serieBean.eliminar(nuevaSerie.getTitulo());
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);

    }

    // </editor-fold>
    @Override
    public String getServletInfo() {
        return "Controlador para gestionar las series";
    }
}
