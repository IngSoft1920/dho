<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
 int iYear=nullIntconv(request.getParameter("iYear"));
 int iMonth=nullIntconv(request.getParameter("iMonth"));

 Calendar ca = new GregorianCalendar();
 int iTDay=ca.get(Calendar.DATE);
 int iTYear=ca.get(Calendar.YEAR);
 int iTMonth=ca.get(Calendar.MONTH);

 if(iYear==0)
 {
      iYear=iTYear;
      iMonth=iTMonth;
 }

 GregorianCalendar cal = new GregorianCalendar (iYear, iMonth, 1); 

 int days=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
 int weekStartDay=cal.get(Calendar.DAY_OF_WEEK);
 
 cal = new GregorianCalendar (iYear, iMonth, days); 
 int iTotalweeks=cal.get(Calendar.WEEK_OF_MONTH);
  
%>



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

* { margin: auto; }

 
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

/*cabecera del calendario*/ 

#titulos { font: normal 20pt "arial black"; padding:0.2em; } 
	
</style>

<head>
<title >Menú de DHO</title> 
</head>

<body>
<h1><align="center" font size=7 >Menú</font></h1>
<br/><br/>

<center>
<form name="frm" method="post">
<table class="center" width="100%" border="0.5" cellspacing="0" cellpadding="0">
  <tr align="center" bottom="middle">
    <td align="center" width="25%">&nbsp;</td>
    <td align="center" width="45%">&nbsp;</td>
    <td align="center" width="30%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table width="100%" border="2" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td width="6%">Year</td>
        <td width="7%">
        <select name="iYear" onChange="goTo()">
        <%
        // start year and end year in combo box to change year in calendar
        for(int iy=iTYear-70;iy<=iTYear+70;iy++)
        {
          if(iy==iYear)
          {
            %>
          <option value="<%=iy%>" selected="selected"><%=iy%></option>
          <%
          }
          else
          {
            %>
          <option value="<%=iy%>"><%=iy%></option>
          <%
          }
        }
       %>
        </select></td>
        <td width="73%" align="center" style="color:#000000"><h3><%=new SimpleDateFormat("MMMM").format(new Date(2008,iMonth,01))%> <%=iYear%></h3></td>
        <td width="6%">Month</td>
        <td width="8%">
        <select name="iMonth" onChange="goTo()">
        <%
        // print month in combo box to change month in calendar
        for(int im=0;im<=11;im++)
        {
          if(im==iMonth)
          {
         %>
          <option value="<%=im%>" selected="selected"><%=new SimpleDateFormat("MMMM").format(new Date(2008,im,01))%></option>
          <%
          }
          else
          {
            %>
          <option value="<%=im%>"><%=new SimpleDateFormat("MMMM").format(new Date(2008,im,01))%></option>
          <%
          }
        }
       %>
        </select></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table align="center" border="0" cellpadding="3" cellspacing="0" width="100%">
      <tbody align="center">
        <tr>
          <th>Sun</th>
          <th>Mon</th>
          <th>Tue</th>
          <th>Wed</th>
          <th>Thu</th>
          <th>Fri</th>
          <th>Sat</th>
        </tr>
        <%
        int cnt =1;
        for(int i=1;i<=iTotalweeks;i++)
        {
        %>
        <tr>
          <% 
            for(int j=1;j<=7;j++)
            {
                if(cnt<weekStartDay || (cnt-weekStartDay+1)>days)
                {
                 %>
                <td align="center" height="35" class="dsb">&nbsp;</td>
               <% 
                }
                else
                {
                 %>
                <td align="center" height="35" id="day_<%=(cnt-weekStartDay+1)%>"><span><%=(cnt-weekStartDay+1)%></span></td>
               <% 
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
</form>
</center>
</body>

</section>


</html>