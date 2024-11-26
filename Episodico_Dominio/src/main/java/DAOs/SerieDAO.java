/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Comentario;
import Entidades.Reseña;
import Entidades.Serie;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import conexion.Conexion;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales
 * Ronjas - 00000245335
 */
public class SerieDAO {

    private final MongoCollection<Serie> seriesCollection;

    // Constructor: obtiene la colección "series" desde la base de datos
    public SerieDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.seriesCollection = database.getCollection("Serie", Serie.class);
    }

    // Método para insertar una nueva serie
    public void insertarSerie(Serie serie) {
        seriesCollection.insertOne(serie);
        System.out.println("Serie insertada: " + serie);
    }

    // Método para buscar una serie por su ID
    public Serie buscarSeriePorId(ObjectId id) {
        return seriesCollection.find(eq("_id", id)).first();
    }

    // Método para obtener todas las series
    public List<Serie> obtenerTodasLasSeries() {
        return seriesCollection.find().into(new ArrayList<>());
    }

    // Método para actualizar los datos de una serie
    public boolean actualizarSerie(ObjectId id, Serie nuevaSerie) {
        UpdateResult result = seriesCollection.replaceOne(eq("_id", id), nuevaSerie);
        return result.getModifiedCount() > 0;
    }

    // Método para eliminar una serie por su ID
    public boolean eliminarSerie(String id) {
        DeleteResult result = seriesCollection.deleteOne(eq("_id", id));
        return result.getDeletedCount() > 0;
    }

    // Métodos adicionales si se requieren para buscar series por ciertos criterios
    public List<Serie> obtenerSeriesPorNombre(String nombre) {
        return seriesCollection.find(eq("nombre", nombre)).into(new ArrayList<>());
    }

    public List<Serie> obtenerSeriesPorCalificacion() {
        // Aquí se puede agregar un filtro y ordenación si es necesario
        return seriesCollection.find().sort(eq("calificacion", -1)).into(new ArrayList<>());
    }

    public List<Serie> obtenerSeriesPorVistas() {
        return seriesCollection.find().sort(eq("vistas", -1)).into(new ArrayList<>());
    }

    public List<Serie> obtenerSeriesPorFechaDeLanzamiento() {
        return seriesCollection.find().sort(eq("fechaDeLanzamiento", -1)).into(new ArrayList<>());
    }
}


