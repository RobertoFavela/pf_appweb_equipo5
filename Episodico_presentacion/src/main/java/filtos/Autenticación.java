/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filtos;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author favel
 */
public class Autenticación implements Filter {

     private static final boolean debug = true;
     private static final String[] urlPublicas = {"LogInView.jsp"};

     private FilterConfig filterConfig = null;

     public Autenticación() {
     }

     private void doBeforeProcessing(ServletRequest request, ServletResponse response)
             throws IOException, ServletException {
          if (debug) {
               log("Autenticación:DoBeforeProcessing");
          }
     }

     private void doAfterProcessing(ServletRequest request, ServletResponse response)
             throws IOException, ServletException {
          if (debug) {
               log("Autenticación:DoAfterProcessing");
          }
     }

     //Verificacion de una sesion activa
     private boolean usuarioLogueado(HttpServletRequest httpRequest) {
          HttpSession sesion = httpRequest.getSession(false);
          boolean logueado = (sesion != null && sesion.getAttribute("usuario") != null);
          return logueado;
     }

     //Verificacion si la ruta es privada
     private boolean esURLPrivada(String ruta) {
          for (String url : urlPublicas) {
               if (ruta.startsWith("/" + url)) {
                    return false;
               }
          }
          return true;
     }

     //Obtiene la ruta a la que se desea acceder
     private String getRutaSolicitada(HttpServletRequest httpRequest) {
          String uriSolicitada = httpRequest.getRequestURI();
          String ruta  = uriSolicitada.substring(httpRequest.getContextPath().length());
          return ruta;
     }

     /**
      *
      * @param request The servlet request we are processing
      * @param response The servlet response we are creating
      * @param chain The filter chain we are processing
      *
      * @exception IOException if an input/output error occurs
      * @exception ServletException if a servlet error occurs
      */
     public void doFilter(ServletRequest request, ServletResponse response,
             FilterChain chain)
             throws IOException, ServletException {

          if (debug) {
               log("Autenticación:doFilter()");
          }

          HttpServletRequest httpRequest = (HttpServletRequest) request;
          HttpServletResponse httpResponse = (HttpServletResponse) request;
          
          String ruta = this.getRutaSolicitada(httpRequest);
          boolean urlPrivada = this.esURLPrivada(ruta);
          boolean logueado = this.usuarioLogueado(httpRequest);
          
          if (!logueado && urlPrivada) {
               httpResponse.sendRedirect(httpRequest.getContextPath() + "LogInView.jsp");
          } else {
               chain.doFilter(request, response);
          }
     }

     /**
      * Return the filter configuration object for this filter.
      */
     public FilterConfig getFilterConfig() {
          return (this.filterConfig);
     }

     /**
      * Set the filter configuration object for this filter.
      *
      * @param filterConfig The filter configuration object
      */
     public void setFilterConfig(FilterConfig filterConfig) {
          this.filterConfig = filterConfig;
     }

     /**
      * Destroy method for this filter
      */
     public void destroy() {
     }

     /**
      * Init method for this filter
      */
     public void init(FilterConfig filterConfig) {
          this.filterConfig = filterConfig;
          if (filterConfig != null) {
               if (debug) {
                    log("Autenticación:Initializing filter");
               }
          }
     }

     /**
      * Return a String representation of this object.
      */
     @Override
     public String toString() {
          if (filterConfig == null) {
               return ("Autenticación()");
          }
          StringBuffer sb = new StringBuffer("Autenticación(");
          sb.append(filterConfig);
          sb.append(")");
          return (sb.toString());
     }

     private void sendProcessingError(Throwable t, ServletResponse response) {
          String stackTrace = getStackTrace(t);

          if (stackTrace != null && !stackTrace.equals("")) {
               try {
                    response.setContentType("text/html");
                    PrintStream ps = new PrintStream(response.getOutputStream());
                    PrintWriter pw = new PrintWriter(ps);
                    pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                    // PENDING! Localize this for next official release
                    pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                    pw.print(stackTrace);
                    pw.print("</pre></body>\n</html>"); //NOI18N
                    pw.close();
                    ps.close();
                    response.getOutputStream().close();
               } catch (Exception ex) {
               }
          } else {
               try {
                    PrintStream ps = new PrintStream(response.getOutputStream());
                    t.printStackTrace(ps);
                    ps.close();
                    response.getOutputStream().close();
               } catch (Exception ex) {
               }
          }
     }

     public static String getStackTrace(Throwable t) {
          String stackTrace = null;
          try {
               StringWriter sw = new StringWriter();
               PrintWriter pw = new PrintWriter(sw);
               t.printStackTrace(pw);
               pw.close();
               sw.close();
               stackTrace = sw.getBuffer().toString();
          } catch (Exception ex) {
          }
          return stackTrace;
     }

     public void log(String msg) {
          filterConfig.getServletContext().log(msg);
     }

}
