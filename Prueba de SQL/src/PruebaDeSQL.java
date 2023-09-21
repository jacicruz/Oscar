
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
                    + "2.- Crear base de datos\n"
                    + "3.- Escoger una base de datos\n"
                    + "4.- Crear tabla\n"
                    + "5.- Insertar datos en una tabla\n"
                    + "6.- actualizar datos en una tabla\n"
                    + "7.- Borrar datos de una tabla\n"
                    + "8.- Borar base de datos\n"
                    + "9.- Desconectar\n"
                    + "0.- Salir\n"
                    + "---------------------------------------------------------");
            opcion = scan.nextShort();
            switch (opcion) {
                case 1:
                    con.connect(host, puerto, usuario, contraseña);
                    break;
                case 2:
                    String cbase = JOptionPane.showInputDialog(null,"Ingresa el nombre de la base a crear");
                    con.crearbasededatos(cbase);
                    break;
                case 3:
                    String base = JOptionPane.showInputDialog(null, "Ingresa la base a usar");
                    con.cambiarBaseDeDatos(base);
            }
        } while (opcion != 0);
    }

}
