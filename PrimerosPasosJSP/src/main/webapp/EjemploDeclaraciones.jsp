<html>

<body>

<h1 style="text-align: center">
Ejemplo declaraciones
</h1>

<%!

	private int resultado;

	public int metodoSuma(int num1, int num2) {
	    
	    resultado = num1 + num2;
	    
	    return resultado;
	}
	
	public int metodoResta(int num1, int num2) {
	    
	    resultado = num1 - num2;
	    
	    return resultado;
	}
	
	public int metodoMultiplicacion(int num1, int num2) {
	    
	    resultado = num1 * num2;
	    
	    return resultado;
	}
	
	public int metodoDivision(int num1, int num2) {
	    
	    resultado = num1 / num2;
	    
	    return resultado;
	}
	
%>
C�mo buenas pr�cticas de programaci�n:<br>
Incluir en los archivos jsp el menor c�digo posible<br><br>

Esto es s�lo un ejemplo, lo normal es que la declaraci�n de los m�todos estuviese en un archivo java<br>
Las llamadas a los m�todos, estar�an en el archivo jsp<br><br>

Cuando hay mucho c�digo, conviene utilizar MVC (M�delo Vista Controlador)<br><br>

El resultado de la suma es: <%= metodoSuma(7, 5) %>
<br>

El resultado de la resta es: <%= metodoResta(7, 5) %>
<br>

El resultado de la  multiplaci�n : <%= metodoMultiplicacion(7, 5) %>
<br>

El resultado de la divisi�n de 244 entre 4 es: <%= metodoDivision(244, 4) %>
<br>
</body>

</html>