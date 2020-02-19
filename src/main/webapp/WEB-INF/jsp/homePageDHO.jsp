<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>

	<body style="background-color:lightblue;">
		<style>
			a { text-decoration: none; }
		</style>
	</body>
	
	<h1>Bienvenido al servicio dho</h1>
	
	
	<form method="POST">
		usuario: <input type="text" name="usuario" autocomplete="off">
		<br><br>
		id_empleado: <input type="text" name="id_empleado" autocomplete="off">
	</form>
	
	<button onclick="window.location.href='/homePageDHO/menu'">Acceder</button>
	
</html>