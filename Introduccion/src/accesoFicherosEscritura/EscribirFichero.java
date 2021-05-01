package accesoFicherosEscritura;

import java.io.*;

public class EscribirFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Escribiendo accesoEscritura = new Escribiendo();
		accesoEscritura.escribir();

	}

}

class Escribiendo {
	
	public void escribir() {
		
		// String frase = "Esto es una prueba de escritura";
		
		String frase = "A�adiendo texto a un archivo existente";
		
		try {
			// FileWriter escritura = new FileWriter("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/EjemploEscritura.txt");
			
			// Si queremos escribir en archivo existente, en el constructor se a�ade el parametro true
			// Si no a�adimos true, se sobreescribe el archivo
			
			FileWriter escritura = new FileWriter("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/EjemploEscritura.txt", true);
			
			for(int i = 0; i < frase.length(); i++) {
				
				escritura.write(frase.charAt(i));
				
			}
			
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
