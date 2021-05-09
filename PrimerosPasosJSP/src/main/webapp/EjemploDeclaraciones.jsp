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
Cómo buenas prácticas de programación:<br>
Incluir en los archivos jsp el menor código posible<br><br>

Esto es sólo un ejemplo, lo normal es que la declaración de los métodos estuviese en un archivo java<br>
Las llamadas a los métodos, estarían en el archivo jsp<br><br>

Cuando hay mucho código, conviene utilizar MVC (Módelo Vista Controlador)<br><br>

El resultado de la suma es: <%= metodoSuma(7, 5) %>
<br>

El resultado de la resta es: <%= metodoResta(7, 5) %>
<br>

El resultado de la  multiplación : <%= metodoMultiplicacion(7, 5) %>
<br>

El resultado de la división de 244 entre 4 es: <%= metodoDivision(244, 4) %>
<br>
</body>

</html>