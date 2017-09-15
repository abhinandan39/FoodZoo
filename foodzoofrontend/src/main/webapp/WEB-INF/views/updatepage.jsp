<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</style>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	<font color='red'> <br> ${exception}
	</font>

	<div class="backgroundimage">
		
		<form:form id="regform" action="updateuser" method="post">
		<form:hidden path="username"/>
		<form:hidden path="password"/>
		<form:hidden path="role"/>
		<form:hidden path="enabled"/>
		<form:hidden path="securityque"/>
		<form:hidden path="securityans"/>
		
			<div class="row">
				<div class="col-sm-3">
					
				</div>

				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<h4 style="text-align:center;"> Update Details</h4>
						
					</div>
				
					<div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">First Name</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							<form:input path="fname" />
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					 <div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Last Name</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							<form:input path="lname" />
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					 <div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Date of Birth</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							<form:input type="date" path="dob" />
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					 <div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Email Id</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							<form:input type="email" path="email" />
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					 <div class="row">

						<div class="col-sm-2">
						
						</div>
						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							<label class="form-label">Contact</label>
						</div>
						<div class="col-sm-5" style="margin-top: 20px">
							<form:input path="contact" />
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
							<input class="btn btn-success" type="submit" value="Update"/>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					 </div>
					 
					
				</div>
				<div class="col-sm-3">
					
				</div>
				
			</div>
		</form:form>



	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>