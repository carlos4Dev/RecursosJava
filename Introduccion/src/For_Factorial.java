import javax.swing.*;
public class For_Factorial {

	public static void main(String[] args) {
		// El factorial de un n�mero puede resultar un n�mero muy grande.
		// Mejor declarar la variable como Long y al iniciar poner 1L
		// Tambi�n se desbordar� si se introduce un n�mero alto
		// Se deber�a utilizar BigInteger
		Long resultado=1L;
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un n�mero"));
		
		for(int i=numero; i>0;i--) {
			resultado=resultado*i;
		}
		System.out.println("El factorial de " + numero + " es " + resultado);
	}

}
