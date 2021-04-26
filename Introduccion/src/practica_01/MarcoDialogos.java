package practica_01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MarcoDialogos extends JFrame {

	private LaminaBotones laminaTipo, laminaTipoMensajes, laminaMensaje;
	private LaminaBotones laminaTipoOpcion, laminaOpciones, laminaEntrada;
	
	// Declaración de variables cuadro Mensajes
	private String cadenaMensaje = "Mensaje";
	private Icon iconoMensaje = new ImageIcon("src/practica_01/bola_azul.gif");
	private Object objetoMensaje = new Date();
	private Component componenteMensaje = new LaminaEjemplo();
	
	public MarcoDialogos() {
		
		setTitle("Prueba de diálogos");
		setBounds(500,300,600,450);
		
		// Si la lámina no tiene ninguna característica especial se puede instanciar directamente
		JPanel laminaCuadricula = new JPanel();
		laminaCuadricula.setLayout(new GridLayout(2,3));
		// Si la lámina tiene muchas carácterísticas, mejor crear una clase aparte
		
		String primero[] = {"Mensaje", "Confirmar", "Opción", "Entrada"};
		laminaTipo = new LaminaBotones("Tipo", primero);
		
		//Instanciando en una sola línea
		laminaTipoMensajes = new LaminaBotones("Mensajes", new String [] {
			
			"ERROR_MESSAGE",
			"INFORMATION_MESSAGE",
			"WARNING_MESSAGE",
			"QUESTION_MESSAGE",
			"PLAIN_MESSAGE"
				
		});
		
		laminaMensaje = new LaminaBotones("Mensaje", new String [] {
				
			"Cadena",
			"Icono",
			"Componente",
			"Otros",
			"Object[]"
				
		});
		
		laminaTipoOpcion = new LaminaBotones("Confirmar", new String [] {
				
			"DEFAULT_OPTION",
			"YES_NO_OPTION",
			"YES_NO_CANCEL_OPTION",
			"OK_CANCEL_OPTION"
				
		});
		
		laminaOpciones = new LaminaBotones("Opcion", new String [] {
				
			"String[]",
			"Icon[]",
			"Object[]"
				
		});
		
		
		laminaEntrada = new LaminaBotones("Entrada", new String [] {
				
			"Campo de texto",
			"Combo"
				
		});
		
		setLayout(new BorderLayout());
		
		laminaCuadricula.add(laminaTipo);
		laminaCuadricula.add(laminaTipoMensajes);
		laminaCuadricula.add(laminaMensaje);
		laminaCuadricula.add(laminaTipoOpcion);
		laminaCuadricula.add(laminaOpciones);
		laminaCuadricula.add(laminaEntrada);
		
		add(laminaCuadricula, BorderLayout.CENTER);
		
		// Construimos la lámina inferior
		
		JPanel laminaMostrar = new JPanel();
		
		JButton botonMostrar = new JButton("Mostrar");
		
		botonMostrar.addActionListener(new AccionMostrar());
		
		
		laminaMostrar.add(botonMostrar);
		
		add(laminaMostrar, BorderLayout.SOUTH);	
		
	}
	
	// Proporciona el mensaje ----------------------------
	
	public Object dameMensaje() {
		
		String s = laminaMensaje.dameSeleccion();
		
		if (s.equals("Cadena")) {
			
			return cadenaMensaje;
			
		} else if (s.equals("Icono")) {
			
			return iconoMensaje;
			
		} else if(s.equals("Componente")) {
			
			return componenteMensaje;
			
		} else if(s.equals("Otros")) {
			
			return objetoMensaje;
			
		} else if(s.equals("Object[]")) {
			
			return new Object[] {
				cadenaMensaje,
				iconoMensaje,
				componenteMensaje,
				objetoMensaje,
					
			};
			
		} else {
			
			return null;
			
		}
		
	}
	
	// Devolver tipo icono  y también número de botones en confirmar ---------
	
	public int dameTipo (LaminaBotones lamina) {
		
		String s = lamina.dameSeleccion();
		
		if (s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) {
			
			return 0;
			
		} else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {
			
			return 1;
			
		} else if (s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) {
			
			return 2;
			
		} else if (s.equals("QUESTION_MESSAGE")) {
			
			return 3;
			
		} else if (s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")) {
			
			return -1;
	
		} else {
			
			return  0;
		}
		
	}
	
	// Da opciones a la lámina opcion -----------------------
	
	public Object[] dameOpciones(LaminaBotones lamina) {
		
		String s = lamina.dameSeleccion();
		
		if (s.equals("String[]")) {
			
			return new String[] {"Amarillo","Azul","Rojo"};
			
		} else if (s.equals("Icon[]")) {
			
			return new Object[] {new ImageIcon("src/practica_01/bola_azul.gif"),
					new ImageIcon("src/practica_01/bola_amarilla.gif"),
					new ImageIcon("src/practica_01/bola_roja.gif")
			};
			
		} else if (s.equals("Object[]")) {
		
			return new Object[] {
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje,
						
				}; 
			
		} else {
			
			return null;
		}
		
	}
	
	// Clase interna que gestiona los eventos ---------------
	private class AccionMostrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// System.out.println(laminaTipo.dameSeleccion());
			
			if (laminaTipo.dameSeleccion().equals("Mensaje")) {
				
				JOptionPane.showMessageDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensajes));
				
				
			} else if (laminaTipo.dameSeleccion().equals("Confirmar")) {
				
				JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoOpcion), dameTipo(laminaTipoMensajes));
				
			} else if (laminaTipo.dameSeleccion().equals("Entrada")) {
				
				if (laminaEntrada.dameSeleccion().equals("Campo de texto")) {
					
					JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensajes));
					
				} else if (laminaEntrada.dameSeleccion().equals("Combo")) {
					
					JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensajes), null, new String[] {"Amarillo","Azul","Rojo"}, "Azul");
					
				}	
				
			} else if (laminaTipo.dameSeleccion().equals("Opción")) {
				
				JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(), "Titulo", 1, dameTipo(laminaTipoMensajes), null, dameOpciones(laminaOpciones), null);
				
			}
			
		}
		
	}
	
}

class LaminaEjemplo extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
	
		g2.setPaint(Color.YELLOW);
		
		g2.fill(rectangulo);
	}
}
