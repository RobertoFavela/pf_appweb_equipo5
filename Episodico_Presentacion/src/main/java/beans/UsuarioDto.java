/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class UsuarioDto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String contraseña;
    private String correo;
    private String rol;

    public UsuarioDto(String nombre, String contraseña, String correo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = "Usuario";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
