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
#displaymessage{
	
	text-align:center;
	padding: 10px;
}
.middleRow{
	background: #ffffff; 
	padding: 5px; 
	margin-top: 10px; 
	margin-bottom: 100px; 
	border-radius: 10px;
}

.nav-pills{
	margin-top: 30px !important;
	border-radius: 4px;
	background: #ffffff;
}

.nav-pills>li.active>a, .nav-pills>li.active>a:focus, .nav-pills>li.active>a:hover{

	color: #fff;
    background-color: #3e9840 !important;
}
.product {
	font-size: 20px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<c:if test="${message == 'success'}">
		<div class="row" id="displaymessage">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="alert alert-dismissable alert-success">
					 
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
						×
					</button>
					<p>
						Order Placed Successfully 
					</p> 
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</c:if>
	<div class="backgroundimage">
		<div class="container">
		<ul class="nav nav-pills nav-justified">
				
				<li id="addressHead" class="active"><a data-toggle="pill" href="#addressPill">Your Details</a></li>
				<li id="paymentHead"><a  data-toggle="pill" href="#paymentPill">Order Details</a></li>
		</ul>
		<div class="tab-content">
		<div id="addressPill" class="row tab-pane fade in active">
			<div class="row">
				<div class="col-sm-1">
					
				</div>

				<div class="col-sm-10"
					style="background: #ffffff; padding: 5px; margin-top: 10px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<div class="" style="text-align: center; " >
						<h1>Your Order</h1>
						
					</div>
					</div>
					<div class="row">
						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">
							<label> Reciever Name: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 20px">
						<span class="orderData form-control">${address.fullname}</span>
						</div>

						<div class="col-sm-2" style="text-align: right; margin-top: 20px">

						</div>
					</div>
				
					<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label> Username: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
							<span class="orderData form-control">${userOrder.username}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label> Payment Mode: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
							<span class="orderData form-control">${userOrder.paymentMode}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label> Address: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
							<span class="orderData form-control">${address.address1}</span>
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
							<span class="orderData form-control">${address.address2}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label>Contact  </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
							<span class="orderData form-control">${address.contact}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-1" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 10px">
							<label>PinCode  </label>
						</div>
						<div class="col-sm-6" style="margin-top: 10px">
							<span class="orderData form-control">${address.zipcode}</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					

					<div class="row" style="margin-top: 30px">

						<div class="col-sm-5" style="text-align: right;">
						</div>
						<div class="col-sm-5">

							<a data-toggle="pill" id="next" href="#paymentPill"><input class="btn btn-success" type="submit" value="Next"/></a>
						</div>
						<div class="col-sm-2" style="margin-top: 20px">
						</div>
					</div>
				</div>
				<div class="col-sm-1">
					
				</div>
				
			</div>
		</div>
		<div id="paymentPill" class="row tab-pane">
			<div class="row">
				<div class="col-sm-1">
					
				</div>

				<div class="col-sm-10"
					style="background: #ffffff; padding: 5px; margin-top: 10px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<div class="" style="text-align: center; " >
						<h1>Your Order</h1>
						
					</div>
					</div>
						<div class="row">
						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">
							<label> OrderId: </label>
						</div>
						<div class="col-sm-6" style="margin-top: 20px">
						<span class="orderData form-control">${userOrder.orderNumber}</span>
						</div>

						<div class="col-sm-2" style="text-align: right; margin-top: 20px">

						</div>
					</div>
				
					
					<div class="row">
						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">
							<label> Cart Details: </label>
							
						</div>
						<div class="col-sm-3" style="margin-top: 20px">
						
						<c:forEach var="productItems" items="${productList}">
							<div class="row form-control" style="background: #0b4098; color:#ffffff; margin-left: 1px;">
							${productItems.product_name}
							</div>
						</c:forEach>
						
						</div>
						<div class="col-sm-1" style="margin-top: 20px">
						<c:forEach var="cartItems" items="${cartList}">
							<div class="row form-control">${cartItems.cartitem_quantity}</div>
						</c:forEach>
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
						<span class="orderData form-control">${total}</span>
						</div>

						<div class="col-sm-2" style="text-align: right; margin-top: 20px">

						</div>
					</div>
					

					
					<div class="row" style="margin-top: 30px">

						<div class="col-sm-5" style="text-align: right;">
						</div>
						<div class="col-sm-5">

							<a href="myOrders"><input type="submit" value="My Orders" name="submit" id="submit"
								class="btn btn-success" style="margin-bottom: 10px;"></a>
						</div>
						<div class="col-sm-2" style="margin-top: 20px">
						</div>
					</div>
				</div>
				<div class="col-sm-1">
					
				</div>
				</div>
				
			</div>
		</div>
	</div>

</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
	 $("#next").click(function(){
		 $("#paymentHead").attr('class','active'); 
		 $("#addressHead").attr('class','');
	  });
	 $("#displaymessage").delay(2000).hide('slow');
	</script>
</body>
</html>