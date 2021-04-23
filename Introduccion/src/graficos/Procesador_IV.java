package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class Procesador_IV {
	
	// Utilizando la clase StyleEditorKit

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuProcesador_IV miMarco = new MenuProcesador_IV();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador_IV extends JFrame {
	
	public MenuProcesador_IV() {
		
		setBounds(300,200,600,400);
		LaminaProcesador_IV miLamina = new LaminaProcesador_IV();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaProcesador_IV extends JPanel {
	
	private JTextPane miArea;
	private JMenu fuente, estilo, tamanio;
	private Font letras;
	
	public LaminaProcesador_IV() {
		
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
		// configura_menu("Negrita","estilo","",Font.BOLD,1,"src/graficos/bola_azul.gif");
		// configura_menu("Cursiva","estilo","",Font.ITALIC,1,"src/graficos/bola_roja.gif");
		
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/graficos/bola_azul.gif"));
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/graficos/bola_roja.gif"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		estilo.add(cursiva);
		
		
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
		/* Si lo construimos con los CheckBox, esta parte sobra
		 
		else if (menu == "estilo") {
			
			estilo.add(elem_menu);
			
			if (estilos == Font.BOLD) {
				
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());
				
			} else if (estilos == Font.ITALIC) {
				
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
				
			}
			
			
			
		}*/ else if (menu == "tamaño") {
			
			tamanio.add(elem_menu);
			
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
			
		}
		
	}
	
}
