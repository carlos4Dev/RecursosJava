package clasesPropias;

// Por convenci�n para indicar tipo gen�rico se suele utilizar T,U o K, normalmente T

public class Pareja <T> {

	private T primero;
	
	public Pareja() {
		
		primero = null;
		
	}
	
	// C�mo par�metro este m�todo setter recibe un objeto de tipo gen�rico T
	public void setPrimero(T nuevoValor) {
		
		primero = nuevoValor;
		
	}
	
	public T getPrimero() {
		
		return primero;
		
	}
	
	// De esta forma s�lo puede imprimir de tipo Empleado
	// public static void imprimirTrabajador(Pareja<Empleado> p) {
	
	// De esta forma puede imprimir Empleado o cualquier tipo que herede de empleado
	public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
		
		Empleado primero = p.getPrimero();
		
		System.out.println(primero);
		
	}
	
}
