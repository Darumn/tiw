<%@include file="includes/header.jsp"%>
<%@page import="model.Product" %>
<%Product producto=(Product)request.getAttribute("product");%>
<div class="main">
	<h1 style="text-align: center;">Lista de productos</h1></p>
	<p style="text-align:center"><a href="InsertProducts.jsp"><input type="submit" value="Insertar Productos"></a></p>
	<p>Nombre Producto: <%= producto.getName() %> Descripcion:<%= producto.getDescription() %> Precio:<%=producto.getPrice() %> 
	Status: <%= producto.getStatus() %> Category_id:<%= producto.getCategory() %>  User_id:<%= producto.getId() %>  
	<a href="UpdateProducts.jsp"><input type="submit" value="modificar datos producto"></a>
	<input type="submit" value="Eliminar producto"></p>
</div>
<%@include file="includes/footer.jsp"%>