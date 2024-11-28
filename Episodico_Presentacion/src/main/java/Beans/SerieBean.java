/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.SerieDAO;
import EntidadesSQL.Serie;
import java.util.List;
import interfaces.ISerieDAO;
import java.util.List;

public class SerieBean {

    private static SerieBean instancia;
    private ISerieDAO serieDAO;
    private Serie serie;
    private List<Serie> listaSeries;

    public static synchronized SerieBean getInstancia() {
        if (instancia == null) {
            instancia = new SerieBean();
        }
        return instancia;
    }

    public void init() {
        serieDAO = new SerieDAO();
        serie = new Serie();
        listaSeries = serieDAO.buscarTodas();
    }

    public void guardar() {
        serieDAO.guardar(serie);
        serie = new Serie();
        listaSeries = serieDAO.buscarTodas();
    }

    public void eliminar(String nombre) {
        Serie serie = serieDAO.buscarPorTitulo(nombre);
        serieDAO.eliminar(serie.getTitulo());
        listaSeries = serieDAO.buscarTodas();
    }

    public void modificar(Serie serie) {
        serieDAO.actualizar(serie);
        listaSeries = serieDAO.buscarTodas();
    }

     
     public List<Serie> buscarTodas() {
           return serieDAO.buscarTodas();
     }
    public Serie buscarPorId(int id) {
        return serieDAO.buscarPorId(id);
    }

    public Serie buscarPorTitulo(String titulo) {
        return serieDAO.buscarPorTitulo(titulo);
    }

    public List<Serie> getListaSeries() {
        return listaSeries;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
