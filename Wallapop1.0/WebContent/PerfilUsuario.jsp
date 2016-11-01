<%@include file="includes/header.jsp"%>
<jsp:useBean id="user" class="managers.UserProfileManager"
	scope="session" />
<div id="section">
	<div id="section1">
		<H3>Detalles del perfil</H3>
		<form method="POST" action="#">
			Usuario:<%= user %>
			</p>
			Email:
			</p>
			<img alt="foto perfil" src="" id="img_logo"></p>
			
			<a href="Viewproductsseller.jsp">Ver productos</a></p>

		</form>
	</div>
	<div id="section2">
		<H3>Cambiar datos</H3>
		<form method="POST" action="">
			Nueva dirección del usuario: <br> <input type="text"
				placeholder="Dirección nueva">
			</p>
			Email nuevo:<br> <input type="text" placeholder="Email nuevo">
			</p>
			Repetir email nuevo:<br> <input type="password"
				placeholder="Repite email nuevo">
			</p>

			Contraseña nueva: <br> <input type="text"
				placeholder="Contraseña nueva">
			</p>
			Repetir contraseña: <br> <input type="text"
				placeholder="Repetir contraseña nueva">
			</p>

			</p>
			<h4>Cambio de foto actual</h4>
			<br> <input type="file" name="fotoperfil" accept="/image">
			</p>
			<input type="submit" value="Guardar">
			</p>
		</form>
	</div>
</div>
<%@include file="includes/footer.jsp"%>