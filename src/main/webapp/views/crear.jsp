<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear producto</title>
<style type="text/css" href="index.css"></style>
</head>
<body>
	<h1>Crear producto</h1>
	<form action="Subscritor" method="post">
	<input type="hidden" name="opcion" value="guardar">
	<table border="1">
		<tr>
		<td>Nombre:</td>
		<td><input type="text" name="nombre" size="50"> </input></td>
		</tr>
		
		<tr>
		<td>Apellido Paterno:</td>
		<td><input type="text" name="apellidoPaterno" size="50"> </input></td>
		</tr>
		
		<tr>
		<td>Apellido Materno:</td>
		<td><input type="text" name="apellidoMaterno" size="50"> </input></td>
		</tr>
		
		<tr>
		<td>Servicio:</td>
		<td><input type="text" name="servicio" size="50"> </input></td>
		</tr>
		
		<tr>
		<td>Fecha de nacimiento:</td>
		<td><input class="fecha" type="date" id="start" name="fechaNacimiento"
       			value="2018-07-22"
       			min="2018-01-01" 
       			max="2018-12-31"></td>
		</tr>
		
		<tr>
		<td>Plan:</td>
		<td><input type="text" name="plan" size="50"> </input></td>
		</tr>
		
		<tr>
		<td>Estatus:</td>
		<td><input type="text" name="estatus" size="50"> </input></td>
		</tr>
		
	</table>
	<input type="submit" value ="guardar">
	</form>
</body>
</html>