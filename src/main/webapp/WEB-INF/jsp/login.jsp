<html>


<head>
	<meta charset="utf-8">
	<title>Página de inicio</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>



<body>
	
<section class="form-login">
	<h5>Login</h5>
	
	<form method="POST" modelAttribute="loginBean";>
		
		<label>Usuario</label>
			<form:input type="text" name="usuario" path="usuario" />
			<input class="controls" type="text" name="Usuario" required="true" >
			
		<br>
		<label>Contrasena</label>
			<form:input type="password" name="password" path="password" />
			<input class="controls" type="password" name="Password" required="true" >
		</br>
		<input class="buttons" type="acceder" name="" value="Ingresar" />
	</form:form>

			
</section>
</body>


</html>