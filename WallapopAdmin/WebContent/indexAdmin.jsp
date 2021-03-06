<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="managers.SessionAdminManager"%>
<%@include file="includes/header.jsp"%>

<div class="main">
	<%
		SessionAdminManager sessionUser = (SessionAdminManager) (request.getAttribute("sessionUser"));
	%>

	<ul>
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="ShowUsers"> <input
				type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>">
			<input class="usersButton" type="submit" value="Usuarios">
		</form>
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="ShowProducts"> <input
				type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>">
			<input class="productsButton" type="submit" value="Productos">
		</form>
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="ChatRoom"> <input
				type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>">
			<input type="submit" value="Mis chats">
		</form>
	</ul>
</div>
<%@include file="includes/footer.jsp"%>
