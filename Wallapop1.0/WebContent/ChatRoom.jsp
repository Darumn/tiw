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
		<div class="contact-container" id="<%=lista.get(i).usuario.getId()%>">
			<%=lista.get(i).usuario.getName() %>
		</div>
	<%} %>
	
		
	</div>
	<% for(int i=0; i<lista.size(); i++){%>
	<% User usuario = lista.get(i).usuario;%>
	<div class="messages-container" id="messages<%=usuario.getId()%>">
		<div class="messages" >
		<% for(int j=0; j<lista.get(i).mensajes.size(); j++){%>
				<p style="text-align:<%if(lista.get(i).mensajes.get(j).getUser1().getId() == usuario.getId()) out.print("left"); else out.print("right");%>"><%=lista.get(i).mensajes.get(j).getMessage() %></p>
		<%} %>
		</div>
		<div class="send-new-message">
			<form method="GET" action="./Controller">
				<input type="hidden" name="redirect" value="sendMessage">
				<input type="hidden" name="receiver_id" value="<%= usuario.getId()%>"/>
				<input type="text" name="message" placeholder="Contacta con este usuario"/>
				<button type="submit" class="btn-success" >Enviar</button>
			</form>
		</div>
		
	</div>
	<%} %>
	<%User admin = (User) request.getAttribute("admin");
	if(admin != null) {%>
	Enviar mensaje al administrador:
	<form method="GET" action="./Controller">
		<input type="hidden" name="redirect" value="sendMessage">
		<input type="hidden" name="receiver_id" value="<%= admin.getId()%>"/>
		<input type="text" name="message" placeholder="Escribe al administrador.."/>
		<button type="submit" class="btn-success" >Enviar</button>
	</form>
	<%} %>
</div>