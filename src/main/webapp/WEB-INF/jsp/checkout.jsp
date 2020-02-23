<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

	<body style="background-color:lightblue;">
		<style>
			a { text-decoration: none; }
		</style>
	</body>
	
	<ul>
		<c:forEach items="${lista}" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
	
	<form method="POST">
		<label>estancia_id</label>
		<input type="text" name="estancia_id" autocomlete="off" />
		<br>
		<input type="submit" value="Registro">
		<br>
	</form>
	
	
	
	
	
</html>
