package cursojava.com.CalculosMatematicos;

public class Calculos {

    // Declaramos static variables y m�todos para que sea m�s f�cil llamarlos desde un archivo jsp
    
    private static int resultado;

    public static int metodoSuma(int num1, int num2) {
        
        resultado = num1 + num2;
        
        return resultado;
    }
    
    public static int metodoResta(int num1, int num2) {
        
        resultado = num1 - num2;
        
        return resultado;
    }
    
    public static int metodoMultiplicacion(int num1, int num2) {
        
        resultado = num1 * num2;
        
        return resultado;
    }
    
    public static int metodoDivision(int num1, int num2) {
        
        resultado = num1 / num2;
        
        return resultado;
    }
    
}
