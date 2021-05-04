package colecciones;

import java.util.*;

public class PruebaMapas {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        HashMap <String, Empleado> personal = new HashMap <String, Empleado>();
        
        personal.put("145", new Empleado("Pepe"));
        personal.put("167", new Empleado("Juan"));
        personal.put("189", new Empleado("Ana"));
        personal.put("199", new Empleado("Sam"));
        
        System.out.println(personal);
        
        personal.remove("167");
        
        System.out.println(personal);
        
        // Si se repite una clave reemplaza el valor
        personal.put("199", new Empleado("Tomy"));
        
        System.out.println(personal);
        
        // System.out.println(personal.entrySet());
        
        for (Map.Entry<String, Empleado> entrada: personal.entrySet()) {
            
            String clave = entrada.getKey();
            
            Empleado valor = entrada.getValue();
            
            System.out.println("Clave = " + clave + ", Valor = " + valor);
            
        }

    }

}

class Empleado {
     private String nombre;
     private double sueldo;
     
    public Empleado (String n) {
        
        nombre = n;
        sueldo = 2000;
        
    }
    
    public String toString() {
        
        return "[Nombre = " + nombre + ", sueldo = " + sueldo + "]";
        
    }
    
}
