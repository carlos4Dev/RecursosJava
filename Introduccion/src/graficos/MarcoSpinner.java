package graficos;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class MarcoSpinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FrameSpinner miMarco = new FrameSpinner();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);

	}

}

class FrameSpinner extends JFrame {
	
	public FrameSpinner() {
		
		setBounds(200,400,550,350);
		setVisible(true);
		add(new LaminaSpinner());
		
	}
}

class LaminaSpinner extends JPanel {
	
	public LaminaSpinner() {
		
		String lista[] = {"Enero", "Febrero", "Marzo", "Abril"};
		
		String fuentes[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		JSpinner control = new JSpinner(new SpinnerDateModel());
		
		JSpinner control2 = new JSpinner(new SpinnerListModel(lista));
		
		JSpinner control3 = new JSpinner(new SpinnerListModel(fuentes));
		
		JSpinner control4 = new JSpinner(new SpinnerNumberModel(5,0,10,1)); //Inicio, minimo, maximo, numero de paso
		
		// JSpinner control5 = new JSpinner(new MiModeloJSpinner());
		
		// Utilizando clase interna anónima
		JSpinner control5 = new JSpinner(new SpinnerNumberModel(5,0,10,1) {
			
			public Object getNextValue() {
				
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue() {
				
				return super.getNextValue();
			}
			
		});
		
		Dimension d = new Dimension(100,20);
		Dimension fontDimension = new Dimension(200,20);
		
		control.setPreferredSize(d);
		control2.setPreferredSize(d);
		control3.setPreferredSize(fontDimension);
		
		add(control);
		add(control2);
		add(control3);
		add(control4);
		add(control5);
		
	}
	
	// Para cambiar el sentido de las botones de subir y bajar
	/* Clase interna normal
	private class MiModeloJSpinner extends SpinnerNumberModel {
		
		public MiModeloJSpinner() {
			
			super(5,0,10,1);
			
		}
		
		public Object getNextValue() {
			
			return super.getPreviousValue();
		}
		
		public Object getPreviousValue() {
			
			return super.getNextValue();
		}
		
	}
	*/
	
}
