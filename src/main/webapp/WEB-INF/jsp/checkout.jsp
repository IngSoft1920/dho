<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<body style="background-color:lightblue;">
		<style>
			a { text-decoration: none; }
		</style>
	</body>
	
	<h1>CHECK-OUT</h1>
	
	
	<form method="POST">
		usuario: <input type="text" name="usuario" autocomplete="off">
		<br><br>
		id_empleado: <input type="text" name="id_empleado" autocomplete="off">
	</form>
	
	<button onclick="window.location.href='/homePageDHO/hacerReserva'">Acceder</button>
	
	
	
	
	
	
</html>
