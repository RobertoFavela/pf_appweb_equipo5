/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tacot
 */
@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "fechaHoraCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCreacion;
    
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "contenido")
    private String contenido;
    
    @Column(name = "fechaHoraEdicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEdicion;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Serie serieId;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Comentario> comentarioCollection;

    public Post() {
    }
    
    public Post(Date fechaHoraCreacion, String titulo, String contenido, String tipo, Serie serieId, Usuario usuarioId) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.tipo = tipo;
        this.serieId = serieId;
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
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

    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Serie getSerieId() {
        return serieId;
    }

    public void setSerieId(Serie serieId) {
        this.serieId = serieId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

}
