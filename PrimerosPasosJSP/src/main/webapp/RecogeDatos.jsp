<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*" %>

<%

	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String usuario = request.getParameter("usuario");
	String contra = request.getParameter("contra");
	String pais = request.getParameter("pais");
	String tecno = request.getParameter("tecnologias");
	
	// Hay que hacer que cargue dinámicamente el driver en tiempo de ejecución con la siguiente instrucción
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
	
	Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp","root","");
	
	Statement miStatement = miConexion.createStatement();
	
	String instruccionSql = "INSERT INTO USUARIOS (Nombre, Apellido, Usuario, Contrasena, Pais, Tecnologia) VALUES('" + nombre + "','" + apellido +"','"+ usuario + " ','" + contra + "','" + pais + "', '"+ tecno + "')";
	
	miStatement.executeUpdate(instruccionSql);
	
	out.println("Registrado con éxito");
	
	} catch (Exception e) {
	    
	    out.println("Ha habido un error");
	}
	
%>

</body>
</html>