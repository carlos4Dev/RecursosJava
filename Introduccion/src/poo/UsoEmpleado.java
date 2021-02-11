package poo;

import java.util.*;

public class UsoEmpleado { 
	// Utilizando un solo archivo fuente (no recomendable)
	// Se deben utilizar varios archivos para tener modularidad
	// Sólo una clase debe ser publica y un solo main

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Empleado empleado1 = new Empleado("Juan Palomo", 1200, 2015, 7, 5);
		Empleado empleado2 = new Empleado("Pepe Pinto", 1600, 2016, 12, 15);
		Empleado empleado3 = new Empleado("Ana Nita", 1300, 2014, 11, 28);
		
		empleado1.subeSueldo(10);
		empleado2.subeSueldo(15);
		empleado3.subeSueldo(20);
		
		System.out.println("Nombre: " + empleado1.dameNombre() + " -> Sueldo: " 
				+ empleado1.dameSueldo() + " -> Fecha de Alta: "
				+ empleado1.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado2.dameNombre() + " -> Sueldo: " 
				+ empleado2.dameSueldo() + " -> Fecha de Alta: "
				+ empleado2.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado3.dameNombre() + " -> Sueldo: " 
				+ empleado3.dameSueldo() + " -> Fecha de Alta: "
				+ empleado3.dameFechaContrato());*/
		
		// Forma alternativa instanciar objetos Empleado (en un array)
		Empleado[] misEmpleados = new Empleado[3];
		
		misEmpleados[0] = new Empleado("Juan Palomo", 1200, 2015, 7, 5);
		misEmpleados[1] = new Empleado("Pepe Pinto", 1600, 2016, 12, 15);
		misEmpleados[2] = new Empleado("Ana Nita", 1300, 2014, 11, 18);
		
		/*for (int i = 0; i < 3; i++) {
			
			misEmpleados[i].subeSueldo(5); // Subimos un 5% a todos 
		}*/
		
		// Utilizando foreach() for mejorado
		for (Empleado e:misEmpleados) {
			
			e.subeSueldo(5);
		}
		
		/*for (int i = 0; i < 3; i++) {
			
			System.out.println("Nombre: " + misEmpleados[i].dameNombre()
					+ " -> Sueldo: " + misEmpleados[i].dameSueldo()
					+ " -> Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
		}*/
		
		// Utilizando foreach() for mejorado
		
		for (Empleado e: misEmpleados) {
			
			System.out.println("Nombre: " + e.dameNombre()
					+ " -> Sueldo: " + e.dameSueldo()
					+ " -> Fecha de Alta: " + e.dameFechaContrato());
		}
	}

}

class Empleado {
	
	public Empleado(String nom, double sue, int anio, int mes, int dia) {
	
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);		
		// en mes indicamos -1, porque Enero = 0 en java.util.Date
		altaContrato = calendario.getTime();
	}
	
	public String dameNombre() { // getter
		
		return nombre;
	}
	
	public double dameSueldo() { // getter
		
		return sueldo;
	}
	
	public Date dameFechaContrato() { // getter
		
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) { // setter
		
		double aumento = sueldo * porcentaje / 100;
		
		sueldo += aumento;
	}
	
	/* Se puede hacer, pero mejor declarar variables de clase antes
	que el constructor, mejor siempre al principio de la clase */
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
}
