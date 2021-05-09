<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Se debería encriptar la contraseña, mejorar la seguridad -->

<%@ page import="java.sql.*" %>

<%

	String usuario = request.getParameter("usuario");
	String contra = request.getParameter("contra");
	
	// Hay que hacer que cargue dinámicamente el driver en tiempo de ejecución con la siguiente instrucción
	
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	// Me genera el siguiente error:
	// Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
	
	
	try {
	
	Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp","root","");
	
	// Usamos consultas preparadas para evitar ataques de inyección de código
	
	PreparedStatement consultaPreparada = miConexion.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO = ? AND CONTRASENA = ?");
	
	consultaPreparada.setString(1, usuario);
	consultaPreparada.setString(2, contra);
	
	ResultSet miResultSet = consultaPreparada.executeQuery();
	
	/*En el video 236 la instrucción que pone es:
	 if (miResultSet.absolute(1)) outprintln("Usuario autorizado");
		
		Este código salta una exception y esta es la explicación que he encontrado:
		En Java por defecto los ResultSet obtenidos en las consultas son de tipo 
		ResultSet.TYPE_FORWARD_ONLY, esto quiere decir que el ResultSet solo puede 
		"avanzar" de registro en registro, no puede arbitrariamente moverse a un registro puntual 
		
		Esto es lo que genera la excepción. Ahora, de acuerdo a tu código realmente no tienes necesidad
		de moverte a un registro puntual simplemente procesar los resultados. Al efectuar una consulta 
		el cursor del ResultSet se ubica justo antes del primero registro, lo primero que se debe hacer 
		es validar si realmente la consulta retornó resultados, esto se logra con la instrucción: .next()
		
		https://es.stackoverflow.com/questions/375554/java-sql-sqlexception-operation-not-allowed-for-a-result-set-of-type-resultset
	*/
	if (miResultSet.next()) out.println("Usuario autorizado");
	
	else out.println("No  hay usuarios con esos datos");
	
	} catch (Exception e) {
	    
	    out.println("Ha habido un error");
	    e.printStackTrace();
	}
	
%>

</body>
</html>