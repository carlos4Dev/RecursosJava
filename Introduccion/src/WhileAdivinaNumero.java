import java.util.*;
public class WhileAdivinaNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		int aleatorio = (int)(Math.random()*100);		
		int numero = 0;
		int intentos = 0;
		
		while (numero != aleatorio) {
			intentos++;
			System.out.println("Introduce un n�mero, por favor");
			numero = entrada.nextInt();
			if (aleatorio < numero) {
				System.out.println("El n�mero a adivinar es m�s bajo");
			}
			else if (aleatorio > numero) {
				System.out.println("El n�mero a adivinar es m�s alto");
			}
		}
		System.out.println("N�mero correcto. Lo has conseguido en " + intentos + " intentos.");
		entrada.close();
	}

}
