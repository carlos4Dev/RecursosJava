  package graficos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Barra_Herramientas {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Marco_Barra miMarco = new Marco_Barra();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
                
    }

}

class Marco_Barra extends JFrame {
    
    JPanel lamina;
    
    public Marco_Barra() {
        
        setTitle("Marco con Barra");
        setBounds(600,350,600,300);  
        lamina = new JPanel();
        add(lamina);
        
        // configuración de acciones
        AccionColor accionAmarillo = 
                new AccionColor("Amarillo",  new ImageIcon("src/graficos/bola_amarilla.gif"), Color.YELLOW);
        AccionColor accionAzul = 
                new AccionColor("Azul",  new ImageIcon("src/graficos/bola_azul.gif"), Color.BLUE);
        AccionColor accionRojo = 
                new AccionColor("Rojo",  new ImageIcon("src/graficos/bola_roja.gif"), Color.RED);
        
        // Añadimos una opción para salir del programa
        Action accionSalir = new AbstractAction("Salir", new ImageIcon("src/graficos/bola.gif")) {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                System.exit(0);
                
            }
            
        };
        
       
        // Añadimos la barra de menú
        JMenu menu = new JMenu("Color");
        menu.add(accionAzul);
        menu.add(accionAmarillo);
        menu.add(accionRojo);
        
        JMenuBar barra_menus = new JMenuBar();
        barra_menus.add(menu);
        
        setJMenuBar(barra_menus);
        
        // Construcción de la barra de herramientas
        
        JToolBar barra = new JToolBar();
        barra.add(accionAzul);
        barra.add(accionAmarillo);
        barra.add(accionRojo);
        
        barra.addSeparator();
        barra.add(accionSalir);
        
        add(barra, BorderLayout.NORTH);
        
        
    }
    
    private class AccionColor extends AbstractAction {
    
        public AccionColor(String nombre, Icon icono, Color c) {
            
            putValue(Action.NAME, nombre);
            
            putValue(Action.SMALL_ICON, icono);
            
            putValue(Action.SHORT_DESCRIPTION, "Color de fondo... " + nombre);
            
            putValue("Color", c);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            Color  c = (Color)getValue("Color");
            
            lamina.setBackground(c);
            
            System.out.println("Nombre: " + getValue(Action.NAME) + " --> Descripcion: " 
                    + getValue(Action.SHORT_DESCRIPTION));
            
        }
        
    }
    
}

