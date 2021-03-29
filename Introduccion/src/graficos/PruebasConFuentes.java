package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class PruebasConFuentes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String fuente = JOptionPane.showInputDialog("Introduce un tipo de fuente");
        boolean estalafuente = false;
        
        String [] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        for (String nombredelafuete : nombresDeFuentes) {
            if (nombredelafuete.equals(fuente)) {
                estalafuente = true;
            }
        }
        if (estalafuente) {
            System.out.println("Fuente instalada");
        } else {
            System.out.println("No está instalada la fuente");
        }
        
    }

}
