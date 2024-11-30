package interfaces;

import java.util.List;

import EntidadesSQL.Comun;

public interface IComunDAO {
    public void guardar(Comun comun);

    public List<Comun> buscarTodos();

    public Comun buscarPorTitulo(String nombre);

    public void actualizar(Comun comun);

    public void eliminar(String nombre);
    
}
