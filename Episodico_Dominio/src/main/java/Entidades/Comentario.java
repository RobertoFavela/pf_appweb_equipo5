/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import org.bson.types.ObjectId;
import java.util.Date;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class Comentario {

    private ObjectId id; 
    private String contenido; 
    private String autor; 
    private Date fechaComentario; 

    public Comentario() {
        this.fechaComentario = new Date(); 
    }

    public Comentario(ObjectId id, String contenido, String autor) {
        this.id = id;
        this.contenido = contenido;
        this.autor = autor;
        this.fechaComentario = new Date(); 
    }

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
    
    public void setFechaComentario(Date fecha) {
         this.fechaComentario = fecha;
    }

    @Override
    public String toString() {
        return "Comentario{" + 
               "autor='" + autor + '\'' +
               ", fechaComentario=" + fechaComentario +
               '}';
    }
}

