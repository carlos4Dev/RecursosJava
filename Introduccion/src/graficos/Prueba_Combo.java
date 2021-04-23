package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Prueba_Combo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCombo miMarco = new MarcoCombo();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoCombo extends JFrame {
	
	public MarcoCombo() {
		
		setVisible(true);
		setBounds(400,250,600,300);
		LaminaCombo miLamina = new LaminaCombo();
		add(miLamina);
		
	}
	
}

class LaminaCombo extends JPanel {
	
	private JLabel texto;
	private JComboBox miCombo;
	
	public LaminaCombo() {
		
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la Mancha...");
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		add(texto, BorderLayout.CENTER);
		
		JPanel lamina_norte = new JPanel();
		
		miCombo = new JComboBox();
		miCombo.setEditable(true); // Permite al usuario introducir un texto
		miCombo.addItem("Serif");
		miCombo.addItem("SansSerif");
		miCombo.addItem("Monospace");
		miCombo.addItem("Dialog");
		
		Evento_combo miEvento = new Evento_combo();
		miCombo.addActionListener(miEvento);
		
		lamina_norte.add(miCombo);
		add(lamina_norte, BorderLayout.NORTH);
	}
	
	private class Evento_combo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			texto.setFont(new Font((String)miCombo.getSelectedItem(), Font.PLAIN, 18));
			
		}	
		
	}
}
