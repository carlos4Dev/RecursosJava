import javax.swing.*;

public class Arrays2 {
	
	public static void main(String[] args) {
		
		String[] paises = new String[8];
		
		/*paises[0] = "Espa�a";
		paises[1] = "M�xico";
		paises[2] = "Colombia";
		paises[3] = "Per�";
		paises[4] = "Chile";
		paises[5] = "Argentina";
		paises[6] = "Ecuador";
		paises[7] = "Venezuela";
		
		for (int i = 0; i < paises.length; i++) {
			System.out.println("Pa�s " + (i+1) + " " + paises[i]);
		}
		
		// Declaraci�n  impl�cita
		String[] paises= {"Espa�a","M�xico","Colombia","Per�","Chile","Argentina","Ecuador","Venezuela"};
		*/
		
		//Introduciendo datos con JOptionPane
		for (int i = 0; i < paises.length; i++) {
			paises[i] = JOptionPane.showInputDialog("Introduce pa�s " + (i+1));
		}
		// Recorriendo la matriz con bucle foreach, for mejorado
		for (String elemento:paises) {
			System.out.println("Pa�s: " + elemento);
		}
		
	}
}
