<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<title>Insert title here</title>
</head>
<style>

/* Full-width input fields */
#username1, #password1 {
	width: 60%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
#button1 {
	background-color: #4CAF50;
	position: relative;
	color: white;
	padding: 14px 20px;
	margin-top: 35px;
	border: none;
	cursor: pointer;
	left: 37%;
	
	color: white;
}

#button2 {
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 50%;
}

/* Float deactivate buttons and add an equal width */
.deactivate {
	margin-left: 200px;
	width: 50%
}

/* Add padding to container elements */
.container {
	padding: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: grey;
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 60%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
#close {
	position: absolute;
	right: 5px;
	top: 0px;
	color: #000;
	font-size: 30px;
	font-weight: bold;
}

#close:hover, #close:focus {
	color: red;
	cursor: pointer;
}

/* Clear floats */
/* .clearfix::after {
    content: "";
    clear: both;
    display: table;
} */

/* Change styles for deactivate button on extra small screens */
@media screen and (max-width: 300px) {
	.deactivate {
		width: 50%;
		margin-left: 70px;
	}
}

#footer1 {
	margin-top: 400px;
}

#gifback {

	background: #ffffff;
	padding: 30px 30px 30px 40px;
	border-radius: 10px;

}

#gif {
	margin-left: 50px;
	height: 80%;
	width: 80%;
}

.backgroundimage {
	background-image: url('${images}/food1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	opacity: 0.6;
}

#msg {
	color: red;
}
#smileydiv{
	margin-top: 100px;
	margin-bottom: 100px;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${not empty msg}">
		<div class="row" id="displaymessage">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="alert alert-dismissable alert-danger">

					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">×</button>
					<p>${msg}</p>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</c:if>
	<div class="backgroundimage">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-5" id="smileydiv">
				<div id="gifback">
					<div>
						<img id="gif" src="${images}/sadcat.gif" alt="">
					</div>

					<div>
						<button id="button1"
							onclick="document.getElementById('id01').style.display='block'"
							style="width: auto;">Deactivate</button>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>

		</div>
	</div>
	<div id="id01" class="modal">

		<form class="modal-content" action="question" method="post">
			<span onclick="document.getElementById('id01').style.display='none'"
				id="close" title="Close Modal">×</span>
			<div class="container">
				<label><b>Username</b></label> <input type="text"
					placeholder="Enter UserName" name="username" id="username1"
					required> <label><b>Password</b></label> <input
					type="password" placeholder="Enter Password" name="password"
					id="password1" required>
				<div>

					<button id="button2" type="submit"
						class="deactivate btn btn-danger">Deactivate</button>
				</div>
			</div>
		</form>
	</div>




	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		$("#displaymessage").delay(2000).hide('slow');
	</script>

</body>
</html>