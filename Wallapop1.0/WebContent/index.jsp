<%@include file="includes/header.jsp"%>
<div class="explorer">
	<select>
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
	</select> <input type="text" placeholder="Buscar producto..."
		name="explorer_input" class="explorer_input" />
</div>
<div class="account">
	<a href="Formulario.jsp" class="account_link">INICIAR SESIÓN |
		REGISTRO</a>
</div>
</div>
<div class="main">
	<div style="width: 20%; float: left;">
		<nav>
			<h3>Regiones Populares</h3>
			<ul>
				<li><a href="#">Provincia de Alacant/Alicante</a>
				<li><a href="#">Provincia de Barcelona</a>
				<li><a href="#">Provincia de Madrid</a>
				<li><a href="#">Provincia de Málaga</a>
				<li><a href="#">Sevilla</a>
				<li><a href="#">Valencia</a>
			</ul>
			</br>
			<h3>Ciudades Populares</h3>
			<ul>
				<li><a href="#">Barcelona</a>
				<li><a href="#">Madrid</a>
				<li><a href="#">Málaga</a>
				<li><a href="#">Sevilla</a>
				<li><a href="#">Valencia</a>
				<li><a href="#">Zaragoza</a>
			</ul>
		</nav>
	</div>
	<div class="container-fluid" style="width: 80%; float: left;">
		<h1 style="text-align: center;">BIENVENIDOS A WALLAPOP</h1>
		<p style="text-align: center;">La web en la que podrás encontrar
			productos de todo tipo de otros usuarios</p>
		<div class="row">
			<div class="col-xs-4 col-md-3 col-lg-2">
				<div class="card-product">
					<div class="image-product">
						<img src="images/casco.jpg" alt="Casco">
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price">65$</p>
							<p class="product-name">Spartan Helmet</p>
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<p class="owner-name">Mario Gonzalo</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-4 col-md-3 col-lg-2">
				<div class="card-product">
					<div class="image-product">
						<img src="images/casco.jpg" alt="Casco">
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price">65$</p>
							<p class="product-name">Spartan Helmet</p>
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<p class="owner-name">Mario Gonzalo</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-4 col-md-3 col-lg-2">
				<div class="card-product">
					<div class="image-product">
						<img src="images/casco.jpg" alt="Casco">
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price">65$</p>
							<p class="product-name">Spartan Helmet</p>
							<p class="product-category">Others...</p>
						</div>
						<div class="product-owner">
							<p class="owner-name">Mario Gonzalo</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>