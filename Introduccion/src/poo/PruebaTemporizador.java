package poo;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;

public class PruebaTemporizador {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        DameLaHora oyente = new DameLaHora();
        
        // ActionListener oyente = new DameLaHora();
        
        Timer miTemporizador = new Timer(5000, oyente);
        
        miTemporizador.start();
        
        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
        
        System.exit(0);
    }

}

class DameLaHora implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Date ahora = new Date();
        System.out.println("Imprimimos la hora cada 5 segundos: " + ahora);
        Toolkit.getDefaultToolkit().beep();
        
    }
    
}