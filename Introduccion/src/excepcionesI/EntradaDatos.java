package excepcionesI;

import java.util.*;

public class EntradaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		String dato;
		
		do {
		
			System.out.println("¿Qué quieres hacer? Introduce 1 o 2");
			System.out.println("1. Introduce datos ");
			System.out.println("2. Salir del programa");
			
			dato = entrada.nextLine();
			
		} while (!dato.equals("1") && !dato.equals("2"));
		
		int decision = Integer.parseInt(dato);
		
		// Si se introduce un string en vez de un int...
		// Exceptioin in thread "main" java.util.InputMismatchException
		
			
	
		//int decision = entrada.nextInt();
		
			
		if (decision == 1) {
			
			// Aquí tiene más sentido introducir el try catch
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
	
	// No es una buena práctica porque se puede mejorar el código
	// Pero a veces puede venir bien utilizar throws en excepciones no controladas
	// Se podría utilizar aquí, pero no tiene mucho sentido
	static void pedirDatos()  throws InputMismatchException{
		
		// try {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduce tu nombre, por favor");
			String nombreUsuario = entrada.nextLine();
			System.out.println("Introduce tu edad, por favor");
			int edad = entrada.nextInt();
			System.out.println("Hola " + nombreUsuario + ". El año que viene tendrás " 
					+ (edad + 1) + " años");
			entrada.close();
		// } catch (InputMismatchException e) {
		// Las dos opciones son válidas para capturar la excepción
		// catch (Exception e) {
			
			// System.out.println("No has introducido un dato de tipo intenger.");
			
		//}
		
		System.out.println("Hemos terminado");
		
	}
	
}
