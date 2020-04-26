<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<header>
	<nav>
		<ul>
			<li><a href="/homePageDHO/menu">Inicio</a></li>
			<li><a href="/homePageDHO/menu/disponibilidad">Disponibilidad</a></li>
			<li><a href="/homePageDHO/menu/reservas1">Reservas</a></li>
			<li><a href="/homePageDHO/menu/asignarTareas">Asignar Tareas</a></li>
			<li><a href="/homePageDHO/menu/calendario">Vista de calendario</a></li>>

		</ul>
	</nav>
</header>
<style>
/*Eliminamos los margenes y paddings que agrega el navegador por defecto*/
* {
  padding: 0;
  margin: 0;
}
 
/*Agregamos margenes inferiores a los parrafos*/
p {
  margin-bottom: 20px;
}

header {
  background: rgba(0,0,0,0.9);
  width: 100%;
  position: fixed;
  z-index: 100;
}

nav {
  float: left; /* Desplazamos el nav hacia la izquierda */
}
 
nav ul {
  list-style: none;
  overflow: hidden; /* Limpiamos errores de float */
}
 
nav ul li {
  float: left;
  font-family: Arial, sans-serif;
  font-size: 16px;
}
 
nav ul li a {
  display: block; /* Convertimos los elementos a en elementos bloque para manipular el padding */
  padding: 20px;
  color: #fff;
  text-decoration: none;
}
 
nav ul li:hover {
  background: #3ead47;
}

.contenido {
  padding-top: 80px;
}

.wrapper {
  width: 80%;
  margin: auto;
  overflow:hidden;
}
</style>

<section class="contenido wrapper">
	<head>
	</head>

	<body style="background-color:lightblue;">
				    
	
		<style>
			a { text-decoration: none; }
		</style>
	</body>
	
	
			
			${estancia_id}
			${cliente_id}	
			${FechaInicio}	
			${FechaFin}	
			${habitacion_id}
			${hotel_id}
			${importe}	
	
	
	
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