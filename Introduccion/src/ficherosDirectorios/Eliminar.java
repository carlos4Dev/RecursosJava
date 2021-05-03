package ficherosDirectorios;

import java.io.File;

public class Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ruta = new File("C:" + File.separator + "Users" + File.separator + "carlo" + File.separator + "Documents" + File.separator + "Copia de Eclipse Workspace" + File.separator + "RecursosJava" + File.separator + "Introduccion" + File.separator + "PruebaCreacionArchivo.txt");
		
		ruta.delete();
		
	}

}
