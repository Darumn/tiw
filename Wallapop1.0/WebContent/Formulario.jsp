<%@include file="includes/header.jsp"%>

<div class="explorer">
	<select>
		<option>Tecnolog�a e Inform�tica</option>
		<option>Coches y Motos</option>
		<option>Deporte y Ocio</option>
		<option>Muebles, Deco y Jard�n</option>
		<option>Consolas y Videojuegos</option>
		<option>Libros, Pel�culas y M�sica</option>
		<option>Moda y Accesorios</option>
		<option>Juguetes, Ni�os y Beb�s</option>
		<option>Inmobiliaria</option>
		<option>Electrodom�sticos</option>
		<option>Servicios</option>
		<option>Otros</option>
	</select> <input type="text" placeholder="Buscar producto..."
		name="explorer_input" class="explorer_input" />
</div>

</div>
<div id="section">
	<div id="section1">
		<H3>INICIA SESI�N</H3>
		<form method="POST" action="Wallapp10">
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
		<form method="POST" action="Wallapp10">
			<h4>Datos de identificaci�n</h4>
			E-mail:<br> <input type="text" placeholder="Usuario...">
			</p>
			Confirmar e-mail:<br> <input type="text"
				placeholder="Repite tu nombre de usuario...">
			</p>
			Contrase�a:<br> <input type="password"
				placeholder="Introduce la contrase�a">
			</p>
			Confirmar Contrase�a:<br> <input type="password"
				placeholder="Repite la contrase�a">
			</p>
			<br>
			<h4>Datos personales</h4>
			Nombre: <br> <input type="text" placeholder="Usuario...">
			</p>
			Primer Apellido: <br> <input type="text"
				placeholder="Usuario...">
			</p>
			<input type="checkbox"> Soy mayor de edad y he leido y acepto
			los t�rminos y condiciones de la pol�tica de seguridad y
			confidencialidad de Wallapop
			</p>
			<input type="submit" value="Registrarse">
		</form>
	</div>
</div>
<%@include file="includes/footer.jsp"%>