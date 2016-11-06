<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/styleAdmin.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Lista Productos</title>
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
			List<Product> productsList = (List<Product>) (request.getAttribute("products list"));
			if (productsList == null || productsList.isEmpty()) {
				out.println("LISTA NULA");
			} else if (productsList.isEmpty()) {
				out.println("LISTA VACIA");
			}

			for (int i = 0; i < productsList.size(); i++) {
		%>

		<div name="<%=productsList.get(i).getName()%>">
			<%=productsList.get(i).getName()%>
			<%=productsList.get(i).getPrice()%>
			<form style="display: inline-block;" method="GET"
				action="./Controller">
				<input type="hidden" name="redirect" value="SelectEditProduct">
				<input type="hidden" name="id_object" value="<%=i + 1%>"> <input
					style="display: inline-block;" type="submit" value="Edit">
			</form>

			<form style="display: inline-block;" method="GET"
				action="./Controller">
				<input type="hidden" name="redirect" value="DeleteProduct">
				<input type="hidden" name="id_object" value="<%=i + 1%>"><input
					style="display: inline-block;" type="submit" value="Delete">
			</form>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>