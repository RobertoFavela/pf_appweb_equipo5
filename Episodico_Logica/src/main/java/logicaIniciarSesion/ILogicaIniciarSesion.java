/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logicaIniciarSesion;

import Entidades.Usuario;
import dtos.UsuarioDto;

/**
 *
 * @author Jesus Morales
 */
public interface ILogicaIniciarSesion {
    public boolean iniciarSesion(String usaurio, String contraseña);
}
