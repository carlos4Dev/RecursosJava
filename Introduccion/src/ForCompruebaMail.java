import javax.swing.JOptionPane;

public class ForCompruebaMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arroba = 0;
		boolean punto = false;
		
		String mail = JOptionPane.showInputDialog("Introduce mail");
		
		// Recorremos mail y buscamos que tenga un caracter arroba y un punto
		// Los char van dentro de comillas simples
		for (int i = 0; i < mail.length(); i++) {
			if (mail.charAt(i) == '@') {
				arroba++;
			}
			if (mail.charAt(i) == '.') {
				punto = true;
			}
		}
		
		if (arroba == 1 && punto == true) {
			System.out.println("El mail es correcto");
		}
		else {
			System.out.println("No es correcto");
		}
	}

}
