<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agencia de viajes</title>
</head>
<body>

<h1 style = "text-align:center">Agencia de viajes</h1>

<%

	// Valor por defecto
	String ciudadFavorita = "Madrid";

	// Lee la cookie de la petición del navegador
	
	Cookie [] lasCookies = request.getCookies();
	
	// Buscar las preferencias, en este caso la ciudad favorita
	
	if(lasCookies != null) {
	    
	    for (Cookie cookieTemporal : lasCookies) {
	        
	        if ("agencia_viajes.ciudad_favorita".equals(cookieTemporal.getName())) {
	            
	            ciudadFavorita = cookieTemporal.getValue();
	            
	            break;
	            
	        }
	        
	    }
	    
	}

%>

<h3>Vuelos a <%= ciudadFavorita %></h3>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<br>

<h3>Hoteles en <%= ciudadFavorita %></h3>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<br>

<h3>Descuentos en restaurantes de <%= ciudadFavorita %></h3>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>




</body>
</html>