package colecciones;

import java.util.*;

public class PruebaLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        LinkedList <String> personas = new LinkedList <String>();
        
        personas.add("Pepe");
        personas.add("Juan");
        personas.add("Luis");
        personas.add("Ana");

        System.out.println("La lista tiene " +  personas.size() + "elementos");
        
        ListIterator <String> it = personas.listIterator();
        
        it.next();
        
        it.add("Sam");
        
        for (String persona : personas) {
            
            System.out.println(persona);
            
        }
        
    }

}
