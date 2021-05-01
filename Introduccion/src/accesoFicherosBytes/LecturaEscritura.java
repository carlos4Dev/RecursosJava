package accesoFicherosBytes;

import java.io.*;

public class LecturaEscritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contador = 0;
		
		int datosEntrada [] = new int[28868]; 
		// El tamaño del array lo sacamos del tamaño del contador una vez recorrido el archivo
		
		try {
			
			FileInputStream archivoLectura = new FileInputStream("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/coche.png");
			
			boolean finalAr = false;
			
			while (!finalAr) {
				
				int byteEntrada = archivoLectura.read();
				
				if (byteEntrada != -1) // El menos uno (cuando llegue al final) no se tiene que incluir en el array
					
					datosEntrada[contador] = byteEntrada;
				
				else
				//if (byteEntrada == -1) // Cuando llegue al final, devolverá -1
					
					finalAr = true;
				
				// Imprimimos el número de byte por consola
				//System.out.println(byteEntrada);
				
				System.out.println(datosEntrada[contador]);
				
				contador++;
				
			}
			// Hay que cerrar el stream , después del while, pero dentro del try
			archivoLectura.close();
			
		} catch(IOException e) {
			
			System.out.println("Error al acceder a la imagen");
			
		}
		
		System.out.println("El archivo pesa " + contador + " bytes");
		
		// Antes de cerrar el método main, llamamos a crearFichero()
		
		crearFichero(datosEntrada);

	}
	
	static void crearFichero(int datosNuevoFichero[]) {
		
		try {
			
			FileOutputStream ficheroNuevo = new FileOutputStream("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/CopiaDeImagen.png");
			
			for(int i = 0; i < datosNuevoFichero.length; i++) {
				
				ficheroNuevo.write(datosNuevoFichero[i]);
				
			}
			
			// Cerramos el stream
			
			ficheroNuevo.close();
			
		} catch(IOException e) {
			
			System.out.println("Error al crear el archivo");
			
		}
		
	}

}
