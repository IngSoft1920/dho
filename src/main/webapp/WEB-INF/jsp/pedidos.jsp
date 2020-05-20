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
			<li><a href="/homePageDHO/menu/reservaGrupos">Reserva Grupos</a></li>

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

	<body style="background-color:lightblue; margin-bottom: 100px">
				    
	
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
	width: 5%;
	
}

#botones2{
	float: right;
}

input[type=button], input[type=submit]{
  border: none;
  color: black;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  font-size: 12px;
  padding : 5px 5px;
 
  
}

#menu * { list-style:none;}
#menu li{ line-height:180%;}
#menu li a{color:#222; text-decoration:none;}
#menu li a:before{ content:"\025b8"; color:#ddd; margin-right:4px;}
#menu input[name="list"] {
	position: absolute;
	left: -1000em;
	}
#menu label:before{ content:"\025b8"; margin-right:4px;}
#menu input:checked ~ label:before{ content:"\025be";}
#menu .interior{display: none;}
#menu input:checked ~ ul{display:block;}

		</style>
		<br>
	<h1><font size=7 align = "center">Pedidos a proveedores</font></h1>
	<br><br>
	
<form:form method="POST" action="/homePageDHO/menu/pedidos/submit">	


<h2><font size=5 align = "center">Datos del pedido</font></h2><br>

<label>Nombre del Hotel:  </label> 
					<input type="text" name="nombreHotel" value="New York" />  
					<br> 
<label>Id del Hotel:  </label> 
					<input type="number" name="hotel_id" min="0" value="6" /> 
					<br> 
<label>Lugar:  </label> 
					<input type="text" name="lugar" value="Restaurante" /> 
					<br> 
<label>Fecha:  </label> 
					<input type="date" name="fecha" value="2020-05-25"/> 
<br> 
<br>
<br>
<h2><font size=5 align = "center"> Contenido del pedido </font></h2><br>

<ul id="menu">
	
        
   <li><input type="checkbox" name="list" id="nivel1-1"><label for="nivel1-1">Proveedor 1</label>
   <ul class="interior">
           <li><input type="checkbox" name="list" id="nivel2-1"><label for="nivel2-1">Alimentación</label>
           <ul class="interior">
           
             <li><a href="#r">
             		<label>Tomates </label> 
					<input type="number" name="tomates1" min="0" value="0" /> Especificaciones:  <input type="text" name="specstom1" value=" Sin especificar " />
					<br> 
				</a></li>
				
             <li><a href="#r">
             		<label>Lechugas </label> 
					<input type="number" name="lechugas1" min="0" value="0"/> Especificaciones:  <input type="text" name="specslec1" value=" Sin especificar " />
					<br> 
				</a></li>
				
            </ul>
         </li>
         <li><input type="checkbox" name="list" id="nivel2-2"><label for="nivel2-2">Menaje</label>
           <ul class="interior">
           
                <li><a href="#r">
             		<label>Toallas </label> 
					<input type="number" name="toallas1" min="0" value="0"/> Especificaciones:  <input type="text" name="specstoallas1" value=" Sin especificar " />
					<br> 
				</a></li>
				
               <li><a href="#r">
             		<label>Papel </label> 
					<input type="number" name="papel1" min="0" value="0"/> Especificaciones:  <input type="text" name="specspapel1" value=" Sin especificar " />
					<br> 
			   </a></li>
             
            </ul>
         </li>
         
          <li><input type="checkbox" name="list" id="nivel2-3"><label for="nivel2-3">Otros</label>
          <ul class="interior">
           
                <li><a href="#r">
             		<label>Otros </label> 
					<input type="number" name="otros1" min="0" value="0"/> Especificaciones:  <input type="text" name="specsotros1" value=" Sin especificar " />
					<br> 
				</a></li>
  
  		    </ul>
  		 </li>
 
      </ul>
   </li>
   
   
----------------------------------------   
   
   
      <li><input type="checkbox" name="list" id="nivel1-2"><label for="nivel1-2">Proveedor 2</label>
   <ul class="interior">
         <li><input type="checkbox" name="list" id="nivel2-4"><label for="nivel2-4">Alimentación</label>
           <ul class="interior">
           
             <li><a href="#r">
             		<label>Tomates </label> 
					<input type="number" name="tomates2" min="0" value="0" /> Especificaciones:  <input type="text" name="specstom2" value=" Sin especificar " />
					<br> 
				</a></li>
				
             <li><a href="#r">
             		<label>Lechugas </label> 
					<input type="number" name="lechugas2" min="0" value="0"/> Especificaciones:  <input type="text" name="specslec2" value=" Sin especificar " />
					<br> 
				</a></li>
				
            </ul>
         </li>
         <li><input type="checkbox" name="list" id="nivel2-5"><label for="nivel2-5">Menaje</label>
           <ul class="interior">
           
                <li><a href="#r">
             		<label>Toallas </label> 
					<input type="number" name="toallas2" min="0" value="0"/> Especificaciones:  <input type="text" name="specstoallas2" value=" Sin especificar " />
					<br> 
				</a></li>
				
               <li><a href="#r">
             		<label>Papel </label> 
					<input type="number" name="papel2" min="0" value="0"/> Especificaciones:  <input type="text" name="specspapel2" value=" Sin especificar " />
					<br> 
			   </a></li>
             
            </ul>
         </li>
         
          <li><input type="checkbox" name="list" id="nivel2-6"><label for="nivel2-6">Otros</label>
          <ul class="interior">
           
                <li><a href="#r">
             		<label>Otros </label> 
					<input type="number" name="otros2" min="0" value="0"/> Especificaciones:  <input type="text" name="specsotros2" value=" Sin especificar " />
					<br> 
				</a></li>
  
  		    </ul>
  		 </li>
 
      </ul>
   </li>
      
</ul>

	<br>
	<input type="submit" value=" Realizar Pedido "> 	
    </form:form>	
	
	
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
	
			
	
</html>