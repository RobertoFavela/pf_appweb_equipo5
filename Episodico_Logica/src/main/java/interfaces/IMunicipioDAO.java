package interfaces;

import java.util.List;

import EntidadesSQL.Municipio;

public interface IMunicipioDAO {
    public void guardar(Municipio municipio);
    
    public List<Municipio> buscarTodos();
    
    public Municipio buscarPorId(Integer id);
 
    public Municipio buscarPorNombre(String nombre);
            
    public void actualizar(Municipio municipio);
    
    public void eliminar(Integer id) ;
}
