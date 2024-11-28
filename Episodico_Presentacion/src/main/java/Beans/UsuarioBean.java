package Beans;

import DAOsSQL.UsuarioDAO;
import EntidadesSQL.Usuario;
import interfaces.IUsuarioDAO;
import java.util.List;

public class UsuarioBean {

     private static UsuarioBean instancia;
     private IUsuarioDAO usuarioDAO;
     private Usuario usuario;
     private List<Usuario> listaUsuarios;

     public static synchronized UsuarioBean getInstancia() {
          if (instancia == null) {
               instancia = new UsuarioBean();
          }
          return instancia;
     }

     public void init() {
          usuarioDAO = new UsuarioDAO();
          usuario = new Usuario();
          listaUsuarios = usuarioDAO.buscarTodos();
     }

     public void guardar() {
          usuarioDAO.guardar(usuario);
          usuario = new Usuario();
          listaUsuarios = usuarioDAO.buscarTodos();
     }

     public void eliminar(int id) {
          usuarioDAO.eliminar(id);
          listaUsuarios = usuarioDAO.buscarTodos();
     }

     public Usuario buscarPorId(int id) {
          return usuarioDAO.buscarPorId(id);
     }

     public Usuario buscarPorNombre(String nombre) {
          return usuarioDAO.buscarPorNombre(nombre);
     }

     public List<Usuario> getListaUsuarios() {
          return listaUsuarios;
     }

     public Usuario getUsuario() {
          return usuario;
     }

     public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
     }
}
