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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Normal")
public class Normal extends Usuario {

    public Normal() {
    }

    public Normal(String nombreCompleto, String correo, String contrasenia) {
        super(nombreCompleto, correo, contrasenia);
    }

    public Normal(String nombreCompleto, String correo, String contrasenia, String telefono, String ciudad, Date fechaNacimiento, String genero, Municipio municipioId) {
        super(nombreCompleto, correo, contrasenia, telefono, ciudad, fechaNacimiento, genero, municipioId);
    }
    
}

