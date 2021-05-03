package ficherosDirectorios;

import java.io.*;

public class AccesoFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ruta = new File("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion");
		// Para asegurar que no hay problemas con las rutas en otros sistema operativos
		// Se puede usar en vez de / podemos poner File.separator
		
		// File ruta = new File("C:" + File.separator + "Users" + File.separator + "carlo" + File.separator + "Documents" + File.separator + "Copia de Eclipse Workspace" + File.separator + "RecursosJava" + File.separator + "Introduccion");
		
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
