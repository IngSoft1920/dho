<!DOCTYPE html>
<html>


<style>

* {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	box-sizing:border-box;
}

body {
  background: #DEDEDE;
  display: flex;
  min-height: 100vh;
}

form {
	margin: auto;
	width: 50%;
	max-width: 500px;
	background: #F3F3F3;
	padding: 30px;
	border: 1px solid rgba(0,0,0,0.2);
}

h2{
	text-align: center;
	margin-bottom: 20px;
	color: rgba (0,0,0,0.5);
}

input {
  display: block;
  padding: 10px;
  width: 100%;
  margin: 30px 0;
  font-size: 20px;
}

input[type="submit"]{
	background: linear-gradient(#FFDA63, #FFB940);
	border: 0;
	color: brown;
	opacity: 0.8;
	cursor: pointer;
	border-radius: 20px;
	margin-bottom: 0;
}

input[type="submit"]:hover{
	opacity: 1;
}

input[type="submit"]:active{
	transform: scale(0.95);
}

@media (max-width:768px){
	form{
		width: 75%;
	}
}

@media (max-width: 480px){
	form{
		width: 95%;
	}
}
  
</style>
<html lang="en-US">
<head>
  <title> Employer Log in </title>
  <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimum.scale=1"> 
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">	
</head>



<body>
    <form action="" method="post">
  	<h2>Employer Log in </h2>
  	<input type="text" placeholder="&#128272; Usuario" name="Usuario"required="true">
  	<input type="password" placeholder="&#128272; Clave" name="Password" required="true">
  	<input type="submit" value="Acceder">


  

</body>

</html>