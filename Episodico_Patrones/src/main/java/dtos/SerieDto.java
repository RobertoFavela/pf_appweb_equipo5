/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 * @author favel
 */
public class SerieDto {

    private String titulo;
    private String descripcion;
    private int lanzamiento;
    private int calificacion;
    private int vistas;
    private byte[] imagen;  

    // Constructor
    public SerieDto(String titulo, String descripcion, int lanzamiento, int calificacion, int vistas, byte[] imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.lanzamiento = lanzamiento;
        this.calificacion = calificacion;
        this.vistas = vistas;
        this.imagen = imagen;
    }
    
    public SerieDto() {
         
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "SerieDTO{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", lanzamiento=" + lanzamiento +
                ", calificacion=" + calificacion +
                ", vistas=" + vistas +
                ", imagen=" + (imagen != null ? "Present" : "No Present") +  // Solo muestra un indicador si la imagen está presente
                '}';
    }
}

