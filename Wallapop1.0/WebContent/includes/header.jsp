
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Wallapop</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="/Wallapop1.0/Controller"> <img alt="logo"
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
			</select> 
			<input type="text" placeholder="Buscar producto..."
				name="explorer_input" class="explorer_input" />
			<button type="submit" class="btn-default" >Buscar</button> 
		</div>
<%@page import="managers.SessionManager" %>
<%@page import="managers.Manager" %>
<%@page import="model.User" %>

<%SessionManager session1 = (SessionManager)request.getAttribute(Manager.CONST_SESSION); 
User user = null;
if(session1!=null){
	user = session1.getUser();
}
%>
		<div class="account">
		<%if(user == null){ %>
			<a href="./Controller?redirect=Formulario" class="account_link">INICIAR SESI�N |
				REGISTRO</a>
		<%} %>
		<%if(user != null){ %>
			<form method="post" action="./Controller">
				<button type="submit" class="btn-link">Hola <%= session1.getUser().getName()%></button>
				<input type="hidden" name="redirect" value="UserProfile" />
			</form>
			<form method="post" action="./Controller">
				<button type="submit" class="btn-link">Cerrar sessi�n</button>
				<input type="hidden" name="redirect" value="invalidateSession" />
			</form>
		<%} %>
		</div>
	</div>