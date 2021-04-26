package practica_01;

import javax.swing.*;

public class LaminaBotones extends JPanel{
	
	private ButtonGroup grupo;
	
	public LaminaBotones(String titulo, String[] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Verticalmente de arriba a abajo
		
		grupo = new ButtonGroup();
		
		for (int i = 0; i < opciones.length; i++) {
			
			JRadioButton boton = new JRadioButton(opciones[i]);
			boton.setActionCommand(opciones[i]);
			add(boton);
			grupo.add(boton);
			boton.setSelected(i == 0);
			
		}
		
	}
	
	public String dameSeleccion() {
		
		/* ButtonModel miBoton = grupo.getSelection();
		
		String s = miBoton.getActionCommand();
		
		return s;
		
		Mejor en una sola línea */
		
		return grupo.getSelection().getActionCommand();
		
	}
	
}
