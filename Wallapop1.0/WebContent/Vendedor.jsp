<%@include file="includes/header.jsp"%>
<div class="main">
	<div id="viewseller">
		<div class="card-profile-seller">
			<p>Mario</p>
			<p>Link del perfil</p>
			<p>Productos vendidos</p>
		</div>
	</div>
	<div class="totalproductsseller">
		<p> products</p>
	</div>
	<div id="productsseller">
		<div class="row">
			<div class="col-xs-4 col-md-3 col-lg-2">
				<div class="card-product">
					<div class="image-product">
						<a href="HomeController<%="?id="+1%>"><img src="images/casco.jpg" alt="Casco"></a>
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
						<a href="HomeController<%="?id="+2%>"><img src="images/casco.jpg" alt="Casco"></a>
					</div>
					<div class="product-info">
						<div class="info-container">
							<p class="product-price">65$</p>
							<p class="product-name">Spartan Helmet</p>
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
							<p class="product-name">Spartan Helmet</p>
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
	
</div>
<%@include file="includes/footer.jsp"%>