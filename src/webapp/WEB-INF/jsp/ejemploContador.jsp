<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	Ejemplo Contador
</head>
<body>
	<div>
	<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<h1>
			Numero de visitas ${ejemploContadorBean.contadorVisitas}
		</h1>
		<h2>Horario de las visitas:</h2>
		<ol>
			<!-- Con esta etiqueta podemos iterar sobre un List de Java. El item que esta en la iteracion se guarda en 
			la variable hora, y la lista de items sobre los que iterar se pone en items
			Esto equivaldria en Java a:
			
			for each(String hora : ejemploContadorBean.getListaHoras()){...}
			
			Notad que en jsp teneis que poner el nombre del campo de la clase, no el getter o setter. Spring
			automaticamente identifica el campo con el getter y lo ejecuta por vosotros. -->
			<c:forEach items="${ejemploContadorBean.listaHoras}" var="hora">
			<li>
				${hora}
			</li>
			</c:forEach>
		</ol>
	</div>
	<form:form method="POST" action="setContador"
		modelAttribute="ejemploContadorBean">
		<label>Nombre de usuario</label>
		<form:input type="text" name="contadorVisitas" path="contadorVisitas" />
		<input type="submit" value="Set Contador">
		<br>
	</form:form>
</body>
</html>