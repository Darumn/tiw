<%@include file="includes/header.jsp"%>

<div id="section">
	<div id="section1">
		<H3>INICIA SESI�N</H3>
		<form method="POST" action="PerfilUsuario.jsp">
			Usuario: <br> <input type="text" placeholder="Usuario...">
			</p>
			Contrase�a:<br> <input type="password"
				placeholder="Introduce la contrase�a">
			</p>
			<input type="submit" value="Iniciar sesi�n">

		</form>
	</div>
	<div id="section2">
		<H3>REGISTRO</H3>
		<form method="GET" action="./Controller">
		<input type="hidden" name="redirect" value="RegisterUserManager">
		<h4>Datos personales</h4>
			Nombre: <br> <input name="name" type="text"
				placeholder="Usuario...">
			</p>
			Primer Apellido: <br> <input name="surname" type="text"
				placeholder="Usuario...">
			</p>
			<h4>Datos de identificaci�n</h4>
			E-mail:<br> <input name="email" type="text"
				placeholder="Usuario...">
			</p>
			Confirmar e-mail:<br> <input name="email2" type="text"
				placeholder="Repite tu nombre de usuario...">
			</p>
			Contrase�a:<br> <input name="pass" type="password"
				placeholder="Introduce la contrase�a">
			</p>
			Confirmar Contrase�a:<br> <input name="pass2" type="password"
				placeholder="Repite la contrase�a">
			</p>
			Ciudad:<br> <input name="city" type="text"
				placeholder="Introduce tu ciudad">
			</p>
			<br>
			
			<input type="checkbox"> Soy mayor de edad y he leido y acepto
			los t�rminos y condiciones de la pol�tica de seguridad y
			confidencialidad de Wallapop
			</p>
			<input type="submit" value="Registrarse">
		</form>
	</div>
</div>

<%@include file="includes/footer.jsp"%>