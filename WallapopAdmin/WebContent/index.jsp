<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="managers.*"%>
<%@include file="includes/header.jsp"%>

<div class="main">
	<%
		SessionAdminManager sessionUser = (SessionAdminManager) request.getAttribute(AdminManager.CONST_SESSION);
		if (sessionUser != null) {
	%>
	HOLA
	<%=sessionUser.getUser().getName()%>
	<form method="post" action="./Controller">
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
	<ul>
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="ShowUsers"> <input
				type="submit" value="Usuarios">
		</form>
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="ShowProducts"> <input
				type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>">
			<input type="submit" value="Productos">
		</form>
	</ul>
</div>
<%@include file="includes/footer.jsp"%>
