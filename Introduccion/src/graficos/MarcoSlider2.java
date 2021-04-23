package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MarcoSlider2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame_Slider2 miMarco = new Frame_Slider2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Frame_Slider2 extends JFrame {
	
	public Frame_Slider2() {
		
		setBounds(300,200,600,300);
		Lamina_Slider2 miLamina = new Lamina_Slider2();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class Lamina_Slider2 extends JPanel {
	
	private JLabel rotulo;
	private JSlider control;
	
	public Lamina_Slider2() {
		
		setLayout(new BorderLayout());
		
		rotulo = new JLabel("En un lugar de la Mancha...");
		add(rotulo, BorderLayout.CENTER);
		
		control = new JSlider(8,60,12);
		control.setMajorTickSpacing(16);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		control.setFont(new Font("Serif", Font.ITALIC, 10));
		control.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider = new JPanel();
		laminaSlider.add(control);
		add(laminaSlider, BorderLayout.NORTH);
		
	}
	
	private class EventoSlider implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			
			//System.out.println("Estás cambiando el tamaño a " + control.getValue());
			
			rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
			
		}
		
	}
	
}