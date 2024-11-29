/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author tacot
 */
@Entity
@Table(name = "anclado")
@DiscriminatorValue("anclado")
public class Anclado extends Post implements Serializable {

    private static final long serialVersionUID = 1L;

    public Anclado() {
    }

    public Anclado(Date fechaHoraCreacion, String titulo, String contenido, String tipo, Serie serieId, Usuario usuarioId) {
        super(fechaHoraCreacion, titulo, contenido, tipo, serieId, usuarioId);
    }
    
    
}
