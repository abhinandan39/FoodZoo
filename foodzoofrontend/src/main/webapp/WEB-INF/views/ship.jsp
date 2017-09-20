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
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
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
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<c:url var="css" value="/resources/css"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<c:url var="images" value="/resources/images"></c:url>
<style type="text/css">


.panel.panel--styled {
    background: #fbfbfb;
    margin-left:30px;
}

.panelTop {
    padding: 20px;
}

.panelBottom {
    border-top: 1px solid #e7e7e7;
    padding-top: 10px;
    padding-bottom: 10px;
     background: #fbfbfb;
}
.btn-add-to-cart {
    background: #46d246;
    color: #fff;
    font-size: 13px !important;
}



span.itemPrice {
    font-size: 20px;
    color: #28a428;
    margin-left: 20px;
    
    
}
span.itemDesc {
    font-size: 20px;
    color: #28a428;
    
}


.backgroundimage {
	background-image: url('${images}/food1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	opacity: 0.8;
}


.form-group{
	text-align:center;
}


.x
{

margin-top:100px;
}
.but-add-to-cart:hover{
	color: #fff;   
    background: #28a428;
	outline: none;
}
.but
{
margin-top:50px;
margin-left:50px;
background-color: light green;
}
	
.product
{
font-size: 20px;

}	
</style>
</head>
<body ng-app="myApp">

	<jsp:include page="header.jsp"></jsp:include>
		
		
			<div class="backgroundimage">
	<div class="container">

		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default panel--styled">
					<div class="panel-body">
						
						<div class="col-sm-4 x">
							<div class="col-sm-12 text-left product">
							<p >Name<span class="itemPrice">${shippingAddress.fullname}</span></p>
							<p >Address<span class="itemPrice">${shippingAddress.address1}  ${shippingAddress.address2}</span></p>
							<p >City<span class="itemPrice">${shippingAddress.city}</span></p>
							<p >ZipCode<span class="itemPrice">${shippingAddress.zipcode}</span></p>
							<p >Contact<span class="itemPrice">${shippingAddress.contact}</span></p>
							<p >Email<span class="itemPrice">${shippingAddress.email} </span></p>
							
							
							
							<div class="col-sm-4">
								<div class="stars">
									<div id="stars" class="starrr"></div>
								</div>
							</div>
						</div>
					</div>
				
		
	<div class="col-sm-12 panelBottom">
							<div class="col-sm-6">
								<button class="btn btn-lg but-add-to-cart but">
								<a href="updateAddress">
									<span>update</span>
								</a>
								</button>
								<button class="btn btn-lg but-add-to-cart but">
								<a href="paymentMode">
									<span>PayNow</span>
								</a>
								</button>
							</div>
							</div>
			</div>			
					</div>
				</div>
		</div>
				
			</div>				
	</div>
				
<jsp:include page="footer.jsp" />
	
	<script type="text/javascript">
	 var app = angular.module("myApp",[]);
	 /* app.controller('productController',function($scope){
		 
		
		 
		 $scope.productList = ${products}
		 
	 }); */
	 

	</script>
	
	
</body>
</html> 







<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
.but-add-to-cart:hover{
	color: #fff;   
    background: #28a428;
	outline: none;
}
.but
{
margin-top:50px;
margin-left:50px;
background-color: light green;
}
</style>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	<font color='red'> <br> ${exception}
	</font>

	<div class="backgroundimage">
		
		<form id="regform" ng-app="myapp" method="post">
		
			<div class="row">
				<div class="col-sm-3">
					
				</div>

				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<h4 style="text-align:center;"> Address</h4>
						
					</div>
				
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Name</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							${shippingAddress.fullname}
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Address</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							${shippingAddress.address1}${shippingAddress.address2}
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">city</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							${shippingAddress.city}
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">zipcode</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							${shippingAddress.zipcode}
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">contact</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
						${shippingAddress.contact}						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">email</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							${shippingAddress.email}
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					
				
				 <div class="row">
					 	<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
						<a href="updateAddress"><input class="btn btn-success" type="submit" value="Update"/></a>
							<input class="btn btn-success" type="submit" value="PayNow"/>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					  
					 
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					  
					 
				</div>
				
								
				<div class="col-sm-3">
					
				</div>
				
			</div>
			
		</form>



	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html> --%>