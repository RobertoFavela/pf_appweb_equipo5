package interfaces;

import java.util.List;

import EntidadesSQL.Post;

public interface IPostDAO {
    public void guardar(Post post);

    public List<Post> buscarTodos();

    public Post buscarPorId(Integer id);

    public void actualizar(Post post);

    public void eliminar(Integer id);

    public List<Post> buscarPorTitulo(String titulo);
}
