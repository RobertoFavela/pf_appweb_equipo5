/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author tacot
 */
@Entity
@Table(name = "Administrador")
@DiscriminatorValue("Administrador")
public class Admin extends Usuario {

    public Admin() {
    }

    public Admin(String nombreCompleto, String correo, String contrasenia) {
        super(nombreCompleto, correo, contrasenia);
    }

    public Admin(String nombreCompleto, String descripcion, String correo, String contrasenia, String telefono, String ciudad, Date fechaNacimiento, String genero, Municipio municipioId) {
        super(nombreCompleto, descripcion, correo, contrasenia, telefono, ciudad, fechaNacimiento, genero, municipioId);
    }

}