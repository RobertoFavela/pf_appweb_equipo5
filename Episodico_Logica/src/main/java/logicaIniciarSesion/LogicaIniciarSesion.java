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
     public boolean iniciarSesion(String usuario, String contraseña) {
          Usuario usuarioEncontrado = daoUsuario.validarCredenciales(usuario, contraseña);

          return usuarioEncontrado != null;
     }
}
