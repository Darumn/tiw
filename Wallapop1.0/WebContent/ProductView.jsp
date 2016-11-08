<%@page import="model.Product" %>
<% Product product=(Product)request.getAttribute("product");%>

<div class="row">
	<div class="product-view-container">
		<!-- Product images -->
		<div class="col-xs-6 col-md-6 col-sm-6">
			<div class="product-view-img-container">
				<img src="images/casco.jpg" class="img-responsive" alt="Casco">
			</div>
		</div>
		<!-- Product info -->
		<div class="col-xs-6 col-md-6 col-sm-6">
			<div class="product-view-info-container">
				<div class="product-view-info-price"><%= product.getPrice() %>&euro;</div>
				<div class="product-view-info-name"><%= product.getName() %></div>
				<div class="product-view-info-description"><%= product.getDescription() %></div>
				<div class="product-view-info-owner-name">
				<form method="get" action="./Controller">
					<input type="hidden" name="redirect" value="SellerProfile" />
					<input type="hidden" name="seller_id" value="<%= product.getUser().getId() %>" />
					<button type="submit" class="btn-link"><%= product.getUser().getName() %></button>
				</form>
				</div>
				<div class="product-view-info-owner-chat">
					<button class="btn-success">Contactar</button>
				</div>
			</div>
		</div>
	</div>
</div>

