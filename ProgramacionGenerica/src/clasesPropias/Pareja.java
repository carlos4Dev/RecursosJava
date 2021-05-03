package clasesPropias;

// Por convención para indicar tipo genérico se suele utilizar T,U o K, normalmente T

public class Pareja <T> {

	private T primero;
	
	public Pareja() {
		
		primero = null;
		
	}
	
	// Cómo parámetro este método setter recibe un objeto de tipo genérico T
	public void setPrimero(T nuevoValor) {
		
		primero = nuevoValor;
		
	}
	
	public T getPrimero() {
		
		return primero;
		
	}
	
	// De esta forma sólo puede imprimir de tipo Empleado
	// public static void imprimirTrabajador(Pareja<Empleado> p) {
	
	// De esta forma puede imprimir Empleado o cualquier tipo que herede de empleado
	public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
		
		Empleado primero = p.getPrimero();
		
		System.out.println(primero);
		
	}
	
}
