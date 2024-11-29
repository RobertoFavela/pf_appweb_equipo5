package interfaces;

import java.util.List;

import EntidadesSQL.Admin;

public interface IAdminDAO {
    public void guardar(Admin admin);
    
    public List<Admin> buscarTodos();
    
    public Admin buscarPorNombre(String nombre);
    
    public void actualizar(Admin admin);
    
    public void eliminar(String nombre) ;
}
