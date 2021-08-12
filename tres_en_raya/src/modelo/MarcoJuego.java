package modelo;

import javax.swing.JFrame;

public class MarcoJuego extends JFrame {
        
    public MarcoJuego() {
                
            setTitle("Tres en Raya");
            setBounds(400,100,600,600);
            setResizable(false);
            
            Lamina miLamina = new Lamina();
            add(miLamina);      
            
    }

    
}