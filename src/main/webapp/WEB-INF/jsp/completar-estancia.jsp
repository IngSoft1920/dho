<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<header>
	<nav>
		<ul>	
			<li><a href="/homePageDHO/menu">Inicio</a></li>
			<li><a href="/homePageDHO/menu/disponibilidad">Disponibilidad</a></li>
			<li><a href="/homePageDHO/menu/reservas1">Servicios</a></li>
			<li><a href="/homePageDHO/menu/asignarTareas">Asignar Tareas</a></li>
			<li><a href="/homePageDHO/menu/pedidos">Pedidos</a></li>
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
  background: #4982D1;
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
	<h1>Registro de un cliente</h1>
	<br><br>
	
	</body>
		
	<form method="POST"> 
		<label>Fecha Entrada (YY-MM-DD)</label> 
		<input type="text" name="Fecha_entrada" autocomlete="off" /> 
		<br><br> 
		<label>Fecha Salida (YY-MM-DD)</label> 
		<input type="text" name="Fecha_salida" autocomlete="off" /> 
		<br><br> 
		<label>Nº Personas</label> 
		<input type="text" name="Num_personas" autocomlete="off" /> 
		<br><br> 
		<label>Tipo de habitaci&oacuten (normal, premium)</label> 
		<input type="text" name="Tipo_hab_String" autocomplete="off" /> 
		<br><br>  
		<label>R&eacutegimen(media,completa)</label> 
		<input type="text" name="regimen" autocomplete="off" /> 
		<br><br>  
		<label>Nombre del Hotel</label> 
		<input type="text" name="Nombre_Hotel" autocomplete="off" /> 
		<br><br>  
		<label>N&uacutemero de Habitaci&oacuten</label> 
		<input type="text" name="Num_Habitacion" autocomplete="off" /> 
		<br><br> 
		<input type="submit" value="Registro"> 
	</form> 	
	
</section>	
</html>