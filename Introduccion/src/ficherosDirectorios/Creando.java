package ficherosDirectorios;

import java.io.*;

public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// File ruta = new File("C:" + File.separator + "Users" + File.separator + "carlo" + File.separator + "Documents" + File.separator + "Copia de Eclipse Workspace" + File.separator + "RecursosJava" + File.separator + "Introduccion" + File.separator + "NuevoDirectorio");
		// Para crear el directorio indicado en la ruta
		// ruta.mkdir();
		
		
		
		File ruta = new File("C:" + File.separator + "Users" + File.separator + "carlo" + File.separator + "Documents" + File.separator + "Copia de Eclipse Workspace" + File.separator + "RecursosJava" + File.separator + "Introduccion" + File.separator + "PruebaCreacionArchivo.txt");
		
		String archivoDestino = ruta.getAbsolutePath();
		
		try {
			ruta.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Escribiendo accedeEs = new Escribiendo();
		
		accedeEs.escribir(archivoDestino);
		
	}
	
}
class Escribiendo{
	
	public void escribir (String rutaArchivo) {
		
		String frase = "Esto es un ejemplo de escritura en un archivo";
		
		try {
			
			FileWriter escritura = new FileWriter(rutaArchivo);
			
			for (int i = 0; i < frase.length(); i++) {
				
				escritura.write(frase.charAt(i));
				
			}
			
			escritura.close();
			
		} catch (IOException e) {
			
		}
	}
}
