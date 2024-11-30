/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author tacot
 */
@Entity
@Table(name = "anclado")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("anclado")
public class Anclado extends Post implements Serializable {

    private static final long serialVersionUID = 1L;

    public Anclado() {
    }

    public Anclado(Date fechaHoraCreacion, String titulo, String contenido, Serie serieId, Usuario usuarioId) {
        super(fechaHoraCreacion, titulo, contenido,serieId, usuarioId);
    }
    
    
}
