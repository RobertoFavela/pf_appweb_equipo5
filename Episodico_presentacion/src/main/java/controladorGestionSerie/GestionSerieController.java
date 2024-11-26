/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladorGestionSerie;

import dtos.SerieDto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.util.List;
import logicaSerie.ILogicaSerie;
import logicaSerie.LogicaSerie;

/**
 *
 * @author favel
 */
public class GestionSerieController extends HttpServlet {

     private final ILogicaSerie logicaSerie;

     public GestionSerieController() {
          logicaSerie = new LogicaSerie();
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
          processRequest(request, response);

          String action = request.getParameter("RegistrarSerie"); // Action de la solicitud

          // Recibir los datos del formulario
          String nombre = request.getParameter("nombre");
          String descripcion = request.getParameter("descripcion");
          String genero = request.getParameter("genero");
          int lanzamiento = Integer.parseInt(request.getParameter("lanzamiento"));

          // Obtener el archivo de la imagen del formulario (se asume que se sube como parte de un formulario multipart)
          Part portadaPart = request.getPart("portada"); // Nombre del campo de la imagen en el formulario

          byte[] portada = null;

          // Verificar si el archivo fue subido
          if (portadaPart != null) {
               // Convertir la imagen a un arreglo de bytes
               try (InputStream inputStream = portadaPart.getInputStream()) {
                    portada = new byte[inputStream.available()];
                    inputStream.read(portada);
               } catch (IOException e) {
                    e.printStackTrace();
                    // Manejo de errores si la imagen no puede ser leída
               }
          }

          // Crear el DTO de la serie
          SerieDto nuevaSerie = new SerieDto();
          nuevaSerie.setTitulo(nombre);
          nuevaSerie.setDescripcion(descripcion);
          nuevaSerie.setImagen(portada);

          // Insertar la serie
          boolean exito = logicaSerie.insertarSerie(nuevaSerie);

          // Redirigir o mostrar mensaje según el resultado
          if (exito) {
               response.sendRedirect("gestionSerie.jsp?mensaje=Serie agregada con éxito");
          } else {
               response.sendRedirect("gestionSerie.jsp?error=Error al agregar la serie");
          }
     }

     // </editor-fold>
     @Override
     public String getServletInfo() {
          return "Controlador para gestionar las series";
     }
}
