/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class Usuario {
    private ObjectId id;
    private String correo, usuario, contrasena, rol;

    public Usuario() {
    }

    public Usuario(String correo, String usuario, String contrasena, String rol) {
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuario(String correo, String contrasena) {
         this.correo = correo;
         this.contrasena = contrasena;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.contrasena);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contrasena, other.contrasena);
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
   
}
