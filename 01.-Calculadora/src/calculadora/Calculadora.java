package calculadora;

import Calculadora.division;
import Calculadora.multiplicacion;
import Calculadora.suma;
import Calculadora.resta;

import javax.swing.JOptionPane;

public class Calculadora {

    public static void main(String[] args) {
        suma sumar = new suma();
        sumar.sumar(7, 7);
        JOptionPane.showMessageDialog(null, "el resultado es: " + sumar.sumar_retorno(5, 5));

        resta restar = new resta();
        restar.resta(10, 5);
        JOptionPane.showMessageDialog(null, "el resultado es: " + restar.resta_retorno(8, 3));

        multiplicacion multiplicar = new multiplicacion();
        multiplicar.multiplicar(5, 2);
        JOptionPane.showMessageDialog(null, "el resultado es: " + multiplicar.multiplicacion_retorno(3, 2));

        division dividir = new division();
        dividir.dividir(8, 2);
        JOptionPane.showMessageDialog(null, "El resultado es: " + (dividir.division_retorno(8, 5)));
    }

}
