package excepcionesI;

import java.util.*;

import javax.swing.JOptionPane;

public class AreasYPeso {
    
    static int figura;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Circulo");
        
        try {
            
            figura = entrada.nextInt();
            // entrada.close(); // Si se cierra aquí en el try, no se ejecuta la segunda parte, la del peso ideal
            
        } catch(Exception e) {
            
            System.out.println("Ha ocurrido un error");
            
        } finally {
            // finally se va a ejecutar siempre
            entrada.close(); // Nos aseguramos de que se cierra el recurso entrada 
            // Se seguirá ejecutando el programa, la segunda parte del peso ideal
        }
        
        switch (figura) {
        
        case 1:
            
            int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
            System.out.println(Math.pow(lado, 2));
            break;
        
        case 2:
            
            int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
            int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura")); 
            System.out.println("El área del rectángulo es " + base * altura);
            break;
        
        case 3:
            
            base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
            altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
            System.out.println("El área del triángulo es " + (base * altura) / 2);
            break;
            
        case 4:
            
            int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
            System.out.println("El área del circulo es " + (Math.PI*(Math.pow(radio, 2))));
            break;
            
        default:
            System.out.println("La opción no es correcta");
        }
        
        // Calculamos el peso ideal ----------------------------------------------------------------
        
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
        System.out.println("Si eres un hombre tu peso ideal es: " + (altura - 110) + " kg");
        System.out.println("Si eres una mujer tu peso ideal es: " + (altura - 120) + " kg");
        
    }

}
