package Beans;

import DAOsSQL.ComentarioDAO;
import EntidadesSQL.Comentario;
import interfaces.IComentarioDAO;
import java.util.List;

public class ComentarioBean {

    private static ComentarioBean instancia;
    private final IComentarioDAO comentarioDAO;

    public static synchronized ComentarioBean getInstancia() {
        if (instancia == null) {
            instancia = new ComentarioBean();
        }
        return instancia;
    }

    private ComentarioBean() {
        comentarioDAO = new ComentarioDAO();
    }

    public void guardar(Comentario comentario) {
        comentarioDAO.guardar(comentario);
    }

    public List<Comentario> buscarTodos() {
        return comentarioDAO.buscarTodos();
    }

    public Comentario buscarPorContenido(String contenido) {
        return comentarioDAO.buscarPorContenido(contenido);
    }

    public void actualizar(Comentario comentario) {
        comentarioDAO.actualizar(comentario);
    }

    public void eliminar(String nombre) {
        comentarioDAO.eliminar(nombre);
    }

    public List<Comentario> buscarPorPostID(Integer id) {
        return comentarioDAO.buscarPorPostID(id);
    }

    public List<Comentario> buscarPorUsuarioID(Integer id) {
        return comentarioDAO.buscarPorUsuarioID(id);
    }
}
