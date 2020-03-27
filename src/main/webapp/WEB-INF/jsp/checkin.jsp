<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<head>
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
		<label>NºHabitaci&oacute;n</label>
		<input type="text" name="habitacion_id" autocomlete="off" />
		<br><br>

		<input type="submit" value="Registro">
		<br><br>
		<input type="button" onclick="history.back()" name="volver atrás" value="Volver atrás">
	</form>

	
	</body>
	
	
			
	
</html>