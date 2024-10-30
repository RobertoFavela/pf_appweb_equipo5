/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logicaRegistro;

import Entidades.Usuario;
import dtos.UsuarioDto;

/**
 *
 * @author tacot
 */
public interface ILogicaRegistro {
    public boolean resgitrarUsuario(UsuarioDto usuario);
    public Usuario convertirDtoAEntidad(UsuarioDto usuariodto);
}
