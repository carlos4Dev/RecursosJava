package excepcionesI;

import java.io.EOFException;

import javax.swing.JOptionPane;

public class CompruebaMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String elMail = JOptionPane.showInputDialog("Introduce un mail v�lido: ");
		
		try {
			
			examinaMail(elMail);
			
		} catch(Exception e) {
			
			System.out.println("La direcci�n de mail no es correcta");
			
			// La siguiente instrucci�n es �til para que un programador tenga m�s datos sobre la excepci�n
			e.printStackTrace();
			
		}
		
		
		/*try {
			
			examinaMail(elMail);
			
		} catch (EOFException e) {
			
			System.out.println("La direcci�n de email no es correcta");
		}*/
		
		
	}

	static void examinaMail(String mail) throws LongitudMailErronea { //throws EOFException {
		
		int arroba = 0;
		boolean punto = false;
		
		if (mail.length() <= 3) {
			
			// No es la forma m�s correcta de lanzar la excepci�n
			// porque no es el tipo de excepci�n que se da en este caso
			// M�s adelante en el curso se ver� como mejorar el c�digo
			// throw new EOFException();
			
			throw new LongitudMailErronea("El mail no puede tener menos de tres caracteres");
			
		} else {
			
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
	
}

// clase de Excepci�n propia
class LongitudMailErronea extends Exception {
	
	public LongitudMailErronea() {
		
	}
	
	public LongitudMailErronea(String msjError) {
		
		super(msjError);
		
	}
	
}

