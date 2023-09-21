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
            }else{
                System.out.println("No tienes una conexion establecida");
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
            }else {
            System.out.println("La base de datos no existe");
            }
        } catch (SQLException e) {
            System.err.println("Error al cambiar de base de datos: " + e.getMessage());
        }
    }
    
    public void crearbasededatos(String nombreBase){
    try{
        if(connection != null){
        connection.createStatement().execute("CREATE DATABASE "+nombreBase);
        System.out.println("Se creo con exito la base de datos: "+nombreBase);
        } else{
            System.out.println("No tienes una conexion");
        }
    }catch(SQLException e){
        System.out.println("Ocurrio un error al crear la base de datos");
        System.out.println(e.getMessage());
    }
    }
    
    public void borrarbasededatos(String nombre){
    try{
        if(connection != null){
        connection.createStatement().execute("DROP DATABASE "+nombre);
        System.out.println("Se elimino con exito la base de datos: "+nombre);       
        }else {
        System.out.println("No tienes una conexion");
        }
    }catch(SQLException e){
        System.out.println("Ocurrio un problema al eliminar la base de datos: "+nombre);
        System.out.println(e.getMessage());
    }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
