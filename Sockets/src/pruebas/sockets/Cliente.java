package pruebas.sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
        
        setBounds(500, 300, 280, 350);
        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
        add(miLamina);
        setVisible(true);
        
        addWindowListener(new EnvioOnline());
        
    }
   
}

// ---------------- ENVÍO DE SEÑAL ONLINE ---------------------------------------------------------

class EnvioOnline extends WindowAdapter {
    
    public void windowOpened(WindowEvent e) {
        
        try {
            
            Socket miSocket = new Socket("192.168.56.1", 9999);
            
            PaqueteEnvio datos = new PaqueteEnvio();
            
            datos.setMensaje(" online ");
            
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
            
            paqueteDatos.writeObject(datos);
            
            miSocket.close();
            
        } catch(Exception excep) {
            
            
            
        }
        
    }
    
}

class LaminaMarcoCliente extends JPanel  implements Runnable{
    
    private JTextField campo1;
    private JComboBox ip;
    private JLabel nick;
    private JButton miBoton;
    private JTextArea campoChat;
    
    public LaminaMarcoCliente() {
        
        String nickUsuario = JOptionPane.showInputDialog("Nick: ");
        JLabel nombreNick = new JLabel("Nick: ");
        add(nombreNick);
        nick = new JLabel();
        nick.setText(nickUsuario);
        add(nick);
        JLabel texto = new JLabel("Online: ");
        add(texto);
        ip = new JComboBox();
        //ip.addItem("Usuario 1");
        //ip.addItem("Usuario 2");
        //ip.addItem("Usuario 3");
        ip.addItem("192.168.56.1");
        ip.addItem("192.168.56.2");
        
        add(ip);
        campoChat = new JTextArea(12,20);
        add(campoChat);
        campo1 = new JTextField(20);
        add(campo1);
        miBoton = new JButton("Enviar");
        
        EnviaTexto miEvento = new EnviaTexto();
        miBoton.addActionListener(miEvento);
        
        add(miBoton);
        
        Thread miHilo = new Thread(this);
        
        miHilo.start();
        
    }
    
    private class EnviaTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            //  System.out.println(campo1.getText());
            
            campoChat.append("");
            
            try {
                Socket miSocket = new Socket("192.168.56.1",  9999);
                
                PaqueteEnvio datos = new PaqueteEnvio();
                
                datos.setNick(nick.getText());
                datos.setIp(ip.getSelectedItem().toString());
                datos.setMensaje(campo1.getText());
                
                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                
                paqueteDatos.writeObject(datos);
                
                miSocket.close();
                
                /* Video 191 enviamos solo texto, en el video 192 envíamos un paquete, datos
                DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());               
                    
                flujoSalida.writeUTF(campo1.getText());
                    
                flujoSalida.close();
                */
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

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        try {
            
            ServerSocket servidorCliente = new ServerSocket(9090);
            
            Socket cliente;
            
            PaqueteEnvio paqueteRecibido;
            
            while (true) {
                
                cliente = servidorCliente.accept();
                
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                
                paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();
                
                campoChat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
                
            }
            
        } catch(Exception e) {
            
            System.out.println(e.getMessage());
            
        }
        
    }
    
}

class PaqueteEnvio implements Serializable {
    
    private String nick, ip, mensaje;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}