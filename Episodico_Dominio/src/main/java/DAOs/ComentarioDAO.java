/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Comentario;
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
public class ComentarioDAO {
    private final MongoCollection<Comentario> comentariosCollection;

    // Constructor que inicializa la colección "comentarios"
    public ComentarioDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.comentariosCollection = database.getCollection("Comentario", Comentario.class);
    }

    // Crear un nuevo comentario
    public void insertarComentario(Comentario comentario) {
        comentariosCollection.insertOne(comentario);
        System.out.println("Comentario insertado: " + comentario);
    }

    // Buscar comentario por ID
    public Comentario buscarComentarioPorId(ObjectId id) {
        return comentariosCollection.find(eq("_id", id)).first();
    }

    // Obtener todos los comentarios
    public List<Comentario> obtenerTodosLosComentarios() {
        return comentariosCollection.find().into(new ArrayList<>());
    }

    // Actualizar un comentario existente
    public boolean actualizarComentario(ObjectId id, Comentario nuevoComentario) {
        UpdateResult result = comentariosCollection.replaceOne(eq("_id", id), nuevoComentario);
        return result.getModifiedCount() > 0;
    }

    // Eliminar un comentario por ID
    public boolean eliminarComentario(ObjectId id) {
        DeleteResult result = comentariosCollection.deleteOne(eq("_id", id));
        return result.getDeletedCount() > 0;
    }
}

