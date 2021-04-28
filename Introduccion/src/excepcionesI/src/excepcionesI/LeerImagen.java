package excepcionesI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeerImagen {

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
    	
    	try {
    		// Ruta incorrecta, sería excepcionesI
    		// imagen = ImageIO.read(new File("src/excepciones/bola.gif"));
    		// Daría una Exception java.lang.NullPointerException
    		
    		imagen = ImageIO.read(new File("src/excepciones/bola.gif"));
    		
    	} catch(IOException e) {
    	
    		System.out.println("La imagen no se encuentra");
    		
    	}
        
    }
    
    // No es una buena práctica utilzar aquí el throws ya que se puede mejorar el código
    public void paintComponent(Graphics g) throws NullPointerException {
        super.paintComponent(g);
        
        // En el caso de que la ruta sea incorrecta
        // Con el if else estaría correcto pero se puede crear una excepcion propia
        // if (imagen == null) {
        	
        	// g.drawString("No podemos cargar la imagen", 10, 10);
        
        //} else {        
        try {
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
        // }
        } catch(NullPointerException e) {
        	
        	g.drawString("No podemos cargar la imagen", 10, 10);
        	
        }
    }
    
}