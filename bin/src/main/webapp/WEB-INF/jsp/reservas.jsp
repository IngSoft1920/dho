<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>


	<head>
	Reservas
	</head>

	<body style="background-color:lightblue;">
	
	<ul>
		<c:forEach items="${listaReservas}" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
	
	</body>
				
	
</html>