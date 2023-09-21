package Tablas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Tablas {
    public static void crearTabla(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa el nombre de la tabla: ");
        String nombreTabla = scanner.nextLine();
        
        System.out.print("Ingresa el número de columnas: ");
        int numColumnas = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        
        StringBuilder sql = new StringBuilder("CREATE TABLE " + nombreTabla + " (");

        for (int i = 0; i < numColumnas; i++) {
            System.out.print("Nombre de la columna " + (i + 1) + ": ");
            String nombreColumna = scanner.nextLine();
            
            System.out.print("Tipo de datos para " + nombreColumna + " (por ejemplo, VARCHAR(255)): ");
            String tipoColumna = scanner.nextLine();
            
            sql.append(nombreColumna).append(" ").append(tipoColumna);
            if (i < numColumnas - 1) {
                sql.append(", ");
            }
        }

        sql.append(")");
        
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql.toString());
            System.out.println("Tabla creada con éxito: " + nombreTabla);
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}

    
