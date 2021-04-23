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

public class Procesador_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuProcesador_III miMarco = new MenuProcesador_III();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador_III extends JFrame {
	
	public MenuProcesador_III() {
		
		setBounds(300,200,600,400);
		LaminaProcesador_III miLamina = new LaminaProcesador_III();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaProcesador_III extends JPanel {
	
	private JTextPane miArea;
	private JMenu fuente, estilo, tamanio;
	private Font letras;
	
	public LaminaProcesador_III() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar miBarra = new JMenuBar();
		
		// Menu principal --------------------------------------------
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamanio = new JMenu("Tamaño");
		
		// Menu Fuente --------------------------------------------
		configura_menu("Arial","fuente","Arial",9,10);
		configura_menu("Courier","fuente","Courier",9,10);
		configura_menu("Verdana","fuente","Verdana",9,10);
		
		// Menu Estilo --------------------------------------------
		configura_menu("Negrita","estilo","",Font.BOLD,1);
		configura_menu("Cursiva","estilo","",Font.ITALIC,1);
		
		// Menu Tamaño --------------------------------------------		
		configura_menu("12","tamaño","",9,12);
		configura_menu("16","tamaño","",9,16);
		configura_menu("20","tamaño","",9,20);
		configura_menu("24","tamaño","",9,24);
		
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
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {
		
		JMenuItem elem_menu = new JMenuItem(rotulo);
		
		if (menu == "fuente") {
			
			fuente.add(elem_menu);
			
		} else if (menu == "estilo") {
			
			estilo.add(elem_menu);
			
		} else if (menu == "tamaño") {
			
			tamanio.add(elem_menu);
			
		}
		
		elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
		
	}
	
	private class Gestiona_Eventos implements ActionListener {

		String tipo_texto, menu;
		
		int estilo_letra, tamanio_letra;
		
		Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra) {
			
			tipo_texto = texto2;
			estilo_letra = estilo2;
			tamanio_letra = tam_letra;
			menu = elemento;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			letras = miArea.getFont();
			
			if (menu == "Arial" || menu == "Courier" || menu == "Verdana") {
				
				estilo_letra = letras.getStyle();
				tamanio_letra = letras.getSize();
				
			} else if (menu == "Cursiva" || menu == "Negrita") {
				
				tipo_texto = letras.getFontName();
				tamanio_letra = letras.getSize();
				
			} else if (menu == "12" || menu == "16" || menu == "20" || menu == "24") {
				
				estilo_letra = letras.getStyle();
				tipo_texto = letras.getFontName();
			}
					
			
			miArea.setFont(new Font(tipo_texto, estilo_letra, tamanio_letra));
			System.out.println("Tipo letra: " + tipo_texto + " Estilo: " + estilo_letra + " Tamaño: " + tamanio_letra);
			
		}
			
	}
	
}