package Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String host;
    private final String port;
    private final String user;
    private final String password;
    private final String database = null;
    private Connection connection;

    public Conexion(String host, String port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public void connect() {
     String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/";

     try {
         // Asegúrate de cargar el controlador JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");


         // Establecer la conexión
         connection = DriverManager.getConnection(jdbcUrl, user, password);
         System.out.println("Conexion exitosa a MySQL");
     } catch (ClassNotFoundException e) {
         System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
     } catch (SQLException e) {
         System.err.println("Error al conectar a MySQL: " + e.getMessage());
     }
 }


    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
