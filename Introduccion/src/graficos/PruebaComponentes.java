package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class PruebaComponentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoPrueba miMarco = new MarcoPrueba();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoPrueba extends JFrame {	
	
	public MarcoPrueba() {
		
		setBounds(500,300,500,350);
		
		LaminaPrueba elimina = new LaminaPrueba();
		
		add(elimina);
		setVisible(true);
		
	}
	
}


class LaminaPrueba extends JPanel {
	
	public LaminaPrueba() {
		
		JTextField miCampo = new JTextField(20);
		
		EscuchaTexto el_evento = new EscuchaTexto();
		
		Document miDoc = miCampo.getDocument();
		
		miDoc.addDocumentListener(el_evento);
		
		add(miCampo);
		
	}
	
	private class EscuchaTexto implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println("Has insertado texto");
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println("Has borrado texto");
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
}