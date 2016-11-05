<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/styleAdmin.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>WallapopAdmin</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<img alt="logo"
				src="http://es.wallapop.com/images/logos/img_logo_header.png"
				id="img_logo">
		</div>
	</div>
	<div class="main">
		<%
			User userOld = (User) (request.getAttribute("old user"));
		%>
		ID:
		<%=userOld.getId()%>
		<br />CITY:
		<%
			if (userOld.getCity() != null) {
		%>
		<%=userOld.getCity()%>
		<%
			}
		%>
		<br />EMAIL:
		<%
			if (userOld.getEmail() != null) {
		%>
		<%=userOld.getEmail()%>
		<%
			}
		%>
		<br />NAME:
		<%
			if (userOld.getName() != null) {
		%>
		<%=userOld.getName()%>
		<%
			}
		%>
		<br />PASSWORD:
		<%
			if (userOld.getPassword() != null) {
		%>
		<%=userOld.getPassword()%>
		<%
			}
		%>
		<br />SURNAME:
		<%
			if (userOld.getSurname() != null) {
		%>
		<%=userOld.getSurname()%>
		<%
			}
		%>

		<br /> <br />Nombre: <br> <input name="name" type="text"
			placeholder="Usuario...">
		</p>

		Primer Apellido: <br> <input name="surname" type="text"
			placeholder="Usuario...">
		</p>
		E-mail:<br> <input name="email" type="text"
			placeholder="Usuario...">
		</p>
		Contraseña:<br> <input name="pass" type="password"
			placeholder="Introduce la contraseña">
		</p>
		Ciudad:<br> <input name="city" type="text"
			placeholder="Introduce tu ciudad">
		</p>
		<input type="submit" value="Actualizar">
	</div>
</body>
<footer> <br>
FOOTER </footer>
</html>