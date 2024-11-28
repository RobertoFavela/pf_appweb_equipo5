package interfaces;

import java.util.List;

import EntidadesSQL.Estado;

public interface IEstadoDAO {
    public void guardar(Estado estado);

    public List<Estado> buscarTodosLosEstados();

    public Estado buscarEstadoPorId(Integer id);

    public Estado buscarEstadoPorNombre(String nombre);

    public void actualizar(Estado estado);

    public void eliminar(Integer id);
}
