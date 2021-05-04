package excepcionesI;

import javax.swing.*;

public class VariasExcepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // No es una buena práctica capturar con un try catch excepciones no controladas
	    // Se supone que son errores de programación que se tienen que controlar programando
	    // Solo se está haciendo para ver la sintaxis de try catch
	    
	    try {
	        
	        division();
	        
	    } catch (ArithmeticException e) {
	        
	        System.out.println("No se permite la división por cero");
	    
	    } catch (NumberFormatException e) {
	        
	        System.out.println("No has introducido un número entero");
	        // System.out.println(e.getMessage());
	        System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
	        
	    }
		
	}
	
	static void division() {
		
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));
		
		System.out.println("El resultado es " + num1/num2);
		
	}

}
