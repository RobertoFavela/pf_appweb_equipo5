/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.ComentarioDAO;
import EntidadesSQL.Comentario;
import interfaces.IComentarioDAO;
import java.util.List;

public class ComentarioBean {
    private IComentarioDAO comentarioDAO;
    private Comentario comentario;
    private List<Comentario> listaComentarios;

    public void init() {
        comentarioDAO = new ComentarioDAO();
        comentario = new Comentario();
        listaComentarios = comentarioDAO.buscarTodos();
    }

    public void guardar() {
        comentarioDAO.guardar(comentario);
        comentario = new Comentario();
        listaComentarios = comentarioDAO.buscarTodos();
    }

    public void eliminar(int id) {
        comentarioDAO.eliminar(id);
        listaComentarios = comentarioDAO.buscarTodos();
    }

    public Comentario buscarPorId(int id) {
        return comentarioDAO.buscarPorId(id);
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}
