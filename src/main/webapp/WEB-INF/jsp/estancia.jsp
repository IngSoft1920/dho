<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<header>
	<nav>
		<ul>
			<li><a href="/homePageDHO/menu">Inicio</a></li>
			<li><a href="/homePageDHO/menu/checkout1">Check-out</a></li>
			<li><a href="/homePageDHO/menu/asignarTareas">Asignar Tareas</a></li>
			<li><a href="/homePageDHO/menu/calendario">Vista de calendario</a></li>

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
	<h1>Reservar una habitación</h1>
	
	</body>
		
	<form method="POST"> 
		<label>cliente_id</label> 
		<input type="text" name="cliente_id" autocomlete="off" /> 
		<br><br> 
		<label>estancia_id</label> 
		<input type="text" name="estancia_id" autocomlete="off" /> 
		<br><br> 
		<label>habitacion_id</label> 
		<input type="text" name="habitacion_id" autocomlete="off" /> 
		<br><br> 
		<label>hotel_id</label> 
		<input type="text" name="hotel_id" autocomplete="off" /> 
		<br><br> 
		<label>fecha_inicio</label> 
		<input type="text" name="fecha_inicio" autocomplete="off" /> 
		<br><br> 
		<label>fecha_fin</label> 
		<input type="text" name="fecha_fin" autocomplete="off" /> 
		<br><br> 
		<label>estado</label> 
		<input type="text" name="estado" autocomplete="off" /> 
		<br><br> 
		<label>importe</label> 
		<input type="text" name="importe" autocomplete="off" /> 
		<br><br> 
		<label>tipo_hab_id</label> 
		<input type="text" name="tipo_hab_id" autocomplete="off" /> 
		<br><br> 
		 
		<input type="submit" value="Registro"> 
	</form> 	
	
					
</section>	
</html>