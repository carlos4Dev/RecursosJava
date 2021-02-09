
public class Arrays_I {

	public static void main(String[] args) {
		
		/*int [] mi_matriz=new int[5]; // Declaración array
		
		mi_matriz[0]=8; // Inicialización de índices
		mi_matriz[1]=14;
		mi_matriz[2]=-3;
		mi_matriz[3]=4;
		mi_matriz[4]=28;*/
		
		// Declaración simplificada o ímplicita
		int [] mi_matriz = {8, 14, -3, 4, 28};
		
		for (int i=0; i<mi_matriz.length; i++) {
			System.out.println("Valor del índice " + i + " = " + mi_matriz[i]);
		}

	}

}
