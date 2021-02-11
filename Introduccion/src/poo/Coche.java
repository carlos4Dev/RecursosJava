package poo;

public class Coche {
	
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int pesoPlataforma;
	private String color;
	private int pesoTotal;
	private boolean asientosCuero, climatizador;
	
	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		pesoPlataforma = 500;
	}
	
	public String dimeDatosGenerales() { // Getter
		
		return "La plataforma del vehículo tiene " + ruedas + " ruedas " +
		". Mide " + largo / 1000 + " metros con un ancho de " + ancho + 
		" cm y un peso de plataforma de " + pesoPlataforma + " kgs. Tiene un motor de " +
		motor + " cc.";
	}
	
	public String dimeColor() { // Getter
		return "El color del coche es " + color;
	}
	
	public void estableceColor(String colorCoche) { // Setter
		
		color = colorCoche;
	}
	
	public void configuraAsientos(String asientosCuero) { // Setter
		
		if(asientosCuero.equalsIgnoreCase("si")) {
			this.asientosCuero = true;
		}else {
			this.asientosCuero = false;
		}
	}
	
	public String dimeAsientos() { // Getter
		if (asientosCuero) { // asientosCuero == true (no es necesario == true)
			return "El coche tiene asientos de cuero";
		} else {
			return "El coche tiene asientos de serie";
		}
	}
	
	public void configuraClimatizador(String climatizador) { 
		if (climatizador.equalsIgnoreCase("si")) {
			this.climatizador = true;
		} else {
			this.climatizador = false;
		}
	}
	
	public String dimeClimatizador() { // Getter
		
		if (climatizador) {
			return "El coche incorpora climatizador";
		} else {
			return "El coche lleva aire acondicionado";
		}
	}
	
	// Se puede crear un método que sea getter y setter a la vez
	// No es recomendable hacerlo
	
	public String dimePesoCoche() { // Setter + getter (No recomendable)
		
		int pesoCarroceria = 500;
		
		pesoTotal = pesoPlataforma + pesoCarroceria;
		
		if (asientosCuero) {
			pesoTotal = pesoTotal + 50;
		}
		
		if (climatizador) {
			pesoTotal = pesoTotal + 20;
		}
		
		return "El peso del coche es " + pesoTotal;	
	}
	
	public int dimePrecioCoche() { // Getter
		
		int precioFinal = 10000;
		
		if (asientosCuero) {
			precioFinal += 2000;
		}
		
		if (climatizador) {
			precioFinal += 1500;
		}
		
		return precioFinal;
	}
	
	
}
