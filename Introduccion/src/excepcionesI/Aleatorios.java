package excepcionesI;

import javax.swing.JOptionPane;

public class Aleatorios {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz"));
        int numAleatorio[] = new int[elementos];
        
        for(int i = 0; i < numAleatorio.length; i++) {
            
            // Tiene un error a propósito para probar el debugging
            // Al hacer el casting se queda con la parte entera 0,7512....
            // Y multiplica 0 * 100
            // numAleatorio[i] = (int)Math.random()*100;
            
            // Se debe multiplicar por 100 y luego hacer el casting
            // 0.7512... * 100 = 75.12.... Al hacer el casting (int) se queda con 75
            
            numAleatorio[i] = (int)(Math.random()*100);
            
        }
        
        for (int elem: numAleatorio) {
            
            System.out.println(elem);
        }
        
    }

}
