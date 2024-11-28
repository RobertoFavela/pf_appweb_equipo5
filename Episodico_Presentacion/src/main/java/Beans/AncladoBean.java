/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.AncladoDAO;
import EntidadesSQL.Anclado;
import interfaces.IAncladoDAO;
import java.util.List;

public class AncladoBean {
    private IAncladoDAO ancladoDAO;
    private Anclado anclado;
    private List<Anclado> listaAnclados;

    public void init() {
        ancladoDAO = new AncladoDAO();
        anclado = new Anclado();
        listaAnclados = ancladoDAO.buscarTodos();
    }

    public void guardar() {
        ancladoDAO.guardar(anclado);
        anclado = new Anclado();
        listaAnclados = ancladoDAO.buscarTodos();
    }

    public void eliminar(int id) {
        ancladoDAO.eliminar(id);
        listaAnclados = ancladoDAO.buscarTodos();
    }

    public Anclado buscarPorId(int id) {
        return ancladoDAO.buscarPorId(id);
    }

    public List<Anclado> getListaAnclados() {
        return listaAnclados;
    }

    public Anclado getAnclado() {
        return anclado;
    }

    public void setAnclado(Anclado anclado) {
        this.anclado = anclado;
    }
}
