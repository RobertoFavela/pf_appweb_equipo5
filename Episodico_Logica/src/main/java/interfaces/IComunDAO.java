package interfaces;

import java.util.List;

import EntidadesSQL.Comun;

public interface IComunDAO {
    public void guardar(Comun comun);

    public List<Comun> buscarTodos();

    public Comun buscarPorId(Integer id);

    public void actualizar(Comun comun);

    public void eliminar(Integer id);
}
