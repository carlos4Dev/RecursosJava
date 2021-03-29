package graficos;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class PruebaDibujo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoConDibujos miMarco = new MarcoConDibujos();
        
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

class MarcoConDibujos extends JFrame {
    
    public MarcoConDibujos() {
        
        setTitle("Prueba de Dibujo");
        setSize(400,400);
        LaminaConFiguras miLamina = new LaminaConFiguras();
        add(miLamina);
        
    }
    
}

class LaminaConFiguras extends JPanel {
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // g.drawRect(50, 50, 200, 200);
        // g.drawLine(100, 100, 300, 200);
        // g.drawArc(50, 100, 100, 200, 120, 150);
        
        Graphics2D g2 = (Graphics2D) g;
        
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200.25, 150);
        
        g2.draw(rectangulo);
        
        Ellipse2D elipse = new Ellipse2D.Double();
        
        elipse.setFrame(rectangulo);
        
        g2.draw(elipse);
        
        g2.draw(new Line2D.Double(100,100,300,250));
        
        double CentroEnX = rectangulo.getCenterX();
        double CentroEnY = rectangulo.getCenterY();
        double radio = 125;
        
        Ellipse2D circulo = new Ellipse2D.Double();
        
        circulo.setFrameFromCenter(CentroEnX, CentroEnY, CentroEnX + radio, CentroEnY + radio);
        
        g2.draw(circulo);
        
    }
    
}
