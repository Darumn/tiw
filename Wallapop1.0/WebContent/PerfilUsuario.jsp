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
<div class="account">
	<a href="#" class="account_link">Ver productos del usuario</a>
</div>
</div>
<div id="section">
	<div id="section1">
		<H3>Detalles del perfil</H3>
		<form method="POST" action="Wallapp10">
			Usuario:
			</p>
			Email:
			</p>
			<img alt="foto perfil" src="" id="img_logo">


		</form>
	</div>
	<div id="section2">
		<H3>Cambiar datos</H3>
		<form method="POST" action="">
			Nueva direcci�n del usuario: <br> <input type="text"
				placeholder="Direcci�n nueva">
			</p>
			Email nuevo:<br> <input type="text" placeholder="Email nuevo">
			</p>
			Repetir email nuevo:<br> <input type="password"
				placeholder="Repite email nuevo">
			</p>

			Contrase�a nueva: <br> <input type="text"
				placeholder="Contrase�a nueva">
			</p>
			Repetir contrase�a: <br> <input type="text"
				placeholder="Repetir contrase�a nueva">
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