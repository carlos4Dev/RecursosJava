package graficos;

import javax.swing.*;
import java.awt.event.*;

public class EventosVentana {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoVentana miMarco = new MarcoVentana();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setTitle("Ventana 1");
        miMarco.setBounds(200,300,500,350);
        
        MarcoVentana miMarco2 = new MarcoVentana();
        miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        miMarco2.setTitle("Ventana 2");
        miMarco2.setBounds(800,300,500,350);
        
    }

}

class MarcoVentana extends JFrame {
    
    public MarcoVentana() {
        
        // Comentamos para diferenciar cada instancia creada
        // setTitle("Respondiendo");
        // setBounds(300,300,500,350);
        setVisible(true);
        
        // Instanciamos clase Oyente M_Ventana
        /* Se puede simplificar después de implementar WindowAdapter
        M_Ventana oyenteVentana = new M_Ventana();
        
        addWindowListener(oyenteVentana);
        */
        addWindowListener(new M_Ventana());
        
    }
    
}

// Clase Oyente implemente interfaz WindowListener
//class M_Ventana implements WindowListener {
class M_Ventana extends WindowAdapter {
    
    /* Al utilizar WindowAdapter se puede utilizar únicamente los métodos que se necesiten
    @Override
    public void windowOpened(WindowEvent e) {
        
        System.out.println("Ventana abierta");
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
        System.out.println("Cerrando ventana");
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
        System.out.println("La ventana ha sido cerrada");
        
    }
    */
    @Override
    public void windowIconified(WindowEvent e) {
        
        System.out.println("Ventana minimizada");
        
    }
    
    /*
    @Override
    public void windowDeiconified(WindowEvent e) {
        
        System.out.println("Ventana restaurada");
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
        System.out.println("Ventana activada");
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
        System.out.println("Ventana desactivada");
        
    }
    */     
}
