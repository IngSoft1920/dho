<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<head>
	Check-IN
	</head>

	<body style="background-color:lightblue;">
	
	<ul>
		<c:forEach items="${listaSinHacerCheckIn}" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
	
	<ul>
		<c:forEach items="${listaConCheckIn}" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
	<br></br>
	<h3>Hacer check-in de </h3>
	<form method="POST">
		<label>estancia_id</label>
		<input type="text" name="estancia_id" autocomlete="off" />
		<br><br>

		<input type="submit" value="Registro">
	</form>
	<br></br>
	<h3>Para la estancia</h3>
	<form method="POST">
		<label>estancia_id</label>
		<input type="text" name="estancia_id" autocomlete="off" />
	
	</form>
	<br></br>
	<h3> Cambiar el nombre </h3>
	<form method="POST">
		<label>nombre</label>
		<input type="text" name="nombre" autocomlete="off" />
		<br><br>

		<input type="submit" value="Registro">
	</form>
	<br></br>.
	<h3> Cambiar la fecha de fin </h3>
	<form method="POST">
		<label>fecha de salida</label>
		<input type="text" name="fecha_fin" autocomlete="off" />
		<br><br>

		<input type="submit" value="Registro">
	</form>
	
	
	</body>
	
	<
			
	
</html>