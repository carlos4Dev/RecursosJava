package clasesPropias;

import java.util.GregorianCalendar;

public class MetodosGenericos2 {
	
	public static void main(String[] args) {
		
		String nombres[] = {"Pepe", "Ana", "Juan"};
		
		System.out.println(MisMatrices2.getMenor(nombres));
		
		// GregorianCalendar si implementa la interface Comparable, igual que String
		
		GregorianCalendar fechas[] = {
				new GregorianCalendar(2015,07,21),
				new GregorianCalendar(2005,02,22),
				new GregorianCalendar(2017,03,23)
		};
		// Devuelve un formato no legible, habria que utilizar un método de la clase GregorianCalendar
		System.out.println(MisMatrices2.getMenor(fechas));
		
	}

}

// No es necesario, pero ejemplo para entender uso métodos genéricos

class MisMatrices2 {
	
	public static <T extends Comparable> T getMenor(T[] a) {
		
		if (a == null || a.length == 0) {
			
			return null;
			
		}
		
		T elementoMenor = a[0];
		
		for (int i = 1; i < a.length; i++) {
			
			// Para poder comparar, en la definición tiene que extender de Comparable
			
			if (elementoMenor.compareTo(a[i]) > 0) {
				
				elementoMenor = a[i];
			}
		}
		
		return elementoMenor;
		
	}
	
}
