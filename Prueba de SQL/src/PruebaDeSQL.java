
import Conector.Conexion;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PruebaDeSQL {

    public static void main(String[] args) {
        String host = JOptionPane.showInputDialog(null, "Ingresa tu host");
        String puerto = JOptionPane.showInputDialog(null, "Ingresa tu puerto");
        String usuario = JOptionPane.showInputDialog(null, "Ingresa tu usuario");
        String contraseña = JOptionPane.showInputDialog(null, "Ingresa tu contraseña");
        Conexion con = new Conexion();
        short opcion = 1000;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("--------------------------------------------------------\n"
                    + "BIENVENIDO A SY GESTOR DE CONFIANZA \n"
                    + "Favor de escoger una opcion adecuada \n"
                    + "1.- Conectar a MySQL\n"
                    + "2.- Escoger una base de datos\n"
                    + "3.- Crear tabla\n"
                    + "4.- Insertar datos en una tabla\n"
                    + "5.- actualizar datos en una tabla\n"
                    + "6.- Borrar datos de una tabla\n"
                    + "7.- Borar base de datos\n"
                    + "8.- Desconectar\n"
                    + "0.- Salir\n"
                    + "---------------------------------------------------------");
            opcion = scan.nextShort();
            switch (opcion) {
                case 1:
                    con.connect(host, puerto, usuario, contraseña);
                    break;
                case 2:
                    String base = JOptionPane.showInputDialog(null, "Ingresa la base a usar");
                    con.cambiarBaseDeDatos(base);
            }
        } while (opcion != 0);
    }

}
