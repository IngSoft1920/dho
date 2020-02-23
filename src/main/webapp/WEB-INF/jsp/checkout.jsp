<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<head>
	Check-OUT
	</head>

	<body style="background-color:lightblue;">
		<style>
			a { text-decoration: none; }
		</style>
	</body>
	
	<ul>
		<c:forEach items="${lista}" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
	
	<form method="POST">
		<label>estancia_id</label>
		<input type="text" name="estancia_id" autocomlete="off" />
		<br><br>
		<label>habitacion_id</label>
		<input type="text" name="habitacion_id" autocomlete="off" />
		<br><br>
		<label>cliente_id</label>
		<input type="text" name="cliente_id" autocomlete="off" />
		<br><br>
		<label>hotel_id</label>
		<input type="text" name="hotel_id" autocomlete="off" />
		<br><br>
		<label>fecha_iniciod</label>
		<input type="text" name="fecha_inicio" autocomlete="off" />
		<br><br>
		<label>fecha_fin</label>
		<input type="text" name="fecha_fin" autocomlete="off" />
		<br><br>
		<label>estado</label>
		<input type="text" name="estado" autocomlete="off" />
		<br><br>
		<br>
		<input type="submit" value="Registro">
		<br>
	</form>
	
	
	
	
	
</html>
