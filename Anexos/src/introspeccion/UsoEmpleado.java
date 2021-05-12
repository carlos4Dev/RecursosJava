package introspeccion;

public class UsoEmpleado {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Persona Antonio = new Persona("Antonio");
        
        System.out.println(Antonio.getNombre());
        
        Empleado Ana = new Empleado("Ana", 35000);
        
        System.out.println(Ana.getNombre());
        
        System.out.println(Ana.getSalario());
        
        /* System.out.println(Antonio.getClass());
        Class cl1 = Antonio.getClass();
        System.out.println(cl1.getName());
        */
        
        String nombreClase = "introspeccion.Persona";
         
        Class cl1;
        try {
            cl1 = Class.forName(nombreClase);
            
            System.out.println(cl1.getName());
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        nombreClase = "introspeccion.Empleado";
        
        try {
            cl1 = Class.forName(nombreClase);
            
            System.out.println(cl1.getName());
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}

class Persona {
    
    private String nombre;
    
    public Persona(String nombre) {
        
        this.nombre = nombre;
        
    }
    
    public String getNombre() {
        
        return nombre;
    }
    
}

class Empleado extends Persona {
    
    private double salario;
     
    public Empleado(String nombre, double salario) {
        super(nombre);
        // TODO Auto-generated constructor stub
        
        this.salario = salario;
    }
    
    public void setIncentivo (double incentivo) {
        
        salario = salario + incentivo;
    }
    
    public String getSalario() {
        
        return "El salario es " + salario;
    }
    
}
