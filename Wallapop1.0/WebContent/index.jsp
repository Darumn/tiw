
<%@page import="model.*" %>
<%@page import="managers.IndexManager" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="managers.UpdateProductManager"%>
<%
//IndexManager manager = new IndexManager();
//List<Product> lista = manager.Execute();
Object o=request.getAttribute("product list");
List<Product> lista = (List<Product>)o;
%>
<%@page import="managers.SessionManager" %>
<%@page import="managers.Manager" %>
<%@page import="model.User" %>

<%SessionManager session1 = (SessionManager)request.getAttribute(Manager.CONST_SESSION); 
User user = null;
if(session1!=null){
	user = session1.getUser();
}

%>
<div class="main">
	<%if(user == null){ %>
		
	<div class="container-fluid" style="width: 100%;">
		<h1 style="text-align: center;">BIENVENIDOS A WALLAPOP</h1>
		<p style="text-align: center;">La web en la que podrás encontrar
			productos de todo tipo de otros usuarios</p>
		<% String mensaje = (String)request.getAttribute("mensaje"); %>
		<% if(mensaje != null && !mensaje.equals("")) { %>
		<h3><%= mensaje %></h3>
		<%} %>
		<div class="row">
		<%if(lista.isEmpty()){ %>
			<h3> NO SE ENCONTRARON PRODUCTOS</h3>
			<%} %>
	<% for(int i=0; i<lista.size(); i++){%>
	
			<div class="col-xs-3 col-md-3">
				<div class="card-product">
				
					<div class="image-product">
						<a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><img src="<%=UpdateProductManager.getUrlImage(lista.get(i)) %>" class="img-responsive" alt="<%= lista.get(i).getName()%>"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<div class="product-view-info-price"><b class="text-product">Precio: </b><%= lista.get(i).getPrice() %>&euro;</p></div>
						 
							<div class="product-view-info-name"><b class="text-product">Nombre: </b><a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><%= lista.get(i).getName() %></a></div>
							<div class="product-view-info-category"><b class="text-product">Categoria: </b><%=lista.get(i).getCategory().getName() %></div>
							<div class="product-view-info-city"><b class="text-product">Ubicación: </b><%=lista.get(i).getUser().getCity() %></div>
						
						</div>
						<div class="product-owner">
							<form method="get" action="./Controller">
								<input type="hidden" name="redirect" value="SellerProfile" />
								<input type="hidden" name="seller_id" value="<%= lista.get(i).getUser().getId()%>" />
								<button type="submit" class="btn-user"><%= lista.get(i).getUser().getName() %></button>
							</form>
						</div>
					</div>
				
				</div>
			</div>
<%}%>
	
	
		</div>
	</div>
	<%}%>
	
	<%if(user != null){ %>
		<nav class="advanced-search">
			<h3>Búsqueda avanzada</h3>
			<form method="get" action="./Controller">
			<input type="hidden" name="redirect" value="searchAllProducts" />
				<% List<Category> cat_list= (List<Category>)request.getAttribute("category_list");%>
				Categoría: <br>
				<select name="search_category" class="form-control">
					<option default value="vacio">Seleccionar..</option>
				<% for(int i = 0; i<cat_list.size(); i++){ %>
					<option value="<%= cat_list.get(i).getId()%>"><%=cat_list.get(i).getName() %></option>
					<%} %>
				</select><br>
				Ciudad: <br> <input type="text" placeholder="Buscar ciudad..."	name="search_city" class="form-control" /> <br>
				Vendedor: <br><input type="text" placeholder="Buscar Vendedor..."	name="search_seller" class="form-control" /> <br>

				Título: <br><input type="text" placeholder="Título producto..."	name="search_title" class="form-control" /> <br>
				Descripción: <br><input type="text" placeholder="Descripción..."	name="search_description" class="form-control" /> <br>
				Estado: <br>
				<select name="search_status" class="form-control">
					<option default value="vacio">Seleccionar..</option>
					<option value="disponible">Disponible</option>
					<option value="reservado">Reservado</option>
					<option value="vendido">Vendido</option>
				</select>
				<br>
				<button type="submit" class="btn-info" >Buscar</button> 
			</form>
		</nav>
	<div class="container-fluid" style="width: 80%; float: left;">
		<h1 style="text-align: center;">BIENVENIDOS A WALLAPOP</h1>
		<p style="text-align: center;">La web en la que podrás encontrar
			productos de todo tipo de otros usuarios</p>
		<% String mensaje = (String)request.getAttribute("mensaje"); %>
		<% if(mensaje != null && !mensaje.equals("")) { %>
		<h3><%= mensaje %></h3>
		<%} %>
		
		<div class="row">
		<%if(lista.isEmpty()){ %>
			<h3> NO SE ENCONTRARON PRODUCTOS</h3>
			<%} %>
	<% for(int i=0; i<lista.size(); i++){%>
	
			<div class="col-xs-3 col-md-3">
				<div class="card-product">
				
					<div class="image-product">
						<a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><img src="<%=UpdateProductManager.getUrlImage(lista.get(i)) %>" class="img-responsive" alt="<%= lista.get(i).getName()%>"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<div class="product-view-info-price"><b class="text-product">Precio: </b><%= lista.get(i).getPrice() %>&euro;</p></div>
						 
							<div class="product-view-info-name"><b class="text-product">Nombre: </b><a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><%= lista.get(i).getName() %></a></div>
							<div class="product-view-info-category"><b class="text-product">Categoria: </b><%=lista.get(i).getCategory().getName() %></div>
							<div class="product-view-info-city"><b class="text-product">Ubicación: </b><%=lista.get(i).getUser().getCity() %></div>
						</div>
						<div class="product-owner">
							<form method="get" action="./Controller">
								<input type="hidden" name="redirect" value="SellerProfile" />
								<input type="hidden" name="seller_id" value="<%= lista.get(i).getUser().getId()%>" />
								<button type="submit" class="btn-success"><%= lista.get(i).getUser().getName() %></button>
							</form>
							
							<div class="product-view-info-owner-chat">
								<% if(lista.get(i).getUser().getId()!=user.getId()){ %>
									<form method="post" action="./Controller">
										<input type="hidden" name="redirect" value="sendMessage">
										<input type="hidden" name="receiver_id" value="<%= lista.get(i).getUser().getId()%>"/>
										<input type="text" name="message" placeholder="Contacta con este usuario" class="form-control"/>
										<div class="product-view-info-owner-chat">
											<button type="submit" class="btn-success">Contactar</button>
										</div>
									</form>
								<%}else{ %>
									<div class="product-view-info-owner-chat">
										<a class="btn btn-success" href="./Controller?redirect=viewUpdateProduct&id=<%=lista.get(i).getId()%>">Modificar</a>

										<a class="btn btn-default" href="./Controller?redirect=DeleteProduct&id=<%=lista.get(i).getId()%>">Eliminar</a>
									</div>
								<%}%>
								
							</div>
						</div>
					</div>
				
				</div>
			</div>
<%}%>
	
	
		</div>
	</div>
	<%}%>
</div>
