<%@include file="includes/header.jsp"%>
<div id="update-productos">
	<H3>PRODUCTO</H3>
	<form method="POST" action="#">
		<h4>Datos actuales</h4>
		Name:
		</p>
		Descripción:
		</p>
		Precio:
		</p>
		Status:
		</p>
		Category_id:
		</p>
		User_id:
		</p>
		Photo:
		</p>
		<br>
		<h4>Modificar campos</h4>
		Name: <input type="text" name="productname">
		</p>
		Descripción:<input type="text" name="descriptionproduct">
		</p>
		Precio:<input type="text" name="pricepproduct">
		</p>
		Status:<input type="text" name="statusproduct">
		</p>
		Category_id:<input type="text" name="idcategory">
		</p>
		User_id:<input type="text" name="iduser">
		</p>
		Photo:<input type="file" name="photoproduct">
		</p>
		<input type="submit" value="Modificar">
	</form>
</div>
<%@include file="includes/footer.jsp"%>