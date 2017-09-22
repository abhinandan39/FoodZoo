<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
.err {
	color: red;
}

.backgroundimage {
	background-image: url('${images}/food1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	opacity: 0.8;
}

#displaymessage {
	text-align: center;
	padding: 10px;
}

.middleRow {
	background: #ffffff;
	padding: 5px;
	margin-top: 10px;
	margin-bottom: 100px;
	border-radius: 10px;
}

.product {
	font-size: 20px;
}
</style>
</head>

<body ng-app="myApp" ng-controller="orderController">
	<jsp:include page="header.jsp"></jsp:include>
	

	<div class="backgroundimage">
	
	<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-10" style="text-align:center; background: #ffffff; padding: 5px; margin-top: 20px; margin-bottom: 20px; border-radius: 10px;">
					<h1>Your Orders</h1>

				</div>
				<div class="col-sm-1"></div>
	</div>
	<div class="row" ng-repeat="(i,order) in orders">
		<div class="col-sm-1"></div>

		<div class="col-sm-10"
			style="background: #ffffff; padding: 5px; margin-top: 10px; margin-bottom: 40px; border-radius: 10px;">
			
			<div class="row">
						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">
							<label> Reciever Name: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 20px">
						<span class="orderData form-control">{{userAddress.fullname}}</span>
						</div>

						<div class="col-sm-2" style="text-align: right; margin-top: 20px">

						</div>
			</div>
			<div class="row">
						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">
							<label> Payment Mode: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 20px">
						<span class="orderData form-control">{{order.paymentMode}}</span>
						</div>

						<div class="col-sm-2" style="text-align: right; margin-top: 20px">

						</div>
			</div>
			<div class="row">
				<div class="col-sm-1" style="text-align: right; margin-top: 20px">

				</div>
				<div class="col-sm-3" style="text-align: left; margin-top: 20px">
					<label> OrderId: </label>
				</div>
				<div class="col-sm-6" style="margin-top: 20px">
					<span class="orderData form-control">{{order.orderNumber}}</span>
				</div>

				<div class="col-sm-2" style="text-align: right; margin-top: 20px">

				</div>
			</div>


			
			<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label> Address: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
						<span class="orderData form-control">{{userAddress.address1}}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
			</div>
			<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label>  </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
						<span class="orderData form-control">{{userAddress.address2}}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>		
			<div class="row">
			<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label> City: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
						<span class="orderData form-control">{{userAddress.city}}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
				</div>	
				<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label> ZipCode: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
						<span class="orderData form-control">{{userAddress.zipcode}}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>	
			<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label> Contact: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
						<span class="orderData form-control">{{userAddress.contact}}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>	
			
			<div class="row">
				<div class="col-sm-1" style="text-align: right; margin-top: 20px">

				</div>
				<div class="col-sm-3" style="text-align: left; margin-top: 20px">
					<label> Your Purchse: </label>

				</div>
				<div class="col-sm-3" style="margin-top: 20px">

					
						<div class="row form-control" ng-repeat="product in productList[i]"
							style="background: #0b4098; color: #ffffff; margin-left: 1px;">
							{{product.product_name}}
							
						</div>
					

				</div>
				<div class="col-sm-1" style="margin-top: 20px">
						<div class="row form-control" ng-repeat="item in cartList[i]">
						{{item.cartitem_quantity}}
						
						</div>
				</div>

				<div class="col-sm-1" style="text-align: right; margin-top: 20px">

				</div>
			</div>	
			<div class="row">
				<div class="col-sm-1" style="text-align: right; margin-top: 20px">

				</div>
				<div class="col-sm-3" style="text-align: left; margin-top: 20px">
					<label> Total Amount </label>
				</div>
				<div class="col-sm-6" style="margin-top: 20px">
					<span class="orderData form-control">{{order.total}}</span>
				</div>

				<div class="col-sm-2" style="text-align: right; margin-top: 20px">

				</div>
			</div>
			
		</div>
		<div class="col-sm-1"></div>
	</div>
</div>
</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
	 var app = angular.module("myApp",[]);
	 app.controller('orderController',function($scope){
		 
		
		 
		 $scope.orders = ${userOrders}
		 $scope.userAddress = ${address}
		 $scope.cartList = ${listOfCarts}
		 $scope.productList = ${listOfProducts}
		 
		 
	 });
	</script>
</body>
</html>