/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaRegistro;

import DAOs.UsuarioDAO;
import Entidades.Usuario;
import dtos.UsuarioDto;
import observers.IEventoRegistrarUsuario;

/**
 *
 * @author tacot
 */
public class LogicaRegistro implements ILogicaRegistro {
    
    
    private UsuarioDAO daoUsuario;
    
    public LogicaRegistro() {
        daoUsuario = new UsuarioDAO();
        
    }
    
    @Override
    public boolean resgitrarUsuario(UsuarioDto usuario) {
        
        Usuario usuarioARegistrar = new Usuario(usuario.getCorreo(), usuario.getUsuario(), usuario.getContrasena());
        
        boolean respuesta = daoUsuario.insertarUsuario(usuarioARegistrar);
        
        return respuesta;
    }
    
}
