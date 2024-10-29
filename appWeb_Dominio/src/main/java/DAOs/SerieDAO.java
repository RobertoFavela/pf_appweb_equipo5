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
    private final ReseñaDAO ReseñaDAO;

    // Constructor: obtiene la colección "series" desde la base de datos
    public SerieDAO(DAOs.ReseñaDAO ReseñaDAO) {
        MongoDatabase database = Conexion.getDatabase();
        this.seriesCollection = database.getCollection("Serie", Serie.class);
        this.ReseñaDAO = ReseñaDAO;
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
    public boolean eliminarSerie(ObjectId id) {
        DeleteResult result = seriesCollection.deleteOne(eq("_id", id));
        return result.getDeletedCount() > 0;
    }

    // Obtener reseñas de una serie mediante el DAO de reseñas
    public List<Reseña> obtenerReseñasDeSerie(ObjectId serieId) {
        // Se obtiene la serie primero
        Serie serie = buscarSeriePorId(serieId);
        if (serie != null) {
            // Instancia de ReseñaDAO se usa para filtrar las reseñas
            List<Reseña> todasLasReseñas = ReseñaDAO.obtenerTodasLasReseñas();
            List<Reseña> reseñasDeSerie = new ArrayList<>();
            for (Reseña r : todasLasReseñas) {
                if (r.getId().equals(serieId)) {
                    reseñasDeSerie.add(r);
                }
            }
            return reseñasDeSerie;
        }
        return new ArrayList<>();
    }

    // Obtener comentarios de una reseña específica mediante el DAO de reseñas
    public List<Comentario> obtenerComentariosDeReseña(ObjectId reseñaId) {
        // Se delega la búsqueda al DAO de reseñas
        Reseña reseña = ReseñaDAO.buscarReseñaPorId(reseñaId);
        if (reseña != null) {
            return reseña.getComentarios();  // Devuelve los comentarios si existe la reseña
        }
        return new ArrayList<>();
    }
}
