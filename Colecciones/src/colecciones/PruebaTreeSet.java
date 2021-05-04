package colecciones;

import java.util.*;

public class PruebaTreeSet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        /*
        TreeSet <String> ordenaPersonas = new TreeSet <>();
        
        ordenaPersonas.add("Juan");
        ordenaPersonas.add("Pepe");
        ordenaPersonas.add("Ana");
        
        for(String s : ordenaPersonas) {
            
            System.out.println(s);
        }
        */
        
        Articulo primero = new Articulo(1, "Primer articulo");
        Articulo segundo = new Articulo(200, "Segundo articulo");
        Articulo tercero = new Articulo(3, "Este es el tercer articulo");
        
        TreeSet <Articulo> ordenaArticulos = new TreeSet <Articulo>();
        
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);
        
        for (Articulo art : ordenaArticulos) {
            
            System.out.println(art.getDescripcion());
        }
        
        /* Video 187
        Articulo comparadorArticulos = new Articulo();        
        TreeSet <Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);
        */
        
        /* Video 188 se omite para usar clase interna anónima
        ComparadorArticulos comparaArt = new ComparadorArticulos();        
        TreeSet <Articulo> ordenaArticulos2 = new TreeSet <Articulo>(comparaArt);
        */
        TreeSet <Articulo> ordenaArticulos2 = new TreeSet <Articulo>(new Comparator <Articulo> () {
            
                public int compare(Articulo o1, Articulo o2) {
                // TODO Auto-generated method stub
                String desc1 = o1.getDescripcion();
                String desc2 = o2.getDescripcion();
                
                return desc1.compareTo(desc2);
                
            }
            
        });
        
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(tercero);
        
        for (Articulo art: ordenaArticulos2) {
            
            System.out.println(art.getDescripcion());
        }
        
    }
    
}

// Utilizando Comparator viddeo 187
// class Articulo implements Comparable <Articulo>,  Comparator<Articulo> {
class Articulo implements Comparable <Articulo> {
    private int numeroArticulo;
    private String descripcion;
    
    /* Este constructor sin parámetros es necesario para utilizar Comparator, video 187
    public Articulo() {
        
    } */
    
    public Articulo (int num, String desc) {
        
        numeroArticulo = num;
        descripcion = desc;
     
    }
    @Override
    public int compareTo(Articulo o) {
        // TODO Auto-generated method stub
        
        return numeroArticulo - o.numeroArticulo;
        
    }
    
    public String getDescripcion() {
        
        return descripcion;
        
    }
    /* Esta es la forma de comparar en el video 187
    @Override
    public int compare(Articulo o1, Articulo o2) {
        // TODO Auto-generated method stub
        String descripcionA = o1.getDescripcion();
        
        String descripcionB = o2.getDescripcion();
        
        return descripcionA.compareTo(descripcionB);
    }
    */
}

/* Vide 188 al usar clase interna anónima se omite esta clase
class ComparadorArticulos implements Comparator <Articulo> {

    @Override
    public int compare(Articulo o1, Articulo o2) {
        // TODO Auto-generated method stub
        String desc1 = o1.getDescripcion();
        String desc2 = o2.getDescripcion();
        
        return desc1.compareTo(desc2);
    }
    
} */