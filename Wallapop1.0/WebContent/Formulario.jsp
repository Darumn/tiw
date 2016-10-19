<%@include file="includes/header.jsp"%>

<div class="explorer">
	<select>
		<option>Tecnología e Informática</option>
		<option>Coches y Motos</option>
		<option>Deporte y Ocio</option>
		<option>Muebles, Deco y Jardín</option>
		<option>Consolas y Videojuegos</option>
		<option>Libros, Películas y Música</option>
		<option>Moda y Accesorios</option>
		<option>Juguetes, Niños y Bebés</option>
		<option>Inmobiliaria</option>
		<option>Electrodomésticos</option>
		<option>Servicios</option>
		<option>Otros</option>
	</select> <input type="text" placeholder="Buscar producto..."
		name="explorer_input" class="explorer_input" />
</div>

</div>
<div id="section">
	<div id="section1">
		<H3>INICIA SESIÓN</H3>
		<form method="POST" action="Wallapp10">
			Usuario: <br> <input type="text" placeholder="Usuario...">
			</p>
			Contraseña:<br> <input type="password"
				placeholder="Introduce la contraseña">
			</p>
			<input type="submit" value="Iniciar sesión">

		</form>
	</div>
	<div id="section2">
		<H3>REGISTRO</H3>
		<form method="POST" action="Wallapp10">
			<h4>Datos de identificación</h4>
			E-mail:<br> <input type="text" placeholder="Usuario...">
			</p>
			Confirmar e-mail:<br> <input type="text"
				placeholder="Repite tu nombre de usuario...">
			</p>
			Contraseña:<br> <input type="password"
				placeholder="Introduce la contraseña">
			</p>
			Confirmar Contraseña:<br> <input type="password"
				placeholder="Repite la contraseña">
			</p>
			<br>
			<h4>Datos personales</h4>
			Nombre: <br> <input type="text" placeholder="Usuario...">
			</p>
			Primer Apellido: <br> <input type="text"
				placeholder="Usuario...">
			</p>
			<input type="checkbox"> Soy mayor de edad y he leido y acepto
			los términos y condiciones de la política de seguridad y
			confidencialidad de Wallapop
			</p>
			<input type="submit" value="Registrarse">
		</form>
	</div>
</div>
<%@include file="includes/footer.jsp"%>