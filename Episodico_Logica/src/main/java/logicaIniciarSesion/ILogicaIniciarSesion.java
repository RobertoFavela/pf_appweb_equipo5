/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logicaIniciarSesion;

import Entidades.Usuario;
import dtos.UsuarioDto;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public interface ILogicaIniciarSesion {
    public boolean iniciarSesion(UsuarioDto usuariodto);
    public Usuario convertirDtoAEntidad(UsuarioDto usuariodto);
}
