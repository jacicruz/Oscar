package Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    Connection connection;
    public void connect(String host, String port, String user, String password) {
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
    public void cambiarBaseDeDatos(String nombreBaseDatos) {
        try {
            if(connection != null){
            connection.createStatement().execute("USE " + nombreBaseDatos);
            System.out.println("Usando la base de datos: " + nombreBaseDatos);
            }
        } catch (SQLException e) {
            System.err.println("Error al cambiar de base de datos: " + e.getMessage());
        }
    }
}
