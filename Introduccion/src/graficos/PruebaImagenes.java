package graficos;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaImagenes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MarcoImagen miMarco = new MarcoImagen();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

class MarcoImagen extends JFrame {
    
        public MarcoImagen() {
            
            setTitle("Marco con imagen");
            setBounds(750, 300, 400, 300);
            LaminaConImagen miLamina = new LaminaConImagen();
            add(miLamina);
            
        }
}

class LaminaConImagen extends JPanel {
    
    private Image imagen;
    
    public LaminaConImagen() {
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
         // Para simplificar el código se puede instanciar al intentar leer la imagen
        // File miImagen = new File("src/graficos/coche.png");
        
        try {
            // imagen = ImageIO.read(new File("src/graficos/coche.png"));
            imagen = ImageIO.read(new File("src/graficos/bola.gif"));
        }
        catch(IOException e) {
            System.out.println("La imagen no se encuentra");
        }        
        
        int anchuraImagen = imagen.getWidth(this);
        int alturaImagen = imagen.getHeight(this);
        
        g.drawImage(imagen, 0, 0, null);
        
        for (int i=0; i < 300; i++) {
            
            for(int j=0; j < 200; j++) {
                
                if (i+j > 0) {
                    
                    g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i,alturaImagen*j);
                
                }
                
            }
        
        }
        
    }
    
}