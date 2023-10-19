package Tablas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Tablas {
  public static void crearTabla(Connection connection, String nombreTabla, int numColumnas) {
    if (nombreTabla == null || nombreTabla.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El nombre de la tabla no puede estar vacío.");
        return;
    }

    if (numColumnas <= 0) {
        JOptionPane.showMessageDialog(null, "El número de columnas debe ser un número entero positivo.");
        return;
    }

    StringBuilder sql = new StringBuilder("CREATE TABLE " + nombreTabla + " (");

    for (int i = 0; i < numColumnas; i++) {
        String nombreColumna = JOptionPane.showInputDialog(null, "Nombre de la columna " + (i + 1) + ":");
        if (nombreColumna == null || nombreColumna.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre de la columna no puede estar vacío.");
            return;
        }

        String tipoColumna = JOptionPane.showInputDialog(null, "Tipo de datos para " + nombreColumna + ":");
        if (tipoColumna == null || tipoColumna.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tipo de datos para la columna no puede estar vacío.");
            return;
        }

        sql.append(nombreColumna).append(" ").append(tipoColumna);
        if (i < numColumnas - 1) {
            sql.append(", ");
        }
    }

    sql.append(")");

    try (Statement statement = connection.createStatement()) {
        statement.executeUpdate(sql.toString());
        JOptionPane.showMessageDialog(null, "Tabla creada con éxito: " + nombreTabla);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al crear la tabla: " + e.getMessage());
    }
}

    public static void insertarDatos(Connection connection) {
        String nombreTabla = JOptionPane.showInputDialog(null, "Ingresa el nombre de la tabla en la que deseas insertar datos:");

        String datos = JOptionPane.showInputDialog(null, "Ingresa los datos a insertar separados por comas (por ejemplo, 'valor1, valor2, valor3'):");

        String[] valores = datos.split(", ");

        StringBuilder sql = new StringBuilder("INSERT INTO " + nombreTabla + " VALUES (");
        for (int i = 0; i < valores.length; i++) {
            sql.append("?");
            if (i < valores.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
            for (int i = 0; i < valores.length; i++) {
                preparedStatement.setString(i + 1, valores[i]);
            }
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos insertados con éxito en la tabla: " + nombreTabla);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos en la tabla: " + e.getMessage());
}
    }
    public static void actualizarDatos(Connection connection) {
        String nombreTabla = JOptionPane.showInputDialog(null, "Ingresa el nombre de la tabla que contiene los datos a actualizar:");

        String columnaActualizar = JOptionPane.showInputDialog(null, "Ingresa el nombre de la columna a actualizar:");

        String nuevoValor = JOptionPane.showInputDialog(null, "Ingresa el nuevo valor para la columna " + columnaActualizar + ":");

        String condicion = JOptionPane.showInputDialog(null, "Ingresa la condición para la actualización (por ejemplo, 'id = 5'):");

        String sql = "UPDATE " + nombreTabla + " SET " + columnaActualizar + " = ? WHERE " + condicion;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevoValor);
            int rowCount = preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se han actualizado " + rowCount + " filas en la tabla: " + nombreTabla);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos en la tabla: " + e.getMessage());
        }
    }
 public static void borrarDatos(Connection connection) {
        String nombreTabla = JOptionPane.showInputDialog(null, "Ingresa el nombre de la tabla en la que deseas borrar datos:");

        String condicion = JOptionPane.showInputDialog(null, "Ingresa la condición para el borrado (por ejemplo, 'id = 5'):");

        String sql = "DELETE FROM " + nombreTabla + " WHERE " + condicion;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int rowCount = preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se han borrado " + rowCount + " filas de la tabla: " + nombreTabla);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al borrar datos de la tabla: " + e.getMessage());
        }
    }
}
