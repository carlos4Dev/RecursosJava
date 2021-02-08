import javax.swing.*;
public class While_Acceso_Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String clave="Pepe";
		String pass="";
		
		while (clave.equals(pass)==false) {
			pass=JOptionPane.showInputDialog("Introduce la constraseña, por favor");
			if (clave.equals(pass)==false) {
				System.out.println("Contraseña incorrecta");
			}
		}
		
		System.out.println("Contraseña correcta. Acceso permitido");
	}

}
