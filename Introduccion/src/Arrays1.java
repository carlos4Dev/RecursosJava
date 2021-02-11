
public class Arrays1 {

	public static void main(String[] args) {
		
		/*int [] miMatriz = new int[5]; // Declaración array
		
		miMatriz[0] = 8; // Inicialización de índices
		miMatriz[1] = 14;
		miMatriz[2] = -3;
		miMatriz[3] = 4;
		miMatriz[4] = 28;*/
		
		// Declaración simplificada o ímplicita
		int [] miMatriz = {8, 14, -3, 4, 28};
		
		for (int i = 0; i < miMatriz.length; i++) {
			System.out.println("Valor del índice " + i + " = " + miMatriz[i]);
		}

	}

}
