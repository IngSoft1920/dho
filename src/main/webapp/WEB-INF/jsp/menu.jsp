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

body {
background-image: url(https://wallup.net/wp-content/uploads/2019/09/46190-hotel-malvivy-pool-interior-ocean-sea-houses-buildings-sky-sunset-3.jpg); /*You will specify your image path here.*/

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
}

/* A partir de aquí el código del calendario */
</style>

<section class="contenido wrapper">

<script type="text/javaScript">
//background ="https://www.todopaisajes.com/1920x1080/hotel-en-la-playa.jpg" background-size=contain
</script>

<style>

@charset "utf-8";
@import url(http://weloveiconfonts.com/api/?family=fontawesome);

[class*="fontawesome-"]:before
{
  font-family: 'FontAwesome', sans-serif;
}



/*instrucciones generales*/
* { margin: auto; }
/*cabecera de la página*/
h1 { text-align: center; padding: 0.5em; }
/*div principal del calendario*/
#calendario { border: 8px double black ; max-width: 1000px; max-height:1000px;
              background-color:#fffafa; text-align: center; }
/*tabla del calendario*/
#diasc { border: 1px solid black; border-collapse: 
         separate; border-spacing: 4px; }
#diasc th,#diasc td { font: normal 14pt arial; width: 130px; height: 90px; }
//#diasc th { background-color: #1fbc22 }
//#diasc td { background-color: #1fbc22 }
/*línea de la fecha actual*/
#fechahoy { font: bold 12pt arial; padding: 0.4em }
#fechahoy i { cursor: pointer ; }
#fechahoy i:hover { color: blue; text-decoration: underline; }
/*formulario de busqueda de fechas*/
#buscafecha { background-color: #663366; color: #9bf5ff; padding: 5px }
#buscafecha select, #buscafecha input  { background-color: #9bf5ff; 
            color: #990099; font: bold 10pt arial;  }
#buscafecha [type=text]  { text-align: center; }
#buscafecha  [type=button] { cursor: pointer; }
/*cabecera del calendario*/ 
#anterior { float: left; width: 100px; font: bold 12pt arial;
          padding: 0.5em 0.1em; cursor: pointer ; }
#posterior { float: right; width: 100px; font: bold 12pt arial; 
          padding: 0.5em 0.1em; cursor: pointer ;}
#anterior:hover {color: blue;text-decoration: underline;}
#posterior:hover {color: blue; text-decoration: underline;}
#titulos { font: normal 20pt "arial black"; padding:0.2em; } 
	
</style>

<head>
<title>Menú de DHO</title> 
</head>
<body>
<h1><font size=7>Menú</font></h1>
<br/><br/>

</body>

</section>


</html>