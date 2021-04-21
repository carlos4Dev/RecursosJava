package graficos;

import java.awt.event.*;

import javax.swing.JFrame;

public class Eventos_Raton_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoRaton2 miMarco = new MarcoRaton2();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

class MarcoRaton2 extends JFrame {
    
    public MarcoRaton2() {
        
        setVisible(true);
        setBounds(700,300,600,450);
        
        EventosDeRaton2 EventoRaton2 = new EventosDeRaton2();
        
        addMouseMotionListener(EventoRaton2);
        
    }
    
}

class EventosDeRaton2 implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        
        System.out.println("Estás arrastrando");
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        System.out.println("Estás moviendo");
        
    }
    
    
}