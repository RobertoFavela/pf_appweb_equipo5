package interfaces;

import java.util.List;

import EntidadesSQL.Normal;

public interface INormalDAO {
    public void guardar(Normal normal);
    
    public List<Normal> buscarTodos();
    
    public Normal buscarPorNombre(String nombre);
           
    public void actualizar(Normal normal);
    
    public void eliminar(String nombre) ;
}
