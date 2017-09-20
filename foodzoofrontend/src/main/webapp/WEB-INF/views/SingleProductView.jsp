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
.count-input {
  position: relative;
  width: 100%;
  max-width: 165px;
  margin: 10px 0;
}
.count-input input {
  width: 100%;
  height: 36.92307692px;
  border: 1px solid #000;
  border-radius: 2px;
  background: none;
  text-align: center;
}
.count-input input:focus {
  outline: none;
}
.count-input .incr-btn {
  display: block;
  position: absolute;
  width: 30px;
  height: 30px;
  font-size: 26px;
  font-weight: 300;
  text-align: center;
  line-height: 30px;
  top: 50%;
  right: 0;
  margin-top: -15px;
  text-decoration:none;
}
.count-input .incr-btn:first-child {
  right: auto;
  left: 0;
  top: 46%;
}
.count-input.count-input-sm {
  max-width: 125px;
}
.count-input.count-input-sm input {
  height: 36px;
}
.count-input.count-input-lg {
  max-width: 200px;
}
.count-input.count-input-lg input {
  height: 70px;
  border-radius: 3px;
}

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
<body ng-app="myApp" ng-controller="productController">

	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default panel--styled">
					<div class="panel-body">
						<div class="col-md-8 panelTop">
							<div class="col-md-12 ">
								<img src="${images}/productOne.jpg" class="img img-rounded" width="100%" height="500px"
									alt="Food" />
							</div>
							
						</div>

						<div class="col-sm-4 x">
							<div class="col-sm-12 text-left product">
								<h3><b>${product.product_name}</b></h3>
									
						<p >Price <span class="itemPrice"> Rs. ${product.price}</span></p>
								<p>Preprared By<span class="itemPrice">${product.supplier_name}</span></p>
								<p>Quantity Left<span class="itemPrice">${product.quantity}</span></p>
														
   <div class="count-input space-bottom">
                                <a class="incr-btn" data-action="decrease" href="#">–</a>
                                <input class="quantity" type="text" name="quantity" value="1"/>
                                <a class="incr-btn" data-action="increase" href="#">&plus;</a>
                            </div>
			
								<div class="col-sm-12">
							
								<button class="btn btn-lg but-add-to-cart but">
								<a href="cartClick?id=${product.product_id}">
									<span>Add To Cart</span>
								</a>
								</button>
						
							</div>
							</div>
							
						</div>
						<div class="col-sm-12 panelBottom product">
							<div class="col-sm-12">
								Description <span class="itemDesc"> ${product.description}</span>
							</div>
							</div>
						
							
							<div class="col-sm-4">
								<div class="stars">
									<div id="stars" class="starrr"></div>
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
	 app.controller('productController',function($scope){
		 
		
		 
		 $scope.productList = ${products}
		 
	 });
	 

	</script>
	<script type="text/javascript">
    $(".incr-btn").on("click", function (e) {
        var $button = $(this);
        var oldValue = $button.parent().find('.quantity').val();
        $button.parent().find('.incr-btn[data-action="decrease"]').removeClass('inactive');
        if ($button.data('action') == "increase") {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below 1
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
                $button.addClass('inactive');
            }
          
        }
        $button.parent().find('.quantity').val(newVal);
        e.preventDefault();
    });
	
	</script>
	
</body>
</html>