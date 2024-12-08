package interfaces;

import java.util.List;

import EntidadesSQL.Admin;

public interface IAdminDAO {
    public void guardar(Admin admin);
    
    public List<Admin> buscarTodos();
    
    public List<Admin> buscarPorCorreo(String correo);
    
    public Admin buscarPorNombre(String nombre);
    
    public void actualizar(Admin admin);
    
    public void eliminar(String nombre) ;
    
    public void agregarSerieFavorita(Admin admin, Integer serieId);

     public void eliminarSerieFavorita(Admin admin, Integer serieId);

     public List<Integer> obtenerSeriesFavoritas(Admin admin);
}
