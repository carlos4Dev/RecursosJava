package poo;

//import javax.swing.*;

public class UsoVehiculo {

	public static void main(String[] args) {
		
		/*
		Coche miCoche = new Coche();
		
		miCoche.estableceColor(JOptionPane.showInputDialog(
				"Introduce color"));
		
		System.out.println(miCoche.dimeDatosGenerales());
		
		
		System.out.println(miCoche.dimeColor());
		
		miCoche.configuraAsientos(JOptionPane.showInputDialog(
				"¿Tiene asientos de cuero?"));
		
		System.out.println(miCoche.dimeAsientos());
		
		miCoche.configuraClimatizador(JOptionPane.showInputDialog(
				"¿Tiene climatizador?"));
		
		System.out.println(miCoche.dimeClimatizador());
		
		System.out.println(miCoche.dimePesoCoche());
		
		System.out.println("El precio final del coche es: " 
				+ miCoche.dimePrecioCoche());
		*/
		
		Coche miCoche1 = new Coche();
		miCoche1.estableceColor("gris metalizado");
		
		Furgoneta miFurgoneta1 = new Furgoneta(700, 7);
		miFurgoneta1.estableceColor("negro");
		miFurgoneta1.configuraAsientos("si");
		miFurgoneta1.configuraClimatizador("si");
		
		System.out.println(miCoche1.dimeDatosGenerales()
				+ "\n" + miCoche1.dimeColor());
		System.out.println(miFurgoneta1.dimeDatosGenerales()
				+ "\n" + miFurgoneta1.dimeDatosFurgoneta());
		
	}

}
