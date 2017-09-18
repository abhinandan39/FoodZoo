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
								  <form class="form-group" action="saveproduct">
								      <input class="form-control" type="text" name="product_id" placeholder="Enter Product ID"/><br>
								  	  <input class="form-control" type="text" name="product_name" placeholder="Enter Product Name"/><br>
								      <input class="form-control" type="text" name="price" placeholder="Enter Product Price"/><br>
								      <input class="form-control" type="text" name="description" placeholder="Enter Product Description"/><br>
								      <input class="form-control" type="text" name="quantity"placeholder="Enter Product Quantity"/><br>
								      <select class="form-control" name="category_name">
								      <c:forEach var="x" items="${categorieslist}">
								      <option><c:out value="${x.category_name}"></c:out></option>
								      </c:forEach>
								      </select><br>
								       <select class="form-control" name="supplier_name">
								      <c:forEach var="x" items="${supplierslist}">
								      <option><c:out value="${x.supplier_name}"></c:out></option>
								      </c:forEach>
								      </select><br>
								    <!--   <input class="form-control" type="file" name="image_file"/><br>
								  -->  <button type="submit" class="btn btn-success">Save Product</button>
								     
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
		<td><i class="fa fa-trash-o" aria-hidden="true" id=""></i></td>
		<td><i class="fa fa-pencil" aria-hidden="true" id=""></i></td>
		</tr>
		</c:forEach>
		
		</table>			
					
					
					
					
		
		
		
		
		
		
		
					
		</div>
	</body>
</html>









