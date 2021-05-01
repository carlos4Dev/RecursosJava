package accesoFicherosLectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Esta forma de leer o escribir archivos sólo sirve para archivos pequeños
// No es eficiente, para archivos normales lo correcto es utilizar BufferedReader

public class AccesoFicherosBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LeerFicheroBuffer accediendo = new LeerFicheroBuffer();
		accediendo.lee();

	}

}

class LeerFicheroBuffer {
	
	public void lee() {
		
		FileReader entrada = null;
		BufferedReader miBuffer = null;
		
		try {
			
			entrada = new FileReader("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/EjemploConBuffer.txt");
			
			miBuffer = new BufferedReader(entrada);
			
			String linea = "";
			
			while (linea != null) { // Mientras no se haya llegado al final del contenido del archivo
				
				linea = miBuffer.readLine();
				
				if (linea != null)
					System.out.println(linea);
				
			}
			// Sería mejor cerrar aquí entrada
			// entrada.close(); // Es necesario cerrar para que el flujo termine y optimizar recursos
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("No se ha encontrado el archivo");
			
		} finally { // No es necesario poner aquí el finally pero se puede hacer
			
			try {
			
				entrada.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
	
}
