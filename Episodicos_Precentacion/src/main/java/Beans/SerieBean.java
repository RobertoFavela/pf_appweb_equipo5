/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.SerieDAO;
import EntidadesSQL.Serie;
import interfaces.ISerieDAO;
import java.util.Date;
import java.util.List;

public class SerieBean {

    private static SerieBean instancia;
    private ISerieDAO serieDAO;

    public static synchronized SerieBean getInstancia() {
        if (instancia == null) {
            instancia = new SerieBean();
        }
        return instancia;
    }

    private SerieBean() {
        serieDAO = new SerieDAO();
    }

    public void guardar(Serie serie) {
        serieDAO.guardar(serie);
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

    public List<Serie> buscarPorGeneros(String genero) {
        return serieDAO.buscarPorGeneros(genero);
    }

    public void actualizar(Serie serie) {
        serieDAO.actualizar(serie);
    }

    public List<Serie> buscarSeriesPorPeriodoDeTiempo(Date fechaInicio, Date fechaFin) {
        return serieDAO.buscarSeriesPorPeriodoDeTiempo(fechaInicio, fechaFin);
    }

    public void eliminar(String titulo) {
        serieDAO.eliminar(titulo);
    }
}
