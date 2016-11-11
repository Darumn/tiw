<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="managers.SessionAdminManager"%>
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
			Product productOld = (Product) (request.getAttribute("old product"));
		%>
		ID:
		<%=productOld.getId()%>
		<br />DESCRIPTION:
		<%
			if (productOld.getDescription() != null) {
		%>
		<%=productOld.getDescription()%>
		<%
			}
		%>
		<br />NAME:
		<%
			if (productOld.getName() != null) {
		%>
		<%=productOld.getName()%>
		<%
			}
		%>
		<br />PRICE:
		<%
			if (productOld.getPrice() != null) {
		%>
		<%=productOld.getPrice().intValue()%>
		<%
			}
		%>
		<br />STATUS:
		<%
			if (productOld.getStatus() != null) {
		%>
		<%=productOld.getStatus()%>
		<%
			}
		%>
		<br />CATEGORY:
		<%
			if (productOld.getCategory() != null) {
		%>
		<%=productOld.getCategory().getName()%>
		<%
			}
		%>
		<br />USER:
		<%
			if (productOld.getUser() != null) {
		%>
		<%=productOld.getUser().getName()%>
		<%
			}
		%>

		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="EditProduct"> <input
				type="hidden" value="<%=productOld.getId()%>" name="oldId" /> <br />
			<br />Name: <br> <input name="name" type="text"
				placeholder="Name...">
			</p>

			Price: <br> <input name="price" type="text"
				placeholder="Price...">
			</p>
			Status:<br> <input name="status" type="text"
				placeholder="Status...">
			</p>
			Category:<br> <select name="category">
				<option value="coche">Coche</option>
				<option value="copa">Copa</option>
				<option value="electronica">Electronica</option>
				<option value="otros">Otros</option>
			</select>
			</p>
			Description:<br> <input name="description" type="text"
				placeholder="Description...">
			</p>
			<input type="hidden" value="<%=productOld.getUser()%>"
				name="userProduct" /> <input type="submit" value="Update">
		</form>
	</div>
</body>
<footer> <br>
FOOTER </footer>
</html>