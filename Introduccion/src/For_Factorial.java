import javax.swing.*;
public class For_Factorial {

	public static void main(String[] args) {
		// El factorial de un número puede resultar un número muy grande.
		// Mejor declarar la variable como Long y al iniciar poner 1L
		// También se desbordará si se introduce un número alto
		// Se debería utilizar BigInteger
		Long resultado=1L;
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		
		for(int i=numero; i>0;i--) {
			resultado=resultado*i;
		}
		System.out.println("El factorial de " + numero + " es " + resultado);
	}

}
