<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

 

	<body style="background-color:#606468;">
	
	<h1> Incidencias </h1>
	
	
	<h2> SIN ASIGNAR </h2>
	<ul>
		<c:forEach items="${incidenciasSinAsignar}" var="item2">
			<li>${item2}</li>
		</c:forEach>
	</ul>
	
	<h3> ASIGNADAS </h3>
	<ul>
		<c:forEach items="${incidenciasAsignadas}" var="item2">
			<li>${item2}</li>
		</c:forEach>
	</ul>
	
	
	<ul>
		<c:forEach items="${empleados}" var="item2">
			<li>${item2}</li>
		</c:forEach>
	</ul>
	
	
	
	</body>
	
	<form method="POST">
		<label>id_incidencia</label>
		<input type="text" name="id_incidencia" autocomlete="off" />
		<br><br>
		<label>id_empleado</label>
		<input type="text" name="id_empleado" autocomlete="off" />
		<br><br>
		<input type="submit" value="Registro">
	</form>
	
	
</html>