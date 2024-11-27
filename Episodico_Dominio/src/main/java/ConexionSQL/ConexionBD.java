package ConexionSQL;

/**
 *
 * 
 * @author tacot
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD instancia; // Instancia única de la clase
    private Connection conexion;

    // Cambiar estos valores según la configuración de tu base de datos
    private static final String URL = "jdbc:mysql://localhost:3309/SeriesDB";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "18931Mor";

    // Constructor privado para evitar instancias externas
    private ConexionBD() {
        try {
            // Registrar el driver de MySQL (opcional desde Java 6)
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    // Método público para obtener la instancia única
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            synchronized (ConexionBD.class) {
                if (instancia == null) { // Doble chequeo
                    instancia = new ConexionBD();
                }
            }
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }

    // Método para cerrar la conexión (si es necesario)
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

