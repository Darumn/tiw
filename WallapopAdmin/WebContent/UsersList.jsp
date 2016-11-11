<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="managers.SessionAdminManager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/styleAdmin.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Lista Usuarios</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<img alt="logo"
				src="http://es.wallapop.com/images/logos/img_logo_header.png"
				id="img_logo">
		</div>
	</div>
	<h3>LISTA DE USUARIOS</h3>
	<div class="main">
		<%
			SessionAdminManager sessionUser = (SessionAdminManager) (request.getAttribute("sessionUser"));
			if (sessionUser != null) {
		%>
		HOLA
		<%=sessionUser.getUser().getName()%>
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="CloseSession"> <input
				style="display: inline-block" name="close session" type="submit"
				value="Cerrar Sesion">
		</form>
		<%
			}
		%>
		<%
			List<User> usersList = (List<User>) (request.getAttribute("users list"));
			if (usersList == null || usersList.isEmpty()) {
				out.println("LISTA NULA");
			} else if (usersList.isEmpty()) {
				out.println("LISTA VACIA");
			}

			for (int i = 0; i < usersList.size(); i++) {
		%>

		<div name="<%=usersList.get(i).getName()%>">
			<%=usersList.get(i).getName()%>
			<form style="display: inline-block;" method="GET"
				action="./Controller">
				<input type="hidden" name="redirect" value="SelectEditUser">
				<input type="hidden" name="id_object" value="<%=i + 1%>"> <input
					style="display: inline-block;" type="submit" value="Edit">
			</form>

			<form style="display: inline-block;" method="GET"
				action="./Controller">
				<input type="hidden" name="redirect" value="DeleteUser"> <input
					type="hidden" name="id_object" value="<%=i + 1%>"><input
					style="display: inline-block;" type="submit" value="Delete">
			</form>
		</div>
		<%
			}
		%>


	</div>

</body>
</html>