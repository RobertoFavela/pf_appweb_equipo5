/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SingIn;

import dtos.UsuarioDto;

/**
 *
 * @author tacot
 */
public class SingInModel {

    private static SingInModel instancia;

    private UsuarioDto usario;

    public SingInModel() {
    }

    public static SingInModel getInstance() {

        if (instancia == null) {
            instancia = new SingInModel();
        }
        return instancia;
    }


    public void actualizarUsuario(UsuarioDto usuario) {
        this.usario = usuario;
    }


}
