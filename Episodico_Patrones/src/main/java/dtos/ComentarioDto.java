/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

public class ComentarioDto {

    private String id; // Usamos String en lugar de ObjectId para facilitar la manipulación
    private String contenido;
    private String autor;
    private Date fechaComentario;

    // Constructor vacío
    public ComentarioDto() {
    }

    // Constructor con parámetros
    public ComentarioDto(String id, String contenido, String autor, Date fechaComentario) {
        this.id = id;
        this.contenido = contenido;
        this.autor = autor;
        this.fechaComentario = fechaComentario;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}


