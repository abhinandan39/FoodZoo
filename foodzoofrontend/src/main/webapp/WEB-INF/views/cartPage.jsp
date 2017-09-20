<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<c:url var="css" value="/resources/css"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<c:url var="images" value="/resources/images"></c:url>
<style type="text/css">

.panel.panel--styled {
    background: #fbfbfb;
    margin-left:30px;
}

.panelTop {
    padding: 10px;
}

.panelBottom {
    border-top: 1px solid #e7e7e7;
    padding-top: 10px;
    padding-bottom: 10px;
}
.btn-add-to-cart {
    background: #46d246;
    color: #fff;
    font-size: 13px !important;
}
.btn.btn-add-to-cart.focus, .btn.btn-add-to-cart:focus, .btn.btn-add-to-cart:hover  {
	color: #fff;   
    background: #28a428;
	outline: none;
}
.btn-add-to-cart:active {
	background: #F9494B;
	outline: none;
}


span.itemPrice {
    font-size: 14px;
    color: #28a428;
}



.img-hover img {
	-webkit-transition: all .3s ease; /* Safari and Chrome */
	-moz-transition: all .3s ease; /* Firefox */
	-o-transition: all .3s ease; /* IE 9 */
	-ms-transition: all .3s ease; /* Opera */
	transition: all .3s ease;
	position: relative;
	opacity: 1;
	backface-visibility: hidden;
	margin-bottom: 30px;
	margin-top: 5px;
}

.btn{
	display:block;
}

.form-group{
	text-align:center;
}

.btn-default{
	font-size: 14px !important;
}
.linkstyle:hover{
	color:#ffffff !important;
}
.totalAmount{
	margin-left: 50px;
	padding: 30px;
	background: #fbfbfb;
	font-size: 16px;
}
.btn-success{
	font-size: 16px !important;
}
	
</style>
</head>
<body ng-app="myApp" ng-controller="cartController">
<!-- 	Cart Page

	<div ng-repeat="product in productList track by $index">{{product}}</div>
	
	{{listQuantity}} -->
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<div class="jumbotron">
    <h2>Your Cart <span class="glyphicon glyphicon-shopping-cart"></span></h2> 
    <p>All the items you selected are at one place now</p> 
  	</div>
		<div class="row">
			<div class="col-sm-3" class="topClass"
				ng-repeat="(i,product) in productList">
				<div class="panel panel-default panel--styled">
				<div class="col-md-12">
							<div>
				
								<a href="deleteItem?id={{product.product_id}}"><button class="close" > x </button></a>
								
							</div>
							

						</div>
					<div class="panel-body">
						
						<div class="col-md-12 panelTop">
							<div class="col-md-12 img-hover">
								<img src="${images}/productOne.jpg" class="img img-rounded"
									width="100%" height="100px" alt="Food" />
								
							</div>
							

						</div>
						
							<div class="col-sm-12 panelBottom">
								<div class="col-sm-12">
									<p style="font-size: 15px; height: 4.0em;">{{product.product_name}}</p>
									Quantity
									<input style="width: 30%;" type="number" ng-value="{{product.quantity}}" ng-model="quant[i]" />
									
									Price: {{product.price }} <p style="font-size: 15px; height: 1.0em;"></p>
								</div>
								<div class="col-sm-12 text-center">
									<a href="updateItem?id={{product.product_id}}&updatedValue={{quant[i]}}"><button class="btn btn-primary">Update</button></a>
								</div>

							</div>
					
						<div class="col-sm-12 panelBottom">
							
							<div class="col-sm-12">
								<h6>
									Total Price <span class="itemPrice">Rs: {{product.price * quant[i]}}</span>
								</h6>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row totalAmount" >
			
			<div class="col-sm-10">
				Total Amount: {{totalAmount}}
			</div>
			<div class="col-sm-2" >
				<a href="checkout">
				<button class="btn btn-success"> Check Out <span class="glyphicon glyphicon-shopping-cart"></span> </button>
				</a>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
	<script type="text/javascript">
		var app = angular.module("myApp", []);
		app.controller('cartController', function($scope) {

			$scope.listQuantity = ${quantity}
			$scope.productList = ${productList}
			$scope.totalAmount = ${total}
			for(i=0;i<$scope.productList.length;i++){
				$scope.productList[i].quantity=$scope.listQuantity[i];
				}
			
		});
	</script>
</body>
</html>