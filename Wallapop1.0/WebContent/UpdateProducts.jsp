<%@page import="managers.UpdateProductManager"%>
<%@page import="model.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<% Product producto=(Product)request.getAttribute("product");%>
<div id="update-productos">
	<H3>PRODUCTO</H3>
		<form method="post" action="./Controller" enctype="multipart/form-data">
			<input type="hidden" name="redirect" value="modificarproductousuario" />
			<input type="hidden" name="id" value="<%=producto.getId()%>" />
			<h4>Modificar campos</h4>
			Name: <input type="text" name="name" value="<%= producto.getName() %>"/>
			</p>
			Descripción:<input type="text" name="descriptionproduct" value="<%= producto.getDescription() %>"/>
			</p>
			Precio:<input type="text" name="pricepproduct" value="<%= producto.getPrice() %>">
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
			
			Photo:<input type="file" name="image" value="<%= UpdateProductManager.getUrlImage(producto)%>">
			</p>
			<button class="btn-success" type="submit">Modificar</a>
	</form>
</div>