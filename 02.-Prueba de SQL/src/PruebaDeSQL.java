
import Conector.Conexion;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Tablas.Tablas;
public class PruebaDeSQL {

    public static void main(String[] args) {
        String host = JOptionPane.showInputDialog(null, "Ingresa tu host");
        String puerto = JOptionPane.showInputDialog(null, "Ingresa tu puerto");
        String usuario = JOptionPane.showInputDialog(null, "Ingresa tu usuario");
        String contraseña = JOptionPane.showInputDialog(null, "Ingresa tu contraseña");
        Conexion con = new Conexion();
        Tablas tab = new Tablas();
        int opcion = 100;
        Scanner scan = new Scanner(System.in);
        while (opcion != 0) {
            String menu = ("--------------------------------------------------------\n"
                    + "BIENVENIDO A SU GESTOR DE CONFIANZA \n"
                    + "Favor de escoger una opcion adecuada \n"
                    + "1.- Conectar a MySQL\n"
                    + "2.- Crear base de datos\n"
                    + "3.- Escoger una base de datos\n"
                    + "4.- Crear tabla\n"
                    + "5.- Insertar datos en una tabla\n"
                    + "6.- Actualizar datos en una tabla\n"
                    + "7.- Borrar datos de una tabla\n"
                    + "8.- Borar base de datos\n"
                    + "9.- Desconectar\n"
                    + "0.- Salir\n"
                    + "---------------------------------------------------------");
            try {opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu)); 
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
                    break;
                case 4:
                tab.crearTabla(con.getConnection());
                break;
                
                case 5: 
                    tab.insertarDatos(con.getConnection());
                    break;
                case 6:
                    tab.actualizarDatos(con.getConnection());
                    break;
                case 7:
                    tab.borrarDatos(con.getConnection());
                    break;
                case 8:
                    String bbase = JOptionPane.showInputDialog(null, "Ingresa la base a eliminar");
                    con.borrarbasededatos(bbase);
                    break;
                case 9:
                    con.disconnect();
                    break;                    
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros");
        }}
    }

}
