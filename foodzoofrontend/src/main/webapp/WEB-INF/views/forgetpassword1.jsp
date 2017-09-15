<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url var="css" value="/resources/css"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<c:url var="images" value="/resources/images"></c:url>
<link rel="stylesheet" href="${css}/styleindex.css">
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<%-- <div class="container-fluid">
	<div class="jumbotron container" style="text-align: center; " >
			<h2>Forgot Your Password?</h2>	
			<p><h6>Please enter the  answer of security question that you used when you created your account and reset your password
			</h6></p>

	<div class="row">
	<div class="col-sm-3"></div>
		<div class="col-sm-5">
		
		</div>
	<div class="col-sm-4"></div>
	</div>
	<div class="row">
    <form class="form from-control" id="forgetpass" action="forgetvalid" onsubmit="return check()" method="post">
    <input type="hidden" name="username" value="${param.username}" />
    <div class="col-sm-3">
				</div>
				<div class="col-sm-6" style="background: #ffffff; padding: 5px; border-radius: 10px;">
					<div class="row">
			
					 	<div class="col-sm-2" style="text-align: left; margin-top: 20px">
					 		
					 	</div>
					 	
					 	<div class="col-sm-7" style="margin-top: 20px">
					 	   <i> <h6 style="color:green;">${securityque}</h6></i>
					 	   <h6 style="color:red;">${msg}</h6>
					 		<input type="text" class="form-control"  name="securityans" placeholder="<spring:message code='label.answer'></spring:message>" required="true" />
					 		
					 	</div>
					 	
					 	<div class="col-sm-3" style="text-align: right; margin-top: 20px">
					 		
					 	</div>
			 		</div>
			 		<div class="row">
			
					 	<div class="col-sm-2" style="text-align: left; margin-top: 10px">
					 		
					 	</div>
					 	<div class="col-sm-7" style="margin-top: 10px">
					 		<input type="password" class="form-control" name="password" placeholder="<spring:message code='label.password'></spring:message>"  required="true"/>
					 		
					 	</div>
					 	
					 	<div class="col-sm-3" style="text-align: right; margin-top: 10px">
					 		
					 	</div>
			 		</div>
			 		<div class="row">
						<div class="col-sm-2" style="margin-top: 20px">
					 		
					 	</div>
					 	
					 	<div class="col-sm-7" >
					 		<input type="password" class="form-control" name="repassword" placeholder="<spring:message code='label.repassword'></spring:message>"  style="margin-top: 10px;  " required>
					 		
					 	</div>
					 		<div class="col-sm-3" style="text-align: left; margin-top: 20px">
					 		
					 	</div>
					 	  
					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px">
					 		
					 	</div>
					 	
					 	<div class="col-sm-7" >
					 		<input class="btn btn-success" type="submit" value="reset" style="margin-bottom: 10px; margin-top: 20px;"></input>
					 		
					 	</div>
					 		<div class="col-sm-3" style="text-align: left; margin-top: 20px">
					 		
					 	</div>
					 	  
					</div>
					
					
			</div>
			<div class="col-sm-3" >
				</div>
		</form>
			</div>
</div>
</div>	

<div style="text-align:center;">Still have an issue? Please <a href="contact" style="color:blue">click here</a> to submit an inquiry for further assistance.</div> --%>
	<div class="backgroundimage">
		<!-- <div class="jumbotron container" style="text-align: center; " >
			<h1>Sign Up</h1>
			<p>Sign Up with us to get the latest updates and offers </p>
		</div> -->
		<form id="loginform" action="forgetvalid" method="post">
		 <input type="hidden" name="username" value="${param.username}" />
  y
			<div class="row">
				<div class="col-sm-3"></div>

				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<div class="" style="text-align: center;">
							<h2>Forgot Your Password?</h2>
							<p>
							Please enter the answer of security question that you used when<br>
							you created your account and reset your password
							</p>
						</div>
					</div>

					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 20px">

						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<i> <h6 style="color:green;">${securityque}</h6></i>
					 	   <h6 style="color:red;">${msg}</h6>
					 		<input type="text" class="form-control"  name="securityans" placeholder="<spring:message code='label.answer'></spring:message>" required="true" />
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-7" style="margin-top: 10px">
							<input type="password" class="form-control" name="password" placeholder="<spring:message code='label.password'></spring:message>"  required="true"/>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-2" style="text-align: left;">

						</div>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="repassword" placeholder="<spring:message code='label.repassword'></spring:message>"  style="margin-top: 10px;  " required>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row" style="margin-top: 30px">

						<div class="col-sm-5" style="text-align: right;"></div>
						<div class="col-sm-3">

							<input class="btn btn-success" type="submit" value="reset" style="margin-bottom: 10px; margin-top: 20px;"></input>
						</div>
						<div class="col-sm-4" style="margin-top: 20px"></div>
					</div>


					</div>
					<div class="col-sm-3"></div>

				</div>
		</form>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		var check = function() {
			if (document.getElementById('passid').value == document
					.getElementById('repassid').value) {
				document.getElementById('message').style.color = 'green';
				document.getElementById('message').innerHTML = 'Passwords Matched';
				return true;
			} else {
				document.getElementById('message').style.color = 'red';
				document.getElementById('message').innerHTML = 'Password Not matching';
				return false;
			}
		}
	</script>
</body>
</html>