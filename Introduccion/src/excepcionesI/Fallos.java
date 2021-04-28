package excepcionesI;

import javax.swing.*;

public class Fallos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] miMatriz = new int [5];
		
		miMatriz[0] = 8;
		miMatriz[1] = 18;
		miMatriz[2] = 55;
		miMatriz[3] = 23;
		miMatriz[4] = 47;
		// Si intentamos añadir un nuevo elemento
		// miMatriz[5] = 29;
		// Nos daría Exception: Index 5 out of bounds for length 5
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("Posición " + i + " = " + miMatriz[i]);
			
		}
		
		// Petición de datos personales
		
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
		
		System.out.println("Hola " + nombre + " tienes " + edad + " años. " 
				+ "El programa termina su ejecución." );
		
		
	}

}
