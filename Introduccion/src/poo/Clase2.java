package poo;

import paquetepruebas.Clase3;

public class Clase2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Clase1 miobj = new Clase1();
        
        Clase3 miobj2 = new Clase3();
        
        System.out.println("La primera variable es de tipo " + miobj.getClass());
        System.out.println("Las variables son iguales: " + miobj2.equals(miobj));
        
    }

}
