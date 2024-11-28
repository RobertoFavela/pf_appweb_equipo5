package interfaces;

import java.util.List;

import EntidadesSQL.Normal;

public interface INormalDAO {
    public void guardar(Normal normal);
    
    public List<Normal> buscarTodos();
    
    public Normal buscarPorId(Integer id);
            
    public void actualizar(Normal normal);
    
    public void eliminar(Integer id) ;
}
