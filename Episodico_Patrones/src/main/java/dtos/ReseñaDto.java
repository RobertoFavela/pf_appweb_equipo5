/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
import java.util.List;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class ReseñaDto {

    private String id;
    private String titulo;
    private String contenido;
    private int calificacion;
    private Date fechaPublicacion;
    private String serieId; 
    private List<ComentarioDto> comentarios; 

    public ReseñaDto() {
    }

    public ReseñaDto(String id, String titulo, String contenido, int calificacion, Date fechaPublicacion, String serieId, List<ComentarioDto> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.calificacion = calificacion;
        this.fechaPublicacion = fechaPublicacion;
        this.serieId = serieId;
        this.comentarios = comentarios;
    }

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


