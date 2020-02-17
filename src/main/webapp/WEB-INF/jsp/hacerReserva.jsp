<%@ page language="java" contentType="text/html; charset=utf-8" pageencoding="utf-8"%>

<html>

	<body>
		<style>
			a { text-decoration: none; }
		</style>
	</body>
	
	<h1>Hacer una reserva</h1>
	
	<form method="POST">
		Nombre del hotel: <input type="text" name="nombre" autocomplete="off">
		<br><br>
		
		<input type="submit" onclick="alert(Enviado')">
	</form>
	
	<button onclick="window.location.href='/homePageDHO'">Regresar</button>
	
</html>