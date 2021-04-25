package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class DisposicionMuelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoMuelle miMarco = new MarcoMuelle();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoMuelle extends JFrame {
	
	public MarcoMuelle() {
		
		setBounds(300,300,600,300);
		LaminaMuelle miLamina = new LaminaMuelle();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaMuelle extends JPanel {

	public LaminaMuelle() {
		
		JButton boton1 = new JButton("Boton 1");
		JButton boton2 = new JButton("Boton 2");
		JButton boton3 = new JButton("Boton 3");
		
		SpringLayout miLayout = new SpringLayout();
		setLayout(miLayout);
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		Spring miMuelle = Spring.constant(0, 10, 100);
		Spring miMuelleRigido = Spring.constant(10);
		
		miLayout.putConstraint(SpringLayout.WEST, boton1, miMuelle, SpringLayout.WEST, this);
		miLayout.putConstraint(SpringLayout.WEST, boton2, miMuelleRigido, SpringLayout.EAST, boton1);
		miLayout.putConstraint(SpringLayout.WEST, boton3, miMuelleRigido, SpringLayout.EAST, boton2);
		miLayout.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, boton3);
	}
	
}
