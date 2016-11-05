<%@page import="model.Product" %>
<% Object o=request.getAttribute("product list");
Product product = (Product)o;%>

<div class="row">
	<div class="product-view-container">
		<!-- Product images -->
		<div class="col-xs-6 col-md-6 col-sm-6">
			<div class="product-view-img-container">
				<img src="images/casco.jpg" alt="Casco">
			</div>
		</div>
		<!-- Product info -->
		<div class="col-xs-6 col-md-6 col-sm-6">
			<div class="product-view-info-container">
				<div class="product-view-info-price"><%= product.getPrice() %>€</div>
				<div class="product-view-info-name"><%= product.getName() %></div>
				<div class="product-view-info-description"><%= product.getDescription() %></div>
				<div class="product-view-info-owner-name">
					<a href="Vendedor.jsp"><%= product.getUser().getName() %></a>
				</div>
				<div class="product-view-info-owner-chat">
					<button class="btn-success">Contactar</button>
				</div>
			</div>
		</div>
	</div>
</div>


<%@include file="includes/footer.jsp"%>