/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaIniciarSesion;

import DAOs.UsuarioDAO;
import Entidades.Usuario;
import dtos.UsuarioDto;

/**
 *
 * @author Jesus Morales
 */
public class LogicaIniciarSesion implements ILogicaIniciarSesion {

     private UsuarioDAO daoUsuario;

     public LogicaIniciarSesion() {
          daoUsuario = new UsuarioDAO();
     }

     @Override
     public boolean iniciarSesion(UsuarioDto usuariodto) {
          // Convertir el UsuarioDto a Usuario
          Usuario usuarioIniciarSesion = convertirDtoAEntidad(usuariodto);

          // Validar las credenciales usando el Usuario convertido
          Usuario usuarioEncontrado = daoUsuario.validarCredenciales(usuarioIniciarSesion);

          // Retornar true si se encuentra el usuario, false si no
          return usuarioEncontrado != null;
     }

     @Override
     public Usuario convertirDtoAEntidad(UsuarioDto usuariodto) {
          // Asegúrate de que los atributos del UsuarioDto estén correctamente mapeados a Usuario
          return new Usuario(usuariodto.getCorreo(),  usuariodto.getContrasena());
     }
}
