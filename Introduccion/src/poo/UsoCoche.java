package poo;

import javax.swing.*;

public class UsoCoche {

	public static void main(String[] args) {
		
		Coche miCoche = new Coche();
		
		miCoche.estableceColor(JOptionPane.showInputDialog("Introduce color"));
		
		System.out.println(miCoche.dimeDatosGenerales());
		
		
		System.out.println(miCoche.dimeColor());
		
		miCoche.configuraAsientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero?"));
		
		System.out.println(miCoche.dimeAsientos());
		
		miCoche.configuraClimatizador(JOptionPane.showInputDialog("¿Tiene climatizador?"));
		
		System.out.println(miCoche.dimeClimatizador());
		
		System.out.println(miCoche.dimePesoCoche());
		
		System.out.println("El precio final del coche es: " + miCoche.dimePrecioCoche());
								
	}

}
