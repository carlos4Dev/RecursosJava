package ficherosDirectorios;

import java.io.*;

public class AccesoFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ruta = new File("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion");
		
		System.out.println(ruta.getAbsolutePath());
		
		String [] nombresArchivos = ruta.list();
		
		for (int i = 0; i < nombresArchivos.length; i++) {
			
			System.out.println(nombresArchivos[i]);
			
			File f = new File(ruta.getAbsoluteFile(), nombresArchivos[i]);
			
			if (f.isDirectory()) {
				
				String [] archivosSubcarpeta = f.list();
				
				for (int j = 0; j < archivosSubcarpeta.length; j++) {
					
					System.out.println(archivosSubcarpeta[j]);
					
				}
				
			}
			
		}
	}

}
