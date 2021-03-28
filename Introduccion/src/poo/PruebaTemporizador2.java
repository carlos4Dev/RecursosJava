package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        /* Si utilizamos constructor con parámetros
         * Reloj miReloj = new Reloj(3000,  true);
         
         * miReloj.enMarcha();
        */
        
        // Si utilizamos una clase interna local, pasando los parámetros en el método enMarcha
        Reloj miReloj = new Reloj();
        miReloj.enMarcha(3000, true);
        
        JOptionPane.showMessageDialog(null, "Pulsa Acepta para terminar");
        System.exit(0);
        
    }

}

class Reloj {
    
    /* Al utilizar una clase interna local se puede prescindir de estas variables
     * Utilizaremos estas variables como parámetros del método enMarcha
    private int intervalo;
    private boolean sonido;
    
    * También se puede prescindir del constructor sobrecargado
    public Reloj (int intervalo, boolean sonido) {
        
        this.intervalo = intervalo;
        this.sonido = sonido;
        
    }*/    

    
    public void enMarcha(int intervalo, final boolean sonido) {
        
        // Clase interna Local DameLaHora2()
        class DameLaHora2 implements ActionListener {
            
            public void actionPerformed(ActionEvent evento) {
                
                Date ahora = new Date();
                
                System.out.println("Imprimimos la hora cada 3 segundos: " + ahora);
                
                if (sonido) {
                    Toolkit.getDefaultToolkit().beep();
                }
                
            }
            
        }
        
        ActionListener oyente = new DameLaHora2();
        
        Timer miTemporizador = new Timer(intervalo, oyente);
        
        miTemporizador.start();
    }
    
    /* Clase interna DameLaHora2()
    private class DameLaHora2 implements ActionListener {
        
        public void actionPerformed(ActionEvent evento) {
            
            Date ahora = new Date();
            
            System.out.println("Imprimimos la hora cada 3 segundos: " + ahora);
            
            if (sonido) {
                Toolkit.getDefaultToolkit().beep();
            }
            
        }
        
    }*/
    
}
