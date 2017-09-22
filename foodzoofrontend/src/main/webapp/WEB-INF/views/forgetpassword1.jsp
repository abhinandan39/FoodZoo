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


	<div class="backgroundimage">
		
		<form id="loginform" action="forgetvalid" method="post">
		 <input type="hidden" name="username" value="${param.username}" />
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
							<input type="password" class="form-control" name="password" id="passid" placeholder="<spring:message code='label.password'></spring:message>"  required="true"/>
							<span
								id="passlength">
							</span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-2" style="text-align: left;">

						</div>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="repassword" id="repassid" placeholder="<spring:message code='label.repassword'></spring:message>"  style="margin-top: 10px;  " required>
							<span
								id="message">
							</span>
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
		$('#loginform').submit(function(e) {
			
			if($('#passid').val().length < 6){
				$('#passlength').css('color','red');
				$('#passlength').text('Password Should be greater than 6 characters').show().fadeOut(2000);
				return false;
			}
		
			else{
				
				if ($('#passid').val() == $('#repassid').val()) {
					
				return true;
					
				} else {
					$('#message').css('color','red');
					$('#message').text('Passwords Not Matching').show().fadeOut(2000);
					
					return false;
				}
			}
		});
	</script>
</body>
</html>