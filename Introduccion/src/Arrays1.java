
public class Arrays1 {

	public static void main(String[] args) {
		
		/*int [] miMatriz = new int[5]; // Declaraci�n array
		
		miMatriz[0] = 8; // Inicializaci�n de �ndices
		miMatriz[1] = 14;
		miMatriz[2] = -3;
		miMatriz[3] = 4;
		miMatriz[4] = 28;*/
		
		// Declaraci�n simplificada o �mplicita
		int [] miMatriz = {8, 14, -3, 4, 28};
		
		for (int i = 0; i < miMatriz.length; i++) {
			System.out.println("Valor del �ndice " + i + " = " + miMatriz[i]);
		}

	}

}
