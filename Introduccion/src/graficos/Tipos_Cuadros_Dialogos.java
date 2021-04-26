package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tipos_Cuadros_Dialogos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CuadrosDialogos miMarco = new CuadrosDialogos();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);

	}

}

class CuadrosDialogos extends JFrame {
	
	public CuadrosDialogos() {
		
		setBounds(500,300,450,250);
		add(new LaminaCuadrosDialogos());
		
	}
	
}

class LaminaCuadrosDialogos extends JPanel {
	
	JButton boton1, boton2, boton3, boton4;
	
	public LaminaCuadrosDialogos() {
		
		boton1 = new JButton("Boton1");
		boton2 = new JButton("Boton2");
		boton3 = new JButton("Boton3");
		boton4 = new JButton("Boton4");
		
		boton1.addActionListener(new AccionBotones());
		boton2.addActionListener(new AccionBotones());
		boton3.addActionListener(new AccionBotones());
		boton4.addActionListener(new AccionBotones());
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		
	}
	
	private class AccionBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == boton1) {
				
				// System.out.println("Has pulsado el botón 1");
				
				// JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Mensaje de prueba");
				
				JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Mensaje de Prueba", "Advertencia", 0);
				// El valor del último parametro es: 0 icono de peligro, 1 icono de informacion
				// 2 icono de advertencia, 3 icono de interrogación
				
				
			} else if (e.getSource() == boton2) {
				
				// System.out.println("Has pulsado el botón 2");
				// JOptionPane.showInputDialog("Introduce tu nombre: ");
				JOptionPane.showInputDialog(LaminaCuadrosDialogos.this, "Introduce tu  nombre", "Introduce datos", 2);
				
			} else if (e.getSource() == boton3) {
				
				// System.out.println("Has pulsado el botón 3");
				JOptionPane.showConfirmDialog(LaminaCuadrosDialogos.this, "Aceptar?", "V Confrimar", 1);
				
				
			} else {
				
				// System.out.println("Has pulsado el botón 4");
				JOptionPane.showOptionDialog(LaminaCuadrosDialogos.this, "Elija una opción", "V Opciones", 1, 1, null, null, null);				
				
			}
			
		}
		
		
		
	}
	
}


