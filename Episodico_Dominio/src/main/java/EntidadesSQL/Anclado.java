/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tacot
 */
@Entity
@Table(name = "anclado")
@NamedQueries({
    @NamedQuery(name = "Anclado.findAll", query = "SELECT a FROM Anclado a"),
    @NamedQuery(name = "Anclado.findById", query = "SELECT a FROM Anclado a WHERE a.id = :id")})
public class Anclado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "Admin_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Admin adminid;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Post post;

    public Anclado() {
    }

    public Anclado(Admin adminid, Post post) {
        this.adminid = adminid;
        this.post = post;
    }

    public Anclado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Admin getAdminid() {
        return adminid;
    }

    public void setAdminid(Admin adminid) {
        this.adminid = adminid;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
        if (!(object instanceof Anclado)) {
            return false;
        }
        Anclado other = (Anclado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntidadesSQL.Anclado[ id=" + id + " ]";
    }
    
}
