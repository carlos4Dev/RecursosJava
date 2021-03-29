package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
// import java.awt.SystemColor;
import java.awt.geom.*;
import javax.swing.*;

public class TrabajandoColores {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MarcoConColor miMarco = new MarcoConColor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
    }

}

class MarcoConColor extends JFrame {
    
    public MarcoConColor() {
        
        setTitle("Prueba con colores");
        setSize(400,400);
        LaminaConColor miLamina = new LaminaConColor();
        add(miLamina);
        miLamina.setBackground(Color.CYAN);
        
        // Para establecer el color de fondo por defecto del color del sistema operativo donde se ejecute
        // miLamina.setBackground(SystemColor.window);
        
    }
    
}

class LaminaConColor extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Dibujo de rectángulo
        
        Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
        
        //Pintando el trazo
        g2.setPaint(Color.pink);
        g2.draw(rectangulo);
        
        // g2.setPaint(Color.green);
        // Instanciando la clase Color
        Color miColor = new Color(124,124,124);
        
        g2.setPaint(miColor);
        
        // fill nos rellena 
        g2.fill(rectangulo);

        // Dibujo de elipse
        
        Ellipse2D elipse = new Ellipse2D.Double();        
        
        elipse.setFrame(rectangulo);
        
        g2.setPaint(new Color(41,23,222).brighter());
        g2.fill(elipse);
        
    }
    
}
