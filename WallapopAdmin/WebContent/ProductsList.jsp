<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="managers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="includes/header.jsp"%>
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
		} else {
	%>
	<jsp:forward page="login.jsp" />
	<%
		}
	%>
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
			<input type="hidden" name="id"
				value="<%=sessionUser.getUser().getId()%>"> <input
				type="hidden" name="id_object"
				value="<%=productsList.get(i).getId()%>"> <input
				style="display: inline-block;" type="submit" value="Edit">
		</form>

		<form style="display: inline-block;" method="GET"
			action="./Controller">
			<input type="hidden" name="redirect" value="DeleteProduct"> <input
				type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>">
			<input type="hidden" name="id_object"
				value="<%=productsList.get(i).getId()%>"><input
				style="display: inline-block;" type="submit" value="Delete">
		</form>
	</div>
	<%
		}
	%>
</div>
<%@include file="includes/footer.jsp"%>