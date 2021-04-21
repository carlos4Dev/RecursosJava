package graficos;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Marco_Layout marco = new Marco_Layout();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        marco.setVisible(true);

    }

}

class Marco_Layout extends JFrame {
    
    public Marco_Layout() {
        
        setTitle("Pruebas Acciones");
        setBounds(300,350,600,300);
        Panel_Layout lamina = new Panel_Layout();
        // FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
        //lamina.setLayout(disposicion);
        
        // Normalmente el layout se  pone en el panel o contenedor donde se crean, en este caso los botones
        
        Panel_Layout2 lamina2 = new Panel_Layout2();
        
        add(lamina, BorderLayout.NORTH);
        add(lamina2, BorderLayout.SOUTH);
    }
    
}

class Panel_Layout extends JPanel {
    
    public Panel_Layout() {
        
        // setLayout(new FlowLayout(FlowLayout.CENTER, 75, 100));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        
    }
    
}

class Panel_Layout2 extends JPanel {
    
    public Panel_Layout2() {
        
        setLayout(new BorderLayout());
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Negro"), BorderLayout.CENTER);
        
    }
    
}

