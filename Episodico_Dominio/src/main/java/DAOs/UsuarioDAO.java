/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import conexion.Conexion;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authors Luis Roberto Favela Castro - 00000246853 Jesus Alberto Morales
 * Ronjas - 00000245335
 */
public class UsuarioDAO {

    private final MongoCollection<Usuario> usuariosCollection;

    // Constructor: obtiene la colección "usuarios" desde la base de datos
    public UsuarioDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.usuariosCollection = database.getCollection("Usuario", Usuario.class);
    }

    // Método para insertar un nuevo usuario
    public boolean insertarUsuario(Usuario usuario) {
        var resultado = usuariosCollection.insertOne(usuario);
        return resultado.wasAcknowledged();
    }

    // Método para buscar un usuario por su ID
    public Usuario buscarUsuarioPorId(ObjectId id) {
        return usuariosCollection.find(eq("_id", id)).first();
    }

    // Método para obtener todos los usuarios de la colección
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuariosCollection.find().into(new ArrayList<>());
    }

    // Método para actualizar los datos de un usuario
    public boolean actualizarUsuario(ObjectId id, Usuario nuevoUsuario) {
        UpdateResult result = usuariosCollection.replaceOne(eq("_id", id), nuevoUsuario);
        return result.getModifiedCount() > 0;
    }

    // Método para eliminar un usuario por su ID
    public boolean eliminarUsuario(ObjectId id) {
        DeleteResult result = usuariosCollection.deleteOne(eq("_id", id));
        return result.getDeletedCount() > 0;
    }

    // Método para validar las credenciales del usuario (inicio de sesión)
    public Usuario validarCredenciales(String correo, String contrasena) {
        Usuario encontrado = usuariosCollection.find(and(eq("correo", correo), eq("contrasena", contrasena))).first();  
        return encontrado;
    }

}
