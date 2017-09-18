<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Manage Products</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
.form
{
   padding-left:50px;

}
</style>
<body>
	<div class="container">

	 
			<button type="submit" class="btn btn-success" value="add product" data-toggle="modal" data-target="#productModal">Add Product</button>
				<div class="modal fade" id="productModal" role="dialog">
					<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								     <h4 class="modal-title">Add a new Product</h4>
								  </div>  
								  <div class="modal-body">
								  <form id="product_form" class="form-group" action="saveproduct">
								      <input class="form-control" type="text" name="product_id" placeholder="Enter Product ID" id="product_id"/><br>
								  	  <input class="form-control" type="text" name="product_name" placeholder="Enter Product Name" id="product_name"/><br>
								      <input class="form-control" type="text" name="price" placeholder="Enter Product Price" id="price"/><br>
								      <input class="form-control" type="text" name="description" placeholder="Enter Product Description" id="description"/><br>
								      <input class="form-control" type="text" name="quantity"placeholder="Enter Product Quantity" id="quantity"/><br>
								      <select class="form-control" name="category_name" id="categoryselect">
								      <c:forEach var="x" items="${categorieslist}">
								      <option><c:out value="${x.category_name}"></c:out></option>
								      </c:forEach>
								      </select><br>
								       <select class="form-control" name="supplier_name" id="supplierselect">
								      <c:forEach var="x" items="${supplierslist}">
								      <option><c:out value="${x.supplier_name}"></c:out></option>
								      </c:forEach>
								      </select><br>
								    <!--   <input class="form-control" type="file" name="image_file"/><br>
								  -->  <input type="submit" class="btn btn-success" id="product_button" value="Save Product"/>
								     
								  </form>
								  </div>
								<div class="modal-footer">
       							 </div>
								</div>
							</div>
					</div>	
		<table class="table table-striped">
		<thead class="thead-inverse">
		<tr>
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Price</td>
			<td>Description</td>
			<td>Quantity</td>
			<td>Category Name</td>
			<td>Supplier Name</td>
		</tr>
		
		</thead>
		<c:forEach var="x" items="${productlist}">
		<tr>
		<td><c:out value="${x.product_id}"></c:out></td>
		<td><c:out value="${x.product_name}"></c:out></td>
		<td><c:out value="${x.price}"></c:out></td>
		<td><c:out value="${x.description}"></c:out></td>
		<td><c:out value="${x.quantity}"></c:out></td>
		<td><c:out value="${x.category_name}"></c:out></td>
		<td><c:out value="${x.supplier_name}"></c:out></td>
		<td><a href="#productModal" data-toggle="modal"><i class="fa fa-pencil" aria-hidden="true" onClick="editFunction('${x.product_id}','${x.product_name}','${x.price}','${x.description}','${x.quantity}','${x.category_name}','${x.supplier_name}')"></i></a></td>
	<td><a href="productdelete/${x.product_id}"><i class="fa fa-trash-o" aria-hidden="true" id="productdelete"></i></a></td>
	</tr>
		</c:forEach>
		
		</table>	
			</div>
	</body>
	<script>
	
        var editFunction = function(id, name, price,description,quantity,categoryname,suppliername){
		
		document.getElementById('product_button').setAttribute("value","Update Product");
		document.getElementById('product_form').setAttribute("action","updateproduct");
		document.getElementById('product_id').setAttribute('value',id);
		document.getElementById('product_name').setAttribute('value',name);
		document.getElementById('price').setAttribute('value',price);
		document.getElementById('description').setAttribute('value',description);
		document.getElementById('quantity').setAttribute('value',quantity);
		document.getElementById('categoryselect').setAttribute('value',categoryname);
		document.getElementById('supplierselect').setAttribute('value',suppliername);
	}
	
	</script>
</html>









