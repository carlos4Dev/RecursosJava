package arrayList;


// Ejemplo sin utilizar programaci�n gen�rica para darse cuenta de las ventajas
// de la programaci�n gen�rica
// Ejemplo r�pido se podr�a mejorar el c�digo. El fin es ver claramente las ventajas

public class ArrayList2 {

	private Object[] datosElemento;
	private int i = 0;
	
	// M�todo constructor que recibe el n�mero de elementos que contendr� el array
	
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