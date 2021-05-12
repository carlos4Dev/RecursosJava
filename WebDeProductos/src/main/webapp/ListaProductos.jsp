<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.cabecera {

	font-size: 1.2em;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #08088A;

}

.filas {

	text-align: center;
	background-color: #5882FA;
	
}

.table {

	float: left;

}

#contenedorBoton {

	margin-left:1000px;

}

</style>
</head>


<body>

	<table>
	
	<tr>
	
		<td class="cabecera">Código Artículo</td>
		<td class="cabecera">Sección</td>
		<td class="cabecera">Nombre Artículo</td>
		<td class="cabecera">Fecha</td>
		<td class="cabecera">Precio</td>
		<td class="cabecera">Importado</td>
		<td class="cabecera">País de Origen</td>
		<td class="cabecera">Acción</td>
	
	</tr>
	
	<c:forEach var = "temProd "items="${LISTAPRODUCTOS }">
	
	<!-- Link para cada producto con su campo clave -->
	
	<c:url var="linkTemp" value="ControladorProductos" >
	
		<c:param name"instruccion" value="cargar"></c:param>
		<c:param name"cArticulo" value="${tempProd.cArt }"></c:param>
		
	</c:url>
	
	<!-- Link para eliminar cada producto con su campo clave -->
	
	<c:url var="linkTempEliminar" value="ControladorProductos" >
	
		<c:param name"instruccion" value="eliminar"></c:param>
		<c:param name"cArticulo" value="${tempProd.cArt }"></c:param>
		
	</c:url>
	
	<tr>
	
	<td class="filas">${tempProd.cArt }</td>
	<td class="filas">${tempProd.seccion}</td>
	<td class="filas">${tempProd.nArt }</td>
	<td class="filas">${tempProd.fecha }</td>
	<td class="filas">${tempProd.precio}</td>
	<td class="filas">${tempProd.importado }</td>
	<td class="filas">${tempProd.pOrig }</td>
	<td class="filas"><a href="${linkTemp }">Actualizar</a>&nbsp;&nbsp;<a href="${linkTempEliminar }">Eliminar</a></td>
	
	</tr>
	
	</c:forEach>
	
	</table>

	<div id="contenedorBoton">
	
		<input type="button" value="Insertar Registro" onclick="window.location.href='InsertaProducto.jsp'"/>
	
	</div>

</body>
</html>