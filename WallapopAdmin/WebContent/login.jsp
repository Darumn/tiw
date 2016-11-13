<%@include file="includes/header.jsp"%>
<div class="main">
	<%
		String error = (String) request.getAttribute("error");
		if (error != null && error.equals("error")) {
	%>
	<h4>USERNAME OR PASSWORD INVALID</h4>
	<%
		}
	%>
	<div class="adminLogin">
		<form method="POST" action="./Controller">
			<input type="hidden" name="redirect" value="AdminLogin"> <br />Name:
			<br> <input name="user" type="text" placeholder="User...">
			</p>
			Password:<br> <input name="password" type="password"
				placeholder="Password...">
			</p>
			<input class="loginButton" name="sesion" type="submit" value="Login">
		</form>
	</div>
</div>
<%@include file="includes/footer.jsp"%>