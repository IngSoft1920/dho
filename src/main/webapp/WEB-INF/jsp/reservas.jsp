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

*{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
}
body{
    font-family: Helvetica;
    -webkit-font-smoothing: antialiased;
    background: rgba( 71, 147, 227, 1);
}
h2{
    text-align: center;
    font-size: 18px;
    text-transform: uppercase;
    letter-spacing: 1px;
    color: white;
    padding: 30px 0;
}

/* Table Styles */

.table-wrapper{
    margin: 10px 70px 70px;
    box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
}

.fl-table {
    border-radius: 5px;
    font-size: 12px;
    font-weight: normal;
    border: none;
    border-collapse: collapse;
    width: 100%;
    max-width: 100%;
    white-space: nowrap;
    background-color: white;
}

.fl-table td, .fl-table th {
    text-align: center;
    padding: 8px;
}

.fl-table td {
    border-right: 1px solid #f8f8f8;
    font-size: 12px;
}

.fl-table thead th {
    color: #ffffff;
    background: #4FC3A1;
}


.fl-table thead th:nth-child(odd) {
    color: #ffffff;
    background: #324960;
}

.fl-table tr:nth-child(even) {
    background: #F8F8F8;
}

/* Responsive */

@media (max-width: 767px) {
    .fl-table {
        display: block;
        width: 100%;
    }
    .table-wrapper:before{
        content: "Scroll horizontally >";
        display: block;
        text-align: right;
        font-size: 11px;
        color: white;
        padding: 0 0 10px;
    }
    .fl-table thead, .fl-table tbody, .fl-table thead th {
        display: block;
    }
    .fl-table thead th:last-child{
        border-bottom: none;
    }
    .fl-table thead {
        float: left;
    }
    .fl-table tbody {
        width: auto;
        position: relative;
        overflow-x: auto;
    }
    .fl-table td, .fl-table th {
        padding: 20px .625em .625em .625em;
        height: 60px;
        vertical-align: middle;
        box-sizing: border-box;
        overflow-x: hidden;
        overflow-y: auto;
        width: 120px;
        font-size: 13px;
        text-overflow: ellipsis;
    }
    .fl-table thead th {
        text-align: left;
        border-bottom: 1px solid #f7f7f9;
    }
    .fl-table tbody tr {
        display: table-cell;
    }
    .fl-table tbody tr:nth-child(odd) {
        background: none;
    }
    .fl-table tr:nth-child(even) {
        background: transparent;
    }
    .fl-table tr td:nth-child(odd) {
        background: #F8F8F8;
        border-right: 1px solid #E6E4E4;
    }
    .fl-table tr td:nth-child(even) {
        border-right: 1px solid #E6E4E4;
    }
    .fl-table tbody td {
        display: block;
        text-align: center;
    }
}
</style>

<section class="contenido wrapper">
	

	
	<h2>Reservas Servicios</h2>
  <div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>ESTANCIA</th>
            <th>CLIENTE</th>
            <th>LUGAR</th>
            <th>FECHA</th>
            <th>HORA</th>
            <th>TIPO</th>
            <th>PLATOS</th>
            <th>ITEMS</th>
            <th>HORA SALIDA</th>
            <th>PRECIO</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaReservas}" var="item2">	
	<tr>			
		    <td><h4>${item2.getId_ServicoHotel()}</h4></td> 
		    <td><h4>${item2.getEstancia_id()}</h4></td> 	
		    <td><h4>${item2.getCliente_id()}</h4></td>
		    <td><h4>${item2.getLugar()}</h4></td>
		    <td><h4>${item2.getFecha_servicio()}</h4></td>
		    <td><h4>${item2.getHora()}</h4></td>
		    <td><h4>${item2.getTipo_servicio()}</h4></td>
		    <td><h4>${item2.getPlatos()}</h4></td>
		    <td><h4>${item2.getItems()}</h4></td>
		    <td><h4>${item2.getHora_salida()}</h4></td>
		    <td><h4>${item2.getPrecio()}</h4></td>
		  
		    
	</tr>
	</c:forEach>
              
        <tbody>
    </table>
    
</div>
	
	</body>
		
	<div class="container">		
	<form method="POST"> 
		<label>cliente_id</label> 
		<input type="text" name="cliente_id" autocomlete="off" /> 
		<br><br> 
		<label>estancia_id</label> 
		<input type="text" name="estancia_id" autocomlete="off" /> 
		<br><br> 
		<label>fecha_servicio</label> 
		<input type="text" name="fecha_servicioString" autocomlete="off" /> 
		<br><br> 
		<label>hora_salida</label> 
		<input type="text" name="hora_salidaString" autocomplete="off" /> 
		<br><br> 
		<label>hora</label> 
		<input type="text" name="horaString" autocomplete="off" /> 
		<br><br> 
		<label>id_ServicoHotel</label> 
		<input type="text" name="id_ServicoHotel" autocomplete="off" /> 
		<br><br> 
		<label>items</label> 
		<input type="text" name="items" autocomplete="off" /> 
		<br><br> 
		<label>lugar</label> 
		<input type="text" name="lugar" autocomplete="off" /> 
		<br><br> 
		<label>platos</label> 
		<input type="text" name="platos" autocomplete="off" /> 
		<br><br> 
		<label>tipo_servicio</label> 
		<input type="text" name="tipo_servicio" autocomplete="off" /> 
		<br><br> 
		 
		<input type="submit" value="Registro"> 
	</form> 	

  <style>

/* Style inputs with type="text", select elements and textareas */
input[type=text], select, textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

/* Style the submit button with a specific background color etc */
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type=submit]:hover {
  background-color: #45a049;
}

/* Add a background color and some padding around the form */
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

</style>

</div>					
	
	
					
</section>	
</html>