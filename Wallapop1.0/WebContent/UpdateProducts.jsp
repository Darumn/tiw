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
			<div>
				Name: <br><input type="text" name="name" value="<%= producto.getName() %>" class="form-control"/>
			</div>
			<div>
			Descripción: <br><input type="text" name="descriptionproduct" value="<%= producto.getDescription() %>" class="form-control"/>
			</div>
			<div>
			Precio: <br><input type="text" name="pricepproduct" value="<%= producto.getPrice() %>" class="form-control">
			</div>
			<div>
			Estado: <br>
			<select name="statusproduct" class="form-control">
				<option value="disponible">Disponible</option>
				<option value="reservado">Reservado</option>
				<option value="vendido">Vendido</option>
			</select>
			</div>
			<div>
			<% List<Category> lista= (List<Category>)request.getAttribute("category_list");%>
			Categoría: <br>
			<select name="idcategory" class="form-control">
			<% for(int i = 0; i<lista.size(); i++){ %>
			
			
				<option value="<%= lista.get(i).getId()%>"><%=lista.get(i).getName() %></option>
				<%} %>
			</select>
			</div>
			<div>
			Photo: <br> <input type="file" style="display:inline;" name="image" class="form-control" value="<%= UpdateProductManager.getUrlImage(producto)%>">
			</div>
			<button class="btn-success" type="submit">Modificar</a>
	</form>
</div>