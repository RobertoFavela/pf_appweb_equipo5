/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logicaSerie;

import dtos.SerieDto;
import java.util.List;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public interface ILogicaSerie {

    /**
     * Método para insertar una nueva serie.
     * 
     * @param serieDTO el DTO que contiene la información de la serie a insertar
     * @return verdadero si la serie fue insertada correctamente, falso en caso contrario
     */
    boolean insertarSerie(SerieDto serieDTO);

    /**
     * Método para buscar una serie por su nombre.
     * 
     * @param nombre el nombre de la serie a buscar
     * @return una lista de series que coinciden con el nombre
     */
    List<SerieDto> buscarSeriesPorNombre(String nombre);

    /**
     * Método para obtener todas las series.
     * 
     * @return una lista de todas las series
     */
    List<SerieDto> obtenerTodasLasSeries();

    /**
     * Método para obtener todas las series ordenadas por calificación.
     * 
     * @return una lista de todas las series ordenadas por calificación (de mayor a menor)
     */
    List<SerieDto> obtenerSeriesPorCalificacion();

    /**
     * Método para obtener todas las series ordenadas por la cantidad de vistas.
     * 
     * @return una lista de todas las series ordenadas por cantidad de vistas (de mayor a menor)
     */
    List<SerieDto> obtenerSeriesPorVistas();

    /**
     * Método para obtener todas las series ordenadas por fecha de lanzamiento.
     * 
     * @return una lista de todas las series ordenadas por fecha de lanzamiento (de más reciente a más antigua)
     */
    List<SerieDto> obtenerSeriesPorFechaDeLanzamiento();

    /**
     * Método para actualizar los datos de una serie.
     * 
     * @param serieDTO el DTO que contiene la nueva información de la serie
     * @return verdadero si la serie fue actualizada correctamente, falso en caso contrario
     */
    boolean actualizarSerie(SerieDto serieDTO);

    /**
     * Método para eliminar una serie por su ID.
     * 
     * @param serieId el ID de la serie a eliminar
     * @return verdadero si la serie fue eliminada correctamente, falso en caso contrario
     */
    boolean eliminarSerie(String serieId);
}

