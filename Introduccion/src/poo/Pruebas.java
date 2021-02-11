package poo;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados trabajador1 = new Empleados("Pepe Pinto");
		Empleados trabajador2 = new Empleados("Juan Palomo");
		
		trabajador1.cambiaSeccion("Recursos Humanos");
		
		System.out.println(trabajador1.devuelveDatos());
		System.out.println(trabajador2.devuelveDatos());

	}

}

// Siempre mejor en archivos separados, aquí sólo por prueba

class Empleados {
	
	// final (constante) el valor no se podrá cambiar
	private final String nombre; 
	private String seccion;
	
	public Empleados(String nom) {
		
		nombre = nom;
		seccion = "Administracion";
	}
	
	public void cambiaSeccion(String seccion) { // setter
		
		this.seccion = seccion;
	}
	
	public String devuelveDatos() {
		return "El trabajador " + nombre + " trabaja en " + seccion;
	}
	
}
