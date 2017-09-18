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
								  <form class="form-group">
								      <input class="form-control" type="text" name="product_id"/><br>
								  	  <input class="form-control" type="text" name="product_name"/><br>
								      <input class="form-control" type="text" name="price"/><br>
								      <input class="form-control" type="text" name="description"/><br>
								      <input class="form-control" type="text" name="quantity"/><br>
								      <select class="form-control" name="category_name">
								      <c:forEach var="x" items="${list1}">
								      <option><c:out value="${x}"></c:out></option>
								      </c:forEach>
								      </select><br>
								       <select class="form-control" name="supplier_name">
								      <c:forEach var="x" items="${list1}">
								      <option><c:out value="${x}"></c:out></option>
								      </c:forEach>
								      </select><br>
								      <input class="form-control" type="file"/><br>
								   <button type="button" class="btn btn-success" data-dismiss="modal">Save Product</button>
								     
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
		
		
		</table>			
					
					
					
					
		
		
		
		
		
		
		
					
		</div>
	</body>
</html>









