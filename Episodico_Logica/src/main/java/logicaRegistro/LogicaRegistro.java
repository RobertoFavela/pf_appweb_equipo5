/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaRegistro;

import DAOs.UsuarioDAO;
import Entidades.Usuario;
import SingIn.SingInModel;
import dtos.UsuarioDto;
import observers.IEventoRegistrarUsuario;

/**
 *
 * @author tacot
 */
public class LogicaRegistro implements ILogicaRegistro {
    
    private SingInModel modelo = SingInModel.getInstance();
    
    private UsuarioDAO daoUsuario;
    
    public LogicaRegistro() {
        daoUsuario = new UsuarioDAO();
        modelo.agregarEventoRegistrarse(new EventoSolicitudRegistrarse());
        
    }
    
    @Override
    public boolean resgitrarUsuario(UsuarioDto usuario) {
        
        Usuario usuarioARegistrar = new Usuario(usuario.getCorreo(), usuario.getUsuario(), usuario.getContrasena());
        
        boolean respuesta = daoUsuario.insertarUsuario(usuarioARegistrar);
        
        return respuesta;
    }
    
    public class EventoSolicitudRegistrarse implements IEventoRegistrarUsuario {
        
        @Override
        public void solicitudDeRegistro(UsuarioDto usuario) {
            
            boolean respuesta = resgitrarUsuario(usuario);
            
            if (respuesta) {
                modelo.actualizarUsuario(usuario);
            }
            modelo.notificarSolicitudRespuesta(respuesta);
        }
    }
    
}
