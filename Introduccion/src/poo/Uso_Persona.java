package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Persona[] lasPersonas = new Persona[2];
        
        lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 02, 25);
        lasPersonas[1] = new Alumno("Curro Jimenez", "Bandolero");
        
        for (Persona p: lasPersonas) {
            
            System.out.println(p.dameNombre() + ", " + p.dameDescripcion());
            
        }
        
    }

}

abstract class Persona {

    private String nombre;

    public Persona(String nom) {

        nombre = nom;

    }

    public String dameNombre() {

        return nombre;

    }

    public abstract String dameDescripcion();

}

class Empleado2 extends Persona {

    public Empleado2(String nom, double sue, int anio, int mes, int dia) {

        super(nom);
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
        // en mes indicamos -1, porque Enero = 0 en java.util.Date
        altaContrato = calendario.getTime();
        ++idSiguiente;
        id = idSiguiente;
    }

    public String dameDescripcion() {

        return "este empleado tiene un Id número " + id + ", con un sueldo de " + sueldo + " €.";

    }

    // poniendo final después de public no se podrá llamar igual a
    // otro método de una clase heredada

    public double dameSueldo() { // getter

        return sueldo;
    }

    public Date dameFechaContrato() { // getter

        return altaContrato;
    }

    public void subeSueldo(double porcentaje) { // setter

        double aumento = sueldo * porcentaje / 100;

        sueldo += aumento;
    }

    /*
     * Se puede hacer, pero mejor declarar variables de clase antes que el
     * constructor, mejor siempre al principio de la clase
     */

    private double sueldo;
    private Date altaContrato;
    private static int idSiguiente;
    private int id;
}

class Alumno extends Persona {
    
        private String carrera;
        
    public Alumno(String nom, String car) {
        
        super(nom);
        carrera = car;
        
    }
    
    public String dameDescripcion() {
        
        return "este  alumno está estudiando la carrera de " + carrera + ".";
        
    }
    
    
}