<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Me da el siguiente error
java.lang.NoClassDefFoundError: javax/servlet/jsp/tagext/TagLibraryValidator

El servidor encontró un error interno que hizo que no pudiera rellenar este requerimiento

Parece que es un por problema de compatibilidad de versiones de los archivos jar descargados
 -->

<%

	String alumnos [] = {"Antonio", "Sandra", "Maria", "Paco"};

	pageContext.setAttribute("losAlumnos", alumnos);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="tempAlumnos" items= "${losAlumnos }">
	
		$ {tempAlumnos} <br>
	
	</c:forEach>

</body>
</html>