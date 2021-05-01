package accesoFicherosSerializacion;

import java.util.*;
import java.io.*;

public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Administrador jefe = new Administrador("Juan", 80000, 2005,12,15);
		
		jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
		
		personal[0] = jefe;
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18800, 2012, 9, 15);
		
		try {
			
			ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/Empleado.dat"));
			escribiendoFichero.writeObject(personal);
			escribiendoFichero.close();
			
			
			ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream("C:/Users/carlo/Documents/Copia de Eclipse Workspace/RecursosJava/Introduccion/src/Empleado.dat"));
			
			// Hay que hacer un cast, pasando el objeto recuperado a un array de tipo Empleado
			Empleado[] personalRecuperado = (Empleado[]) recuperandoFichero.readObject();
			
			recuperandoFichero.close();
			
			// Bucle foreach (en java no se escribe el each
			for (Empleado e : personalRecuperado) {
				
				System.out.println(e);
				
			}
			
		} catch(Exception e) {
			
			
		}
		
	
	}

}

// --------------------------------------------------------------

class Empleado implements Serializable {
	
	/**
	 * El número de versión sería 1 la L mayúscula es por tipo de dato long
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	//private double sueldo; //Hacemos un cambio para el segundo video
	private double sueldos;
	private Date fechaContrato;
	
	public Empleado(String n, double s, int anio, int mes, int dia) {
		
		nombre = n;
		
		sueldos = s;
		
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
		
		fechaContrato = calendario.getTime();
		
	}
	
	public String getNombre() {
		
		return nombre;
		
	}
	
	public double getSueldo() {
		
		return sueldos;
	}
	
	public Date getFechaContrato() {
		
		return fechaContrato;
	}
	
	public void subirSueldo(double porcentaje) {
		
		double aumento = sueldos * porcentaje/100;
		
		sueldos += aumento;
		
	}
	
	public String toString() {
		
		return "Nombre: " + nombre + " -> sueldo: " + sueldos + " -> fecha de contrato: " + fechaContrato;

	}
	
}

//--------------------------------------------------------------

class Administrador extends Empleado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double incentivo;
	
	public Administrador(String n, double s, int anio, int mes, int dia) {
		
		super(n, s, anio, mes, dia);
		
		incentivo = 0;
		
	}
	
	public double getSueldo() {
		
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	
	}
	
	public void setIncentivo(double b) {
		
		incentivo = b;
		
	}
	
	public String toString() {
		
		return super.toString() + " -> Incentivo " + incentivo;
	}
	
	
}
