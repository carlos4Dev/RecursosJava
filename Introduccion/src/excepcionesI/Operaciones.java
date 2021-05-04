package excepcionesI;

public class Operaciones {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Suma operacion1 = new Suma();
        Resta operacion2 = new Resta();
        Multiplica operacion3 = new Multiplica();
        Divide operacion4 = new Divide();
        
        System.out.println(operacion1.calculo(7,8));
        System.out.println(operacion2.calculo(7,8));
        System.out.println(operacion3.calculo(7,8));
        System.out.println(operacion4.calculo(7,8));

    }

}
