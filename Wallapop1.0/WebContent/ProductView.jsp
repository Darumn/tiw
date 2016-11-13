<%@page import="model.*" %>
<%@page import="managers.UpdateProductManager"%>
<%@page import="managers.SessionManager" %>
<%@page import="managers.Manager" %>
<% Product product=(Product)request.getAttribute("product");%>

<div class="row">
	<div class="product-view-container">
			
		<!-- Product info -->
		
			<div class="product-view-info-container">
				<div class="product-view-info-picture">
					<img src="<%= UpdateProductManager.getUrlImage(product)%>" class="img-responsive" style="width:100%;
    				border-width: thin;
   					border-radius: 16px;" alt="<%= product.getName()%>">
					</br>
				</div>
				<div class="product-view-info-price"><b class="text-product">Precio Producto:</b> <%= product.getPrice() %>&euro;</div>
				<div class="product-view-info-name"><b class="text-product">Nombre producto: </b><%= product.getName() %></div>
				<div class="product-view-info-description"><b class="text-product">Descripción del producto: </b><%= product.getDescription() %></div>
				<div class="product-view-info-category"><b class="text-product">Categoria del producto: </b><%=product.getCategory().getName() %></div>
				<div class="product-view-info-city"><b class="text-product">Ubicación: </b><%=product.getUser().getCity() %></div>
				<div class="product-view-info-owner-name">
				<form method="get" action="./Controller">
					<input type="hidden" name="redirect" value="SellerProfile" />
					<input type="hidden" name="seller_id" value="<%= product.getUser().getId() %>" />
					<button type="submit" class="btn-link"><%= product.getUser().getName() %></button>
				</form>
				</div>
				<%
				SessionManager session1 = (SessionManager)request.getAttribute(Manager.CONST_SESSION); 
				User user = null;
				if(session1!=null){
					user = session1.getUser();
				}
				if(user != null){%>
				<div class="product-view-info-owner-chat">
					<form method="post" action="./Controller">
						<input type="hidden" name="redirect" value="sendMessage">
						<input type="hidden" name="receiver_id" value="<%= product.getUser().getId()%>"/>
						<input type="text" name="message" placeholder="Contacta con este usuario"/>
						<div class="product-view-info-owner-chat">
						<button type="submit" class="btn-success">Contactar</button>
					</form>
				</div>
				<%} %>
			</div>
		
	</div>
</div>

