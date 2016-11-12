<%@page import="managers.UserUpdateManager"%>
<%@page import="model.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<% Product producto=(Product)request.getAttribute("product");%>
<div id="update-productos">
	<H3>PRODUCTO</H3>
	<form method="POST" action="#">
		<h4>Datos actuales</h4>
		Name:<%= producto.getName() %>
		</p>
		Descripción:<%= producto.getDescription() %>
		</p>
		Precio:<%= producto.getPrice() %>
		</p>
		Status:<%=producto.getStatus() %>
		</p>
		Category: <%= producto.getCategory().getName() %>
		</p>
		
		Photo:
		</p>
		<br>
		<form method="post" action="./Controller" enctype="multipart/form-data">
			<input type="hidden" name="redirect" value="updateProductUser">
			<input type="hidden" name="id" value="<%=producto.getId()%>">
			<h4>Modificar campos</h4>
			Name: <input type="text" name="name">
			</p>
			Descripción:<input type="text" name="descriptionproduct">
			</p>
			Precio:<input type="text" name="pricepproduct">
			</p>
			Status:
			<select name="statusproduct">
				<option value="disponible">Disponible</option>
				<option value="reservado">Reservado</option>
				<option value="vendido">Vendido</option>
			</select>
			</p>
			<% List<Category> lista= (List<Category>)request.getAttribute("category_list");%>
			Category_id:
			<select name="idcategory">
			<% for(int i = 0; i<lista.size(); i++){ %>
			
			
				<option value="<%= lista.get(i).getId()%>"><%=lista.get(i).getName() %></option>
				<%} %>
			</select>
			
			Photo:<input type="file" name="photoproduct">
			</p>
			<button class="btn-success" type="submit">Modificar</a>
	</form>
</div>