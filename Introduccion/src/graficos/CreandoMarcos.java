package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        miMarco marco1 = new miMarco();
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class miMarco extends JFrame {
    
    public miMarco() {
        // setSize(500,300);
        // setLocation(500,300);
        
        // setBounds tiene como parámetros, primero location y luego el tamaño
        setBounds(500, 300, 550, 250);
        
        // Si no se pone nada el frame es redimensionable
        //setResizable(false);
        
        // Se puede establecer que se expanda a lo ancho, alto o ambas
        // setExtendedState(Frame.MAXIMIZED_BOTH);
        
        setTitle("Ventana de pruebas");
    }
    
}