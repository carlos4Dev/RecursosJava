package graficos;

import java.awt.*;
import javax.swing.*;

public class TrabajandoConFuentes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoConFuentes miMarco = new MarcoConFuentes();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }

}

class MarcoConFuentes extends JFrame {
    
    public MarcoConFuentes() {
        
        setTitle("Prueba con fuentes");
        setSize(400,400);
        
        LaminaConFuentes miLamina = new LaminaConFuentes();
        add(miLamina);
        
        // Establecer el color por defecto en todo aquello que se dibuja en la lámina
        // miLamina.setForeground(Color.BLUE);
    }
    
}

class LaminaConFuentes extends JPanel {
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D  g2 = (Graphics2D) g;
        
        // Instanciamos la clase Font
        Font miFuente = new Font("Arial", Font.BOLD, 26);
        
        g2.setFont(miFuente);
        g2.setColor(Color.blue);
        g2.drawString("Carlos", 100, 100);
        
        // Instanciamos la clase Font dentro de setFont
        g2.setFont(new Font("Courier", Font.ITALIC, 14));
        g2.setColor(new Color(128,90,50));
        g2.drawString("Curso de Java", 100, 200);
    }
}