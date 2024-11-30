package interfaces;

import java.util.List;

import EntidadesSQL.Anclado;
import EntidadesSQL.Comentario;

public interface IAncladoDAO {
    public void guardar(Anclado anclado);

    public List<Anclado> buscarTodos();

    public Anclado buscarPorTitulo(String nombre);

    public void actualizar(Anclado anclado);

    public void eliminar(String nombre);
    
    
    
    public Anclado buscarPorSerie(int id);
}
