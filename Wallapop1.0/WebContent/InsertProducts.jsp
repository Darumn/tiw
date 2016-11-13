<%@page import="model.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<div class="main">
	<div id="update-productos">
		<H3>PRODUCTO</H3>
		<form method="post" action="./Controller" enctype="multipart/form-data">
			<input type="hidden" name="redirect" value="RegisterProductManager">
			<h4>Insertar datos producto</h4>
			<div>
			Name: <br> <input type="text" name="productname" class="form-control">
			</div>
			<div>
				Descripción: <br><input type="text" name="descriptionproduct" class="form-control">
			</div>
			<br>
			<div>
				Precio: <br><input type="text" name="pricepproduct" class="form-control">
			</div>
			<br>
			<div>
				Estado: <br>
				<select name="statusproduct" class="form-control">
					<option value="disponible">Disponible</option>
					<option value="reservado">Reservado</option>
					<option value="vendido">Vendido</option>
				</select>
			</div>
			<br>
			<div>
				<% List<Category> lista= (List<Category>)request.getAttribute("category_list");%>
				Categoría: <br>
				<select name="idcategory" class="form-control">
				<% for(int i = 0; i<lista.size(); i++){ %>
					<option value="<%= lista.get(i).getId()%>"><%=lista.get(i).getName() %></option>
					<%} %>
				</select>
			</div>
						
			
			<button class="btn-success" type="submit" >Guardar</button>
		</form>
	</div>
</div>