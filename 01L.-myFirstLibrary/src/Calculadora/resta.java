package Calculadora;

import javax.swing.JOptionPane;

public class resta {
    public void resta(float num, float num2){
        JOptionPane.showMessageDialog(null, "El resultado de la resta es: "+(num-num2));
    }
    public float resta_retorno(float num, float num2){
    return(num-num2);
    }
}
