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
					<select name = "nombre"> <option value="New York"> Hotel New York </option> </select> 
					<br> 
<label>Id del Hotel:  </label> 
					<select name = "hotel_id"> <option value="6"> 6 </option></select> 
					<br> 
<label>Lugar:  </label>
					<select name = "lugar"> 
					<option value="Restaurante">Restaurante</option>
					<option value="Bar">Bar</option>
					<option value="Servicio de Mantenimiento y Limpieza">Servicio de Mantenimiento y Limpieza</option>
					</select> 
					<br>
<label>Fecha:  </label> 
					<input type="date" name="fecha" value="2020-05-25"/> 
<br> 
 <label>Proveedor:  </label> 
   <select name = "idProveedor"> 
	    <option value="0"> Cocinas S.A. </option>
		<option value="1"> Items S.A. </option>
   </select> 
<br>
<br>
<br>
<h2><font size=5 align = "center"> Contenido del pedido </font></h2><br>

<ul id="menu">
	
        
   <li><input type="checkbox" name="list" id="nivel1-1"><label for="nivel1-1">Tipos de productos </label>
   <ul class="interior">
           <li><input type="checkbox" name="list" id="nivel2-1"><label for="nivel2-1">Alimentación</label>
           <ul class="interior">
           
           
             <li><a href="#r">
             		<label>Tomates </label> 
					<input type="number" name="tomates" min="0" value="0" /> Especificaciones:  
					<select name = "specstom"> 
	   				 <option value="en rama"> En rama </option>
					 <option value="kumato"> Kumato </option>
					 <option value="cherry"> Cherry </option>
					  <option value="Marglobe"> Marglobe </option>
					 <option value="Roma"> Roma </option>
					 <option value="Raf"> Raf </option>
   					</select>
					<br> 
				</a></li>
				
				
				
             <li><a href="#r">
             		<label>Lechugas </label> 
					<input type="number" name="lechugas" min="0" value="0"/> Especificaciones: 
					<select name = "specslec"> 
	   				 <option value="Endibia"> Endibia </option>
					 <option value=" Canónigo"> Canónigo </option>
					 <option value="Rúcula"> Rúcula </option>
					 <option value="Escarola"> Escarola </option>
					 <option value="Iceberg"> Iceberg </option>
					 <option value="Radicchio"> Radicchio </option>
					 <option value="Lollo Rosso"> Lollo Rosso </option>
					 <option value="Tatsoi"> Tatsoi </option>
					 <option value="Batavia"> Batavia </option>
   					</select>
					<br> 
				</a></li>
				
			<li><a href="#r">
             		<label>Pan </label> 
					<input type="number" name="pan" min="0" value="0"/> Especificaciones: 
					<select name = "specspan"> 
	   				 <option value="Baguette"> Baguette </option>
					 <option value="Hogaza"> Hogaza </option>
					 <option value="Tostada"> Tostada </option>
					 <option value="Rústico"> Rústico </option>
					 <option value="Sin gluten"> Sin gluten </option>
					 <option value="De pipas"> De pipas </option>
					 <option value="Multicereales"> Multicereales </option>
					 <option value="Ácimo"> Ácimo </option>
					 <option value="De maíz"> De maíz </option>
					  <option value="Torta de aceite"> Torta de aceite </option>
					 <option value="Integral"> Integral </option>
					 <option value="Barra normal">Barra normal </option>
   					</select>
					<br> 
				</a></li>
				
		  <li><a href="#r">
             		<label>Huevos </label> 
					<input type="number" name="huevos" min="0" value="0"/> Especificaciones: 
					<select name = "specshuevos"> 
	   				 <option value="Gallina XL"> Gallina XL </option>
					 <option value="Gallina M> Gallina M </option>
					 <option value="Gallina S"> Gallina S </option>
					 <option value="Avestruz"> Avestruz </option>
					 <option value="Oca"> Oca </option>
					 <option value="Pato"> Pato </option>
					 <option value="Perdiz"> Perdiz </option>
					 <option value="Codorniz"> Codorniz </option>
   					</select>
					<br> 
				</a></li>
				
		 <li><a href="#r">
             		<label>Leche </label> 
					<input type="number" name="leche" min="0" value="0"/> Especificaciones: 
					<select name = "specsleche"> 
	   				 <option value="Desnatada"> Desnatada </option>
					 <option value="Semidesnatada"> Semidesnatada </option>
					 <option value="Entera"> Entera </option>
					 <option value="De soja"> De soja </option>
					 <option value="De almendras"> De almendras </option>
   					</select>
					<br> 
				</a></li>
				
				
				
		 <li><a href="#r">
             		<label>Aceite </label> 
					<input type="number" name="aceite" min="0" value="0"/> Especificaciones: 
					<select name = "specsaceite"> 
	   				 <option value="De oliva virgen"> De oliva virgen </option>
					 <option value="De oliva virgen extra"> de oliva virgen extra </option>
					 <option value="De girasol"> De girasol </option>
					 <option value="De orujo"> De orujo </option>
   					</select>
					<br> 
				</a></li>
				
				
		 <li><a href="#r">
             		<label>Queso </label> 
					<input type="number" name="queso" min="0" value="0"/> Especificaciones: 
					<select name = "specsqueso"> 
	   				 <option value="De cabra"> De cabra </option>
					 <option value="De vaca manchego"> De vaca manchego </option>
					 <option value="Parmesano"> Parmesano </option>
					 <option value="Emental">Emental </option>
					 <option value="Brie"> Brie </option>
					 <option value="Semicurado"> Semicurado</option>
					 <option value="Azul"> Azul </option>
					 <option value="Manchego"> Manchego </option>
					 <option value="De oveja"> De oveja</option>
					 <option value="Roquefort"> Roquefort </option>
					 <option value="Gouda"> Gouda </option>
   					</select>
					<br> 
				</a></li>
				
			<li><a href="#r">
             		<label>Carne </label> 
					<input type="number" name="carne" min="0" value="0"/> Especificaciones: 
					<select name = "specscarne"> 
	   				 <option value="Picada de vaca"> Picada de vaca </option>
					 <option value="Codillo de cerdo"> Codillo de cerdo </option>
					 <option value="Solomillo de cerdo"> Solomillo de cerdo </option>
					 <option value="Cordero">Cordero</option>
					 <option value="De aguja"> De aguja </option>
					 <option value="De conejo">De conejp</option>
					 <option value="Lechón"> Lechón </option>
					 <option value="Secreto">Secreto</option>
					 <option value="Carrilleras">Carrilleras</option>
					 <option value="Oreja de cerdo">Oreja de cerdo</option>
   					</select>
					<br> 
				</a></li>	
				
			<li><a href="#r">
             		<label>Refrescos </label> 
					<input type="number" name="refrescos" min="0" value="0"/> Especificaciones: 
					<select name = "specsrefrescos"> 
	   				 <option value="Coca-Cola"> Coca-Cola </option>
					 <option value="Fanta de limón"> Fanta de limón </option>
					 <option value="Fanta de naranja"> Fanta de naranja </option>
					 <option value="Bitter kas">Bitter kas</option>
					 <option value="Nestea"> Nestea </option>
					 <option value="Aquarius">Aquuarius</option>
					 <option value="7 up"> 7 up </option>
					 <option value="Gaseosa">Gaseosa</option>
					 <option value="Dr pepper">Dr pepper</option>
   					</select>
					<br> 
				</a></li>	
				
            </ul>
         </li>
         <li><input type="checkbox" name="list" id="nivel2-2"><label for="nivel2-2">Menaje</label>
           <ul class="interior">
           
                <li><a href="#r">
             		<label>Toallas</label> 
					<input type="number" name="toallas" min="0" value="0"/> Especificaciones: 
					<select name = "specstoallas"> 
	   				 <option value="De ducha pequeña"> De ducha pequeña </option>
					 <option value="De ducha grande"> De ducha grande </option>
					 <option value="De piscina"> De piscina </option>
					 <option value="De spa"> De spa </option>
					 <option value="De sauna"> De sauna </option>

   					</select>
					<br> 
				</a></li>	
				
				
				
				
                <li><a href="#r">
             		<label>Papel</label> 
					<input type="number" name="papel" min="0" value="0"/> Especificaciones: 
					<select name = "specspapel"> 
	   				 <option value="Pañuelos"> Pañuelos </option>
					 <option value="Sevilletas"> Servilletas </option>
					 <option value="Higiénico"> Higiénico </option>
					 <option value="De cocina"> De cocina </option>
					 
   					</select>
					<br> 
				</a></li>
             
             
              <li><a href="#r">
             		<label>Jabón</label> 
					<input type="number" name="jabon" min="0" value="0"/> Especificaciones: 
					<select name = "specsjabon"> 
	   				 <option value="Gel de ducha">Gel de ducha </option>
					 <option value="Champú"> Champú </option>
					 <option value="De manos"> De manos </option>
					 <option value="De spa"> De spa </option>
					 <option value="Suavizante"> Suavizante </option>
					 <option value="Detergente"> Detergente </option>
   					</select>
					<br> 
				</a></li>
				
				
			 <li><a href="#r">
             		<label>Obsequios de aseo</label> 
					<input type="number" name="aseo" min="0" value="0"/> Especificaciones: 
					<select name = "specsaseo"> 
	   				 <option value="Peine">Peine</option>
					 <option value="Cepillo de dientes">Cepillo de dientes</option>
					 <option value="Colonia"> Colonia </option>
					 <option value="Pastilla de jabón"> Pastilla de jabón </option>
					  <option value="Líquido de lentillas"> Líquido de lentillas </option>
   					</select>
					<br> 
				</a></li>
				
				
				
				
            </ul>
         </li>
         
          <li><input type="checkbox" name="list" id="nivel2-3"><label for="nivel2-3">Otros</label>
          <ul class="interior">
           
                <li><a href="#r">
             		<label>Otros </label> 
					<input type="number" name="otros" min="0" value="0"/> Especificaciones:  <input type="text" name="specsotros" value=" Sin especificar " />
					<br> 
				</a></li>
  
  		    </ul>
  		 </li>
 
      </ul>
   </li>
   

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