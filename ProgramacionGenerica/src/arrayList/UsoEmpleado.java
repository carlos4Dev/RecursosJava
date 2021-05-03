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
		// Si sabemos el tamaño exacto que tendrá se puede indicar y se ahorran recursos
		// Normalmente no se sabe el tamaño del ArrayList
		
		// listaEmpleados.ensureCapacity(15);
		
		
		listaEmpleados.add(new Empleado("Juan Palomo", 45, 2500));
		listaEmpleados.add(new Empleado("Pepe Pinto", 55, 2000));
		listaEmpleados.add(new Empleado("Ana Nita", 25, 2600));
		listaEmpleados.add(new Empleado("Miguel Miguelon", 35, 2200));
		listaEmpleados.add(new Empleado("Simón Sinsin", 15, 200));
		
		listaEmpleados.add(new Empleado("Juan Palomo", 45, 2500));
		listaEmpleados.add(new Empleado("Pepe Pinto", 55, 2000));
		listaEmpleados.add(new Empleado("Ana Nita", 25, 2600));
		listaEmpleados.add(new Empleado("Miguel Miguelon", 35, 2200));
		listaEmpleados.add(new Empleado("Simón Sinsin", 15, 200));
		
		listaEmpleados.add(new Empleado("Juan Palomo", 45, 2500));
		listaEmpleados.add(new Empleado("Pepe Pinto", 55, 2000));
		listaEmpleados.add(new Empleado("Ana Nita", 25, 2600));
		listaEmpleados.add(new Empleado("Miguel Miguelon", 35, 2200));
		listaEmpleados.add(new Empleado("Simón Sinsin", 15, 200));
		
		// Añadimos el elemento en la posición que indicamos como primer parámetro al constructor
		listaEmpleados.set(1, new Empleado("Carl Carlson", 29, 3200));
		
		// Obtener (para imprimir en este caso) el elemento de una posición dada
		
		System.out.println("Elemento obtenido con método get --> \n" 
				+ listaEmpleados.get(4).dameDatos() + "\n");
		
		// Para optimizar recursos de memoria
		// Si estamos seguros de que el ArrayList no va a tener más elementos
		
		// listaEmpleados.trimToSize();
		
		// Se pueden volver a añadir más elementos después, se consumirán más recursos pero se puede hacer
		
		System.out.println("Método .size -->> La lista tiene " + listaEmpleados.size() + " elementos. \n");
		
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
		System.out.println("\nSe puede recorrer con un for normal pero se utiliza más código -->>");
		
		for (int i = 0; i < listaEmpleados.size(); i++) {
			
			Empleado e = listaEmpleados.get(i);
			
			System.out.println(e.dameDatos());
			
		}
		*/
		
		// También se puede pasar el ArrayList a un array normal
		// Se utiliza más código y se utilizan más recursos, aquí como ejemplo
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
		
		return "El empleado se llama " + nombre + ". Tiene " + edad + " años. Y un salario de " + salario;
		
	}
	
}