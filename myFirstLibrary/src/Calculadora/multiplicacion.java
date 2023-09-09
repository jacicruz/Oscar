package Calculadora;

import javax.swing.JOptionPane;

public class multiplicacion {
   public void multiplicar (float num, float num2){
       JOptionPane.showMessageDialog(null,"El resultado de la multiplicacion es: "+(num*num2));
   } 
   public float multiplicacion_retorno (float num, float num2){
       return(num*num2);
   }
}
