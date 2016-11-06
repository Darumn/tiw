
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
	<div style="width: 20%; float: left;">
		<nav>
			<h3>Regiones Populares</h3>
			<ul>
				<li><a href="Formulario.jsp">Provincia de Alacant/Alicante</a>
				<li><a href="Formulario.jsp">Provincia de Barcelona</a>
				<li><a href="Formulario.jsp">Provincia de Madrid</a>
				<li><a href="Formulario.jsp">Provincia de Málaga</a>
				<li><a href="Formulario.jsp">Sevilla</a>
				<li><a href="Formulario.jsp">Valencia</a>
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
	</div>
	<div class="container-fluid" style="width: 80%; float: left;">
		<h1 style="text-align: center;">BIENVENIDOS A WALLAPOP</h1>
		<p style="text-align: center;">La web en la que podrás encontrar
			productos de todo tipo de otros usuarios</p>
		<div class="row">
	<% for(int i=0; i<lista.size(); i++){%>
	
			<div class="col-md-3">
				<div class="card-product">
				
					<div class="image-product">
						<a href="HomeController<%="?id="+1%>"><img src="images/casco.jpg" class="img-responsive" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price"><%= lista.get(i).getPrice() %>&euro;</p>
						 
							<a href="Controller?redirect=Product&id=<%=lista.get(i).getId()%>"><%= lista.get(i).getName() %></a>
							
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<a href="Vendedor.jsp"><p class="owner-name"><%= lista.get(i).getUser().getName()%></p></a>
							<div class="product-view-info-owner-chat">
								<button class="btn-success">Contactar</button>
							</div>
						</div>
					</div>
				
				</div>
			</div>
<%}%>
	
	
		</div>
	</div>
