<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie ciudad favorita</title>
</head>
<body>

<%

	// Leyendo datos del formulario
	String ciudadFavorita = request.getParameter("ciudad_favorita"); // el parámetro es el campo del formulario
	
	// Crear la cookie:
	// clase Cookie nombreVariable = 
	// new Cookie (primer parámetro nombre significativo, segundo parámetro valor dato recogido en
	// request.getParameter("nombre del campo del formulario(en este caso ciudadFavorita)"),)
	
	Cookie laCookie = new Cookie("agencia_viajes.ciudad_favorita",  ciudadFavorita);
	
	// Vida de la cookie
	
	laCookie.setMaxAge(365*24*60*60); // un año cálculo del parámetro, tiene que ser segundos
	
	// Enviar al Usuario
	
	response.addCookie(laCookie);
	


%>

Gracias por enviar tus preferencias

<a href="AgenciaViajes.jsp">Ir a la agencia de viajes</a>

</body>
</html>