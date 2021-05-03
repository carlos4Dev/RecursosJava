package usoThreads;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame miMarco = new MarcoRebote();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);

	}

}

// Implementación multihilos

class PelotaHilos implements Runnable {
	
	private Pelota pelota;
	private Component componente;
	
	public PelotaHilos(Pelota unaPelota, Component unComponente) {
		
		pelota = unaPelota;
		componente = unComponente;
		
	}
	
	/*
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 1; i <= 3000; i++) {
			
			pelota.muevePelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			
			// Le damos una pausa para poder ver el movimiento
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				// e.printStackTrace(); Imprimiría la pila del error
				System.out.println("Hilo bloqueado. Imposible su interrupción"); // Mensaje personalizado
				// System.exit(0); // Terminar el proceso, saliendo del programa
				
				// Se puede interrumpir de diferentes formas
			}
			
		}		
		*/
	
	// Ahora utilizando interrupted y sin utilizar sleep
	
	public void run() {
		
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		
		//while(!Thread.interrupted()) { // interrupted es static y hay que utilizar nombre de la clase
		while(!Thread.currentThread().isInterrupted()) {
			
			pelota.muevePelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			
			try {
				
				Thread.sleep(4);
				
			} catch (InterruptedException e) {
				
				Thread.currentThread().interrupt();
				
			}
			
		}
		
		System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
	
	}
		
}

// Movimiento de la pelota ------------------------------------

class Pelota {
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	private static final int TAMX = 15;
	private static final int TAMY = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	public void muevePelota(Rectangle2D limites) {
		
		x += dx;
		y += dy;
		
		if (x < limites.getMinX()) {
			
			x = limites.getMinX();
			dx = -dx;
		}
		
		if (x + TAMX >= limites.getMaxX()) {
			
			x = limites.getMaxX() - TAMX;
			
			dx = -dx;
		}
		
		if (y < limites.getMinY()) {
			
			y = limites.getMinY();
			
			dy = -dy;
		}
		
		if (y + TAMY >= limites.getMaxY()) {
			
			y = limites.getMaxY() - TAMY;
			
			dy = -dy;
		}
		
	}
	
	// Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape() {
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}
	
}

// Lamina que dibuja la pelota -------------------------------------------

class LaminaPelota extends JPanel {
	
	// Añadimos la pelota a la lámina
	
	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
	
	public void add(Pelota b) {
		
		pelotas.add(b);
	
	}
	
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		for(Pelota b: pelotas) {
			
			g2.fill(b.getShape());
		}
		
	}
	
}

// Marco con lámina y botones -------------------------------------------

class MarcoRebote extends JFrame {
	
	private LaminaPelota lamina;
	
	private Thread t1, t2, t3;
	
	private JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
	
	public MarcoRebote() {
		
		setBounds(600,300,600,350);
		setTitle("Rebotes");
		lamina = new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones = new JPanel();
		
		arranca1 = new JButton("Hilo1");
		arranca1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				comienzaElJuego(evento);
			}
			
		});
		
		laminaBotones.add(arranca1);
		
		// ----------------------------------------------
		
		arranca2 = new JButton("Hilo2");
		arranca2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				comienzaElJuego(evento);
			}
			
		});
		
		laminaBotones.add(arranca2);
		
		// -----------------------------------------------
		
		arranca3 = new JButton("Hilo3");
		arranca3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				comienzaElJuego(evento);
			}
			
		});
		
		laminaBotones.add(arranca3);
		
		// ----------------------------------------------
		
		detener1 = new JButton("Detener1");
		detener1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				detener(evento);
			}
			
		});
		
		laminaBotones.add(detener1);
		
		// ----------------------------------------------
		
		detener2 = new JButton("Detener2");
		detener2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				detener(evento);
			}
			
		});
		
		laminaBotones.add(detener2);
		
		// ----------------------------------------------
		
		detener3 = new JButton("Detener3");
		detener3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				detener(evento);
			}
			
		});
		
		laminaBotones.add(detener3);
		
		/*
		 * 
		 * 
		ponerBoton(laminaBotones, "Inicio", new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				comienzaElJuego();
				
			}
		});
		
		ponerBoton(laminaBotones, "Salir", new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				System.exit(0);
			}
			
		});
		
		// Añadimos el botón de detener
		
		ponerBoton(laminaBotones, "Detener", new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				detener();
				
			}
			
		});
		*/
		
		add(laminaBotones, BorderLayout.SOUTH);
		
	}
	
	// Ponemos botones
	
	/*
	public void ponerBoton(Container c, String titulo, ActionListener oyente) {
		
		JButton boton = new JButton(titulo);		
		c.add(boton);
		boton.addActionListener(oyente);
		
	}
	*/
	// Añade pelota y la bota 3000 veces
	
	public void comienzaElJuego(ActionEvent e) {
		
		Pelota pelota = new Pelota();
		lamina.add(pelota);
		
		// Multihilo // Se puede simplificar el código, aquí a modo de explicación
		
		Runnable r = new PelotaHilos(pelota, lamina);
		
		if (e.getSource().equals(arranca1)) {
			
			t1 = new Thread(r);
			t1.start();
			
		} else if (e.getSource().equals(arranca2)) {
			
			t2 = new Thread(r);
			t2.start();
			
		} else if (e.getSource().equals(arranca3)) {
			
			t3 = new Thread(r);
			t3.start();
		
		}
		// t = new Thread(r);
		
		// t.start();
		
		/* Un único hilo
		 
		for (int i = 1; i <= 3000; i++) {
			
			pelota.muevePelota(lamina.getBounds());
			lamina.paint(lamina.getGraphics());
			
			// Le damos una pausa para poder ver el movimiento
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
	}
	
	public void detener(ActionEvent e) {
		
		// t.stop(); método obsoleto
		
		// t.interrupt(); // al utilizar método sleep, salta mensaje de sleep interrupted
		// no se puede interrumpir y continúa
		
		if (e.getSource().equals(detener1)) {
			
			t1.interrupt();
			
		} else if (e.getSource().equals(detener2)) {
			
			t2.interrupt();
		
		} else if (e.getSource().equals(detener3)) {
			
			t3.interrupt();
		
		}
		
	}
	
	
}
