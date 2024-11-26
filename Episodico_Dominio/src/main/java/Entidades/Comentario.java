/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import org.bson.types.ObjectId;
import java.util.Date;

public class Comentario {

    private ObjectId id; // ID único del comentario
    private String contenido; // Contenido del comentario
    private String autor; // Nombre del autor del comentario
    private Date fechaComentario; // Fecha en la que se realizó el comentario

    // Constructor vacío
    public Comentario() {
        this.fechaComentario = new Date(); // Fecha actual al crear el comentario
    }

    // Constructor con parámetros
    public Comentario(ObjectId id, String contenido, String autor) {
        this.id = id;
        this.contenido = contenido;
        this.autor = autor;
        this.fechaComentario = new Date(); // Fecha actual al crear el comentario
    }

    // Getters y Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + 
               "autor='" + autor + '\'' +
               ", fechaComentario=" + fechaComentario +
               '}';
    }
}

