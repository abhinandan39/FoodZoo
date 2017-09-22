
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
#submit
{
margin-top:60px;

marigin-left:-100px;

}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${not empty existmsg}">
		<div class="row" id="displaymessage">
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
	<c:if test="${not empty msg}">
		<div class="row" id="displaymessage">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="alert alert-dismissable alert-danger">
					 
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
	<font color='red'> <br> ${exception}
	</font>

	<div class="backgroundimage">
		
		<form id="regform" action="checkout1" method="post">
			<div class="row">
				<div class="col-sm-3">
					<input type="hidden" name="username" value="${sessionusername}" />
				</div>

				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<div class="" style="text-align: center; " >
						<h1>Shipping Address</h1>
						
					</div>
					</div>
				
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 20px">
							
						</div>
						<div class="col-sm-7" style="margin-top: 20px">
							<input type="text" class="form-control" name="fullname" id="fullname"
								placeholder="<spring:message code='label.fullname'></spring:message>"
								required="true" /> <span class="err"><form:errors
									path="shppingAddress.fullname"></form:errors></span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 20px">

						</div>
					</div>
					
					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-7" style="margin-top: 10px">
							<input type="text" class="form-control" name="address1" id="address1"
								placeholder="<spring:message code='label.address1'></spring:message>"
								required="true" /> <span class="err"><form:errors
									path="shippingAddress.address1"></form:errors></span>
						</div>

						<div class="col-sm-3" style="text-align: right; margin-top: 10px">

						</div>
						
					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="text" class="form-control" name="address2"
								placeholder="<spring:message code='label.address2'></spring:message>"
								id="address2" style="margin-top: 10px;" required> <span
								class="err"><form:errors path="shippingAddress.address2"></form:errors></span>
						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">

						</div>

					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="text" class="form-control" name="city"
								placeholder="<spring:message code='label.city'></spring:message>"
								id="city" style="margin-top: 10px;" required><span
								class="err"><form:errors path="shippingAddress.city"></form:errors></span>
								<span
								id="passlength">
								</span>
						</div>
						<div class="col-sm-3" style="text-align: left; margin-top: 20px">

						</div>

					</div>
					
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="text" length="10" class="form-control"
								name="zipcode"
								placeholder="<spring:message code='label.zipcode'></spring:message>"
								id="zipcode" placeholder="Zip Code/PinCode"
								 style="margin-top: 10px" required>
							<span class="err"><form:errors path="shippingAddress.zipcode"></form:errors></span>
						</div>
						<div class="col-sm-3" style="margin-top: 20px"></div>

					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="text" length="10" class="form-control"
								name="contact"
								placeholder="<spring:message code='label.contact'></spring:message>"
								id="contactid" placeholder="Enter Contact Number"
								pattern="[7-9]{1}[0-9]{9}" style="margin-top: 10px" required>
							<span class="err"><form:errors path="shippingAddress.contact"></form:errors></span>
						</div>
						<div class="col-sm-3" style="margin-top: 20px"></div>

					</div>
					<div class="row">
						<div class="col-sm-2" style="margin-top: 20px"></div>

						<div class="col-sm-7">
							<input type="text" length="10" class="form-control"
								name="contact"
								placeholder="<spring:message code='label.country'></spring:message>"
								id="contactid" placeholder="Enter country"
								 style="margin-top: 10px" required>
							<span class="err"><form:errors path="shippingAddress.country"></form:errors></span>
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
									path="shippingAddress.email"></form:errors></span>
						</div>
						<div class="col-sm-3" style="margin-top: 20px"></div>

					</div>
				<div class="row">
			<div class="col-sm-2" style="text-align: right;">
						</div>
						<div class="col-sm-5">
							
					 		<select class="form-control" name="state" id="state" placeholder= "<spring:message code='label.state'></spring:message>" style="margin-top: 10px" required><span class="err"><form:errors
									path="shippingAddress.state"></form:errors></span>
								<option>Haryana</option>
					 	        <option>haryana</option>
					 	        <option>hharyana</option>
					 	        <option>haryana</option>
					 	        <option>haryana</option>
					 	      
					 	    </select>
					 	</div>
					 	<div class="col-sm-3" style="margin-top: 20px">
					 		
					 	</div>
					 	  </div>
					
					

					<div class="row" style="margin-top: 30px">

						<div class="col-sm-2" style="text-align: right;">
						</div>
						<div class="col-sm-5">

							<input type="submit" value="submit" name="submit" id="submit"
								class="btn btn-success" style="margin-bottom: 10px;">
						</div>
						<div class="col-sm-3" style="margin-top: 20px">
						</div>
					</div>
					</div>
				</div>
				</form>
			</div>
		



	
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
			
			$("#displaymessage").delay(2000).hide('slow');
			$('#regform').submit(function(e) {
				
				if($('#passid').val().length < 6){
					$('#passlength').css('color','red');
					$('#passlength').text('Password Should be greater than 6 characters').show().fadeOut(3000);
					return false;
				}
			
				else{
					
					if ($('#passid').val() == $('#repassid').val()) {
						
					return true;
						
					} else {
						$('#message').css('color','red');
						$('#message').text('Passwords Not Matching').show().fadeOut(3000);
						
						return false;
					}
				}
			});
			
	</script>
</body>
</html>
