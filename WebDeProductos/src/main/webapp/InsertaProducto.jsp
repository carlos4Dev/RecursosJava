<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1 style="text-align:center">Insertar Registros</h1>
	
	<form name="form1" method="get" action="ControladorProductos">
	
	<!-- Esta instrucci�n es para controlar con un if  en ControladorProductos, si se debe insertar un producto o listar -->
	<input type="hidden" name="instruccion" value="insertarBBDD">
	
		<table  width="50%"  border="0 ">
		
			<tr>
			
				<td width="27%">C�digo Art�culo</td>
				<td width="73%"><label for="cArt"></label>
				<input type="text" name="cArt" id="cArt"></td>
					
			</tr>
			
			<tr>
			
				<td>Secci�n</td>
				<td><label for="seccion"></label>
				<input type="text" name="seccion" id="seccion"></td>
					
			</tr>
			
			<tr>
			
				<td>Art�culo</td>
				<td><label for="nArt"></label>
				<input type="text" name="nArt" id="nArt"></td>
					
			</tr>
			
			<tr>
			
				<td>Fecha</td>
				<td><label for="fecha"></label>
				<input type="text" name="fecha" id="fecha"></td>
					
			</tr>
			
			<tr>
			
				<td>Precio</td>
				<td><label for="precio"></label>
				<input type="text" name="precio" id="precio"></td>
					
			</tr>
			
			<tr>
			
				<td>Importado</td>
				<td><label for="importado"></label>
				<input type="text" name="importado" id="importado"></td>
					
			</tr>
			
			<tr>
			
				<td>Pais de origen</td>
				<td><label for="pOrig"></label>
				<input type="text" name="pOrig" id="pOrig"></td>
					
			</tr>
			
			<tr>
			
				<td><input type="submit" name="envio" value="Enviar"></td>
				<td><input type="reset" name="borrar" value="Restablecer"></td>
			</tr>
			
		</table>
		
	</form>

</body>
</html>