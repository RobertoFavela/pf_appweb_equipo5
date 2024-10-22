/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class Reseña {
    private String titulo, reseña;
    private int califiacion;
    private Date creacion;

    public Reseña() {
    }

    public Reseña(String titulo, String reseña, int califiacion, Date creacion) {
        this.titulo = titulo;
        this.reseña = reseña;
        this.califiacion = califiacion;
        this.creacion = creacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getReseña() {
        return reseña;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }

    public int getCalifiacion() {
        return califiacion;
    }

    public void setCalifiacion(int califiacion) {
        this.califiacion = califiacion;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.titulo);
        hash = 37 * hash + Objects.hashCode(this.reseña);
        hash = 37 * hash + this.califiacion;
        hash = 37 * hash + Objects.hashCode(this.creacion);
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
        final Reseña other = (Reseña) obj;
        if (this.califiacion != other.califiacion) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.reseña, other.reseña)) {
            return false;
        }
        return Objects.equals(this.creacion, other.creacion);
    }

    @Override
    public String toString() {
        return "Rese\u00f1a{" + "titulo=" + titulo + ", rese\u00f1a=" + reseña + ", califiacion=" + califiacion + ", creacion=" + creacion + '}';
    }
    
    
}
