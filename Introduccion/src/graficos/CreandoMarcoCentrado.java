package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoCentrado miMarco = new MarcoCentrado();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
    }

}

class MarcoCentrado extends JFrame {
    
    public MarcoCentrado() {
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        Dimension tamanioPantalla = miPantalla.getScreenSize();
        
        int anchoPantalla = tamanioPantalla.width;
        int alturaPantalla = tamanioPantalla.height;
        
        setSize(anchoPantalla/2, alturaPantalla/2);
        
        setLocation(anchoPantalla/4, alturaPantalla/4);
        
        setTitle("Marco Centrado");
        
        // El tipo de archivo del icono tiene que ser .jpg .png y .gif El que menos pesa es .gif
        Image miIcono = miPantalla.getImage("src/graficos/Computer_icon.gif");
        
        setIconImage(miIcono);
        
    }
    
}
