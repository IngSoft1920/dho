<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<head>
	Check-IN
	</head>

	<body style="background-color:lightblue;">
	
	<ul>
		<c:forEach items="${lista}" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
	
	<form method="POST">
		<label>estancia_id</label>
		<input type="text" name="estancia_id" autocomlete="off" />
		<br><br>
<<<<<<< HEAD
=======
		<label>habitacion_id</label>
		<input type="text" name="habitacion_id" autocomlete="off" />
		<br><br>
		<label>cliente_id</label>
		<input type="text" name="cliente_id" autocomlete="off" />
		<br><br>
		<label>hotel_id</label>
		<input type="text" name="hotel_id" autocomlete="off" />
		<br><br>
		<label>fecha_inicio</label>
		<input type="text" name="fecha_inicio" autocomlete="off" />
		<br><br>
		<label>fecha_fin</label>
		<input type="text" name="fecha_fin" autocomlete="off" />
		<br><br>
		<label>estado</label>
		<input type="text" name="estado" autocomlete="off" />
		<br><br>
		<br>
>>>>>>> develop
		<input type="submit" value="Registro">
	</form>
	
	</body>
	
	
			
	
	
	
	
	
	
	
	
	
</html>