<div class="main">
	<div id="update-productos">
		<H3>PRODUCTO</H3>
		<form method="post" action="./Controller">
			<input type="hidden" name="redirect" value="RegisterProductManager">
			<h4>Insertar datos producto</h4>
	
			Name: <input type="text" name="productname">
			</p>
			Descripción:<input type="text" name="descriptionproduct">
			</p>
			Precio:<input type="text" name="pricepproduct">
			</p>
			Status:<input type="text" name="statusproduct">
			</p>
			Category_id:<input type="text" name="idcategory">
			<select>
				<option></option>
			</select>
			</p>
			User_id:<input type="text" name="iduser">
			</p>
			Photo:<input type="file" name="photoproduct">
			</p>
			<button class="btn-default" type="submit" >Guardar</button>
		</form>
	</div>
</div>