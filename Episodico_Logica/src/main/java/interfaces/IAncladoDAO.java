package interfaces;

import java.util.List;

import EntidadesSQL.Anclado;

public interface IAncladoDAO {
    public void guardar(Anclado anclado);

    public List<Anclado> buscarTodos();

    public Anclado buscarPorId(Integer id);

    public void actualizar(Anclado anclado);

    public void eliminar(Integer id);
}
