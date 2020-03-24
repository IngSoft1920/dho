<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<header>
	<nav>
		<ul>
			<li><a href="/homePageDHO/menu/checkout1">Check-out</a></li>
			<li><a href="/homePageDHO/menu/asignarTareas">Asignar Tareas</a></li>
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

/*A partir de aquí el código del calendario*/

<section class="contenido wrapper">

<script type="text/javaScript">


//Arrays de datos:
meses=["enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"];
lasemana=["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"]
diassemana=["lun","mar","mié","jue","vie","sáb","dom"];

maximodia=["31","28","31","30","31","30","31","31","30","31","30","31"];
maximodiasig=["32","29","32","31","32","31","32","32","31","32","31","32"];


habitacionespiso1=["101","102","103","104","105","106","107"];
habitacionespiso2=["201","202","203","204","205","206","207"];
habitacionespiso3=["301","302","303","304","305","306","307"];
habitacionespiso4=["401","402","403","404","405","406","407"];
habitacionespiso5=["501","502","503","504","505","506","507"];
habitacionespiso6=["601","602","603","604","605","606","607"];
habitacionespiso7=["701","702","703","704","705","706","707"];




//Tras cargarse la página ...
window.onload = function() 
{
//fecha actual
hoy=new Date(); //objeto fecha actual
diasemhoy=hoy.getDay(); //dia semana actual
diahoy=hoy.getDate(); //dia mes actual
meshoy=hoy.getMonth(); //mes actual
annohoy=hoy.getFullYear(); //año actual
// Elementos del DOM: en cabecera de calendario 
tit=document.getElementById("titulos"); //cabecera del calendario
ant=document.getElementById("anterior"); //mes anterior
pos=document.getElementById("posterior"); //mes posterior
// Elementos del DOM en las filas
f0=document.getElementById("fila0");
f1=document.getElementById("fila1");
f2=document.getElementById("fila2");
f3=document.getElementById("fila3");
f4=document.getElementById("fila4");
f5=document.getElementById("fila5");
f6=document.getElementById("fila6");
//Pie de calendario
pie=document.getElementById("fechaactual");
pie.innerHTML+=lasemana[diasemhoy]+", "+diahoy+" de "+meses[meshoy]+" de "+annohoy;
//formulario: datos iniciales:
document.buscar.buscaanno.value=annohoy;
// Definir elementos iniciales:
mescal = meshoy; //mes principal
annocal = annohoy //año principal

//iniciar calendario:
cabecera() 



}




//FUNCIONES de creación del calendario:
//cabecera del calendario
function cabecera() {
     	 ant.innerHTML="anterior";
         pos.innerHTML="posterior";
         mesant=mescal-1;
         mespos=mescal+1;
         
            //cambio de año
         if(mescal==11 && diahoy==32) { annocal=annocal+1; diahoy=1; mescal=0;}
         else if(mescal==0 && diahoy==0) { annocal=annocal-1; diahoy=31; mescal=11; } 
         
         //cambio de mes bisiesto
         else if(mescal==2 && diahoy==0 && annocal%4==0 && annocal%100!=0) { diahoy=maximodiasig[mesant]; mescal=mesant; }
         else if(mescal==1 && diahoy==29 && annocal%4==0 && annocal%100!=0){}
         else if(mescal==1 && diahoy==30 && annocal%4==0 && annocal%100!=0) { diahoy=1; mescal=mespos; }
         
         //cambio de mes normal
		 else if(diahoy==0){ mescal=mesant;diahoy=maximodia[mesant]; }
		 else if(diahoy==maximodiasig[mescal]){ mescal=mespos; diahoy=1; }
		 
		 //imprimir por pantalla
         tit.innerHTML=diahoy+" "+meses[mescal]+" de "+annocal;
} 


//Ver mes anterior
function mesantes() {
		 diahoy=diahoy-1;
         cabecera() //llamada a funcion de cambio de cabecera
         }
//ver mes posterior
function mesdespues() {
		 diahoy=diahoy+1;
         cabecera() //escribir la cabecera 
         }
//volver al mes actual
function actualizar() {
         mescal=hoy.getMonth(); //cambiar a mes actual
         annocal=hoy.getFullYear(); //cambiar a año actual 
         cabecera() //escribir la cabecera
         escribirdias() //escribir la tabla
         }
//ir al mes buscado
function mifecha() {
         //Recoger dato del año en el formulario
         mianno=document.buscar.buscaanno.value; 
         //recoger dato del mes en el formulario
         listameses=document.buscar.buscames;
         opciones=listameses.options;
         num=listameses.selectedIndex
         mimes=opciones[num].value;
         //Comprobar si el año está bien escrito
         if (isNaN(mianno) || mianno<1) { 
            //año mal escrito: mensaje de error
            alert("El año no es válido:\n debe ser un número mayor que 0")
            }
         else { //año bien escrito: ver mes en calendario:
              mife=new Date(); //nueva fecha
              mife.setMonth(mimes); //añadir mes y año a nueva fecha
              mife.setFullYear(mianno);
              mescal=mife.getMonth(); //cambiar a mes y año indicados
              annocal=mife.getFullYear();
              cabecera() //escribir cabecera
              escribirdias() //escribir tabla
              }
}
  
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
				tabla+= "<td bgcolor=\"${coloresCelda[0]}\" width=\"120px\" height=\"120px\" align=\"center\">" + "<h3><a href=\"/homePageDHO/menu/checkin1\">" + habitacion + "</a></h3></td>";;
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
#calendario { border: 8px double black ; max-width: 1200px; max-height:1000px;
              background-color:#fffafa; text-align: center; }
/*tabla del calendario*/
#diasc { border: 1px solid black; border-collapse: 
         separate; border-spacing: 4px; }
#diasc th,#diasc td { font: normal 14pt arial; width: 130px; height: 90px; }
//#diasc th { background-color: #1fbc22 }
//#diasc td { background-color: #1fbc22 }
/*línea de la fecha actual*/
#fechaactual { font: bold 12pt arial; padding: 0.4em }
#fechaactual i { cursor: pointer ; }
#fechaactual i:hover { color: blue; text-decoration: underline; }
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
<body>
<h1>Disponibilidad actual</h1>
<br/><br/>
<div id="calendario">
  <div id="anterior" onclick="mesantes()"></div>
  <div id="posterior" onclick="mesdespues()"></div>
  
  <h2 id="titulos"></h2>
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
			<td width="120px" height="120px" align="center" bgcolor="<%=coloresCelda[n]%>"><h3><a href="<%=links[n]%>"><%=hab%></a></h3></td> 
			<% n++;%>
	  <%}
	    hab=hab+100-7;%>
		 </tr>
	<%}%>
	
 </table>
 
  
  <div id="fechaactual"><i onclick="actualizar()">HOY: </i></div>
  <div id="buscafecha">
    <form action="#" name="buscar">
      <p>DÍA
        <select name="buscames">
          <option value="0">Enero</option>
          <option value="1">Febrero</option>
          <option value="2">Marzo</option>
          <option value="3">Abril</option>
          <option value="4">Mayo</option>
          <option value="5">Junio</option>
          <option value="6">Julio</option>
          <option value="7">Agosto</option>
          <option value="8">Septiembre</option>
          <option value="9">Octubre</option>
          <option value="10">Noviembre</option>
          <option value="11">Diciembre</option>
        </select>
      ... AÑO ...
        <input type="text" name="buscaanno" maxlength="4" size="4" />
      ... 
        <input type="button" value="BUSCAR" onclick="mifecha()" />
      </p>
    </form>
  </div>
</div>
</body>

</section>


</html>