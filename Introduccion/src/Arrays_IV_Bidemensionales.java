
public class Arrays_IV_Bidemensionales {

	public static void main(String[] args) {
		
		/* int[][] matrix = new int[3][2];
		
		matrix[0][0] = 15;
		matrix[0][1] = 8;
		
		matrix[1][0] = 2;
		matrix[1][1] = 25;
		
		matrix[2][0] = 7;
		matrix[2][1] = 11; */
		
		int[][] matrix = {
				{15,8},
				{2,25},
				{7,11}
		};
		
		for (int i=0; i<3; i++) {
			System.out.println();
			for (int j=0; j<2; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		
		// Recorriendo con Foreach
		
		for (int[] fila:matrix) {
			System.out.println();
			for (int z:fila) {
				System.out.print(z + " ");
			}
		}
	}

}
