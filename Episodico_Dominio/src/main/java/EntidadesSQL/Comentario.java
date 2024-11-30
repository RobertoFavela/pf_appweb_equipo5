/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tacot
 */
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "contenido")
    private String contenido;
    
    @OneToMany(mappedBy = "comentarioPadreId")
    private List<Comentario> comentarioCollection;
    
    @JoinColumn(name = "comentario_padre_id", referencedColumnName = "id")
    @ManyToOne
    private Comentario comentarioPadreId;
    
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Post postId;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Comentario() {
    }

    public Comentario(Date fechaHora, String contenido, Comentario comentarioPadreId, Post postId, Usuario usuarioId) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comentarioPadreId = comentarioPadreId;
        this.postId = postId;
        this.usuarioId = usuarioId;
    }

    public Comentario(Integer id) {
        this.id = id;
    }

    public Comentario(Integer id, Date fechaHora, String contenido) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(List<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    public Comentario getComentarioPadreId() {
        return comentarioPadreId;
    }

    public void setComentarioPadreId(Comentario comentarioPadreId) {
        this.comentarioPadreId = comentarioPadreId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntidadesSQL.Comentario[ id=" + id + " ]";
    }
    
}
