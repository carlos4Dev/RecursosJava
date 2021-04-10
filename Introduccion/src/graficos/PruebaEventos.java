package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PruebaEventos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoBotones miMarco = new MarcoBotones();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

class MarcoBotones extends JFrame {
    
    public MarcoBotones() {
        
        setTitle("Botones y Eventos");
        setBounds(700,300,500,300);
        LaminaBotones miLamina = new LaminaBotones();
        add(miLamina);
        
    }
    
}

// Objeto Oyente del evento, laminaBotones
// class LaminaBotones extends JPanel implements ActionListener {
    class LaminaBotones extends JPanel {

    // Objeto Fuente del evento, boton
    JButton botonAzul = new JButton ("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");
    
    public LaminaBotones() {
        
        add(botonAzul); // Objeto Evento addActionListener
        add(botonAmarillo);
        add(botonRojo);
        
        // Instancias Objeto ColorFondo
        ColorFondo Azul = new ColorFondo(Color.blue);
        ColorFondo Amarillo = new ColorFondo(Color.yellow);
        ColorFondo Rojo = new ColorFondo(Color.red);
        
        /*
        botonAzul.addActionListener(this); // this referencia a LaminaBotones, que es el Objeto Oyente
        // Fuente      // Evento              // Oyente
        botonAmarillo.addActionListener(this);
        botonRojo.addActionListener(this);
        */
        
        botonAzul.addActionListener(Azul);
        botonAmarillo.addActionListener(Amarillo);
        botonRojo.addActionListener(Rojo);         
        
    }
    
     // Creando un Objeto Oyente ColorFondo
    private class ColorFondo implements ActionListener {
        
        private  Color colorDeFondo;
        
        public ColorFondo(Color c) {
            colorDeFondo = c;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            setBackground(colorDeFondo);
            
        }
        
    }
        
    /* En el caso de que Objeto Oyente sea LaminaBotones, se implementa ActionListener
     * y se sobreescribe el metodo actionPerfomerd de la interfaz
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object botonPulsado = e.getSource();
        
        if(botonPulsado == botonAzul) {
            
            setBackground(Color.blue);
            
        }
        
        else if(botonPulsado == botonAmarillo) {
            
            setBackground(Color.yellow);
            
        }
        
        if(botonPulsado == botonRojo) {
            
            setBackground(Color.red);
            
        }
             
    }*/
    
}


