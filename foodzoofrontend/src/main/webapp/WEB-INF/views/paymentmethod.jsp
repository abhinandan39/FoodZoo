
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
#displaymessage{
	
	text-align:center;
	padding: 10px;
}
</style>
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
		  
	  });
	 
	   
	 
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	
     <div class="row">
     <div class="col-sm-3"></div>
     
     <div class="col-sm-6" style="background-color:white ;">
     ${msg}
               <div class="row">
               <div class="col-sm-1"></div>
               <div class="col-sm-10">
               <h2 style="color:green;">Choose Your Payment Method</h2>
               </div>
               <div class="col-sm-1"></div>
               </div>
				
				    <div class="row">
				    
				    <div class="col-sm-1"></div>
				    <div class="col-sm-10">
					</div>
					<div class="col-sm-1"></div>
					</div>
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
									 <form class="form-group" action="paynow" method="post">
								  <span>
				 					 <input type="radio" name="mode" value="cod" id="id1" />
									<label for="id1">Cash On Delivery</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="mode" value="card" id="id2" />
									<label for="id2">Card Payment Method</label>
									</span>
									<br><br>
									<div id="div1">
									  <p><h3>Cash on Delivery payment method</h3></p>
					 				  <p>Pay with Cash When Your Order is delivered</p>
									  <input type="submit" class="btn btn-success" value="Pay Now"/>
								      </div>
								      
								   <div id="div2" style="backgroud-color:#fffffff">
								   <input class="form-control" type="text" name="cardnumber" placeholder="enter your card number"><span class="err"><form:errors
									path="payment.cardnumber"></form:errors></span><br>
									<input class="form-control" type="text" name="nameoncard" placeholder="enter your name on card">
						
								
								    <div class="input-group">
									<input class="form-control" type="text" name="cvv" placeholder="CVV" style="width:50%; margin-top:5px;"/>
									<span><i class="fa fa-credit-card-alt fa-3x" aria-hidden="true" style="color:#007acc; padding-left:20px; padding-bottom:20px;"></i></span>
									</div><span class="err"><form:errors
									path="payment.cvv"></form:errors></span>
									<br>
									<input type="submit" class="btn btn-success" value="Pay Now"/>
									</div> 
								</form> 
			
						</div>
						<div class=col-sm-1"></div>
					
                  </div>
    
     	</div>	
     	<div class="col-sm-3"></div>
		</div>
  	<jsp:include page="footer.jsp"></jsp:include>
	
 </body>
</html>
