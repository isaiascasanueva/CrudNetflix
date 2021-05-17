<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="PlanController" method="post">
	<input type="hidden" name="opcion" value="guardar">
	<table border="1">
	
		
			<tr>
		<td>idPlan</td>
		<td><input type="number" name="idPlan" size="50"> </input></td>
		</tr>
		
	
	
		<tr>
		<td>Nombre Plan</td>
		<td><input type="text" name="nombrePlan" size="50"> </input></td>
		</tr>
		
		<tr>
		<td>Costo</td>
		<td><input type="text" name="costo" size="50"> </input></td>
		</tr>

		
	</table>
	<input type="submit" value ="guardar">
	</form>


</body>
</html>