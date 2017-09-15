<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sending email</title>


	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<c:url var="images" value="/resources/images"></c:url>
	<c:url var="css" value="/resources/css"></c:url>
	<%-- <link rel="stylesheet" href="${css}/styleindex.css"> --%>
</head>
<style>
.button {
	border-radius: 2px;
	background-color: green;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 15px;
	padding: 20px;
	width: 90px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 1px;
	height: 1px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 15px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

#sub {
	margin-top: -10px;
}

/* input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
} */
/* input[type=text]:focus {
    width: 100%;
} */
.textinput , .textarea, .inputselect{
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}
.buttonsubmit{
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
.buttonsubmit:hover{
	background-color: #45a049;
}
/* input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	
} */

#country {
	height: 30px;
}

#from {
	width: 350px;
	height: 30px;
}

#myForm {
	margin-top: 10px;
}

.contacts {
	
}

.details {
	margin-left: 20px;
}

.contaier {
	
	border-radius: 5px;
	width:100%;
	margin-top:50px;
	padding-left:50px;
	background-color: #ffffff;
	
}
.formarea{
padding: 30px;


}
.imgrow{
	padding-left: 30px;
	width:100%;
	height: 40%;
}
.addressrow{
	padding: 50px;
}
.heading{
	margin-top:5px;
}
.content{
	margin-top:5px;
	padding-right:40px;
	
}

</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid fld">
	<form action="contact1" method="post" name="myForm">
		<div class="row">
			<div class="col-sm-6">
				<div>
				<img class="imgrow img img-rounded" src="${images}/contactus3.jpg"></img>
				</div>
				<div class="addressrow">
				<legend>
					<span class="glyphicon glyphicon-globe"></span> Our Location
				</legend>
				<address>
					<strong>foodZoo.com</strong><br> 878/22b EastVihar<br>
					Mayapuri, New Delhi - 110058<br> <abbr title="Phone">
						Phone</abbr> (+91) 9312 690 490
				</address>
				<address>
					<p>Need any help ? Reach out to us at</p>
					Email: <a href="mailto: sharmaparul597@gmail.com">sharmaparul597@gmail.com</a>
				</address>
				</div>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				
					<div class="row heading">
			 		<label for="country">Name</label> 
			 		</div>
					<div class="row content">		
						<input type="text" class="form-control"  name="name" placeholder="Your name" required="true" />
						 		 	
			 		</div>
			 		
			 		<div class="row heading">
			 		<label for="country">Country</label> 
			 		</div>
					<div class="row content">		
						<select id="country" class="inputselect form-control"
									name="country" required>
									<option value="australia">Australia</option>
									<option value="canada">Canada</option>
									<option value="usa">USA</option>
						</select>
						 		 	
			 		</div>
			 		
			 		<div class="row heading">
			 		<label for="from">Email Id:</label>
			 		</div>
					<div class="row content ">		
						<input type="email" class="form-control" id="from" name="from" placeholder="x@domain.com">
						 		 	
			 		</div>
			 		
			 		<div class="row heading">
			 		<label for="subject">Subject</label>
			 		</div>
					<div class="row content">		
						<input type="text" class="textinput form-control" id="subject" name="subject" placeholder="mail subject.."
									required>
						 		 	
			 		</div>
			 		
			 		<div class="row heading">
			 		<label for="name">Message:</label>
			 		</div>
					<div class="row content">		
						<textarea name="message" id="message" class="textarea form-control"></textarea>
						 		 	
			 		</div>
			 		<div class="form-group">
								<button class="button" class="buttonsubmit">
									<span id="sub">submit</span>
								</button>

					</div>
			 		
			 		
							
						</div>
					</div>
				</form>
			</div>
		


	
	<jsp:include page="footer.jsp" />
</body>
</html>


