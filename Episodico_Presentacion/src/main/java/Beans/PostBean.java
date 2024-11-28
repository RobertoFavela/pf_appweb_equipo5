/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.PostDAO;
import EntidadesSQL.Post;
import interfaces.IPostDAO;
import java.util.List;

public class PostBean {
    private IPostDAO postDAO;
    private Post post;
    private List<Post> listaPosts;

    public void init() {
        postDAO = new PostDAO();
        post = new Post();
        listaPosts = postDAO.buscarTodos();
    }

    public void guardar() {
        postDAO.guardar(post);
        post = new Post();
        listaPosts = postDAO.buscarTodos();
    }

    public void eliminar(int id) {
        postDAO.eliminar(id);
        listaPosts = postDAO.buscarTodos();
    }

    public Post buscarPorId(int id) {
        return postDAO.buscarPorId(id);
    }

    public List<Post> getListaPosts() {
        return listaPosts;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
