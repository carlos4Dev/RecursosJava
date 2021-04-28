package excepcionesI;

import java.util.*;

public class EntradaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		String dato;
		
		do {
		
			System.out.println("�Qu� quieres hacer? Introduce 1 o 2");
			System.out.println("1. Introduce datos ");
			System.out.println("2. Salir del programa");
			
			dato = entrada.nextLine();
			
		} while (!dato.equals("1") && !dato.equals("2"));
		
		int decision = Integer.parseInt(dato);
		
		// Si se introduce un string en vez de un int...
		// Exceptioin in thread "main" java.util.InputMismatchException
		
			
	
		//int decision = entrada.nextInt();
		
			
		if (decision == 1) {
			
			// Aqu� tiene m�s sentido introducir el try catch
			try {
				
				pedirDatos();
				
			} catch (InputMismatchException e) {
				
				System.out.println("No has introducido un dato de tipo intenger." +
						"\nFin del programa");
				
			}
			
			
		} else {
			
			System.out.println("Adios. Programa Terminado");
			System.exit(0);
			
		}
		
		entrada.close();
		
	}
	
	// No es una buena pr�ctica porque se puede mejorar el c�digo
	// Pero a veces puede venir bien utilizar throws en excepciones no controladas
	// Se podr�a utilizar aqu�, pero no tiene mucho sentido
	static void pedirDatos()  throws InputMismatchException{
		
		// try {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduce tu nombre, por favor");
			String nombreUsuario = entrada.nextLine();
			System.out.println("Introduce tu edad, por favor");
			int edad = entrada.nextInt();
			System.out.println("Hola " + nombreUsuario + ". El a�o que viene tendr�s " 
					+ (edad + 1) + " a�os");
			entrada.close();
		// } catch (InputMismatchException e) {
		// Las dos opciones son v�lidas para capturar la excepci�n
		// catch (Exception e) {
			
			// System.out.println("No has introducido un dato de tipo intenger.");
			
		//}
		
		System.out.println("Hemos terminado");
		
	}
	
}
