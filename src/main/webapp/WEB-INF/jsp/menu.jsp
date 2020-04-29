<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.text.DecimalFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page  language="java" import="java.util.*,java.text.*"%>
<%!
public int nullIntconv(String inv)
{   
    int conv=0;
        
    try{
        conv=Integer.parseInt(inv);
    }
    catch(Exception e)
    {}
    return conv;
}
%>
<%

%>



<html>
<header>
	<nav>
		<ul>
			<li><a href="/homePageDHO/menu">Inicio</a></li>
			<li><a href="/homePageDHO/menu/disponibilidad">Disponibilidad</a></li>
			<li><a href="/homePageDHO/menu/reservas1">Reservas</a></li>
			<li><a href="/homePageDHO/menu/asignarTareas">Asignar Tareas</a></li>
		</ul>
	</nav>
</header>


<style>

* { margin: auto; }

 
/*Agregamos margenes inferiores a los parrafos*/
p {
  margin-bottom: 10px;
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
  padding-top: 60px;
}

.wrapper {
  width: 100%;
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


.dsb
{
  background-color: #CCC8BE
}

table.center{
margin-left:auto;
margin-right:auto;
}

/* A partir de aquí el código del calendario */
</style>

<section class="contenido wrapper">

<script type="text/javaScript">
//background ="https://www.todopaisajes.com/1920x1080/hotel-en-la-playa.jpg" background-size=contain
function refresh()
{
  
}
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
h1 {font: normal 40pt "arial black"; text-align: center; }
/*div principal del calendario*/
#calendario { border: 16px double black ; max-width: 1000px; max-height:500px;
              background-color:#fffafa; text-align: center; }
/*tabla del calendario*/
#diasc { border: 1px solid black; border-collapse: 
         separate; border-spacing: 4px; }
#diasc th,#diasc td { font: normal 14pt arial; width: 130px; height: 90px; }
#diasc th { background-color: #1fbc22 }
#diasc td { background-color: #1fbc22 }
#anterior { float: left; width: 100px; font: bold 10pt arial;
          padding: 0.5em 0.1em; cursor: pointer ; }
#posterior { float: right; width: 100px; font: bold 10pt arial; 
          padding: 0.5em 0.1em; cursor: pointer ;}
/*cabecera del calendario*/ 
#buscafecha { background-color: #663366; color: #9bf5ff; padding: 5px }
#buscafecha select, #buscafecha input  { background-color: #9bf5ff; 
            color: #990099; font: bold 10pt arial;  }
#buscafecha [type=text]  { text-align: center; }
#buscafecha  [type=button] { cursor: pointer; }
#titulos { font: normal 20pt "arial black"; padding:0.2em; } 
	
</style>

<head>
<title >Menú de DHO</title> 
</head>

<body><br/><br/>
<h1><align="center" font size=20 >Ocupación del hotel</font></h1>
<br/><br/>

<div id="calendario">
<center>
<form:form method="POST" name="postTabla" >
<table class="center" width=900px height=120px border="0" cellspacing="0" cellpadding="0">
  <tr align="center" >
    <td align="center" width="25%" >&nbsp;</td>
    <td align="center" width="50%">&nbsp;</td>
    <td align="center" width="25%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table width="100%" height="10" border="2" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" height="2" border="1" cellspacing="0" cellpadding="0">
      <tr>
        
        <td width="70%" align="center" style="color:#000000"><h3>${Mes} del ${Año}</h3></td>
        
        <td width="40%"> <h3 align="center">  Cambiar mes:  </h3>
  		
    	<div id="anterior"  style="padding-left:20px;">
  			<a href="/homePageDHO/menu/ant"> Anterior </a>
    	</div>
  		<div id="posterior">
			<a href="/homePageDHO/menu/post"> Posterior </a>
		</div>
  		</td>
  		
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table align="center" width=800 height=100 border="0" cellpadding="0" cellspacing="0" >
      <tbody align="center">
        <tr width="100%" height="100%">
          <th width="14,28%" height="14,28%">Sun</th>
          <th width="14,28%" height="14,28%">Mon</th>
          <th width="14,28%" height="14,28%">Tue</th>
          <th width="14,28%" height="14,28%">Wed</th>
          <th width="14,28%" height="14,28%">Thu</th>
          <th width="14,28%" height="14,28%">Fri</th>
          <th width="14,28%" height="14,28%">Sat</th>
        </tr>
        <%
        int cnt =1;
        int n = 0;
        int[] misPorcentajes = (int[]) request.getAttribute("misPorcentajes");
        String[] misColores = (String[]) request.getAttribute("misColores");
        int mesnum = (int) request.getAttribute("MesNum");
        int anno = (int) request.getAttribute("Año");
        int iTotalweeks = (int) request.getAttribute("iTotalweeks");
        int weekStartDay =  (int) request.getAttribute("weekStartDay");
        int days =  (int) request.getAttribute("days");
        for(int i=1;i<=iTotalweeks;i++)
        {
        %>
        <tr width="100%" height="60%">
          <%   
            for(int j=1;j<=7;j++)
            {
                if(cnt<weekStartDay || (cnt-weekStartDay+1)>days)
                {
                 %>
                <td align="center"  height="50" width="50" class="dsb">&nbsp;</td>
               <% 
                }
                else
                { 	String fecha = "";
          			if(mesnum == 10 || mesnum == 11 || mesnum == 12){
          				if((cnt-weekStartDay+1)<10)
          					{fecha = "menu/disponibilidad/" + anno + "-" + mesnum + "-0" + ""+(cnt-weekStartDay+1);}
          				else{
          					fecha = "menu/disponibilidad/" + anno + "-" + mesnum + "-" + ""+(cnt-weekStartDay+1);}
          			}
                	else{
                		if((cnt-weekStartDay+1)<10){
          					fecha = "menu/disponibilidad/" + anno + "-0" + mesnum + "-0" + ""+(cnt-weekStartDay+1);}
          				else{
          					fecha = "menu/disponibilidad/" + anno + "-0" + mesnum + "-" + ""+(cnt-weekStartDay+1);}
                	}
                 %>
                <td align="center" height="50" width="50" id="day_<%=(cnt-weekStartDay+1)%>" bgcolor="<%=misColores[n]%>">   <h3>  <a href=<%=fecha%>> <%=(cnt-weekStartDay+1)%> </a> </h3>  <span> <%=misPorcentajes[n]%>% </span>     </td>
               <% n++;
                }
                cnt++;
              }
            %>
        </tr>
        <% 
        }
        %>
      </tbody>
    </table></td>
  </tr>
</table></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form:form>
</center>
</div>
</body>

</section>


</html>