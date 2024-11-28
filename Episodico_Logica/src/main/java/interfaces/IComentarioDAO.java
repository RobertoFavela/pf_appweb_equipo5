package interfaces;

import java.util.List;

import EntidadesSQL.Comentario;

public interface IComentarioDAO {
    public void guardar(Comentario comentario);

    public List<Comentario> buscarTodos();

    public Comentario buscarPorId(Integer id);

    public void actualizar(Comentario comentario);

    public void eliminar(Integer id);
}
