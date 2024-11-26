/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import Entidades.Reseña;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @authors 
 * Luis Roberto Favela Castro - 00000246853
 * Jesus Alberto Morales Ronjas - 00000245335
 */
public class ReseñaDAO {

    private final MongoCollection<Document> coleccionReseñas;

    public ReseñaDAO(MongoDatabase database) {
        this.coleccionReseñas = database.getCollection("Reseñas");
    }

    // Crear una nueva reseña en la colección
    public void crearReseñaCompleta(Reseña reseña) {
        Document documento = new Document("_id", reseña.getId())
                .append("titulo", reseña.getTitulo())
                .append("contenido", reseña.getContenido())
                .append("calificacion", reseña.getCalificacion())
                .append("fechaPublicacion", reseña.getFechaPublicacion())
                .append("serieId", reseña.getSerieId())
                .append("comentarios", reseña.getComentarios()); // Lista de ObjectId de comentarios

        coleccionReseñas.insertOne(documento);
    }
    
    // Crear una nueva reseña en la colección
    public void crearReseñaCorta(Reseña reseña) {
        Document documento = new Document("_id", reseña.getId())
                .append("contenido", reseña.getContenido()); // Lista de ObjectId de comentarios

        coleccionReseñas.insertOne(documento);
    }

    // Obtener una reseña por su ID
    public Reseña obtenerReseñaPorId(String id) {
        Document documento = coleccionReseñas.find(Filters.eq("_id", new ObjectId(id))).first();
        if (documento != null) {
            return convertirDocumentoAReseña(documento);
        }
        return null;
    }

    // Obtener todas las reseñas
    public List<Reseña> obtenerTodasLasReseñas() {
        List<Reseña> reseñas = new ArrayList<>();
        MongoCursor<Document> cursor = coleccionReseñas.find().iterator();
        try {
            while (cursor.hasNext()) {
                reseñas.add(convertirDocumentoAReseña(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        return reseñas;
    }

    // Actualizar una reseña por su ID
    public boolean actualizarReseña(String id, Reseña nuevaReseña) {
        UpdateResult resultado = coleccionReseñas.updateOne(
                Filters.eq("_id", new ObjectId(id)),
                Updates.combine(
                        Updates.set("titulo", nuevaReseña.getTitulo()),
                        Updates.set("contenido", nuevaReseña.getContenido()),
                        Updates.set("calificacion", nuevaReseña.getCalificacion()),
                        Updates.set("fechaPublicacion", nuevaReseña.getFechaPublicacion()),
                        Updates.set("serieId", nuevaReseña.getSerieId()),
                        Updates.set("comentarios", nuevaReseña.getComentarios())
                )
        );
        return resultado.getModifiedCount() > 0;
    }

    // Eliminar una reseña por su ID
    public boolean eliminarReseña(String id) {
        DeleteResult resultado = coleccionReseñas.deleteOne(Filters.eq("_id", new ObjectId(id)));
        return resultado.getDeletedCount() > 0;
    }

    // Convertir un Document de MongoDB a un objeto Reseña
    private Reseña convertirDocumentoAReseña(Document documento) {
        Reseña reseña = new Reseña();
        reseña.setId(documento.getObjectId("_id"));
        reseña.setTitulo(documento.getString("titulo"));
        reseña.setContenido(documento.getString("contenido"));
        reseña.setCalificacion(documento.getInteger("calificacion"));
        reseña.setFechaPublicacion(documento.getDate("fechaPublicacion"));
        reseña.setSerieId(documento.getObjectId("serieId"));
        return reseña;
    }
}


