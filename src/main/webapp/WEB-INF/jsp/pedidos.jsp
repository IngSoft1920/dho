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
	<h1><font size=7 align = "center">Pedidos a proveedores</font></h1>
	<br><br>
	
<ul id="menu">

   <li><input type="checkbox" name="list" id="nivel1-1"><label for="nivel1-1">Proveedor 1</label>
   <ul class="interior">
           <li><input type="checkbox" name="list" id="nivel2-1"><label for="nivel2-1">Alimentación</label>
           <ul class="interior">
           
             <li><a href="#r">
             		<label>Tomates </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
				</a></li>
				
             <li><a href="#r">
             		<label>Lechugas </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
				</a></li>
				
            </ul>
         </li>
         <li><input type="checkbox" name="list" id="nivel2-2"><label for="nivel2-2">Menaje</label>
           <ul class="interior">
           
                <li><a href="#r">
             		<label>Toallas </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
				</a></li>
				
               <li><a href="#r">
             		<label>Papel </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
			   </a></li>
             
            </ul>
         </li>
         
          <li><input type="checkbox" name="list" id="nivel2-3"><label for="nivel2-3">Otros</label>
          <ul class="interior">
           
                <li><a href="#r">
             		<label>Otros </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
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
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
				</a></li>
				
             <li><a href="#r">
             		<label>Lechugas </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
				</a></li>
				
            </ul>
         </li>
         <li><input type="checkbox" name="list" id="nivel2-5"><label for="nivel2-5">Menaje</label>
           <ul class="interior">
           
                <li><a href="#r">
             		<label>Toallas </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
				</a></li>
				
               <li><a href="#r">
             		<label>Papel </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
			   </a></li>
             
            </ul>
         </li>
         
          <li><input type="checkbox" name="list" id="nivel2-6"><label for="nivel2-6">Otros</label>
          <ul class="interior">
           
                <li><a href="#r">
             		<label>Otros </label> 
					<input type="text" name="nombre" autocomplete="off" /> 
					<br> 
				</a></li>
  
  		    </ul>
  		 </li>
 
      </ul>
   </li>
   
   
   
   
</ul>

	<br>
	<input type="submit" value="Realizar Pedido"> 
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
	
			
	
</html>