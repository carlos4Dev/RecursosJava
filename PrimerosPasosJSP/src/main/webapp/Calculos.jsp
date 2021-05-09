<%@ page import="cursojava.com.CalculosMatematicos.*" %>
<!--  Para importar más paquetes, en la primera línea, despúes del primer paquete, se pone una coma y la ruta del siguiente paquete -->
<html>

<body>
<!-- Se puede minimizar código en la ruta, simplemente como ejemplo -->

La suma de 5 y 7 es: <%= cursojava.com.CalculosMatematicos.Calculos.metodoSuma(5, 7) %>
<!-- Para hacer la llamada, primero el paquete. segundo la Clase. tercero método -->
<br><br>

La resta de 12 y 3 es: <%= cursojava.com.CalculosMatematicos.Calculos.metodoResta(12, 3) %>
<br><br>

La multiplicación de 28 y 7 es: <%= cursojava.com.CalculosMatematicos.Calculos.metodoResta(28, 7) %>
<br><br>

<!-- Para acortar la ruta, se puede importar al principio del archivo  y luego solo llamar a la Clase y método-->
La división de 235 y 5 es: <%= Calculos.metodoDivision(235, 5) %>

</body>

</html>