/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesSQL;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author tacot
 */
@Entity
@Table(name = "admin")
public class Admin extends Usuario {

    public Admin() {
    }

    
    public Admin(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, Normal normal, Municipio municipioId) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, normal, municipioId);
    }
    
}