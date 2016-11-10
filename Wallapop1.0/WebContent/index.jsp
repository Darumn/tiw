
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

<div class="main">
	
		<nav>
			<h3>Regiones Populares</h3>
			<ul>
				<li><a href="Formulario.jsp">Provincia de Alacant/Alicante</a>
				<li><a href="Formulario.jsp">Provincia de Barcelona</a>
				<li><a href="Formulario.jsp">Provincia de Madrid</a>
				<li><a href="Formulario.jsp">Provincia de Málaga</a>
				<li><a href="Formulario.jsp">Provincia de Sevilla</a>
				<li><a href="Formulario.jsp">Provincia de Valencia</a>
			</ul>
			</br>
			<h3>Ciudades Populares</h3>
			<ul>
				<li><a href="Formulario.jsp">Barcelona</a>
				<li><a href="Formulario.jsp">Madrid</a>
				<li><a href="Formulario.jsp">Málaga</a>
				<li><a href="Formulario.jsp">Sevilla</a>
				<li><a href="Formulario.jsp">Valencia</a>
				<li><a href="Formulario.jsp">Zaragoza</a>
			</ul>
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
</div>
