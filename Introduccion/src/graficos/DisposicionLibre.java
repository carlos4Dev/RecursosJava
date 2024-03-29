package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisposicionLibre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoLibre miMarco = new MarcoLibre();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoLibre extends JFrame {
	
	public MarcoLibre() {
		
		setBounds(300,300,900,400);
		LaminaLibre miLamina = new LaminaLibre();
		add(miLamina);
		setVisible(true);
		
	}
	
}


class LaminaLibre extends JPanel {
	
	public LaminaLibre() {
		
		// Disposici�n Libre
		// setLayout(null);
		
		// Disposici�n con una clase propia creada por nosotros
		setLayout(new EnColumnas());
		
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel edad = new JLabel("Edad: ");
		JLabel telefono = new JLabel("Telefono: ");
		
		JTextField c_nombre = new JTextField();
		JTextField c_apellido = new JTextField();
		JTextField c_edad = new JTextField();
		JTextField c_telefono = new JTextField();
		
		/*
		nombre.setBounds(20, 20, 80, 10);
		c_nombre.setBounds(100, 15, 100, 20);
		apellido.setBounds(20, 60, 80, 15);
		c_apellido.setBounds(100, 55, 100, 20);
		*/
		
		add(nombre);
		add(c_nombre);
		
		add(apellido);
		add(c_apellido);
		
		add(edad);
		add(c_edad);
		
		add(telefono);
		add(c_telefono);
		
		
		
	}
}

class EnColumnas implements LayoutManager {

	// private int x = 20; 
	// Si queremos que se cree en el centro, se crea, pero no se inciailiza
	private int x;
	private int y = 20;
	
	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container miContenedor) {
		// TODO Auto-generated method stub
		
		// Para que se vaya creando en el centro
		int d = miContenedor.getWidth();
		
		x = d/2; // Para sabaer la mitad del ancho
		
		// A partir de aqu�, el c�digo es casi el mismo
		int contador = 0;
		int n = miContenedor.getComponentCount();
		
		for (int i = 0; i < n; i++) {
			
			contador++;
			
			Component c = miContenedor.getComponent(i);
			
			/*
			c.setBounds(x, y, 100, 20);
			
			 Para crear en el medio se le resta el ancho del componente
			*/
			c.setBounds(x-100, y, 100, 20);
			
			x += 100;
			
			if (contador %2 == 0) {
				
				// x = 20;
				x = d/2;
				y += 40;
			}
		}
		
	}
	
}