
<div class="main_footer">
	<span class="glyphicon glyphicon-search" aria-hidden="true"></span>

</div>
<div class="footer">Política de privacidad y cosas varias</div>
<script>
	$('.contact-container').on('click', function() {
		$('.contact-container').removeClass('selected');
		$(this).addClass('selected');
		var id = $(this).attr('id');
		$('.messages-container').hide();
		$('#messages' + id).show();
	});
</script>
</body>
</html>