package graficos;

import java.awt.event.*;

import javax.swing.JFrame;

public class Eventos_Raton {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoRaton miMarco = new MarcoRaton();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

class MarcoRaton extends JFrame {
    
    public MarcoRaton() {
        
        setVisible(true);
        setBounds(700,300,600,450);
        
        EventosDeRaton EventoRaton = new EventosDeRaton();
        
        addMouseListener(EventoRaton);
        
    }
    
}

/* Si se quiere implementar todas las opciones de MouseListener
  
class EventosDeRaton implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println("Has hecho clic");
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        System.out.println("Acaba de presionar el ratón");
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        System.out.println("Acabas de levantar el dedo del ratón");
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        System.out.println("Acabas de entrar en el marco");
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        System.out.println("Acabas de salir del marco");
        
    }
      
}

*/

// Si sólo se quiere utilizar alguna de opciones, se extendería de MouseAdapter

class EventosDeRaton extends MouseAdapter {
    
    /*
    public void mouseClicked(MouseEvent e) {
        
        // System.out.println("Coordenada X: " + e.getX() + ", Coordenada Y: " + e.getY());
        
        System.out.println(e.getClickCount());
        
    }
    */
    
    public void mousePressed(MouseEvent e) {
        
        if (e.getModifiersEx()== MouseEvent.BUTTON1_DOWN_MASK) {
            
            System.out.println("Has pulsado el botón izquierdo");
            
        } else if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
            
            System.out.println("Has pulsado la rueda del ratón");
                    
        } else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
            
            System.out.println("Has pulsado el botón derecho");
        }
                
    }
    
}