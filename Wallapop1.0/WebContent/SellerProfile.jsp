
<%@page import="managers.UserUpdateManager"%>
<%@page import="model.User"%>
<%@page import="managers.SessionManager" %>
<%@page import="managers.Manager" %>
<% User usuario=(User)request.getAttribute("user");%>
<div id="section">
	<div id="section1">
		<H3>Detalles del perfil</H3>
			Usuario:
			<%= usuario.getName() %>
			<br>
			Email:
			<%= usuario.getEmail() %>rc="" id="img_logo">
			<br>

			<a href="./Controller?redirect=UserProducts&id=<%=usuario.getId()%>">Ver productos</a>
			<br>

	</div>
	<div id="section2">
		<H3>Datos del vendedor</H3>
			Nombre: 
			<%= usuario.getName() %>
			<br>
			Primer Apellido: 
			<%= usuario.getSurname() %>
			<br>
			<h4>Datos de identificación</h4>
			E-mail:
			<%= usuario.getEmail() %>
			<br>
			Ciudad:
			<%= usuario.getCity() %>
			<br>
			<%SessionManager session1 = (SessionManager)request.getAttribute(Manager.CONST_SESSION); 
			User user = null;
			if(session1!=null){
				user = session1.getUser();
			}
			if(user != null){ %>
			<form method="post" action="./Controller">
				<input type="hidden" name="redirect" value="sendMessage">
				<input type="hidden" name="receiver_id" value="<%= usuario.getId()%>"/>
				<input type="text" name="message" placeholder="Contacta con este usuario"/>
				<div class="product-view-info-owner-chat">
					<button type="submit" class="btn-success">Contactar</button>
				</div>
			</form>
			<%} %>
	</div>
</div>
