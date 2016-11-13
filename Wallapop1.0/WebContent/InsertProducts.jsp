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
			Name: <input type="text" name="productname">
			</div>
			<div>
				Descripción:<input type="text" name="descriptionproduct">
			</div>
			<div>
				Precio:<input type="text" name="pricepproduct">
			</div>
			<div>
				Status:
				<select name="statusproduct">
					<option value="disponible">Disponible</option>
					<option value="reservado">Reservado</option>
					<option value="vendido">Vendido</option>
				</select>
			</div>
			<div>
				<% List<Category> lista= (List<Category>)request.getAttribute("category_list");%>
				Category_id:
				<select name="idcategory">
				<% for(int i = 0; i<lista.size(); i++){ %>
					<option value="<%= lista.get(i).getId()%>"><%=lista.get(i).getName() %></option>
					<%} %>
				</select>
			</div>
						
			
			<button class="btn-default" type="submit" >Guardar</button>
		</form>
	</div>
</div>