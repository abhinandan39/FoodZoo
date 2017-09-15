<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <%@import uri='https://fonts.googleapis.com/css?family=Josefin+Sans'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<c:url var="css" value="/resources/css"></c:url>
	<c:url var="images" value="/resources/images"></c:url>
	<link rel="stylesheet" href="${css}/styleindex.css">
  <link rel="stylesheet" href="${css}/headstyle.css">
  <link rel="stylesheet" href="${css}/footstyle.css">
  
</head>
<body>
<style>
#j1{
width:100%;

}
#j
{
margin-top:40px;
height:150px;

}
#b1{
opacity: 0.5;

}
</style>

<jsp:include page="header.jsp"></jsp:include>

<div class="jumbotron container" style="text-align: center; " id="j1">
			<h1>We will miss you</h1>
			<p>Hope To See You Soon</p>
		</div>




			<div class="col-sm-4 img-hover" style="text-align: center">
				<img src="${images}/sademoji.jpg" class="img-rounded"
					style="width: 100%; height: 250px;margin-left: 550px">
				<div class="middle">
					<div class="text">
					
					</div>
				</div>



			
		</div>


<div class="row1">
<div class="container">
<div class="col-sm-12">
<div class="jumbotron container" style="text-align: center; " id="j">
			<h4><style="text-align: center;margin-bottom:-100px; " >Reason To Deactivate</h4>	</style>
		</div>
<form action="finaldeactivate" name="Form">
<input type="hidden" name="username">
<div class="col-sm-2">

</div>
<div class="col-sm-8">
<fieldset>
  <div class="form-group">
  
   <div class="col-xs-9">
    <div class="radio">
     <label>
      <input id="inlineradio1" name="sampleinlineradio" value="option1" type="radio">
      Did Not Like Our Service</label>
    </div>
    <div class="radio">
     <label>
      <input id="inlineradio1" name="sampleinlineradio" value="option1" type="radio">
      Temporary Deactivate</label>
    </div>
    <div class="radio">
     <label>
      <input id="inlineradio1" name="sampleinlineradio" value="option1" type="radio">
      It diverts your mind</label>
    </div>
    <div class="radio">
     <label>
      <input id="inlineradio1" name="sampleinlineradio" value="option1" type="radio">
      Not Worth</label>
    </div>
    <input type="submit" name="deactivate">
   </div>
  </div>
 </fieldset>
 
 
</div>
</div>
</form>
</div>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html> --%>


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
	<c:url var="images" value="/resources/images"></c:url>
	<link rel="stylesheet" href="${css}/styleindex.css">
  <link rel="stylesheet" href="${css}/headstyle.css">
  <link rel="stylesheet" href="${css}/footstyle.css">
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
#j1{
width:100%;

}
#regform1
{
align:center;
margin-top:200px;
margin-left:0px;
}

</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<font color='red'> <br> ${exception}
	</font>

	<div class="backgroundimage">
		<div class="jumbotron container" style="text-align: center; " id="j1">
			<h1>We will miss you</h1>
			<p>Hope To See You Soon</p>
		</div>
		<div class="col-sm-4 img-hover" style="text-align: center">
				<img src="${images}/sademoji.jpg" class="img-rounded"
					style="width: 100%; height: 250px;margin-left: 650px;">
				<div class="middle">
					<div class="text">
					
					</div>
				</div>



			
		</div>
		<form id="regform1" action="finaldeactivate" onsubmit="return check()"
			method="post">
			<div class="row">
				<!-- <div class="col-sm-3">
					
				</div>
 -->
				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div class="row">
						<div class="" style="text-align: center; " >
						<h1>Reason To Deactivate</h1>
						
					</div>
					</div>
				
					
	
				
					
					
					
					<div class="row">
						
					 	<div class="col-sm-2" style="text-align: left;margin-top: 10px">
					 		 
					 	</div>
					 	<div class="col-sm-7">
					 		<input type="radio" class="form-control" name="question" id="question" >
					 	       Did Not Like Our Service
					 	    <br>
					 	    <input type="radio" class="form-control" name="question" id="question" >
					 	       Temporary Deactivate
					 	    <br>
					 	    <input type="radio" class="form-control" name="question" id="question" >
					 	       It diverts your mind
					 	    <br>
					 	    <input type="radio" class="form-control" name="question" id="question" >
					 	       Not Worth
					 	    <br>
					 	</div>
					 	<div class="col-sm-3" style="margin-top: 20px">
					 		
					 	</div>
					 	  
					</div>
					
					
					
					
					

					<div class="row" style="margin-top: 30px">

						<div class="col-sm-2" style="text-align: right;">
						</div>
						<div class="col-sm-5">

							<input type="submit" value="Deactivate" name="submit" id="submit"
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
