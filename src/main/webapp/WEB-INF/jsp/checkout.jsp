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
		<style>
			a { text-decoration: none; }
			
			#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 30%;
  float: left;
}

			#servicios {
			font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 30%;
  float: right;
			}

table td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

table tr:nth-child(even){background-color: #f2f2f2;}

table td:nth-child(1){font-weight: bold;}

table tr:hover {background-color: #ddd;}

table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: middle;
  background-color:#15062c;
  color: white;
}

#botones{
	float: left;
	display: block;
	width: 25%;
	
}

#botones2{
	float: right;
}

input[type=button], input[type=submit]{
  background-color: #15062c;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  font-size: 18px;
 
  
}
		</style>

	
	
	<form id="info" method="POST">
			
		<table id="customers">
			<th>
				Info cliente
			</th>
			<tr>
				<td>Id de la estancia</td>	
				<td>${estancia_id}</td>	
			</tr>	
			<tr>
				<td>Id del cliente</td>	
				<td>${cliente_id}</td>	
			</tr>		
			<tr>
				<td>Nombre</td>	
				<td>${nombre}</td>	
			</tr>	
			<tr>
				<td>Apellidos</td>	
				<td>${apellidos}</td>	
			</tr>
			<tr>
				<td>DNI</td>	
				<td>${DNI}</td>	
			</tr>	
			<tr>
				<td>Email</td>	
				<td>${email}</td>	
			</tr>
			<tr>
				<td>Nacionalidad</td>	
				<td>${nacionalidad}</td>	
			</tr>
			<tr>
				<td>Tel&eacute;fono</td>	
				<td>${telefono}</td>	
			</tr>
			<tr>
				<td>Preferencias</td>	
				<td>${preferencias}</td>	
			</tr>
			<tr>
				<td>Fecha de inicio</td>	
				<td>${fecha_inicio}</td>	
			</tr>
			<tr>
				<td>Fecha de fin</td>	
				<td>${fecha_fin}</td>	
			</tr>
			<tr>
				<td>N&uacute;mero habitaci&oacute;n</td>	
				<td>${habitacion_id}</td>	
			</tr>
				<tr>
				<td>Importe</td>	
				<td>${importe}</td>	
			</tr>
		</table>
			
		<table id="servicios">
			<c:forEach items="${servicios}" var="item2">
			<th>
				Servicio_${item2.getServicios_id()}
			</th>
			<tr>
				<td>Lugar</td>	
				<td>${item2.getLugar()}</td>	
			</tr>
			<tr>
				<td>Fecha</td>	
				<td>${item2.getFecha_servicio()}</td>	
			</tr>
			<tr>
				<td>Hora</td>	
				<td>${item2.getHora()}</td>	
			</tr>
			</c:forEach>
		</table>	
			

						
	<br><br>	
		
	<div id="botones">
	<div id="botones2">
		<input type="submit" value="Check-out">
		<br><br>
		<input type="button" onclick="history.back()" name="volver atrás" value="Volver atrás">	
	</div>
	</div>
	</form>
	<br></br>
	
	
	<form method="POST" action="/homePageDHO/menu/disponibilidad/checkout1/servivioHabitaciones/${habitacion_id}/${fecha_aux}/${hotel_id}/${cliente_id}" > 
		<td>${realizada}</td>	
		<br><br>
		<input type="submit" value="servicio"> 
	</form> 	
	
	
	
	
	

	
	
	<script type="text/javascript">
	const btn = document.querySelector(".btn");
	const msg = document.querySelector("#miParrafo");
	btn.addEventListener("click", e => {
		e.preventDefault();
		document.getElementById("miParrafo").style.display = "inline";
		document.getElementById("miParrafo").style.color = "green";
		setTimeout(()=> msg.remove(),3000);
		});
	</script>
		</body>
</section>
	
</html>
