<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="main">
	<%
		String error = (String) request.getAttribute("error");
		if (error != null && error.equals("error")) {
	%>
	<h4>USERNAME OR PASSWORD INVALID</h4>
	<%
		}
	%>
	<form method="GET" action="./Controller">
		<input type="hidden" name="redirect" value="AdminLogin"> <br />Nombre:
		<br> <input name="user" type="text" placeholder="Usuario...">
		</p>
		Contraseña:<br> <input name="password" type="password"
			placeholder="Introduce la contraseña">
		</p>
		<input name="sesion" type="submit" value="Iniciar Sesion">
	</form>
</div>
<%@include file="includes/footer.jsp"%>