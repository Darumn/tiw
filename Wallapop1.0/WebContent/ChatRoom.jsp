<%@include file="includes/header.jsp"%>
<div class="main">
	<p style="text-align:center;">MENSAJES</p>
	<div class="contacts-container">
		<div class="contact-container">
			ANA FERN�NDEZ
		</div>
		<div class="contact-container">
			ANA FERN�NDEZ
		</div>
		<div class="contact-container">
			ANA FERN�NDEZ
		</div>
		<div class="contact-container">
			ANA FERN�NDEZ
		</div>
		<div class="contact-container">
			ANA FERN�NDEZ
		</div>
		<div class="contact-container">
			ANA FERN�NDEZ
		</div>
		<div class="contact-container">
			ANA FERN�NDEZ
		</div>
	</div>
	<div class="messages-container">
		<div class="messages">
			<p>Mensaje</p>
		</div>
		<div class="send-new-message">
		<form method="GET" action="./Controller">
			<input type="hidden" name="redirect" value="RegisterProductManager">
			<input type="text" name="new-message" placeholder="Env�a un mensaje.."/>
			<button class="btn-success" >Enviar</button>
		</form>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>