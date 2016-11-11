
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
	
<%@page import="managers.SessionManager" %>
<%@page import="managers.Manager" %>
<%@page import="model.User" %>

<%SessionManager session1 = (SessionManager)request.getAttribute(Manager.CONST_SESSION); 
User user = null;
if(session1!=null){
	user = session1.getUser();
}
%>
		<%if(user != null){ %>
		<div class="explorer">	
		
			<form method="get" action="./Controller">
			<input type="hidden" name="redirect" value="searchProducts">
				<input type="text" placeholder="Buscar producto..."
					name="search_input" class="explorer_input" />
				<button type="submit" class="btn-default" >Buscar</button> 
			</form>
			
		</div>
		<%}%>
		<div class="account">
		<%if(user == null){ %>
			<a href="./Controller?redirect=Formulario" class="account_link">INICIAR SESIÓN |
				REGISTRO</a>
		<%} %>
		<%if(user != null){ %>
			<form method="get" action="./Controller">
				<input type="hidden" name="redirect" value="UserProfile" />
				<button type="submit" class="btn-link">Hola <%= session1.getUser().getName()%></button>
				
			</form>
			<form method="get" action="./Controller">
				<input type="hidden" name="redirect" value="invalidateSession" />
				<button type="submit" class="btn-link">Cerrar sessión</button>
				
			</form>
		<%} %>
		</div>
	</div>