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
		// Si intentamos a�adir un nuevo elemento
		// miMatriz[5] = 29;
		// Nos dar�a Exception: Index 5 out of bounds for length 5
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("Posici�n " + i + " = " + miMatriz[i]);
			
		}
		
		// Petici�n de datos personales
		
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
		
		System.out.println("Hola " + nombre + " tienes " + edad + " a�os. " 
				+ "El programa termina su ejecuci�n." );
		
		
	}

}
