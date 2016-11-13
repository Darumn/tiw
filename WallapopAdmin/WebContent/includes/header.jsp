<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="managers.SessionAdminManager"%>

<%@page import="managers.AdminManager"%>
<%@page import="model.User"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/styleAdmin.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Wallapop</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="/WallapopAdmin/Controller"> <img alt="logo"
				src="http://es.wallapop.com/images/logos/img_logo_header.png"
				id="img_logo">
			</a>
		</div>


		<%
			SessionAdminManager session1 = (SessionAdminManager) request.getAttribute(AdminManager.CONST_SESSION);
			User user = null;
			if (session1 != null) {
				user = session1.getUser();
			}
		%>

		<div class="account">

			<%
				if (user != null) {
			%>
			<form method="get" action="./Controller">
				<input type="hidden" name="redirect" value="UserProfile" />
				<button type="submit" class="btn-link">
					Hello
					<%=session1.getUser().getName()%></button>

			</form>
			<form method="post" action="./Controller">
				<input type="hidden" name="redirect" value="CloseSession">
				<button type="submit" class="btn-link">Logout</button>
			</form>
			<%
				}
			%>
		</div>
	</div>