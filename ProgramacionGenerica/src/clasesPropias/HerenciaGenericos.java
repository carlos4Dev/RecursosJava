package clasesPropias;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Empleado administrativa = new Empleado("Elena", 45, 1500);
		
		Jefe directoraComercial = new Jefe("Ana", 27, 3500);
		
		// Principio de sustituci�n ...es un   Un Jefe siempre ...es un    Empleado
		
		Empleado nuevoEmpleado = directoraComercial; 
		*/
		
		// Ahora utilzando clases gen�ricas
		
		Pareja<Empleado> administrativa = new Pareja<Empleado>();
		Pareja<Jefe> directoraComercial = new Pareja<Jefe>();
		
		// Lo siguiente no funciona porque las gen�ricas no herendan
		// Pareja<Empleado> nuevoEmpleado = directoraComercial;
		
		Pareja.imprimirTrabajador(administrativa);
		
		// No se puede, porque debe recibir un objeto Pareja de tipo Empleado
		// Pareja.imprimirTrabajador(directoraComercial);
		
		// Si se modifica el m�todo en la clase Pareja
		Pareja.imprimirTrabajador(directoraComercial);
		
	}

}
