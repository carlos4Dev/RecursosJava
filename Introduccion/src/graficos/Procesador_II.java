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
import javax.swing.JTextPane;

public class Procesador_II {
	
	// Este programa no está terminado porque se genera bastante código
	// En Procesador_III se optimiza un poco el código

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuProcesador_II miMarco = new MenuProcesador_II();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador_II extends JFrame {
	
	public MenuProcesador_II() {
		
		setBounds(300,200,600,400);
		LaminaProcesador_II miLamina = new LaminaProcesador_II();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaProcesador_II extends JPanel {
	
	private JTextPane miArea;
	
	public LaminaProcesador_II() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar miBarra = new JMenuBar();
		
		//Menu principal --------------------------------------------
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamanio = new JMenu("Tamaño");
		
		//Menu Fuente --------------------------------------------
		JMenuItem arial = new JMenuItem("Arial");
		arial.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				miArea.setFont(new Font("Arial", Font.PLAIN, 12));
				
			}
			
		});
		
		JMenuItem courier = new JMenuItem("Courier");
		courier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				miArea.setFont(new Font("Courier", Font.PLAIN, 12));
				
			}
			
		});
		
		JMenuItem verdana = new JMenuItem("Fuente");
		verdana.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				miArea.setFont(new Font("Verdana", Font.PLAIN, 12));
				
			}
			
		});
		
		fuente.add(arial);
		fuente.add(courier);
		fuente.add(verdana);
		
		//Menu Estilo --------------------------------------------
		JMenuItem negrita = new JMenuItem("Negrita");
		JMenuItem cursiva = new JMenuItem("Cursiva");		
		estilo.add(negrita);
		estilo.add(cursiva);
		
		// Menu Fuente --------------------------------------------
		JMenuItem tam_12 = new JMenuItem("12");
		JMenuItem tam_16 = new JMenuItem("16");
		JMenuItem tam_20 = new JMenuItem("20");
		JMenuItem tam_24 = new JMenuItem("24");
		tamanio.add(tam_12);
		tamanio.add(tam_16);
		tamanio.add(tam_20);
		tamanio.add(tam_24);
		
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
		
	}
	
}