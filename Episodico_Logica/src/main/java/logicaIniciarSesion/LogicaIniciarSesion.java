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
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class LogicaIniciarSesion implements ILogicaIniciarSesion {

     private UsuarioDAO daoUsuario;

     public LogicaIniciarSesion() {
          daoUsuario = new UsuarioDAO();
     }

     @Override
     public boolean iniciarSesion(UsuarioDto usuariodto) {
          Usuario usuarioIniciarSesion = convertirDtoAEntidad(usuariodto);

          Usuario usuarioEncontrado = daoUsuario.validarCredenciales(usuarioIniciarSesion);

          return usuarioEncontrado != null;
     }

     @Override
     public Usuario convertirDtoAEntidad(UsuarioDto usuariodto) {
          return new Usuario(usuariodto.getCorreo(),  usuariodto.getContrasena());
     }
}
