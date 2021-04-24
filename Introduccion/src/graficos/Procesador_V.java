package graficos;

// Añado menús emergentes

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.BoldAction;

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
		
		setBounds(300,200,600,420);
		LaminaProcesador_V miLamina = new LaminaProcesador_V();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaProcesador_V extends JPanel {
	
	private JTextPane miArea;
	private JMenu fuente, estilo, tamanio;
	private Font letras;
	private JButton negritaBarra, cursivaBarra, subraBarra, azulBarra, amarilloBarra, rojoBarra;
	private JButton a_izquierda, a_centrado,  a_derecha, a_justificado;
	private JToolBar barra;
	
	
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
		configura_menu("Negrita","estilo","",Font.BOLD,1,"src/graficos/negrita.gif");
		configura_menu("Cursiva","estilo","",Font.ITALIC,1,"src/graficos/cursiva.gif");
		
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
		
		// Añado menú Emergente -----------------------------------------
		
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem negritaE = new JMenuItem("Negrita");
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		
		emergente.add(negritaE);
		emergente.add(cursivaE);
		
		miArea.setComponentPopupMenu(emergente);
		
		/* De esta forma se genera bastante código, se puede optimizar con un método configura_barra()
		// Barra de herramientas ------------------------------------------------------------------------
		JToolBar barra = new JToolBar();
		// Estilo ---------------------------
		JButton negritaBarra = new JButton(new ImageIcon("src/graficos/negrita.gif"));
		JButton cursivaBarra = new JButton(new ImageIcon("src/graficos/cursiva.gif"));
		JButton subraBarra = new JButton(new ImageIcon("src/graficos/subrayado.gif"));
		// Color de fuente ----------------
		JButton azulBarra = new JButton(new ImageIcon("src/graficos/bola_azul.gif"));
		JButton amarilloBarra = new JButton(new ImageIcon("src/graficos/bola_amarilla.gif"));
		JButton rojoBarra = new JButton(new ImageIcon("src/graficos/bola_roja.gif"));
		// Alineación ----------------------
		JButton a_izquierda = new JButton(new ImageIcon("src/graficos/a_izquierda.gif"));
		JButton a_centrada = new JButton(new ImageIcon("src/graficos/centrado.gif"));
		JButton a_derecha = new JButton(new ImageIcon("src/graficos/a_derecha.gif"));
		JButton a_justificado = new JButton(new ImageIcon("src/graficos/justificado.gif"));
		
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		subraBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Fuente_Azul", Color.BLUE));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Fuente_Amarillo", Color.YELLOW));		
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Fuente_Rojo", Color.RED));
		
		a_izquierda.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		a_centrada.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		a_derecha.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		a_justificado.addActionListener(new StyledEditorKit.AlignmentAction("Justicado", 3));
		
		
		barra.add(negritaBarra);
		barra.add(cursivaBarra);
		barra.add(subraBarra);
		
		barra.add(azulBarra);
		barra.add(amarilloBarra);
		barra.add(rojoBarra);
		
		barra.add(a_izquierda);
		barra.add(a_centrada);
		barra.add(a_derecha);
		barra.add(a_justificado);
		
		*/
		barra = new JToolBar();
		configura_barra("src/graficos/negrita.gif").addActionListener(new StyledEditorKit.BoldAction());
		configura_barra("src/graficos/cursiva.gif").addActionListener(new StyledEditorKit.ItalicAction());
		configura_barra("src/graficos/subrayado.gif").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barra.addSeparator();
		
		configura_barra("src/graficos/bola_azul.gif")
		    .addActionListener(new StyledEditorKit.ForegroundAction("Fuente_Azul", Color.BLUE));
		configura_barra("src/graficos/bola_amarilla.gif")
		    .addActionListener(new StyledEditorKit.ForegroundAction("Fuente_Azul", Color.YELLOW));
		configura_barra("src/graficos/bola_roja.gif")
		    .addActionListener(new StyledEditorKit.ForegroundAction("Fuente_Azul", Color.RED));
		
		
		barra.addSeparator();
        
        configura_barra("src/graficos/a_izquierda.gif")
            .addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
        configura_barra("src/graficos/centrado.gif")
            .addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
        configura_barra("src/graficos/a_derecha.gif")
            .addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
        configura_barra("src/graficos/justificado.gif")
        .addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
        
        barra.setOrientation(1);
		add(barra, BorderLayout.WEST);
	}
	
	public JButton configura_barra(String ruta) {
	    
	    JButton boton = new JButton(new ImageIcon(ruta));
	    
	    barra.add(boton);
	    
	    return boton;
	    
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
