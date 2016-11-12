<%@page import="model.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<div class="main">
	<div id="update-productos">
		<H3>PRODUCTO</H3>
		<form method="post" action="./Controller">
			<input type="hidden" name="redirect" value="RegisterProductManager">
			<h4>Insertar datos producto</h4>
	
			Name: <input type="text" name="productname">
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
			</p>			
			Photo:<input type="file" name="photoproduct">
			</p>
			<button class="btn-default" type="submit" >Guardar</button>
		</form>
	</div>
</div>