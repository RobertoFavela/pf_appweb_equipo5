/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Comentario;
import Entidades.Reseña;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import static com.mongodb.client.model.Filters.eq;
import conexion.Conexion;
import org.bson.types.ObjectId;
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
    private final MongoCollection<Reseña> reseñasCollection;

    // Constructor que inicializa la conexión con la colección "reseñas"
    public ReseñaDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.reseñasCollection = database.getCollection("Reseña", Reseña.class);
    }

    // Crear una nueva reseña
    public void insertarReseña(Reseña reseña) {
        reseñasCollection.insertOne(reseña);
        System.out.println("Reseña insertada: " + reseña);
    }

    // Buscar reseña por ID
    public Reseña buscarReseñaPorId(ObjectId id) {
        return reseñasCollection.find(eq("_id", id)).first();
    }

    // Obtener todas las reseñas
    public List<Reseña> obtenerTodasLasReseñas() {
        return reseñasCollection.find().into(new ArrayList<>());
    }

    // Actualizar una reseña existente
    public boolean actualizarReseña(ObjectId id, Reseña nuevaReseña) {
        UpdateResult result = reseñasCollection.replaceOne(eq("_id", id), nuevaReseña);
        return result.getModifiedCount() > 0;
    }

    // Eliminar reseña por ID
    public boolean eliminarReseña(ObjectId id) {
        DeleteResult result = reseñasCollection.deleteOne(eq("_id", id));
        return result.getDeletedCount() > 0;
    }

    // Obtener los comentarios de una reseña específica
    public List<Comentario> obtenerComentariosDeReseña(ObjectId reseñaId) {
        Reseña reseña = buscarReseñaPorId(reseñaId);
        return reseña != null ? reseña.getComentarios() : new ArrayList<>();
    }
}

