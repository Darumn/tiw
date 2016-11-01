<%@include file="includes/header.jsp"%>
<div id="update-productos">
		<H3>PRODUCTO</H3>		
		<form method="GET" action="./Controller">
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
			</p>
			User_id:<input type="text" name="iduser">
			</p>
			Photo:<input type="file" name="photoproduct">
			</p>			
			<input type="submit" value="Incluir producto">
		</form>
	</div>
<%@include file="includes/footer.jsp"%>