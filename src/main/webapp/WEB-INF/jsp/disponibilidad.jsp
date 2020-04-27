<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<header>
	<nav>
		<ul>
			<li><a href="/homePageDHO/menu/">Inicio</a></li>
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
/* A partir de aquí el código del calendario */
</style>

<section class="contenido wrapper">

<script type="text/javaScript">


//Arrays de datos:
meses=["enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"];
lasemana=["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"]
diassemana=["lun","mar","mié","jue","vie","sáb","dom"];

maximodia=["31","28","31","30","31","30","31","31","30","31","30","31"];
maximodiasig=["32","29","32","31","32","31","32","32","31","32","31","32"];

fechaString = '${fechaConsultaString}'

habitacionespiso1=["101","102","103","104","105","106","107"];
habitacionespiso2=["201","202","203","204","205","206","207"];
habitacionespiso3=["301","302","303","304","305","306","307"];
habitacionespiso4=["401","402","403","404","405","406","407"];
habitacionespiso5=["501","502","503","504","505","506","507"];
habitacionespiso6=["601","602","603","604","605","606","607"];
habitacionespiso7=["701","702","703","704","705","706","707"];


  
function tabla() {         
   		var tabla = "";
		var filas = 7;
		var columnas = 7;
		var habitacion=100;
		var n=0;
		for (var i = 0; i <filas; i++)
		{
			tabla+="<tr>";
			for(var j = 0; j<columnas;j++)
			{
				habitacion+=1;
				tabla+= "<td bgcolor=\"${coloresCelda[0]}\" width=\"120px\" height=\"120px\" align=\"center\">" + "<h3><a href=\"/homePageDHO/menu/disponibilidad/checkin1\">" + habitacion + "</a></h3></td>";;
				n=n+1;
				if(j==columnas-1) { tabla+="</td>"; }
			}
			habitacion=habitacion+100-7;
		}

		document.write("<table id=\"diasc\">" + tabla + "</table>");
}  
  
//tabla()
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
<title>Calendario</title> 
</head>
<body background ="https://www.dhresource.com/0x0/f2/albu/g5/M00/41/F0/rBVaI1lsb-OAPmhoAAZftdBWzDY234.jpg">
<h1><font size=7>Disponibilidad</font></h1>
<br/><br/>
<div id="calendario">
  	<div id="anterior">
  		<form:form method="POST" action="/homePageDHO/menu/disponibilidad/ant/${fechaConsultaString}">
    		<input type="submit" value="Anterior" />
		</form:form>
    </div>
  	<div id="posterior">
		<form:form method="POST" action="/homePageDHO/menu/disponibilidad/post/${fechaConsultaString}">
    		<input type="submit" value="Posterior" />
		</form:form>
	</div>
  <h2 id="titulos">${Dia} de ${Mes} del ${Año}</h2>
  <%  int n=0;%>
  <%  int hab=100;%>
  <% String[] coloresCelda = (String[]) request.getAttribute("coloresCelda");%>
  <% String[] links = (String[]) request.getAttribute("links");%>
  
 <table>

<%for(int i=0; i<7;i++)
	{
	%>	
	<tr>
	<%for(int j=0; j<7;j++)
		{ 
			hab+=1;%>
			<td width="100px" height="100px" align="center" bgcolor="<%=coloresCelda[n]%>">  <h3>    <a href="<%=links[n]%>">  <%=hab%>    </a>    </h3>    </td> 
			<% n++;%>
	  <%}%>
	    <%hab=hab+100-7;%>
		 </tr>
	<%}%>
	
 </table>
 
  <div id="fechahoy">
  	<form:form method="POST" action="/homePageDHO/menu/disponibilidad/hoy">
  		<i>
   			<input type="submit" value=" HOY: ${DiaHoy} de ${MesHoy} del ${AñoHoy} "/> 
   		</i>
   	</form:form>
  </div>
  
  <div id="buscafecha">      
  	<form:form method="POST" action="/homePageDHO/menu/disponibilidad/buscar">
        <input type="date" name="fechaConsultaString" value=${fechaConsultaString} min=${fechaConsultaString} max="2024-12-31">
        <input type="submit" value="Buscar"/>
    </form:form>
  </div>
  
</div>
</body>

</section>


</html>