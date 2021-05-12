<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1 style="text-align:center">Actualizar Producto</h1>
	
	<form name="form1" method="get" action="ControladorProductos">
	
	<!-- Esta instrucción es para controlar con un if  en ControladorProductos, si se debe insertar un producto o listar -->
	<input type="hidden" name="instruccion" value="actualizarBBDD">
	<input type="hidden" name="cArt" value="${ProductoActualizar.cArt }">
	
		<table  width="50%"  border="0 ">
			
			<!-- Al actualizar no se debe tocar el Código Artículo que es la clave Primaria -->
			<!--<tr>
			
				<td width="27%">Código Artículo</td>
				<td width="73%"><label for="cArt"></label>
				<input type="text" name="cArt" id="cArt"></td>
					
			</tr>-->
			
			<tr>
			
				<td>Sección</td>
				<td><label for="seccion"></label>
				<input type="text" name="seccion" id="seccion" value="${ProductoActualizar.seccion }"></td>
					
			</tr>
			
			<tr>
			
				<td>Artículo</td>
				<td><label for="nArt"></label>
				<input type="text" name="nArt" id="nArt" value="${ProductoActualizar.nArt }"></td>
					
			</tr>
			
			<tr>
			
				<td>Fecha</td>
				<td><label for="fecha"></label>
				<input type="text" name="fecha" id="fecha" value="${ProductoActualizar.fecha }"></td>
					
			</tr>
			
			<tr>
			
				<td>Precio</td>
				<td><label for="precio"></label>
				<input type="text" name="precio" id="precio" value="${ProductoActualizar.precio }"></td>
					
			</tr>
			
			<tr>
			
				<td>Importado</td>
				<td><label for="importado"></label>
				<input type="text" name="importado" id="importado" value="${ProductoActualizar.importado }"></td>
					
			</tr>
			
			<tr>
			
				<td>Pais de origen</td>
				<td><label for="pOrig"></label>
				<input type="text" name="pOrig" id="pOrig" value="${ProductoActualizar.pOrig}"></td>
					
			</tr>
			
			<tr>
			
				<td><input type="submit" name="envio" value="Enviar"></td>
				<td><input type="reset" name="borrar" value="Restablecer" ></td>
			</tr>
			
		</table>
		
	</form>

</body>
</html>