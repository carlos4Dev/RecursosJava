package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CampoPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoPassword miMarco = new MarcoPassword();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}


class MarcoPassword extends JFrame {
	
	
	public MarcoPassword() {
		
		setBounds(400,300,550,400);
		
		LaminaPassword miLamina = new LaminaPassword();
		
		add(miLamina);
		
		setVisible(true);
		
	}
	
}

class LaminaPassword extends JPanel {
	
	JPasswordField c_contra;
	
	public LaminaPassword() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina_superior = new JPanel();
		
		lamina_superior.setLayout(new GridLayout(2,2));
		
		add(lamina_superior, BorderLayout.NORTH);
		
		JLabel etiqueta1 = new JLabel("Usuario: ");
		JLabel etiqueta2 = new JLabel("Contraseña: ");
		
		JTextField c_usuario = new JTextField(15);
		Comprueba_pass miEvento = new Comprueba_pass();
		c_contra = new JPasswordField(15);
		c_contra.getDocument().addDocumentListener(miEvento);
		
		
		lamina_superior.add(etiqueta1);
		lamina_superior.add(c_usuario);
		lamina_superior.add(etiqueta2);
		lamina_superior.add(c_contra);
		
		JButton enviar = new JButton("Enviar");
		add(enviar, BorderLayout.SOUTH);
	
	}
	
	private class Comprueba_pass implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			char [] contrasenia;
			contrasenia = c_contra.getPassword();
			
			if (contrasenia.length < 8 || contrasenia.length > 12) {
				
				c_contra.setBackground(Color.RED);
				
			} else {
				
				c_contra.setBackground(Color.WHITE);
			}
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			char [] contrasenia;
			contrasenia = c_contra.getPassword();
			
			if (contrasenia.length < 8 || contrasenia.length > 12) {
				
				c_contra.setBackground(Color.RED);
				
			} else {
				
				c_contra.setBackground(Color.WHITE);
			}
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
}