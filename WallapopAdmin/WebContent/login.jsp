<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/styleAdmin.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<img alt="logo"
				src="http://es.wallapop.com/images/logos/img_logo_header.png"
				id="img_logo">
		</div>
	</div>
	<div class="main">
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="AdminLogin"> <br />Nombre:
			<br> <input name="user" type="text" placeholder="Usuario...">
			</p>
			Contraseña:<br> <input name="password" type="password"
				placeholder="Introduce la contraseña">
			</p>
			<input name="sesion" type="submit" value="Iniciar Sesion">
		</form>
	</div>
</body>
<footer> <br>
FOOTER </footer>
</html>
</html>