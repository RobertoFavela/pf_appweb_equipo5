/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.ComunDAO;
import EntidadesSQL.Comun;
import interfaces.IComunDAO;
import java.util.List;

/**
 *
 * @author tacot
 */
public class ComunBean {
    
    private IComunDAO comunDAO;
    private Comun comun;
    private List<Comun> listaComunes;

    public void init() {
        comunDAO = new ComunDAO();
        comun = new Comun();
        listaComunes = comunDAO.buscarTodos();
    }

    public void guardar() {
        comunDAO.guardar(comun);
        comun = new Comun();
        listaComunes = comunDAO.buscarTodos();
    }

    public void eliminar(int id) {
        comunDAO.eliminar(id);
        listaComunes = comunDAO.buscarTodos();
    }

    public Comun buscarPorId(int id) {
        return comunDAO.buscarPorId(id);
    }

    public List<Comun> getListaComunes() {
        return listaComunes;
    }

    public Comun getComun() {
        return comun;
    }

    public void setComun(Comun comun) {
        this.comun = comun;
    }
}

