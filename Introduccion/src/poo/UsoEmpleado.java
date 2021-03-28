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
		Jefatura jefe_RRHH = new Jefatura("Charlie Seen", 5500, 2005, 2, 3);
		
		jefe_RRHH.estableceIncentivo(2570);
		
		Empleado[] misEmpleados = new Empleado[6];
		
		misEmpleados[0] = new Empleado("Juan Palomo", 1200, 2015, 7, 5);
		misEmpleados[1] = new Empleado("Pepe Pinto", 1600, 2016, 12, 15);
		misEmpleados[2] = new Empleado("Ana Nita", 1300, 2014, 11, 18);
		misEmpleados[3] = new Empleado("Luis Listillo", 1550, 2001,3, 5);
		misEmpleados[4] = jefe_RRHH; // Polimorfimo en acción, principio de sustitución
		misEmpleados[5] = new Jefatura("Juanita Juna", 2330, 1999, 5, 22);
		Jefatura jefa_Finanzas = (Jefatura) misEmpleados[5];
		jefa_Finanzas.estableceIncentivo(2100);

		System.out.println(jefa_Finanzas.tomar_decisiones("dar más días de vacaciones a los empleados."));
		
		System.out.println("El jefe " + jefa_Finanzas.dameNombre() + "tiene un bonus de " 
		         + jefa_Finanzas.establece_bonus(500) );
		
		System.out.println(misEmpleados[2].dameNombre() + " tiene un bonus de " 
		        + misEmpleados[2].establece_bonus(200));
		
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
		
		Arrays.sort(misEmpleados);
		
		// Utilizando foreach() for mejorado
		
		for (Empleado e: misEmpleados) {
			
			System.out.println("Nombre: " + e.dameNombre()
					+ " -> Sueldo: " + e.dameSueldo()
					+ " -> Fecha de Alta: " + e.dameFechaContrato());
		}
	}

}

class Empleado implements Comparable<Object>, Trabajadores {
    
    /* Se puede hacer, pero mejor declarar variables de clase antes
    que el constructor, mejor siempre al principio de la clase */
    
    private String nombre;
    private double sueldo;
    private Date altaContrato;
    private static int idSiguiente;
    private int id;
	
	public Empleado(String nom, double sue, int anio, int mes, int dia) {
	
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);		
		// en mes indicamos -1, porque Enero = 0 en java.util.Date
		altaContrato = calendario.getTime();
		++idSiguiente;
        id = idSiguiente;
	}
	
	public Empleado(String nom) {
		
		this(nom, 30000, 2000, 01, 01);
		
	}
	
	public String dameNombre() { // getter
		
		return nombre + " -> Nº: " + id;		
	}
	
	// poniendo final después de public no se podrá llamar igual a 
	// otro método de una clase heredada
	
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
	
	public int compareTo(Object miObjeto) {
	    
	    Empleado otroEmpleado = (Empleado) miObjeto;
	    
	    if (this.sueldo < otroEmpleado.sueldo) {
	        return -1;
	    }
	    
	    if (this.sueldo > otroEmpleado.sueldo) {
	        return 1;
	    }
	    
	    return 0;
	    
	}

    @Override
    public double establece_bonus(double gratificacion) {
        
        return Trabajadores.bonus_base + gratificacion;
    }
	
}

// poniendo final delante de la clase no se podrá extender la clase

class Jefatura extends Empleado implements Jefes {
	
	public Jefatura (String nom, double sue, int anio, int mes, 
			int dia) {
		
		super(nom, sue, anio, mes, dia);
	}
	
	
	public void estableceIncentivo(double b) {
		incentivo= b;
	}
	
	public double dameSueldo() {
		
		double sueldoJefe = super.dameSueldo();
		
		return sueldoJefe + incentivo;
	}
	
	private double incentivo;

    @Override
    public String tomar_decisiones(String decision) {
        
        return "Un miembro de la dirección ha tomado la decisión de:  " + decision;
    
    }


    @Override
    public double establece_bonus(double gratificacion) {
        double prima = 2000;
        return Trabajadores.bonus_base + gratificacion + prima;
    }
}
