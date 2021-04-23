package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButton_Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco_RadioButton miMarco = new Marco_RadioButton();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_RadioButton extends JFrame {
	
	public Marco_RadioButton() {
		
		setVisible(true);
		setBounds(550,300,500,350);
		Lamina_radio miLamina = new Lamina_radio();
		add(miLamina);
		
	}	
	
}

class Lamina_radio extends JPanel {
	
	private JLabel texto;
	private JRadioButton boton1, boton2,boton3, boton4;
	
	private ButtonGroup miGrupo;
	private JPanel lamina_botones;
	
	public Lamina_radio() {
		
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
		
		texto.setFont(new Font("Serif", Font.PLAIN, 12));
		add(texto, BorderLayout.CENTER);
	
		miGrupo = new ButtonGroup();
		lamina_botones = new JPanel();
	
		
		colocarBotones("Pequeño", false, 10);
		colocarBotones("Mediano", true, 12);
		colocarBotones("Grande", false, 18);
		colocarBotones("Muy grande", false, 24);
		
		add(lamina_botones, BorderLayout.SOUTH);
		
		/* Esta parte se repite bastante y genera bastante código
		ButtonGroup miGrupo = new ButtonGroup();
		boton1 = new JRadioButton("Pequeño", false);
		boton2 = new JRadioButton("Mediano", true);
		boton3 = new JRadioButton("Grande", false);
		boton4 = new JRadioButton("Muy grande", false);
		
		JPanel lamina_radio = new JPanel();
		Evento_Radio miEvento = new Evento_Radio();
		boton1.addActionListener(miEvento);
		boton2.addActionListener(miEvento);
		boton3.addActionListener(miEvento);
		boton4.addActionListener(miEvento);
		
		miGrupo.add(boton1);
		miGrupo.add(boton2);
		miGrupo.add(boton3);
		miGrupo.add(boton4);
		
		lamina_radio.add(boton1);
		lamina_radio.add(boton2);
		lamina_radio.add(boton3);
		lamina_radio.add(boton4);
		
		add(lamina_radio, BorderLayout.SOUTH);
		*/
		
	}
	
	public void colocarBotones(String nombre, boolean seleccionado, final int tamanio) {
		
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		miGrupo.add(boton);
		lamina_botones.add(boton);
		ActionListener miEvento = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				texto.setFont(new Font("Serif", Font.PLAIN, tamanio));
				
			}
			
		};
		
		boton.addActionListener(miEvento);
		
		
		
	}
	
	/* Esta clase interna se puede eliminar para intentar escribir menos código
	private class Evento_Radio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == boton1) {
				
				// System.out.println("Has pulsado el boton 1");
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
				
			} else if (e.getSource() == boton2) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 12));
				
			} else if (e.getSource() == boton3) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 18));
				
			} else if (e.getSource() == boton4) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 24));
				
			}
			
		}
		
	}
	*/
}
