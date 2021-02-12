package poo;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados trabajador1 = new Empleados("Pepe Pinto");
		Empleados trabajador2 = new Empleados("Juan Palomo");
		Empleados trabajador3 = new Empleados("Luis Listillo");
		Empleados trabajador4 = new Empleados("Ana Nita");
		
		trabajador1.cambiaSeccion("Recursos Humanos");
		
		System.out.println(trabajador1.devuelveDatos());
		System.out.println(trabajador2.devuelveDatos());
		System.out.println(trabajador3.devuelveDatos());
		System.out.println(trabajador4.devuelveDatos());
		System.out.println(Empleados.dameIdSigiente());

	}

}

// Siempre mejor en archivos separados, aquí sólo por prueba

class Empleados {
	
	// final (constante) el valor no se podrá cambiar
	private final String nombre; 
	private String seccion;
	private int id;
	private static int idSiguiente = 1;
	
	public Empleados(String nom) {
		
		nombre = nom;
		seccion = "Administracion";
		id = idSiguiente;
		idSiguiente++;
	}
	
	public void cambiaSeccion(String seccion) { // setter
		
		this.seccion = seccion;
	}
	
	public String devuelveDatos() {
		
		return "El trabajador " + nombre + " trabaja en " + seccion 
				+ " y su id es " + id;
	}
	
	public static String dameIdSigiente() {
		
		return "El id siguiente es " + idSiguiente;
	}
	
}
