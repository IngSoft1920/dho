<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>


<script type="text/javaScript">


//Arrays de datos:
meses=["enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"];
lasemana=["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"]
<<<<<<< Updated upstream
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




=======
diassemana=["lun","mar","mier","juev","vier","sab","dom"];
nHabs=7;
>>>>>>> Stashed changes
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
//rellenarceldas()
}




//FUNCIONES de creación del calendario:
//cabecera del calendario
function cabecera() {
<<<<<<< Updated upstream
     	 ant.innerHTML="anterior";
=======
<<<<<<< Updated upstream
         tit.innerHTML=diasemhoy+" "+meses[mescal]+" de "+annocal;
         mesant=mescal-1; //mes anterior
         mespos=mescal+1; //mes posterior
         if (mesant<0) {mesant=11;}
         if (mespos>11) {mespos=0;}
         ant.innerHTML="anterior";
>>>>>>> Stashed changes
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
//primera línea de tabla: días de la semana.
function rellenarceldas() {
         for (i=0;i<7;i++) {
             celda0=f0.getElementsByTagName("td")[i];
             celda0.innerHTML=habitacionespiso1[i]
=======
         tit.innerHTML=meses[mescal]+" de "+annocal;
         //mesant=mescal-1; //mes anterior
         //mespos=mescal+1; //mes posterior
         //if (mesant<0) {mesant=11;}
         //if (mespos>11) {mespos=0;}
         ant.innerHTML="anterior"//meses[mesant]
         pos.innerHTML="siguiente"//meses[mespos]
         } 
//primera línea de tabla: días de la semana.
function primeralinea() {
         for (i=0;i<nHabs;i++) {
             celda0=f0.getElementsByTagName("th")[i];
             celda0.innerHTML=diassemana[i]
>>>>>>> Stashed changes
             }
         for (i=0;i<7;i++) {
             celda0=f1.getElementsByTagName("td")[i];
             celda0.innerHTML=habitacionespiso2[i]
             }
         for (i=0;i<7;i++) {
             celda0=f2.getElementsByTagName("td")[i];
             celda0.innerHTML=habitacionespiso3[i]
             }
         for (i=0;i<7;i++) {
             celda0=f3.getElementsByTagName("td")[i];
             celda0.innerHTML=habitacionespiso4[i]
             }
         for (i=0;i<7;i++) {
             celda0=f4.getElementsByTagName("td")[i];
             celda0.innerHTML=habitacionespiso5[i]
             }
         for (i=0;i<7;i++) {
             celda0=f5.getElementsByTagName("td")[i];
             celda0.innerHTML=habitacionespiso6[i]
             }
         for (i=0;i<7;i++) {
             celda0=f6.getElementsByTagName("td")[i];
             celda0.innerHTML=habitacionespiso7[i]
             }
             
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
  <table id="diasc">
    <tr id="fila0"><td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">101</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">102</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">103</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">104</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">105</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">106</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">107</a></h3></td></td>
    			   
    			   
    			   
    <tr id="fila1"><td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">101</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">202</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">203</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">204</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">205</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">206</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">207</a></h3></td></td>
    			   
    			   
    <tr id="fila2"><td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">301</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">302</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">303</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">304</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">305</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">306</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">307</a></h3></td></td>
    			   
    			   
    <tr id="fila3"><td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">401</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">402</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">403</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">404</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">405</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">46</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">407</a></h3></td></td>
    			   
    <tr id="fila4"><td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">501</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">502</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">503</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">504</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">505</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">506</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">507</a></h3></td></td>
    			   
    <tr id="fila5"><td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">601</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">602</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">603</a></h3></td>
    			   <td bgcolor="#dc2816"><h3><a href="/homePageDHO/menu/checkin1">604</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">605</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">606</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">607</a></h3></td></td>
    			   
    <tr id="fila6"><td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">701</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">702</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">703</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">704</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">705</a></h3></td>
    			   <td bgcolor="#27a912"><h3><a href="/homePageDHO/menu/checkin1">706</a></h3></td>
    			   <td bgcolor="#EC8B19"><h3><a href="/homePageDHO/menu/checkin1">707</a></h3></td></td>
    			   
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
</html>
