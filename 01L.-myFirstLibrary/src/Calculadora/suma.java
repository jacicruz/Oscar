package Calculadora;

import javax.swing.JOptionPane;

public class suma {
    public void sumar(float num, float num2){
        JOptionPane.showMessageDialog(null, "el resultado de la suma es: "+ (num+num2));
    }
    
    public float sumar_retorno(float num, float num2){
        return(num+num2);
    }
    }