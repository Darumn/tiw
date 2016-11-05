
<%@page import="model.Product" %>
<%@page import="java.util.List"%>
<%
//IndexManager manager = new IndexManager();
//List<Product> lista = manager.Execute();
Object o=request.getAttribute("product list");
List<Product> lista = (List<Product>)o;
%>
<div class="main">
	<h1 style="text-align: center;">Lista de productos</h1></p>
	<p style="text-align:center"><a href="InsertProducts.jsp"><input type="submit" value="Insertar Productos"></a></p>
	<div class="row">
	<% for(int i=0; i<lista.size(); i++){%>
		<div class="col-md-3">
				<div class="card-product">
					<div class="image-product">
						<a href="HomeController<%="?id="+1%>"><img src="images/casco.jpg" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p >id: <%= lista.get(i).getId() %></p>
						 
							<p> Name: <%= lista.get(i).getName() %></p>
							
							<p >Description: <%= lista.get(i).getDescription() %></p>
							<p >Price: <%= lista.get(i).getPrice() %></p>
							<p >Status: <%= lista.get(i).getStatus() %></p>
							<p >Category: <%= lista.get(i).getCategory() %></p>
							<p >User_id: <%= lista.get(i).getUser() %></p>
							
						</div>
						
								<a class="btn btn-default" href="UpdateProducts.jsp">modificar</a>
								<a class="btn btn-default" href="#">Eliminar</a>
						
					</div>
				</div>
			</div>
			
	<%}%>
	</div>
	
</div>
