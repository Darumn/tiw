<%@page import="managers.UserUpdateManager"%>
<%@page import="model.Product"%>
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
		Category_id:<%= producto.getCategory() %>
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
			Status:<input type="text" name="statusproduct">
			</p>
			Category_id:<input type="text" name="idcategory">
			</p>
			
			Photo:<input type="file" name="photoproduct">
			</p>
			<a class="btn-success" href="./Controller?redirect=updateProductUser&id=<%=producto.getId()%>">Modificar</a>
	</form>
</div>