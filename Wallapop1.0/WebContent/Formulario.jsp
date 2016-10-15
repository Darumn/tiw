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
			</select> <input type="text" placeholder="Buscar producto..." name="explorer_input"
				class="explorer_input" />
		</div>
		
	</div>
	<div id="section">
		<div id="section1">
			<H3>INICIA SESI�N</H3>
			<form method="POST" action="Wallapp10">
				Usuario: <br>    <input type="text" placeholder="Usuario..."></p>
				Contrase�a:<br>  <input type="password" placeholder="Introduce la contrase�a">	</p>
				<input type="submit" value="Iniciar sesi�n">
				
			</form>
		</div>
		<div id="section2">
			<H3>REGISTRO</H3>
			<form method="POST" action="Wallapp10">
				<h4>Datos de identificaci�n</h4>
				E-mail:<br>    <input type="text" placeholder="Usuario..."></p>
				Confirmar e-mail:<br>    <input type="text" placeholder="Repite tu nombre de usuario..."></p>
				Contrase�a:<br>  <input type="password" placeholder="Introduce la contrase�a">	</p>
				Confirmar Contrase�a:<br>  <input type="password" placeholder="Repite la contrase�a">	</p>
				<br>
				<h4>Datos personales</h4>
				Nombre: <br>    <input type="text" placeholder="Usuario..."></p>
				Primer Apellido: <br>    <input type="text" placeholder="Usuario..."></p>
				<input type="checkbox"> Soy mayor de edad y he leido y acepto los t�rminos y condiciones de la pol�tica de seguridad y confidencialidad de Wallapop 
				</p>
					<input type="submit" value="Registrarse">
			</form>
		</div>
	</div>
	<div class="main">
		<div class="main_footer">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		</div>
	</div>
	<div class="footer">Pol�tica de privacidad y cosas varias</div>
</body>
</html>