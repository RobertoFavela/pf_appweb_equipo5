/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
import java.util.List;

public class ReseñaDto {

    private String id; // Usamos String en lugar de ObjectId para facilitar la manipulación
    private String titulo;
    private String contenido;
    private int calificacion;
    private Date fechaPublicacion;
    private String serieId; // ID de la serie a la que pertenece la reseña
    private List<ComentarioDto> comentarios; // Lista de comentarios en formato DTO

    // Constructor vacío
    public ReseñaDto() {
    }

    // Constructor con parámetros
    public ReseñaDto(String id, String titulo, String contenido, int calificacion, Date fechaPublicacion, String serieId, List<ComentarioDto> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.calificacion = calificacion;
        this.fechaPublicacion = fechaPublicacion;
        this.serieId = serieId;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        this.calificacion = calificacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getSerieId() {
        return serieId;
    }

    public void setSerieId(String serieId) {
        this.serieId = serieId;
    }

    public List<ComentarioDto> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDto> comentarios) {
        this.comentarios = comentarios;
    }
}


