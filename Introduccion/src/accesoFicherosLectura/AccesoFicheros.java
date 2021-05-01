package accesoFicherosLectura;

import java.io.FileReader;
import java.io.IOException;

// Esta forma de leer o escribir archivos s�lo sirve para archivos peque�os
// No es eficiente, para archivos normales lo correcto es utilizar BufferedReader

public class AccesoFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LeerFichero accediendo = new LeerFichero();
		accediendo.lee();

	}

}

class LeerFichero {
	
	public void lee() {
		
		FileReader entrada = null;
		
		try {
			
			entrada = new FileReader("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/Ejemplo.txt");
			
			// Hay que iniciar la variable en 0 para que lea todos los caracteres, si no, no lee el primer car�cter
			int c = 0;
			
			while (c != -1) { // Mientras no se haya llegado al final del contenido del archivo
				
				c = entrada.read();
				
				char letra = (char)c;
				
				System.out.print(letra);
				
			}
			// Ser�a mejor cerrar aqu� entrada
			// entrada.close(); // Es necesario cerrar para que el flujo termine y optimizar recursos
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("No se ha encontrado el archivo");
			
		} finally { // No es necesario poner aqu� el finally pero se puede hacer
			
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
	
}
