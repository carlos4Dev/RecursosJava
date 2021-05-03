package arrayList;

import java.io.*;

// Ejemplo en el que utilizamos la clase ArrayList creada para ver ventajas de programación genérica

public class UsoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList2 archivos = new ArrayList2(5);
		
		archivos.add("Juan");
		archivos.add("Pepe");
		archivos.add("Ana");
		archivos.add("Sam");
		archivos.add(new File("gestionPedidos.accdb"));
		
		// La clase ArrayList2 la creamos con Object para que reciba cualquier tipo
		// Esto obliga a hacer un casting para que no de error
		// Tener que realizar continuamente casting es un inconveniente
		
		String nombrePersona = (String)archivos.get(2);
		
		String nombreArchivo = (String)archivos.get(4);
		
		// Eclipse no da error en tiempo de compilación
		
		// De esta forma los errores salen en tiempo de ejecución 
		// Lo mejor es que los errores nos salgan en tiempo de compilación para poder corrregirlos antes
		
		// Ojo!!! Me da error, no se puede convertir Integer a String
		// System.out.println(nombrePersona);
		// Es normal que nos de error, no se puede convertir File a String
		System.out.println(nombreArchivo);
		
		// Esta forma da problemas, mejor programación genérica
		
	}

}
