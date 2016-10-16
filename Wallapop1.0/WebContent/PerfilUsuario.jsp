<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="formulariostyle.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Wallapop</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="index.jsp">
				<img alt="logo"
					src="http://es.wallapop.com/images/logos/img_logo_header.png"
					id="img_logo">
			</a>
		</div>

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
			</select> <input type="text" placeholder="Buscar producto..." name="explorer_input"
				class="explorer_input" />
		</div>
		<div class="account">
			<a href="#" class="account_link">Ver productos del usuario</a>
		</div>
	</div>
	<div id="section">
		<div id="section1">
			<H3>Detalles del perfil</H3>
			<form method="POST" action="Wallapp10">
				Usuario: </p>
				Email: </p>
				<img alt="foto perfil"
				src=""
				id="img_logo">
				
				
			</form>
		</div>
		<div id="section2">
			<H3>Cambiar datos</H3>
			<form method="POST" action="">
				Nueva dirección del usuario: <br>    <input type="text" placeholder="Dirección nueva"></p>
				Email nuevo:<br>    <input type="text" placeholder="Email nuevo"></p>
				Repetir email nuevo:<br>  <input type="password" placeholder="Repite email nuevo">	</p>				
				
				Contraseña nueva: <br>    <input type="text" placeholder="Contraseña nueva"></p>
				Repetir contraseña: <br>    <input type="text" placeholder="Repetir contraseña nueva"></p>
				
				</p>
				<h4>Cambio de foto actual</h4>
				<br>    <input type="file" name="fotoperfil" accept="/image"></p>
				<input type="submit" value="Guardar"></p>
			</form>
		</div>
	</div>
	<div class="main">
		<div class="main_footer">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		</div>
	</div>
	<div class="footer">Política de privacidad y cosas varias</div>
</body>
</html>