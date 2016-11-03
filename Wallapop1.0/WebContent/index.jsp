<%@include file="includes/header.jsp"%>
<%@page import="model.Product" %>
<%Product producto=(Product)request.getAttribute("product"); %>
<div class="main">
	<div style="width: 20%; float: left;">
		<nav>
			<h3>Regiones Populares</h3>
			<ul>
				<li><a href="Formulario.jsp">Provincia de Alacant/Alicante</a>
				<li><a href="Formulario.jsp">Provincia de Barcelona</a>
				<li><a href="Formulario.jsp">Provincia de Madrid</a>
				<li><a href="Formulario.jsp">Provincia de M�laga</a>
				<li><a href="Formulario.jsp">Sevilla</a>
				<li><a href="Formulario.jsp">Valencia</a>
			</ul>
			</br>
			<h3>Ciudades Populares</h3>
			<ul>
				<li><a href="Formulario.jsp">Barcelona</a>
				<li><a href="Formulario.jsp">Madrid</a>
				<li><a href="Formulario.jsp">M�laga</a>
				<li><a href="Formulario.jsp">Sevilla</a>
				<li><a href="Formulario.jsp">Valencia</a>
				<li><a href="Formulario.jsp">Zaragoza</a>
			</ul>
		</nav>
	</div>
	<div class="container-fluid" style="width: 80%; float: left;">
		<h1 style="text-align: center;">BIENVENIDOS A WALLAPOP</h1>
		<p style="text-align: center;">La web en la que podr�s encontrar
			productos de todo tipo de otros usuarios</p>
		<div class="row">
			
			<div class="col-xs-4 col-md-3 col-lg-2">
				<div class="card-product">
					<div class="image-product">
						<a href="HomeController<%="?id="+1%>"><img src="images/casco.jpg" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price">65$</p>
							id: <%= producto.getId() %>
							<a href="HomeController<%="?id="+1%>"><p class="product-name">Spartan Helmet</p>
							</a>
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<a href="Vendedor.jsp"><p class="owner-name">Mario Gonzalo</p></a>
							<div class="product-view-info-owner-chat">
								<button class="btn-success">Contactar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-4 col-md-3 col-lg-2">
				<div class="card-product">
					<div class="image-product">
						<a href="HomeController<%="?id="+2%>"><img src="images/casco.jpg" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price">65$</p>
							<a href="HomeController<%="?id="+1%>"><p class="product-name">Spartan Helmet</p>
							</a>
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<a href="Vendedor.jsp"><p class="owner-name">Mario Gonzalo</p></a>
							<div class="product-view-info-owner-chat">
								<button class="btn-success">Contactar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-4 col-md-3 col-lg-2">
				<div class="card-product">
					<div class="image-product">
						<a href="HomeController<%="?id="+3%>"><img src="images/casco.jpg" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price">65$</p>
							<a href="HomeController<%="?id="+1%>"><p class="product-name">Spartan Helmet</p>
							</a>
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<a href="Vendedor.jsp"><p class="owner-name">Mario Gonzalo</p></a>
							<div class="product-view-info-owner-chat">
								<button class="btn-success">Contactar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>