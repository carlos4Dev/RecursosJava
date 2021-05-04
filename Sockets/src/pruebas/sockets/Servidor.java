package pruebas.sockets;

import javax.swing.*;
import java.awt.*;

public class Servidor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoServidor  miMarco = new MarcoServidor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoServidor extends JFrame {
    
    private JTextArea areaTexto;
    
    public MarcoServidor() {
        
        setBounds(800,300,280,350);
        JPanel miLamina = new JPanel();
        miLamina.setLayout(new BorderLayout());
        areaTexto = new JTextArea();
        miLamina.add(areaTexto, BorderLayout.CENTER);
        add(miLamina);
        setVisible(true);
        
    }
}
