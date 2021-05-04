package pruebas.sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoCliente miMarco = new MarcoCliente();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoCliente extends JFrame {
    
    public MarcoCliente() {
        
        setBounds(600, 300, 200, 350);
        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
        add(miLamina);
        setVisible(true);
        
    }
   
}

class LaminaMarcoCliente extends JPanel {
    
    private JTextField campo1;
    private JButton miBoton;
    
    public LaminaMarcoCliente() {
        
        JLabel texto = new JLabel("CLIENTE");
        add(texto);
        campo1 = new JTextField(20);
        add(campo1);
        miBoton = new JButton("Enviar");
        
        EnviaTexto miEvento = new EnviaTexto();
        miBoton.addActionListener(miEvento);
        
        add(miBoton);
        
    }
    
    private class EnviaTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            //  System.out.println(campo1.getText());
            
            try {
                Socket miSocket = new Socket("192.168.56.1",  9999);
            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                System.out.println(e1.getMessage());
            }
            
        }
        
        
    }
    
}
