package arrayList;


// Ejemplo sin utilizar programación genérica para darse cuenta de las ventajas
// de la programación genérica
// Ejemplo rápido se podría mejorar el código. El fin es ver claramente las ventajas

public class ArrayList2 {

	private Object[] datosElemento;
	private int i = 0;
	
	// Método constructor que recibe el número de elementos que contendrá el array
	
	public ArrayList2 (int z) {
		
		datosElemento = new Object[z];
		
	}
	
	public Object get(int i) {
		
		return datosElemento[i];
		
	}
	
	public void add(Object o) {
		
		datosElemento[i] = 0;
		
		i++;
		
	}
	

}