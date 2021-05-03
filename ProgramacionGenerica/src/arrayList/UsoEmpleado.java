package arrayList;

import java.util.*;

public class UsoEmpleado { 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*Empleado[] listaEmpleados = new Empleado[3];
		
		listaEmpleados[0] = new Empleado("Juan Palomo", 45, 2500);
		listaEmpleados[1] = new Empleado("Pepe Pinto", 55, 2000);
		listaEmpleados[2] = new Empleado("Ana Nita", 25, 2600); */
		
		ArrayList <Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		// Los ArrayList reservan en memoria una capacidad para 10 elementos
		// Si sabemos el tama�o exacto que tendr� se puede indicar y se ahorran recursos
		// Normalmente no se sabe el tama�o del ArrayList
		
		// listaEmpleados.ensureCapacity(15);
		
		
		listaEmpleados.add(new Empleado("Juan Palomo", 45, 2500));
		listaEmpleados.add(new Empleado("Pepe Pinto", 55, 2000));
		listaEmpleados.add(new Empleado("Ana Nita", 25, 2600));
		listaEmpleados.add(new Empleado("Miguel Miguelon", 35, 2200));
		listaEmpleados.add(new Empleado("Sim�n Sinsin", 15, 200));
		
		listaEmpleados.add(new Empleado("Juan Palomo", 45, 2500));
		listaEmpleados.add(new Empleado("Pepe Pinto", 55, 2000));
		listaEmpleados.add(new Empleado("Ana Nita", 25, 2600));
		listaEmpleados.add(new Empleado("Miguel Miguelon", 35, 2200));
		listaEmpleados.add(new Empleado("Sim�n Sinsin", 15, 200));
		
		listaEmpleados.add(new Empleado("Juan Palomo", 45, 2500));
		listaEmpleados.add(new Empleado("Pepe Pinto", 55, 2000));
		listaEmpleados.add(new Empleado("Ana Nita", 25, 2600));
		listaEmpleados.add(new Empleado("Miguel Miguelon", 35, 2200));
		listaEmpleados.add(new Empleado("Sim�n Sinsin", 15, 200));
		
		// A�adimos el elemento en la posici�n que indicamos como primer par�metro al constructor
		listaEmpleados.set(1, new Empleado("Carl Carlson", 29, 3200));
		
		// Obtener (para imprimir en este caso) el elemento de una posici�n dada
		
		System.out.println("Elemento obtenido con m�todo get --> \n" 
				+ listaEmpleados.get(4).dameDatos() + "\n");
		
		// Para optimizar recursos de memoria
		// Si estamos seguros de que el ArrayList no va a tener m�s elementos
		
		// listaEmpleados.trimToSize();
		
		// Se pueden volver a a�adir m�s elementos despu�s, se consumir�n m�s recursos pero se puede hacer
		
		System.out.println("M�todo .size -->> La lista tiene " + listaEmpleados.size() + " elementos. \n");
		
		System.out.println("Para recorrer ArrayList se utiliza foreach: -->");
		
		for (Empleado e: listaEmpleados) {
			
			System.out.println(e.dameDatos());
			
		}
		
		// Utilizando un iterator para recorrer ArrayList
		System.out.println("\nUtilizando un iterator para recorrer ArrayList -->>");
		
		Iterator <Empleado> miIterador = listaEmpleados.iterator();
		
		while (miIterador.hasNext()) {
			
			System.out.println(miIterador.next().dameDatos());
			
		}
		
		/*
		System.out.println("\nSe puede recorrer con un for normal pero se utiliza m�s c�digo -->>");
		
		for (int i = 0; i < listaEmpleados.size(); i++) {
			
			Empleado e = listaEmpleados.get(i);
			
			System.out.println(e.dameDatos());
			
		}
		*/
		
		// Tambi�n se puede pasar el ArrayList a un array normal
		// Se utiliza m�s c�digo y se utilizan m�s recursos, aqu� como ejemplo
		/* Mejor utilizar ArrayList y bucle foreach para recorrer
		 
		Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];
		
		listaEmpleados.toArray(arrayEmpleados);
		
		for (int i = 0; i < arrayEmpleados.length; i++) {
			
			System.out.println(arrayEmpleados[i].dameDatos());
			
		}
		*/
		
	}
	
}	

class Empleado {
    
    private String nombre;
    private int edad;
    private double salario;
	
	public Empleado(String nombre, int edad, double salario) {
	
		this.nombre = nombre;
		
		this.edad = edad;
		
		this.salario = salario;
	}
	
	public String dameDatos() {
		
		return "El empleado se llama " + nombre + ". Tiene " + edad + " a�os. Y un salario de " + salario;
		
	}
	
}