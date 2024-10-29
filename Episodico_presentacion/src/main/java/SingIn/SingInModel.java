/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SingIn;

import dtos.UsuarioDto;
import observers.IEventoRegistrarUsuario;
import observers.IEventoRespuestaRegistro;

/**
 *
 * @author tacot
 */
public class SingInModel {

    private IEventoRegistrarUsuario eventoRegistro;
    private IEventoRespuestaRegistro eventoRespuesta;

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

    //para logica
    public void agregarEventoRegistrarse(IEventoRegistrarUsuario evento) {
        this.eventoRegistro = evento;
    }

    public void notificarSolicitudRegistro(UsuarioDto usuario) {
        this.eventoRegistro.solicitudDeRegistro(usuario);
    }

    public void actualizarUsuario(UsuarioDto usuario) {
        this.usario = usuario;
    }

    //para controlador
    public void agregarEventoRespuesta(IEventoRespuestaRegistro evento) {
        this.eventoRespuesta = evento;
    }

    public void notificarSolicitudRespuesta(boolean respuesta) {
        this.eventoRespuesta.actualizar(respuesta);
    }

}
