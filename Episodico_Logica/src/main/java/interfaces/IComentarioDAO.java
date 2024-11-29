package interfaces;

import java.util.List;

import EntidadesSQL.Comentario;

public interface IComentarioDAO {
    public void guardar(Comentario comentario);

    public List<Comentario> buscarTodos();

    public Comentario buscarPorContenido(String nombre);

    public void actualizar(Comentario comentario);

    public void eliminar(String nombre);
    
    public List<Comentario> buscarPorPostID(Integer id);
    
    public List<Comentario> buscarPorUsuarioID(Integer id);
}
