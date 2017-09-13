<!DOCTYPE html>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<title></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   
    <c:url var="css" value="/resources/css"></c:url>
    <c:url var="js"  value="/resources/js"></c:url>
    <c:url var="images" value="/resources/images"></c:url>
	<link rel="stylesheet" href="${css}/footstyle.css">    
      
</head>
<body>
<div class="row footstyle">
			<div class="col-sm-3" >
				<h6 class="find">
				Find Us Here
				</h6>
				<p>
			   	 <a href="https://www.facebook.com" class="fa fa-facebook"></a>
				 <a href="https://www.twitter.com" class="fa fa-twitter"></a>
				 <a href="https://www.goole.com" class="fa fa-google"></a>
				 <a href="https://www.instagram.com" class="fa fa-instagram"></a>
				 <a href="https://www.snapchat.com" class="fa fa-snapchat"></a>
				</p>
				<p class="find"><a href=#>FAQ and Support</a></p>
				<p class="find"><a href=#>Contact</a></p>
			</div>

			<div class="col-sm-3">

				<h6 class="find">Serving Locations</h6>
				<p class="serv"> Gurgaon </p>
				<p class="serv"> Noida </p>
				<p class="serv"> Delhi </p>
				<p class="serv"> Chandigarh </p> 

			</div>
			<div class="col-sm-3">
				<h6 class="find">Payment Methods</h6>
				<p class="find">
					<img class="payment" src="${images}/mastercard.png"> 
					<img class="payment" src="${images}/visa.png">
					<img class="payment" src="${images}/cod.png">
				</p>
				<p class="find">
					<img class="payment" src="${images}/paytm.png">
					<img class="payment" src="${images}/americanexpress.png">
				</p>

			</div>
			
			<div class="col-sm-3" style="text-align: left; color: #ffffff">
			
				<p class="find"> Site Languages </p>
				<p class="serv"><a href=""> English .</a> <a href=""> French .</a> <a href=""> German </a></p>
				<p class="find" style="margin-top: 35px"><small> &copy; 2017</small> FoodZoo  
				</p>
				
			</div>
	

</div>
</body>
</html>