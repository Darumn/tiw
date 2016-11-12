<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="managers.SessionAdminManager"%>
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
	<form method="GET" action="./Controller">
		<input type="hidden" name="redirect" value="EditUser"> <input
			type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>">
		<input type="hidden" value="<%=userOld.getId()%>" name="oldId" /> <br />
		<br />Nombre: <br> <input name="name" type="text"
			placeholder="Usuario...">
		</p>

		Primer Apellido: <br> <input name="surname" type="text"
			placeholder="Usuario...">
		</p>
		E-mail:<br> <input name="email" type="text"
			placeholder="Usuario...">
		</p>
		Contraseña:<br> <input name="password" type="password"
			placeholder="Introduce la contraseña">
		</p>
		Ciudad:<br> <input name="city" type="text"
			placeholder="Introduce tu ciudad">
		</p>
		<input type="submit" value="Actualizar">
	</form>
</div>
<%@include file="includes/footer.jsp"%>