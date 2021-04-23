package graficos;

// Añado menús emergentes

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class Procesador_V {
	
	// Utilizando la clase StyleEditorKit

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuProcesador_V miMarco = new MenuProcesador_V();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador_V extends JFrame {
	
	public MenuProcesador_V() {
		
		setBounds(300,200,600,400);
		LaminaProcesador_V miLamina = new LaminaProcesador_V();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaProcesador_V extends JPanel {
	
	private JTextPane miArea;
	private JMenu fuente, estilo, tamanio;
	private Font letras;
	
	public LaminaProcesador_V() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar miBarra = new JMenuBar();
		
		// Menu principal --------------------------------------------
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamanio = new JMenu("Tamaño");
		
		// Menu Fuente --------------------------------------------
		configura_menu("Arial","fuente","Arial",9,10,"");
		configura_menu("Courier","fuente","Courier",9,10,"");
		configura_menu("Verdana","fuente","Verdana",9,10,"");
		
		// Menu Estilo --------------------------------------------
		configura_menu("Negrita","estilo","",Font.BOLD,1,"src/graficos/bola_azul.gif");
		configura_menu("Cursiva","estilo","",Font.ITALIC,1,"src/graficos/bola_roja.gif");
		
		/* Para evitar conflicto con el menú emergente lo comento y quito el comentario de las dos líneas anteriores
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/graficos/bola_azul.gif"));
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/graficos/bola_roja.gif"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		estilo.add(cursiva);
		*/
		
		// Menu Tamaño --------------------------------------------		
		/*
		configura_menu("12","tamaño","",9,12,"");
		configura_menu("16","tamaño","",9,16,"");
		configura_menu("20","tamaño","",9,20,"");
		configura_menu("24","tamaño","",9,24,"");
		*/
		
		ButtonGroup tamanio_letra = new ButtonGroup();
		
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
		
		// Atajado de teclado Ctrl + D para cambiar a 24 el tamaño
		// veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		tamanio_letra.add(doce);
		tamanio_letra.add(dieciseis);
		tamanio_letra.add(veinte);
		tamanio_letra.add(veinticuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 24));
		
		tamanio.add(doce);
		tamanio.add(dieciseis);
		tamanio.add(veinte);
		tamanio.add(veinticuatro);
		
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
		
		// Añado menú Emergente
		
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem negritaE = new JMenuItem("Negrita");
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		
		emergente.add(negritaE);
		emergente.add(cursivaE);
		
		miArea.setComponentPopupMenu(emergente);
		
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta_icono) {
		
		JMenuItem elem_menu = new JMenuItem(rotulo, new ImageIcon(ruta_icono));
		
		if (menu == "fuente") {
			
			fuente.add(elem_menu);
			
			if (tipo_letra == "Arial") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra","Arial"));
				
			} else if (tipo_letra == "Courier") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra","Courier"));
			
			} else if (tipo_letra == "Verdana") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra","Verdana"));
				
			}
			
			
		} 
		// Si lo construimos con los CheckBox, esta parte sobra
		 
		else if (menu == "estilo") {
			
			estilo.add(elem_menu);
			
			if (estilos == Font.BOLD) {
				// Combinación de teclas para atajo de teclado
				elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());
				
			} else if (estilos == Font.ITALIC) {
				// Combinación de teclas para atajo de teclado
				elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
				
			}
			
			
			
		}// Hasta aquí sobraría si utilizamos el CheckBox
		
		else if (menu == "tamaño") {
			
			tamanio.add(elem_menu);
			
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
			
		}
		
	}
	
}
