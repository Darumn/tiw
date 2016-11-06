
<%@page import="managers.UserUpdateManager"%>
<%@page import="model.User"%>
<% User usuario=(User)request.getAttribute("user");%>
<div id="section">
	<div id="section1">
		<H3>Detalles del perfil</H3>
		<form method="POST" action="#">
			Usuario:
			<%= usuario.getName() %>
			<br>
			Email:
			<%= usuario.getEmail() %>
			<br>
			<img alt="foto perfil" src="" id="img_logo">
			<br>

			<a href="./Controller?redirect=UserProducts&id=<%=usuario.getId()%>">Ver productos</a>
			<br>

		</form>
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
			
			Foto de perfil:<br> <input name="image" type="file" accept="*/image" >
			<br>
			<form method="get" action="./Controller">
				<input type="hidden" name="redirect" value="ChatUser" />
				<input type="hidden" name="user_id" value="<%= usuario.getId()%>" />
				<button type="submit" class="btn-success">Contactar</button>
			</form>
	</div>
</div>
