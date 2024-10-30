/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorRegistro;

import dtos.UsuarioDto;
import logicaRegistro.LogicaRegistro;

/**
 *
 * @author tacot
 */
public class RegisterModel {

    private final LogicaRegistro logicaRegistro;
    
    public RegisterModel() {
        
        this.logicaRegistro = new LogicaRegistro();
    }
    
    public boolean registrarUsuario(UsuarioDto usuario){
    
        return logicaRegistro.resgitrarUsuario(usuario);
    }


}
