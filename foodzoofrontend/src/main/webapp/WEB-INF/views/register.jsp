
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
#message{
	
	text-align:center;
	padding: 10px;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${not empty existmsg}">
		<div class="row" id="message">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="alert alert-dismissable alert-danger">
					 
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
						×
					</button>
					<p>
						${existmsg}
					</p> 
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</c:if>
	<font color='red'> <br> ${exception}
	</font>

	<div class="backgroundimage">
		
		<form id="regform" action="registeruser" onsubmit="return check()"
			method="post">
			<div class="row">
				<div class="col-sm-3">
					
				</div>

				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<div class="" style="text-align: center; " >
						<h1>Sign Up</h1>
						<p>Sign Up with us to get the latest updates and offers </p>
					</div>
					</div>
				
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<input type="text" class="form-control" name="fname" id="fname"
								placeholder="<spring:message code='label.fname'></spring:message>"
								required="true" /> <span class="err"><form:errors
									path="users.fname"></form:errors></span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					</div>
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-7" style="margin-top: 10px">
							<input type="text" class="form-control" name="lname"
								placeholder="<spring:message code='label.lname'></spring:message>"
								required="true" /> <span class="err"><form:errors
									path="users.fname"></form:errors></span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="text" class="form-control" name="username"
								placeholder="<spring:message code='label.username'></spring:message>"
								id="username" style="margin-top: 10px;" required> <span
								class="err"><form:errors path="users.username"></form:errors></span>
						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">

						</div>

					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="Password" class="form-control" name="password"
								placeholder="<spring:message code='label.password'></spring:message>"
								id="passid" style="margin-top: 10px;" required> <span
								class="err"><form:errors path="users.password"></form:errors></span>
						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">

						</div>

					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="Password" class="form-control" name="repassword"
								placeholder="<spring:message code='label.repassword'></spring:message>"
								id="repassid" style="margin-top: 10px;" required> <span
								id=message></span>
						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">

						</div>

					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="text" length="10" class="form-control"
								name="contact"
								placeholder="<spring:message code='label.contact'></spring:message>"
								id="contactid" placeholder="Enter Contact Number"
								pattern="[7-9]{1}[0-9]{9}" style="margin-top: 10px" required>
							<span class="err"><form:errors path="users.contact"></form:errors></span>
						</div>
						<div class="col-sm-3" style="margin-top: 20px"></div>

					</div>
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-7">
							<input type="email" class="form-control" name="email"
								id="emailid"
								placeholder="<spring:message code='label.email'></spring:message>"
								style="margin-top: 10px" required> <span class="err"><form:errors
									path="users.email"></form:errors></span>
						</div>
						<div class="col-sm-3" style="margin-top: 20px"></div>

					</div>
					<div class="row">
						
					 	<div class="col-sm-2" style="text-align: left;margin-top: 10px">
					 		 
					 	</div>
					 	<div class="col-sm-7">
					 		<select class="form-control" name="securityque" id="securityque" placeholder= "<spring:message code='label.securityquestion'></spring:message>" style="margin-top: 10px" required>
					 	        <option>whats your pet name</option>
					 	        <option>whats your mother's maiden name</option>
					 	        <option>whats your first crush name</option>
					 	        <option>whats your dog's name</option>
					 	        <option>whats your favourite food</option>
					 	      
					 	    </select>
					 	</div>
					 	<div class="col-sm-3" style="margin-top: 20px">
					 		
					 	</div>
					 	  
					</div>
					
					<div class="row">
						
					 	<div class="col-sm-2" style="text-align: left;margin-top: 10px">
					 		 
					 	</div>
					 	<div class="col-sm-7">
					 		<input type="text" class="form-control" name="securityans" id="securityanswer" placeholder= "<spring:message code='label.answer'></spring:message>" style="margin-top: 10px" required>
					 	</div>
					 	<div class="col-sm-3" style="margin-top: 20px">
					 		
					 	</div>
					 	  
					</div>
					
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>
						<div class="col-sm-2" style="text-align: left; margin-top: 10px">
							<spring:message code="label.dob"></spring:message>
						</div>
						<div class="col-sm-5" style="margin-top: 10px">
							<input type="date" name="dob" value="1995-09-25"
								class="form-control" /> <span class="err"><form:errors
									path="users.dob"></form:errors></span>
						</div>

		
					</div>
					<%-- <div class="row">
				<div class="col-sm-2" style="margin-top: 20px">
			 		
			 	</div>
			 	<div class="col-sm-2" style="text-align: left;margin-top: 10px">
			 		<spring:message code="label.dob"></spring:message>
			 	</div>
			 	<div class="col-sm-5" style="margin-top: 10px">
				 	<input type="date" name="dob" value="1995-09-25"  class="form-control"/>
			 		<span class="err"><form:errors path="users.dob"></form:errors></span>
			 	</div>
			 	
			 	  
			</div> --%>

					<div class="row" style="margin-top: 30px">

						<div class="col-sm-2" style="text-align: right;">
						</div>
						<div class="col-sm-5">

							<input type="submit" value="Sign Up" name="submit" id="submit"
								class="btn btn-success" style="margin-bottom: 10px;">
						</div>
						<div class="col-sm-3" style="margin-top: 20px">
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
