package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Varios_oyentes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Marco_Principal miMarco = new Marco_Principal();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
    }

}

class Marco_Principal extends JFrame {
    
    public Marco_Principal() {
        
        setTitle("Prueba Varios");
        setBounds(500, 100, 300, 200);
        Lamina_Principal lamina = new Lamina_Principal();
        add(lamina);
        
    }
    
}

class Lamina_Principal extends JPanel {
    
    public Lamina_Principal() {
        
        // El botón nuevo no se va utilizar fuera de la función
        JButton boton_nuevo = new JButton("Nuevo");
        
        add(boton_nuevo);
        
        boton_cerrar = new JButton("Cerrar todo");
        
        add(boton_cerrar);
        
        OyenteNuevo miOyente = new OyenteNuevo();
        
        boton_nuevo.addActionListener(miOyente);
        
    }
    
    private class OyenteNuevo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            Marco_Emergente marco = new Marco_Emergente(boton_cerrar);
            
            marco.setVisible(true);
            
        }
        
        
    }
    
    // Este nombre de instancia se declara fuera porque se va utilizar en otros métodos
    JButton boton_cerrar;
    
}

class Marco_Emergente extends JFrame {
    
    public Marco_Emergente(JButton boton_de_principal) {
        
        contador ++;
        
        setTitle("Ventana " + contador);
        setBounds(40 * contador, 40 * contador, 300, 150);
        CierraTodos oyenteCerrar = new CierraTodos();
        boton_de_principal.addActionListener(oyenteCerrar);
        
    }
    
    private static int contador = 0;
    
    private class CierraTodos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            dispose();
            
        }
        
        
    }
    
}