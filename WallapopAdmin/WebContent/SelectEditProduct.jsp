<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="managers.SessionAdminManager"%>
<%@page import="model.*"%>
<%@page import="logic.*"%>
<%@ page import="java.util.List"%>
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
	<div class="editProductDetails">
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
				type="hidden" name="id" value="<%=sessionUser.getUser().getId()%>"><input
				type="hidden" value="<%=productOld.getId()%>" name="oldId" /> <br />
			<br />Name: <br> <input name="name" type="text"
				placeholder="Name...">
			</p>

			Price: <br> <input name="price" type="text"
				placeholder="Price...">
			</p>
			Status:<br> <select name="status">
				<option value="disponible">Disponible</option>
				<option value="reservado">Reservado</option>
				<option value="vendido">Vendido</option>
			</select>
			</p>
			Category:<br> <select name="category">
				<%
				CategoryManager man = new CategoryManager();
				List<Category> categoryList = man.findAll();

				if (categoryList != null) {
					for (int i = 0; i < categoryList.size(); i++) {
			%>

				<option value="<%=categoryList.get(i).getId()%>">
					<%=categoryList.get(i).getName()%>
				</option>

				<%
				}
			%>
				<%
				}
			%>
			</select>
			</p>
			Description: <br> <input name="description" type="text"
				placeholder="Description...">
			</p>
			<input type="hidden" value="<%=productOld.getUser()%>"
				name="userProduct" /> <input type="submit" value="Update">
		</form>
	</div>
</div>
<%@include file="includes/footer.jsp"%>