package clasesPropias;

public class MetodosGenericos {
	
	public static void main(String[] args) {
		
		String nombres[] = {"Pepe", "Ana", "Juan"};
		
		// No es necesario este paso, pero para verlo más claro
		String elementos = MisMatrices.getElementos(nombres);
		
		System.out.println("Este array es "+ nombres.getClass() + " " + elementos);
		
		Empleado listaEmpleados[] = {
				new Empleado("Ana",45,2500),
				new Empleado("Ana",45,2500),
				new Empleado("Ana",45,2500),
				new Empleado("Ana",45,2500),
				new Empleado("Ana",45,2500),
		};
		
		System.out.println("Este array es "+ listaEmpleados.getClass() + " " + MisMatrices.getElementos(listaEmpleados));
		
	}

}

// No es necesario, pero ejemplo para entender uso métodos genéricos

class MisMatrices {
	
	public static <T> String getElementos(T[] a) {
		
		return "El array tiene " + a.length + " elementos";
		
	}
	
}
