package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class MenuEmergente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoEmergente miMarco = new MarcoEmergente();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoEmergente extends JFrame {
	
	public MarcoEmergente() {
		
		setBounds(300,300,400,300);
		LaminaEmergente miLamina = new LaminaEmergente();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaEmergente extends JPanel {
	
	JTextPane miArea;
	
	public LaminaEmergente() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar miBarra = new JMenuBar();
		
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamanio = new JMenu("Tamaño");
		
		
		// Añadimos los menus a la barra --------------------------------------------
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamanio);
		
		// Añadimos la barra a la lámina --------------------------------------------
		laminaMenu.add(miBarra);
		
		// Añadimos la lámina del menu
		add(laminaMenu, BorderLayout.NORTH);
		
		// Añadimos el area de texto
		miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
		
		// Añadimos el menú emergente
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		JMenuItem opcion3 = new JMenuItem("Opcion 3");
		
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		
		// Con la siguiente instrucción el menú emergente se añadiría a la lámina
		// setComponentPopupMenu(emergente);
		
		// Aquí se añadiría al TextArea
		miArea.setComponentPopupMenu(emergente);
		
	}
}