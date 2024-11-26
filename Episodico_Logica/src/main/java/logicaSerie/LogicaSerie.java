/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaSerie;

import DAOs.SerieDAO;
import dtos.SerieDto;
import Entidades.Serie;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class LogicaSerie implements ILogicaSerie {

    private final SerieDAO serieDAO;

    public LogicaSerie() {
        this.serieDAO = new SerieDAO();
    }

    /**
     * Convierte un SerieDTO en una entidad Serie.
     * Este método se usa para evitar la conversión repetida en los métodos de la lógica.
     *
     * @param serieDTO el DTO que contiene los datos de la serie
     * @return una entidad Serie correspondiente al DTO
     */
    private Serie convertirDtoAEntidad(SerieDto serieDTO) {
        Serie serie = new Serie();
        serie.setTitulo(serieDTO.getTitulo());
        serie.setDescripcion(serieDTO.getDescripcion());
        serie.setCalificacion(serieDTO.getCalificacion());
        serie.setLanzamiento(serieDTO.getLanzamiento());
        serie.setVistas(serieDTO.getVistas());
        serie.setLanzamiento(serieDTO.getLanzamiento());
//        serie.setImagen(serieDTO.getImagen()); // Imagen como bytes
        return serie;
    }

    @Override
    public boolean insertarSerie(SerieDto serieDTO) {
        Serie serie = convertirDtoAEntidad(serieDTO);
        serieDAO.insertarSerie(serie);
        return true; 
    }

    @Override
    public List<SerieDto> buscarSeriesPorNombre(String nombre) {
        List<Serie> series = serieDAO.obtenerSeriesPorNombre(nombre);
        return series.stream()
                     .map(this::convertirEntidadADto) 
                     .collect(Collectors.toList());
    }

    @Override
    public List<SerieDto> obtenerTodasLasSeries() {
        List<Serie> series = serieDAO.obtenerTodasLasSeries();
        return series.stream()
                     .map(this::convertirEntidadADto) 
                     .collect(Collectors.toList());
    }

    @Override
    public List<SerieDto> obtenerSeriesPorCalificacion() {
        List<Serie> series = serieDAO.obtenerSeriesPorCalificacion();
        return series.stream()
                     .map(this::convertirEntidadADto) 
                     .collect(Collectors.toList());
    }

    @Override
    public List<SerieDto> obtenerSeriesPorVistas() {
        List<Serie> series = serieDAO.obtenerSeriesPorVistas();
        return series.stream()
                     .map(this::convertirEntidadADto) 
                     .collect(Collectors.toList());
    }

    @Override
    public List<SerieDto> obtenerSeriesPorFechaDeLanzamiento() {
        List<Serie> series = serieDAO.obtenerSeriesPorFechaDeLanzamiento();
        return series.stream()
                     .map(this::convertirEntidadADto) 
                     .collect(Collectors.toList());
    }

    @Override
    public boolean actualizarSerie(SerieDto serieDTO) {
        Serie serie = convertirDtoAEntidad(serieDTO);
        return serieDAO.actualizarSerie(serie.getId(), serie);
    }

    @Override
    public boolean eliminarSerie(String serieId) {
        return serieDAO.eliminarSerie(serieId);
    }

    /**
     * Convierte una entidad Serie a su DTO correspondiente.
     *
     * @param serie la entidad Serie a convertir
     * @return el DTO correspondiente
     */
    private SerieDto convertirEntidadADto(Serie serie) {
        SerieDto serieDTO = new SerieDto();
        serieDTO.setId(serie.getId().toString());
        serieDTO.setTitulo(serie.getTitulo());
        serieDTO.setDescripcion(serie.getDescripcion());
        serieDTO.setCalificacion(serie.getCalificacion());
        serieDTO.setVistas(serie.getVistas());
        serieDTO.setLanzamiento(serie.getLanzamiento());
//        serieDTO.setImagen(serie.getImagen()); // Convertir de byte[] a formato adecuado si es necesario
        return serieDTO;
    }
}

