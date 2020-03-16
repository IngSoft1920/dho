<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<header>
	<nav>
		<ul>
			<li><a href="/homePageDHO/menu">Inicio</a></li>
			<li><a href="/homePageDHO/menu/checkout1">Check-out</a></li>
			<li><a href="/homePageDHO/menu/reservas1">Reservas</a></li>
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
	
</section>	
</html>