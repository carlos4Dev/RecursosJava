package ficherosDirectorios;

import java.io.*;

public class PruebasRutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Si no ponenemos la ruta completa, Eclipse considera
		// que el archivo se encuentra en la misma carpeta
		
		// File archivo = new File("ejemploArchivo"); nombre inventando, no existe
		File archivo = new File("bin");
		
		System.out.println(archivo.getAbsolutePath());
		
		System.out.println(archivo.exists());
		

	}

}
