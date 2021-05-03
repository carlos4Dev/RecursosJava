package clasesPropias;

public class UsoPareja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pareja<String> una = new Pareja<String>();
		una.setPrimero("Pepe");
		System.out.println(una.getPrimero());
		
		Persona pers1 = new Persona("Juan");
		
		Pareja<Persona> dos = new Pareja<Persona>();
		dos.setPrimero(pers1);
		// Al utilizar get aquí devuelve un objeto Persona, no un String
		System.out.println(dos.getPrimero());
		
		// Si queremos que devuelva un String 
		// tenemos que tener un método toString en la clase Persona

	}

}

class Persona {
	
	private String nombre;
	
	public Persona(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public String toString() {
		
		return nombre;
	}
	
}