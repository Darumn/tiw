
<%@page import="managers.UserUpdateManager"%>
<%@page import="model.User"%>
<% User usuario=(User)request.getAttribute("user");%>
<div id="section">
	<div id="section1">
		<H3>Detalles del perfil</H3>
		<form method="POST" action="#">
			Nombre Usuario:
			<%= usuario.getName() %>
			<br>
			Email Usuario:<%= usuario.getEmail() %>
			<br>
			<img alt="foto perfil" src="" id="img_logo">
			<br>

			<a href="./Controller?redirect=UserProducts&id=<%=usuario.getId()%>">Ver productos</a>
		
			<br>

		</form>
		<form method="get" action="./Controller">
				<input type="hidden" name="redirect" value="insertproduct" />
				<p style="text-align:center"><input type="submit" value="Insertar Productos"></p>
				
			</form>
		
	</div>
	<div id="section2">
		<H3>Cambiar datos</H3>
		<form method="post" action="./Controller" enctype="multipart/form-data">
			<input type="hidden" name="redirect" value="modificarUsuario">
			<input type="hidden" name="id" value="<%=usuario.getId()%>">
			<h4>Datos personales</h4>
			Nombre: <br> <input name="name" type="text"
				placeholder="Usuario...">
			<br>
			Apellidos: <br> <input name="surname" type="text"
				placeholder="Apellidos...">
			<br>
			<h4>Datos de identificación</h4>
			E-mail:<br> <input name="email" type="text"
				placeholder="Email Usuario...">
			<br>			
			Contraseña:<br> <input name="pass" type="password"
				placeholder="Introduce la contraseña">
			<br>
			Confirmar Contraseña:<br> <input name="pass2" type="password"
				placeholder="Repite la contraseña">
			<br>
			Ciudad:<br> <input name="city" type="text"
				placeholder="Introduce tu ciudad">
			<br>
			
			Foto de perfil:<br> <input name="image" type="file" accept="*/image" >
			<br>
			<img src="<%= UserUpdateManager.getUrlImage(usuario)%>" /> 
			<br>
			<input type="submit" value="Actualizar">
		</form>
	</div>
</div>
