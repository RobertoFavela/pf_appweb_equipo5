/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Reseña {

    private ObjectId id; // ID único de la reseña
    private String titulo; // Título de la reseña
    private String contenido; // Contenido de la reseña
    private int calificacion; // Calificación entre 1 y 5
    private Date fechaPublicacion; // Fecha de publicación
    private ObjectId serieId; // ID de la serie a la que pertenece la reseña
    private List<Comentario> comentarios; // Lista de comentarios asociados a la reseña

    // Constructor vacío
    public Reseña() {
        this.fechaPublicacion = new Date(); // Fecha actual al crear la reseña
        this.comentarios = new ArrayList<>();
    }

    // Constructor con parámetros
    public Reseña(ObjectId id, String titulo, String contenido, int calificacion, ObjectId serieId) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        setCalificacion(calificacion);
        this.fechaPublicacion = new Date(); // Fecha actual al crear la reseña
        this.serieId = serieId;
        this.comentarios = new ArrayList<>();
    }

    // Getters y Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
        this.calificacion = calificacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public ObjectId getSerieId() {
        return serieId;
    }

    public void setSerieId(ObjectId serieId) {
        this.serieId = serieId;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void agregarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    @Override
    public String toString() {
        return "Reseña{" + 
               "titulo='" + titulo + '\'' +
               ", calificacion=" + calificacion +
               ", fechaPublicacion=" + fechaPublicacion +
               '}';
    }
}

