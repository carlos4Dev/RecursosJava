package beans;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *  Esta clase pretende construir un Bean para incluir imágenes
 * @author Carlos
 *
 */
public class VisorDeImagenesBean  extends JLabel {
    /**
     * El tamaño máximo en megas
     * 
     */
    
    public static int PruebaConstante = 5;
    private File archivo = null;
    
    public VisorDeImagenesBean() {
        
        setBorder(BorderFactory.createEtchedBorder());
        
    }
    /**
     * Método clave para escoger imagen del disco duro
     * @param elegirImagen. Este parámetro te permitirá escoger una imagen
     */
    public void setEscogeImagen(String elegirImagen) {
        
        try {
            
            archivo = new File(elegirImagen);
            setIcon(new ImageIcon(ImageIO.read(archivo)));
            
        } catch (IOException e) {
            
            archivo = null;
            setIcon(null);
            e.printStackTrace();
            
        }
        
    }
    
    /**
     * 
     * 
     * @return Devuelve la ruta de la imagen escogida con setEscogeImagen
     * @param No recibe parámetro alguno (es algo redundante y sólo se debe poner si tiene parámetros)
     */
    public String getEscogeImagen() {
        
        if (archivo == null) return null;
        else return archivo.getPath();
        
    }
    
    public Dimension getPreferredSize() {
        
        return new Dimension(600,400);
        
    }
    
}
