<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.User"%>
<%@page import="managers.SessionManager"%>
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
			SessionManager sessionUser = (SessionManager) (request.getAttribute("sessionUser"));
			if (sessionUser != null) {
		%>
		HOLA
		<%=sessionUser.getUser().getName()%>
		<%
			}
		%>

		<%
			
		%>
		<ul>
			<form method="GET" action="./Controller">
				<input type="hidden" name="redirect" value="ShowUsers"> <input
					type="submit" value="Usuarios">
			</form>
			<li><a href="ProductsList.jsp">Productos</a></li>
		</ul>
	</div>
</body>
<footer> <br>
FOOTER </footer>
</html>