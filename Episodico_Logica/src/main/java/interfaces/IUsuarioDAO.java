/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import EntidadesSQL.Usuario;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IUsuarioDAO {
    public void guardar(Usuario usuario);
    
    public List<Usuario> buscarTodos();
    
    public Usuario buscarPorId(Integer id);
 
    public Usuario buscarPorNombre(String nombre);
    
    public boolean autenticacion(Usuario usuario);
            
    public void actualizar(Usuario usuario);
    
    public void eliminar(Integer id) ;
}
