package interfaces;

import java.util.List;

import EntidadesSQL.Normal;

public interface INormalDAO {
    public void guardar(Normal normal);
    
    public List<Normal> buscarTodos();
    
    public List<Normal> buscarPorCorreo(String correo);
    
    public Normal buscarPorNombre(String nombre);
           
    public void actualizar(Normal normal);
    
    public void eliminar(String nombre) ;
    
       public void agregarSerieFavorita(Normal normal, Integer serieId);

     public void eliminarSerieFavorita(Normal normal, Integer serieId);

     public List<Integer> obtenerSeriesFavoritas(Normal normal);
}
