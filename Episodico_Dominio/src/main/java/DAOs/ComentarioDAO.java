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
import Entidades.Comentario;
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
public class ComentarioDAO {

    private final MongoCollection<Document> coleccionComentarios;

    public ComentarioDAO(MongoDatabase database) {
        this.coleccionComentarios = database.getCollection("Comentarios");
    }

    // Crear un nuevo comentario en la colección
    public void crearComentario(Comentario comentario) {
        Document documento = new Document("_id", comentario.getId())
                .append("contenido", comentario.getContenido())
                .append("autor", comentario.getAutor())
                .append("fechaComentario", comentario.getFechaComentario());

        coleccionComentarios.insertOne(documento);
    }

    // Obtener un comentario por su ID
    public Comentario obtenerComentarioPorId(String id) {
        Document documento = coleccionComentarios.find(Filters.eq("_id", new ObjectId(id))).first();
        if (documento != null) {
            return convertirDocumentoAComentario(documento);
        }
        return null;
    }

    // Obtener todos los comentarios
    public List<Comentario> obtenerTodosLosComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
        MongoCursor<Document> cursor = coleccionComentarios.find().iterator();
        try {
            while (cursor.hasNext()) {
                comentarios.add(convertirDocumentoAComentario(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        return comentarios;
    }

    // Actualizar un comentario por su ID
    public boolean actualizarComentario(String id, Comentario nuevoComentario) {
        UpdateResult resultado = coleccionComentarios.updateOne(
                Filters.eq("_id", new ObjectId(id)),
                Updates.combine(
                        Updates.set("contenido", nuevoComentario.getContenido()),
                        Updates.set("autor", nuevoComentario.getAutor()),
                        Updates.set("fechaComentario", nuevoComentario.getFechaComentario())
                )
        );
        return resultado.getModifiedCount() > 0;
    }

    // Eliminar un comentario por su ID
    public boolean eliminarComentario(String id) {
        DeleteResult resultado = coleccionComentarios.deleteOne(Filters.eq("_id", new ObjectId(id)));
        return resultado.getDeletedCount() > 0;
    }

    // Convertir un Document de MongoDB a un objeto Comentario
    private Comentario convertirDocumentoAComentario(Document documento) {
        Comentario comentario = new Comentario();
        comentario.setId(documento.getObjectId("_id"));
        comentario.setContenido(documento.getString("contenido"));
        comentario.setAutor(documento.getString("autor"));
        comentario.setFechaComentario(documento.getDate("fechaComentario"));
        return comentario;
    }
}

