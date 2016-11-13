
<div id="section">
	<div id="section1">
		<H3>INICIA SESIÓN</H3>
		<form method="post" action="./Controller">
		<input type="hidden" name="redirect" value="Login">
			E-mail Usuario: <br> <input type="text" name="user" placeholder="Email usuario..." class="form-control">
			<br>
			Contraseña:<br> <input type="password" name="password"
				placeholder="Introduce la contraseña" class="form-control">
			<br>
			<button type="submit" class="btn-success">Iniciar sesión</button>

		</form>
	</div>
	<div id="section2">
		<H3>REGISTRO</H3>
		<form method="post" action="./Controller">
		<input type="hidden" name="redirect" value="RegisterUserManager">
		<h4>Datos personales</h4>
			Nombre: <br> <input name="name" type="text"
				placeholder="Usuario..." class="form-control" required>
			<br>
			Apellidos: <br> <input name="surname" type="text"
				placeholder="Apellidos..." class="form-control" required>
			<br>
			<h4>Datos de identificación</h4>
			E-mail:<br> <input name="email" type="text"
				placeholder="Email Usuario..." class="form-control" required>
			<br>
			Contraseña:<br> <input name="pass" type="password"
				placeholder="Introduce la contraseña" class="form-control" required>
			<br>
			Confirmar Contraseña:<br> <input name="pass2" type="password"
				placeholder="Repite la contraseña" class="form-control">
			<br>
			Ciudad:<br> <input name="city" type="text"
				placeholder="Introduce tu ciudad" class="form-control" required>
			<br>
			<br>
			
			<input type="checkbox" required> Soy mayor de edad y he leido y acepto
			los términos y condiciones de la política de seguridad y
			confidencialidad de Wallapop
			<br>
			<button type="submit" class="btn-primary">Registrarse</button>
		</form>
	</div>
</div>
