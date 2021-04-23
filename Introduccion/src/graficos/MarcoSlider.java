package graficos;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class MarcoSlider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame_Slider miMarco = new Frame_Slider();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Frame_Slider extends JFrame {
	
	public Frame_Slider() {
		
		setBounds(300,200,600,300);
		Lamina_Slider miLamina = new Lamina_Slider();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class Lamina_Slider extends JPanel {
	
	public Lamina_Slider() {
		
		JSlider control = new JSlider(0,100,50); // Inicio, Fin, Por defecto
		// control.setOrientation(SwingConstants.VERTICAL);
		control.setMajorTickSpacing(25);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		
		control.setFont(new Font("Serif",Font.ITALIC,12));
		control.setPaintLabels(true);
		
		control.setSnapToTicks(true); // Salta a la marca más cercana, no se queda en un punto intermedio
		
		add(control);
		
	}
	
}