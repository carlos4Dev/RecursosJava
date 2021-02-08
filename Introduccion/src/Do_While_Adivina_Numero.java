import java.util.Scanner;
public class Do_While_Adivina_Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada=new Scanner(System.in);
		int aleatorio=(int)(Math.random()*100);		
		int numero=0;
		int intentos=0;
		
		do {
			intentos++;
			System.out.println("Introduce un número, por favor");
			numero=entrada.nextInt();
			if(aleatorio<numero) {
				System.out.println("El número a adivinar es más bajo");
			}
			else if(aleatorio>numero) {
				System.out.println("El número a adivinar es más alto");
			}
			
		}while(numero!=aleatorio);
		System.out.println("Número correcto. Lo has conseguido en " + intentos + " intentos.");
		entrada.close();
	}

}
