/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class SerieDto {

     private String id;
    private String titulo;
    private String descripcion;
    private int lanzamiento;
    private int calificacion;
    private int vistas;
//    private byte[] imagen;  

     public SerieDto(String id, String titulo, String descripcion, int lanzamiento, int calificacion, int vistas) {
          this.id = id;
          this.titulo = titulo;
          this.descripcion = descripcion;
          this.lanzamiento = lanzamiento;
          this.calificacion = calificacion;
          this.vistas = vistas;
     }
    
    /*
     Constructor con el array de bytes para la imagen que aun no esta implementado
     */
//    public SerieDto(String titulo, String descripcion, int lanzamiento, int calificacion, int vistas, byte[] imagen) {
//        this.titulo = titulo;
//        this.descripcion = descripcion;
//        this.lanzamiento = lanzamiento;
//        this.calificacion = calificacion;
//        this.vistas = vistas;
//        this.imagen = imagen;
//    }
    
    public SerieDto() {
         
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

    /*
    Getter y setter para la imagen y el toString con la imagen
    */
//    public byte[] getImagen() {
//        return imagen;
//    }
//
//    public void setImagen(byte[] imagen) {
//        this.imagen = imagen;
//    }
//
//    @Override
//    public String toString() {
//        return "SerieDTO{" +
//                "titulo='" + titulo + '\'' +
//                ", descripcion='" + descripcion + '\'' +
//                ", lanzamiento=" + lanzamiento +
//                ", calificacion=" + calificacion +
//                ", vistas=" + vistas +
//                ", imagen=" + (imagen != null ? "Present" : "No Present") +  // Solo muestra un indicador si la imagen está presente
//                '}';
//    }

     @Override
     public String toString() {
          return "SerieDto{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", lanzamiento=" + lanzamiento + ", calificacion=" + calificacion + ", vistas=" + vistas + '}';
     }
}

