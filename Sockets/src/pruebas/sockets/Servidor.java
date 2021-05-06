package pruebas.sockets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MarcoServidor  miMarco = new MarcoServidor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoServidor extends JFrame implements Runnable {
    
    private JTextArea areaTexto;
    
    public MarcoServidor() {
        
        setBounds(800,300,280,350);
        JPanel miLamina = new JPanel();
        miLamina.setLayout(new BorderLayout());
        areaTexto = new JTextArea();
        miLamina.add(areaTexto, BorderLayout.CENTER);
        add(miLamina);
        setVisible(true);
        
        Thread miHilo = new Thread(this);
        
        miHilo.start();
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        // System.out.println("Estoy a la escucha");
        
        try {
            ServerSocket servidor = new ServerSocket(9999);
            
            String nick, ip, mensaje;
            
            ArrayList <String> listaIp = new ArrayList<String>();
            
            PaqueteEnvio paqueteRecibido;
            
            while (true) {
                
                Socket miSocket = servidor.accept();
                
                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());
                
                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();
                
                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();
                
                /* video 191
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                
                String mensajeTexto = flujoEntrada.readUTF();
                
                areaTexto.append("\n" + mensajeTexto); */
                
                if (!mensaje.equals(" online")) {
                    
                    areaTexto.append("\n" + nick + ": " + mensaje + " para " + ip);
                
                    Socket enviaDestinatario = new Socket(ip, 9090);
                
                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                
                    paqueteReenvio.writeObject(paqueteRecibido);
                
                    paqueteReenvio.close();
                    
                    enviaDestinatario.close();
                
                    miSocket.close();          
                
                } else {
                    // -------------- DETECTA ONLINE --------------------------------------------
                    
                    InetAddress localizacion = miSocket.getInetAddress();
                    String ipRemota = localizacion.getHostAddress();
                    System.out.println("Online " + ipRemota);
                    
                    // Esta parte no me funciona porque no estoy implementando máquinaas virtuales
                    // que creen diferentes ip
                    listaIp.add(ipRemota);
                    
                    for (String z : listaIp) {
                        
                        System.out.println("Array: " + z);
                        
                    }
                    
                    // ----------------------------------------------------------------------------------
                }
                
            }
            
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
