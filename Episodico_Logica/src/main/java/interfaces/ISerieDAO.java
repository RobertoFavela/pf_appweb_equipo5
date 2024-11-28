/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;

import EntidadesSQL.Serie;

/**
 *
 * @author tacot
 */
public interface ISerieDAO {
    public void guardar(Serie serie);
    
    public List<Serie> buscarTodas();
    
    public Serie buscarPorId(Integer id);
    
    public Serie buscarPorTitulo(String titulo);
    
    public List<Serie> buscarPorGeneros(String genero);
    
    public void actualizar(Serie serie);
    
    public void eliminar(Integer id) ;
}
