/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorPost;

import Beans.AdminBean;
import Beans.AncladoBean;
import Beans.ComunBean;
import Beans.NormalBean;
import Beans.SerieBean;
import EntidadesSQL.Admin;
import EntidadesSQL.Anclado;
import EntidadesSQL.Comun;
import EntidadesSQL.Normal;
import EntidadesSQL.Serie;
import EntidadesSQL.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author favel
 */
public class ResenaController extends HttpServlet {

    private NormalBean normalBean;
    private AdminBean adminBean;

    private SerieBean serieBean;
    private ComunBean comunBean;

    @Override
    public void init() throws ServletException {
        serieBean = SerieBean.getInstancia();

        normalBean = NormalBean.getInstancia();
        adminBean = AdminBean.getInstancia();

        comunBean = ComunBean.getInstancia();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/UserProfileView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String titulo = request.getParameter("txtTitulo");
        String contenido = request.getParameter("txtContenido");
        String nombreSerie = request.getParameter("txtNombre");
        String esAnclado = request.getParameter("chkAnclado");

        try {
            Comun comun = new Comun();
            comun.setTitulo(titulo);
            comun.setContenido(contenido);
            comun.setFechaHoraCreacion(new Date());

            Serie serie = serieBean.buscarPorTitulo(nombreSerie);
            comun.setSerieId(serie);

            Usuario usuario = null;
            Admin adminActual = adminBean.getAdminEnSesion();
            Normal normalActual = normalBean.getUsuarioEnSesion();

            if (adminActual != null) {
                usuario = adminActual;
            } else if (normalActual != null) {
                usuario = normalActual;
            }

            if (usuario != null) {
                comun.setUsuarioId(usuario);
            }

            comunBean.guardar(comun);

            if ("on".equals(esAnclado) && adminActual != null) {
                Anclado anclado = new Anclado();
                anclado.setTitulo(titulo);
                anclado.setContenido(contenido);
                anclado.setFechaHoraCreacion(new Date());
                anclado.setSerieId(serie);
                anclado.setUsuarioId(adminActual);

                AncladoBean.getInstancia().guardar(anclado);
            }

            Map<String, Object> postData = new HashMap<>();
            postData.put("id", comun.getId());
            postData.put("titulo", comun.getTitulo());
            postData.put("contenido", comun.getContenido());
            postData.put("fechaHoraCreacion", comun.getFechaHoraCreacion());
            postData.put("usuarioNombre", usuario.getNombreCompleto());

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(new Gson().toJson(Map.of("success", true, "post", postData)));
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(new Gson().toJson(Map.of("success", false, "error", e.getMessage())));
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
