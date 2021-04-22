package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploArea2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoPruebaArea miMarco = new MarcoPruebaArea();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class MarcoPruebaArea extends JFrame {
	
	private JPanel laminaBotones;
	private JButton botonInsertar, botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaConBarras;
	
	
	public MarcoPruebaArea() {
		
		setTitle("Probando �rea de texto");
		setBounds(500,300,500,350);
		setLayout(new BorderLayout());
		laminaBotones = new JPanel();
		
		botonInsertar = new JButton("Insertar");
		botonInsertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				areaTexto.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme... ");
				
			}
			
			
		});
		
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea = new JButton("Salto de L�nea");
		botonSaltoLinea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean saltar = !areaTexto.getLineWrap();
				areaTexto.setLineWrap(saltar);
				
				/* Esta es la forma normal de hacer el if
				if (saltar) {
					
					botonSaltoLinea.setText("Quitar salto");
					
				} else {
					
					botonSaltoLinea.setText("Salto L�nea");
				}
				*/
				
				// Lo mismo pero con operador ternario
				
				botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto L�nea");
			}
			
			
		});
		
		laminaBotones.add(botonSaltoLinea);
		add(laminaBotones, BorderLayout.SOUTH);
		areaTexto = new JTextArea(8,20);
		laminaConBarras = new JScrollPane(areaTexto);
		add(laminaConBarras, BorderLayout.CENTER);
		
	}
	
	
}
