package graficos;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Sintaxix_radio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_radio_sintaxis miMarco = new Marco_radio_sintaxis();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_radio_sintaxis extends JFrame {
	
	public Marco_radio_sintaxis() {
		
		setVisible(true);
		setBounds(550,300,400,300);
		Lamina_radio_sintaxis miLamina = new Lamina_radio_sintaxis();
		add(miLamina);
		
	}
	
}

class Lamina_radio_sintaxis extends JPanel {
	
	public Lamina_radio_sintaxis() {
		
		ButtonGroup miGrupo1 = new ButtonGroup();
		ButtonGroup miGrupo2 = new ButtonGroup();
		
		JRadioButton boton1 = new JRadioButton("Azul", false);
		JRadioButton boton2 = new JRadioButton("Rojo", true);
		JRadioButton boton3 = new JRadioButton("Verde", false);
		
		JRadioButton boton4 = new JRadioButton("Masculino", false);
		JRadioButton boton5 = new JRadioButton("Femenino", false);
		
		miGrupo1.add(boton1);
		miGrupo1.add(boton2);
		miGrupo1.add(boton3);
		
		miGrupo2.add(boton4);
		miGrupo2.add(boton5);
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		add(boton4);
		add(boton5);
		
	}
}


