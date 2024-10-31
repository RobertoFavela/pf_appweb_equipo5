/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoInicioSesion;

import logicaIniciarSesion.LogicaIniciarSesion;

/**
 *
 * @author favel
 */
public class LogInModel {
     
     private final LogicaIniciarSesion logicaIniciarSesion;
     
     public LogInModel() {
          this.logicaIniciarSesion = new LogicaIniciarSesion();
     }
     
     public boolean iniciarSesion(String usuario, String contrasena) {
          return logicaIniciarSesion.iniciarSesion(usuario, contrasena);
     }
     
}
