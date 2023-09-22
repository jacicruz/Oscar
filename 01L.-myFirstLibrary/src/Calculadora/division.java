package Calculadora;

import javax.swing.JOptionPane;

public class division {

    public void dividir(float num, float num2) {
        if (num2 != 0.0) {
            JOptionPane.showMessageDialog(null, "El resultado de la division es: " + (num / num2));
        } else {
            JOptionPane.showMessageDialog(null, "No existe la division entre 0");
        }
    }

    public float division_retorno(float num, float num2) {
        if (num2 != 0.0) {
            return (num / num2);
        } else {
            JOptionPane.showMessageDialog(null, "No existe la division entre 0");
            System.exit(0);
        }
        return 0;

    }
}
