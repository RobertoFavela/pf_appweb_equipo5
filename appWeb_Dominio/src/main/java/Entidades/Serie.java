/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class Serie {
    
    private ObjectId id;
    private String titulo, descripcion;
    private int calificacion, vistas;
    private Date lanzamiento;

    public Serie() {
    }

    public Serie(ObjectId id, String titulo, String descripcion, int calificacion, int vistas, Date lanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.vistas = vistas;
        this.lanzamiento = lanzamiento;
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

    public Date getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Date lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.titulo);
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        hash = 29 * hash + this.calificacion;
        hash = 29 * hash + this.vistas;
        hash = 29 * hash + Objects.hashCode(this.lanzamiento);
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
        final Serie other = (Serie) obj;
        if (this.calificacion != other.calificacion) {
            return false;
        }
        if (this.vistas != other.vistas) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.lanzamiento, other.lanzamiento);
    }

    @Override
    public String toString() {
        return "Serie{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", calificacion=" + calificacion + ", vistas=" + vistas + ", lanzamiento=" + lanzamiento + '}';
    }
    
    
}
