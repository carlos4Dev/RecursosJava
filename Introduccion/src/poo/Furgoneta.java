package poo;

public class Furgoneta extends Coche {
	/* Hubiera sido mejor crear una clase Vehiculo con las 
	características generales, y luego clases hijas Coche y Furgoneta,
	que responden a la regla "es un" Vehiculo (siempre), con las 
	características	específicas de cada uno.
	*/
	private int capacidadCarga;
	private int plazasExtra;
	
	public Furgoneta(int capacidadCarga, int plazasExtra) {
		
		super();
		this.capacidadCarga = capacidadCarga;
		this.plazasExtra = plazasExtra;
	}
	
	public String dimeDatosFurgoneta() {
		
		return "La capacidad de carga es " + capacidadCarga
				+ " y las plazas son " + plazasExtra + ".";
	}
	
	
}
