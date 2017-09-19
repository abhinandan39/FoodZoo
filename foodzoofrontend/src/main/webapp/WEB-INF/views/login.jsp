<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#displaymessage{
	
	text-align:center;
	
	padding: 10px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${not empty msg}">
		<div class="row" id="displaymessage">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="alert alert-dismissable alert-success">
					 
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
						×
					</button>
					<p>
						${msg}
					</p> 
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</c:if>
	
	<c:if test="${not empty errormsg}">
		<div class="row" id="displaymessage">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="alert alert-dismissable alert-danger">
					 
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
						×
					</button>
					<p>
						${errormsg}
					</p> 
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</c:if>
	
<div class="backgroundimage">
		
		
		<form id="loginform" action="login" method="post">
			<div class="row">
				<div class="col-sm-3">
					
				</div>
				<input type="hidden" value="${url}" />
				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<div class="" style="text-align: center; " >
						<span style="color:green;">${passwordreset}</span>
						<h1>Log In</h1>
						<p>Get back to your account and enjoy tasty food </p>
						</div>
					</div>
				
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<input type="text" class="form-control" name="username" id="username"
								placeholder="<spring:message code='label.username'></spring:message>"
								required="true" /> <span class="err"><form:errors
									path="users.username"></form:errors></span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-7" style="margin-top: 10px">
							<input type="password" class="form-control" name="password"
								placeholder="<spring:message code='label.password'></spring:message>"
								required="true" /> <span class="err"><form:errors
									path="users.password"></form:errors></span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row" style="margin-top: 30px">

						<div class="col-sm-5" style="text-align: right;">
						</div>
						<div class="col-sm-3">
		
							<input type="submit" value="Log In" name="submit" id="submit"
								class="btn btn-success" style="margin-bottom: 10px;">
						</div>
						<div class="col-sm-4" style="margin-top: 20px">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<a href="forgot"> Forgot Password ? Click Here</a>
						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">

						</div>

					</div>
					
					
				</div>
				<div class="col-sm-3">
					
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