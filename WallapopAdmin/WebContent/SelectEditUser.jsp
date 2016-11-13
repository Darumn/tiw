<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="managers.SessionAdminManager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="includes/header.jsp"%>
<%
	SessionAdminManager sessionUser = (SessionAdminManager) (request.getAttribute("sessionUser"));
%>
<div class="main">
	<div class="returnIndex">
		<form method="GET" action="./Controller">
			<input type="hidden" value="ReturnIndex" name="redirect" id="return" />
			<input type="hidden" value="<%=sessionUser.getUser().getId()%>"
				name="id" /> <input type="submit" value="Return" />
		</form>
	</div>
	<div class="editUserDetails">
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
				placeholder="Name...">
			</p>

			Primer Apellido: <br> <input name="surname" type="text"
				placeholder="Surname...">
			</p>
			E-mail:<br> <input name="email" type="text"
				placeholder="Email...">
			</p>
			Contraseña:<br> <input name="password" type="password"
				placeholder="Password...">
			</p>
			Ciudad:<br> <input name="city" type="text" placeholder="Cuty...">
			</p>
			<input type="submit" value="Actualizar">
		</form>
	</div>
</div>
<%@include file="includes/footer.jsp"%>