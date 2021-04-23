package graficos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MarcoMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuFrame miMarco = new MenuFrame();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);

	}

}

class MenuFrame extends JFrame {
	
	public MenuFrame() {
		
		setBounds(500,300,550,400);
		MenuLamina miLamina = new MenuLamina();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class MenuLamina extends JPanel {
	
	public MenuLamina() {
		
		JMenuBar miBarra = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edición");
		JMenu herramientas = new JMenu("Herramientas");
		JMenu opciones = new JMenu("Opciones");
		
		// Menu -> Archivo
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardar_como = new JMenuItem("Guardar como");
		
		// Menu -> Edicion
		JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("src/graficos/cortar.gif"));
		JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/graficos/copiar.gif"));
		// Se puede cambiar la posición, por defecto es a la izquierda
		// copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/graficos/pegar.gif"));
		
		// Menu -> Herramientas
		
		JMenuItem generales = new JMenuItem("Generales");
		
		// Menu -> Opciones
		
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		
		opciones.add(opcion1);
		opciones.add(opcion2);
		
		archivo.add(guardar);
		archivo.add(guardar_como);
		
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		
		// Para añadir un separador
		edicion.addSeparator();
		edicion.add(opciones);
		
		herramientas.add(generales);
		
		miBarra.add(archivo);
		miBarra.add(edicion);
		miBarra.add(herramientas);
		
		add(miBarra);
	}
}
