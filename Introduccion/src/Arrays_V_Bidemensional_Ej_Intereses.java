
public class Arrays_V_Bidemensional_Ej_Intereses {

	public static void main(String[] args) {
		
		double acumulado;
		double interes=0.10;
		
		double[][] saldo=new double[6][5];
		
		for (int i=0; i<6; i++) {
			saldo[i][0]=10000; // La primera columna será el saldo inicial
			acumulado=10000;
			for (int j=1; j<5;j++) { // En este caso j se inicia en 1, porque 0 ya le hemos dado valores
				acumulado=acumulado+(acumulado*interes);
				saldo[i][j]=acumulado;
			}
			interes = interes + 0.01; // El interés se incrementa un 1% en cada columna
		}
		
		for (int z=0;z<6;z++) {
			System.out.println();
			for (int h=0;h<5;h++) {
				System.out.printf("%1.2f", saldo[z][h]);
				System.out.print(" ");
			}
		}
	}
}
