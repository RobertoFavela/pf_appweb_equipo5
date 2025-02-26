/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
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
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Basic
     @Column(name = "id")
     private Integer id;

     @Basic(optional = false)
     @Column(name = "nombreCompleto")
     private String nombreCompleto;

     @Column(name = "descripcion")
     private String descripcion;

     @Basic(optional = false)
     @Column(name = "correo")
     private String correo;

     @Basic(optional = false)
     @Column(name = "contrasenia")
     private String contrasenia;

     @Column(name = "telefono")
     private String telefono;

     @Column(name = "avatar")
     private String avatar;

     @Column(name = "ciudad")
     private String ciudad;

     @Column(name = "fechaNacimiento")
     @Temporal(TemporalType.DATE)
     private Date fechaNacimiento;

     @Column(name = "genero")
     private String genero;

     @Column(name = "seriesFavoritas")
     private String seriesFavoritas;

     @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
     private Collection<Post> postCollection;

     @JoinColumn(name = "municipio_id", referencedColumnName = "id")
     @ManyToOne
     private Municipio municipioId;

     @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
     private Collection<Comentario> comentarioCollection;

     public Usuario() {
     }

     public Usuario(String nombreCompleto, String correo, String contrasenia) {
          this.nombreCompleto = nombreCompleto;
          this.correo = correo;
          this.contrasenia = contrasenia;
     }

     public Usuario(String nombreCompleto, String descripcion, String correo, String contrasenia, String telefono, String ciudad, Date fechaNacimiento, String genero, Municipio municipioId) {
          this.nombreCompleto = nombreCompleto;
          this.descripcion = descripcion;
          this.correo = correo;
          this.contrasenia = contrasenia;
          this.telefono = telefono;
          this.ciudad = ciudad;
          this.fechaNacimiento = fechaNacimiento;
          this.genero = genero;
          this.municipioId = municipioId;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getNombreCompleto() {
          return nombreCompleto;
     }

     public void setNombreCompleto(String nombreCompleto) {
          this.nombreCompleto = nombreCompleto;
     }

     public String getDescripcion() {
          return descripcion;
     }

     public void setDescripcion(String descripcion) {
          this.descripcion = descripcion;
     }

     public String getCorreo() {
          return correo;
     }

     public void setCorreo(String correo) {
          this.correo = correo;
     }

     public String getContrasenia() {
          return contrasenia;
     }

     public void setContrasenia(String contrasenia) {
          this.contrasenia = contrasenia;
     }

     public String getTelefono() {
          return telefono;
     }

     public void setTelefono(String telefono) {
          this.telefono = telefono;
     }

     public String getAvatar() {
          return avatar;
     }

     public void setAvatar(String avatar) {
          this.avatar = avatar;
     }

     public String getCiudad() {
          return ciudad;
     }

     public void setCiudad(String ciudad) {
          this.ciudad = ciudad;
     }

     public Date getFechaNacimiento() {
          return fechaNacimiento;
     }

     public void setFechaNacimiento(Date fechaNacimiento) {
          this.fechaNacimiento = fechaNacimiento;
     }

     public String getGenero() {
          return genero;
     }

     public void setGenero(String genero) {
          this.genero = genero;
     }

     public String getSeriesFavoritas() {
          return seriesFavoritas;
     }

     public void setSeriesFavoritas(String seriesFavoritas) {
          this.seriesFavoritas = seriesFavoritas;
     }

     public List<Integer> getSeriesFavoritasList() {
          if (seriesFavoritas == null || seriesFavoritas.isEmpty()) {
               return new ArrayList<>();
          }
          return Arrays.stream(seriesFavoritas.split(","))
                  .map(Integer::parseInt)
                  .toList();
     }

     public void addSerieFavorita(Integer serieId) {
          List<Integer> favoritas = getSeriesFavoritasList();
          if (!favoritas.contains(serieId)) {
               favoritas.add(serieId);
               this.seriesFavoritas = String.join(",", favoritas.stream().map(String::valueOf).toList());
          }
     }

     public void removeSerieFavorita(Integer serieId) {
          // Obtener la lista de series favoritas
          List<Integer> favoritas = new ArrayList<>(getSeriesFavoritasList());

          // Eliminar el serieId de la lista
          if (favoritas.remove(serieId)) {
               // Convertir la lista a un String con las series favoritas
               this.seriesFavoritas = String.join(",", favoritas.stream().map(String::valueOf).toList());
          }
     }

     public Collection<Post> getPostCollection() {
          return postCollection;
     }

     public void setPostCollection(Collection<Post> postCollection) {
          this.postCollection = postCollection;
     }

     public Municipio getMunicipioId() {
          return municipioId;
     }

     public void setMunicipioId(Municipio municipioId) {
          this.municipioId = municipioId;
     }

     public Collection<Comentario> getComentarioCollection() {
          return comentarioCollection;
     }

     public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
          this.comentarioCollection = comentarioCollection;
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
          if (!(object instanceof Usuario)) {
               return false;
          }
          Usuario other = (Usuario) object;
          if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
               return false;
          }
          return true;
     }

     @Override
     public String toString() {
          return "Usuario{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", descripcion=" + descripcion + ", correo=" + correo + ", contrasenia=" + contrasenia + ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", postCollection=" + postCollection + ", municipioId=" + municipioId + ", comentarioCollection=" + comentarioCollection + '}';
     }

}
