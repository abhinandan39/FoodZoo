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
.panel.panel--styled {
	background: #fbfbfb;
	margin-left: 30px;
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

.form-group {
	text-align: center;
}

.but-add-to-cart:hover {
	color: #fff;
	background: #28a428;
	outline: none;
}

.but {
	margin-top: 50px;
	margin-left: 50px;
	background-color: light green;
}

.product {
	font-size: 20px;
}
.middleRow{
	background: #ffffff; 
	padding: 5px; 
	margin-top: 10px; 
	margin-bottom: 100px; 
	border-radius: 10px;
}

.nav-pills{
	margin-top: 20px !important;
	border-radius: 4px;
	background: #ffffff;
}

.nav-pills>li.active>a, .nav-pills>li.active>a:focus, .nav-pills>li.active>a:hover{

	color: #fff;
    background-color: #3e9840 !important;
}



input[type=radio] {
  position: absolute;
  visibility: hidden;
  display: none;
}

label {
  color: lighten($bg,40%);
  display: inline-block;
  cursor: pointer;
  font-weight: bold;
  padding: 5px 20px;
}

input[type=radio]:checked + label{
  color: #ffffff;
  background:#989898;
}

label + input[type=radio] + label {
  border-left: solid $borderWidth $fg;
}
.radio-group {
  border: solid $borderWidth $fg;
  display: inline-block;
  margin: 20px;
  border-radius: 10px;
  overflow: hidden;
}



</style>

<script type="text/javascript">
function validate()
{
	console.log("hey!!");
	var x=document.getElementById("cvv").value;
	var y=document.getElementById("cardnumber").value;
	  if (y.length!=16|| isNaN(y)) 
		{
	        text = "please enter 16 digit card number";
	        document.getElementById("error1").innerHTML = text;
	      
	        return false;
		} 
	  else
		  {
		  document.getElementById("error1").innerHTML ="";
		  }
		
 	  if (x.length!=3 || isNaN(x)) 
	 {
        text = "please enter 3 digit cvv number";
        document.getElementById("error2").innerHTML = text;
        return false;

	 } 
 	  else
 		  {
 		  
		  document.getElementById("error1").innerHTML ="";

 		  
 		  }
	
	

	 return true; 
	 
}
 


</script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<div class="backgroundimage">
		<div class="container">
			
			<ul class="nav nav-pills nav-justified">
				
				<li id="addressHead" class="active"><a data-toggle="pill" href="#addressPill">Address</a></li>
				<li id="paymentHead"><a  data-toggle="pill" href="#paymentPill">Payment Methods</a></li>
			</ul>
		  <div class="tab-content">
			<div id="addressPill" class="row tab-pane fade in active">
				<div class="row">
				<div class="col-sm-1">
					
				</div>

				<div class="col-sm-10 middleRow">
					<div class="row">
						<h4 style="text-align:center;"> Your Address</h4>
						
					</div>
				
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Name</label>
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<span class="form-control">${shippingAddress.fullname}</span>
						</div>

						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Address</label>
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<span class="form-control">${shippingAddress.address1}</span>
						</div>

						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					 <div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label"></label>
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<span class="form-control">${shippingAddress.address2}</span>
						</div>

						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">city</label>
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<span class="form-control">${shippingAddress.city}</span>
						</div>

						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">zipcode</label>
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<span class="form-control">${shippingAddress.zipcode}</span>
						</div>

						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">contact</label>
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<span class="form-control">${shippingAddress.contact}</span>
						</div>

						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">email</label>
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<span class="form-control">${shippingAddress.email}</span>
						</div>

						<div class="col-sm-1" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					
				
			 <div class="row">
					 	<div class="col-sm-4">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<a href="updateAddress"><input class="btn btn-success" type="submit" value="Update"/></a>
						</div>
						<div class="col-sm-2" style="margin-top: 20px">
							
							<a data-toggle="pill" id="next" href="#paymentPill"><input class="btn btn-success" type="submit" value="Next"/></a>
						</div>

						<div class="col-sm-4" style="text-align: right; margin-top: 20px">
						
						</div>
					 </div>
					  
					 
				</div>
				<div class="col-sm-1">
					
				</div>
				
			</div>
			</div>
			<div id="paymentPill" class="row tab-pane fade">
					
				<div class="row">
				<div class="col-sm-1"></div>

				<div class="col-sm-10 middleRow" style="background-color: white;">
					
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<h2 style="color: #66c2ff; text-align:center;">Choose Your Payment Method</h2>
						</div>
						<div class="col-sm-1"></div>
					</div>

					<div class="row">

						<div class="col-sm-1"></div>
						<div class="col-sm-10"></div>
						<div class="col-sm-1"></div>
					</div>
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<form id="paymentform" class="form-group" action="paynow" method="post" style="margin-top:20px;">
								<span> <input type="radio" name="mode" value="COD"
									id="id1" checked/> <label for="id1">Cash On Delivery</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="mode" value="Card" id="id2" checked/> <label
									for="id2">Card Payment Method</label>
								</span> <br> <br>
								<div id="div1" style="color:gray">
								
									<h4>Cash On Delivery</h4>
										<p>Pay with Cash When Your Order is delivered<br>
									NOTE: All authorised notes are accepted, except Rs.500 (old)</p>
									
									<input id="codbutton" type="submit" class="btn btn-success" value="Place Order" style="margin-top:20px; margin-bottom:20px;" formnovalidate/>
								</div>

								<div id="div2" style="backgroud-color: #fffffff">
								     <span id="error1" style="color:red;"></span> 
									<input class="form-control" type="text"  id="cardnumber" name="cardnumber"
										placeholder="enter your card number" required><br>
									<input class="form-control" type="text" name="nameoncard"
										placeholder="enter your name on card" required><br>

                                 
									<div class="input-group">
									     <span id="error2" style="color:red;"></span>   
										<input class="form-control" type="text" name="cvv" id="cvv"
											placeholder="CVV" style="width: 50%; margin-top: 5px;" required/> <span><i
											class="fa fa-credit-card-alt fa-3x" aria-hidden="true"
											style="color: #007acc; padding-left: 20px; padding-bottom: 20px;"></i></span>
											
									</div>
									
									<br> <input type="submit" class="btn btn-success"
										value="Place Order" id="cardbutton" />
								</div>
							</form>

						</div>
						<div class="col-sm-1"></div>

					</div>

				</div>
				<div class="col-sm-1"></div>
				</div>
			</div>
			</div>

		</div>

	</div>

	<jsp:include page="footer.jsp" />


<script>
     


	  $(document).ready(function()
	  {
		  
		  
		  $("#div1").hide();
		  $("#div2").hide();
		/*   $("input:radio[name=card]").click(function(){
			   
		      $("#div2").hide();
		      }); */
		  $("#id2").click(function(){
			   
			  $("#div1").hide();
		      $("#div2").show();
		      
		      });
		  $("#id1").click(function(){
			   
		      $("#div2").hide();
		      $("#div1").show();
		      });
		  
		  $("#next").click(function(){
			 $("#paymentHead").attr('class','active'); 
			 $("#addressHead").attr('class','');
		  });
		  $("#cardbutton").click(function(){
			   
			  $("#paymentform").attr('onsubmit',"return validate()"); 
		      
		      });
		  
		 
		    
		  
	  });
	 

</script>

</body>
</html>

