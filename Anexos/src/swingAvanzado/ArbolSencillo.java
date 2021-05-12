package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolSencillo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame miMarco = new MarcoArbol();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        miMarco.setVisible(true);
        
    }

}

class MarcoArbol extends JFrame {
    
    public MarcoArbol() {
        
        setTitle("Arbol Sencillo");
        setBounds (350,300,600,150);
        
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo");
        
        DefaultMutableTreeNode pais = new DefaultMutableTreeNode("España");
        
        raiz.add(pais);
        
        DefaultMutableTreeNode comunidad = new DefaultMutableTreeNode("Madrid");
        
        pais.add(comunidad);
        
        DefaultMutableTreeNode mostoles = new DefaultMutableTreeNode("Móstoles");
        
        comunidad.add(mostoles);
        
        DefaultMutableTreeNode alcobendas = new DefaultMutableTreeNode("Alcobendas");
        
        comunidad.add(alcobendas);
        
        comunidad = new DefaultMutableTreeNode("Cantabria");
        
        pais.add(comunidad);
        
        DefaultMutableTreeNode santillana = new DefaultMutableTreeNode("Santillana del Mar");
        
        comunidad.add(santillana);
        
        pais = new DefaultMutableTreeNode("Alemania");
        
        raiz.add(pais);
        
        comunidad = new DefaultMutableTreeNode("Baviera");
        
        pais.add(comunidad);
        
        DefaultMutableTreeNode munich = new DefaultMutableTreeNode("Munich");
        
        comunidad.add(munich);
        
        JTree arbol = new JTree(raiz);
        
        // LaminaArbol miLamina = new LaminaArbol(arbol);
        
        // add(miLamina);
        
        Container laminaContenido = getContentPane();
        
        laminaContenido.add(new JScrollPane(arbol));
        
        
    }
    
}

/* Con un ScrollPane no hace falta el siguiente código
class LaminaArbol extends JPanel {
    
    public LaminaArbol (JTree miArbol) {
        
        setLayout (new BorderLayout());
        
        add(miArbol, BorderLayout.NORTH);
        
        
    }
    
}
*/