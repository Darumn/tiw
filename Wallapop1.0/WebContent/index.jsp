
<%@page import="model.*" %>
<%@page import="managers.IndexManager" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
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
	<% for(int i=0; i<lista.size(); i++){%>
	
			<div class="col-md-3">
				<div class="card-product">
				
					<div class="image-product">
						<a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><img src="images/casco.jpg" class="img-responsive" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price"><%= lista.get(i).getPrice() %>&euro;</p>
						 
							<a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><%= lista.get(i).getName() %></a>
							
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<form method="get" action="./Controller">
								<input type="hidden" name="redirect" value="SellerProfile" />
								<input type="hidden" name="seller_id" value="<%= lista.get(i).getUser().getId()%>" />
								<button type="submit" class="btn-link"><%= lista.get(i).getUser().getName() %></button>
							</form>
							<% if(lista.get(i).getUser().getId()!=user.getId()){ %>
							<div class="product-view-info-owner-chat">
								<button type="submit" class="btn-success">Contactar</button>
							</div>
							<%}else{ %>
							<div class="product-view-info-owner-chat">
								<button type="submit" class="btn-success">Contactar</button>
							</div>
							<%} %>
						</div>
					</div>
				
				</div>
			</div>
<%}%>
	
	
		</div>
	</div>
	<%}%>
	
	<%if(user != null){ %>
		<nav>
			<h3>Búsqueda avanzada</h3>
			Categoria: <select>
				<option>Tecnología e Informática</option>
				<option>Coches y Motos</option>
				<option>Deporte y Ocio</option>
				<option>Muebles, Deco y Jardín</option>
				<option>Consolas y Videojuegos</option>
				<option>Libros, Películas y Música</option>
				<option>Moda y Accesorios</option>
				<option>Juguetes, Niños y Bebés</option>
				<option>Inmobiliaria</option>
				<option>Electrodomésticos</option>
				<option>Servicios</option>
				<option>Otros</option>
			</select> 
			Ciudad: <input type="text" placeholder="Buscar ciudad..."	name="search_city" class="explorer_input" />
			Vendedor: <input type="text" placeholder="Buscar Vendedor..."	name="search_seller" class="explorer_input" />
			Título: <input type="text" placeholder="ítulo producto..."	name="search_title" class="explorer_input" />
			Descripción: <input type="text" placeholder="Descripción..."	name="search_description" class="explorer_input" />
			<form method="get" action="./Controller">
			<input type="hidden" name="redirect" value="searchAllProducts">
				<input type="text" placeholder="Buscar producto..."
					name="search_input" class="explorer_input" />
				<button type="submit" class="btn-default" >Buscar</button> 
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
	<% for(int i=0; i<lista.size(); i++){%>
	
			<div class="col-md-3">
				<div class="card-product">
				
					<div class="image-product">
						<a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><img src="images/casco.jpg" class="img-responsive" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price"><%= lista.get(i).getPrice() %>&euro;</p>
						 
							<a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><%= lista.get(i).getName() %></a>
							
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<form method="get" action="./Controller">
								<input type="hidden" name="redirect" value="SellerProfile" />
								<input type="hidden" name="seller_id" value="<%= lista.get(i).getUser().getId()%>" />
								<button type="submit" class="btn-link"><%= lista.get(i).getUser().getName() %></button>
							</form>
							
							<div class="product-view-info-owner-chat">
								<button type="submit" class="btn-success">Contactar</button>
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
