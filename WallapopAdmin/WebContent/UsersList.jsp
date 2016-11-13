<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="managers.SessionAdminManager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="includes/header.jsp"%>
<div class="main">
	<%
		SessionAdminManager sessionUser = (SessionAdminManager) (request.getAttribute("sessionUser"));
		if (sessionUser == null) {
	%>
	<jsp:forward page="login.jsp" />
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
	%>

	<div class="returnIndex">
		<form method="GET" action="./Controller">
			<input type="hidden" value="ReturnIndex" name="redirect" id="return" />
			<input type="hidden" value="<%=sessionUser.getUser().getId()%>"
				name="id" /> <input type="submit" value="Return" />
		</form>
	</div>


	<div class="usersList">
		<%
			for (int i = 0; i < usersList.size(); i++) {
		%>
		<div class="rowsUsers">
			<div name="<%=usersList.get(i).getName()%>">
				<%=usersList.get(i).getName()%>
			</div>
			<div>
				<form style="display: inline-block;" method="GET"
					action="./Controller">
					<input type="hidden" name="redirect" value="SelectEditUser">
					<input type="hidden" name="id"
						value="<%=sessionUser.getUser().getId()%>"> <input
						type="hidden" name="id_object"
						value="<%=usersList.get(i).getId()%>"> <input
						style="display: inline-block;" type="submit" value="Edit">
				</form>

				<form style="display: inline-block;" method="GET"
					action="./Controller">
					<input type="hidden" name="redirect" value="DeleteUser"> <input
						type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>"><input
						type="hidden" name="id_object"
						value="<%=usersList.get(i).getId()%>"><input
						style="display: inline-block;" type="submit" value="Delete">
				</form>

				<form style="display: inline-block;" method="GET"
					action="./Controller">
					<input type="hidden" name="redirect" value="sendMessage"> <input
						type="hidden" name="receiver_id"
						value="<%=usersList.get(i).getId()%>"> <input
						type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>">
					<input type="text" name="message" style="display: inline-block;"
						placeholder="Enviar mensaje.." /> <input
						style="display: inline-block;" type="submit"
						value="Enviar mensaje">
				</form>
			</div>
		</div>
		<%
			}
		%>
	</div>
</div>
<%@include file="includes/footer.jsp"%>