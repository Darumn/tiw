<div class="main">
	<p style="text-align:center;">MENSAJES</p>
	<div class="contacts-container">
	<%@page import="model.*" %>
	<%@page import="java.util.Iterator"%>
	<%@page import="java.util.List"%>
	<%@page import="managers.ContactList"%>
	<%
	List<ContactList> lista = (List<ContactList>) request.getAttribute("contact_list");
	for(int i=0; i<lista.size(); i++){%>
		<div class="contact-container">
			<%=lista.get(i).usuario.getName() %>
		</div>
	<%} %>
	
		
	</div>
	<div class="messages-container">
		<div class="messages">
			<p>Mensaje</p>
		</div>
		<div class="send-new-message">
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="RegisterProductManager">
			<input type="text" name="new-message" placeholder="Envía un mensaje.."/>
			<button class="btn-success" >Enviar</button>
		</form>
		</div>
	</div>
</div>