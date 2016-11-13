
<%@page import="managers.UserUpdateManager"%>
<%@page import="model.User"%>
<% User usuario=(User)request.getAttribute("user");%>
<div id="section">
	<div id="section1">
		<H3>Bienvenido a tu perfil, <p class="user_profile_name"><%= usuario.getName()%></p></H3>
			<br>
			<div class="user_profile_buttons">
				<form method="get" action="./Controller">
					<input type="hidden" name="redirect" value="chatRoom">
					<button type="submit" class="btn-success">Mis chats</button>
				</form>
				<form method="get" action="./Controller">
					<input type="hidden" name="redirect" value="UserProducts" />
					<input type="hidden" name="id" value="<%= usuario.getId()%>" />
					<button type="submit" class="btn-default">Ver productos</button> 
				</form>
				<form method="get" action="./Controller">
					<input type="hidden" name="redirect" value="insertproduct" />
					<button type="submit" class="btn-info">Insertar Productos</button>
					
				</form>
				<form method="get" action="./Controller">
					<input type="hidden" name="redirect" value="eliminarUsuario" />
					<input type="hidden" name="id" value="<%=usuario.getId() %>" />
					<button type="submit" class="btn-danger">Eliminar Usuario</button>
				</form>
			</div>
	</div>
	<div id="section2">
		<H3>Cambiar datos</H3>
		
		<form method="post" action="./Controller" enctype="multipart/form-data">
			<input type="hidden" name="redirect" value="modificarUsuario">
			<input type="hidden" name="id" value="<%=usuario.getId()%>">
			<h4>Datos personales</h4>
			Nombre: <br> <input name="name" type="text"
				placeholder="Usuario..." value="<%=usuario.getName()%>" class="form-control">
			<br>
			Apellidos: <br> <input name="surname" type="text"
				placeholder="Apellidos..." value="<%=usuario.getSurname()%>" class="form-control">
			<br>
			<h4>Datos de identificación</h4>
			E-mail:<br> <input name="email" type="text"
				placeholder="Email Usuario..." value="<%=usuario.getEmail()%>" class="form-control">
			<br>			
			Contraseña:<br> <input name="pass" type="password"
				placeholder="Introduce la contraseña" class="form-control">
			<br>
			Confirmar Contraseña:<br> <input name="pass2" type="password"
				placeholder="Repite la contraseña" class="form-control">
			<br>
			Ciudad:<br> <input name="city" type="text"
				placeholder="Introduce tu ciudad" value="<%=usuario.getCity()%>" class="form-control">
			<br>
			<button class="btn-info" type="submit" >Actualizar</button>
		</form>
	</div>
</div>
