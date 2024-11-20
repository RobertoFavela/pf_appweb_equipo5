/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaRegistro;

import DAOs.UsuarioDAO;
import Entidades.Usuario;
import dtos.UsuarioDto;

/**
 *
 * @author tacot
 */
public class LogicaRegistro implements ILogicaRegistro {
    
    
    private final UsuarioDAO daoUsuario;
    
    public LogicaRegistro() {
        daoUsuario = new UsuarioDAO();
        
    }
    
    @Override
    public boolean resgitrarUsuario(UsuarioDto usuariodto) {
        
        Usuario usuarioARegistrar = convertirDtoAEntidad(usuariodto);
        
        boolean respuesta = daoUsuario.insertarUsuario(usuarioARegistrar);
        
        return respuesta;
    }
    
    @Override
    public Usuario convertirDtoAEntidad(UsuarioDto usuariodto){
    
        return new Usuario(usuariodto.getCorreo(), usuariodto.getNombre(), usuariodto.getContrasena(), usuariodto.getRol());
    }
}
