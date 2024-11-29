package interfaces;

import java.util.List;

import EntidadesSQL.Serie;
import java.util.Date;

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
    
    public List<Serie> buscarSeriesPorPeriodoDeTiempo(Date fechaInicio, Date fechaFin);
    
    public void eliminar(Integer id) ;
}
