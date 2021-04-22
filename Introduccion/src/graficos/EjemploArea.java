package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoArea miMarco = new MarcoArea();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoArea extends JFrame {
	
	public MarcoArea() {
		
		setBounds(500,300,500,350);
		LaminaArea miLamina = new LaminaArea();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaArea extends JPanel {
	
	private JTextArea miArea;
	
	public LaminaArea() {
		
		miArea = new JTextArea(8,20);
		
		JScrollPane laminaBarras = new JScrollPane(miArea);
		
		miArea.setLineWrap(true);
		
		add(laminaBarras);
		
		JButton miBoton = new JButton("Enviar");
		
		miBoton.addActionListener(new GestionaArea());
		
		add(miBoton);
		
	}
	
	private class GestionaArea implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println(miArea.getText());
			
		}
		
		
	}
}