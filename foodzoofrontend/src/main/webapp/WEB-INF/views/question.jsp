

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
	opacity: 0.7;
}

#j1 {
	width: 100%;
}

#regform1 {
	align: center;
}
.btn-warning{
	text-align: left !important;
}


.btndiv{

	display:list-item;
	float: left;
	margin-top: 5px;
	width: 100%;
}	




</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<font color='red'> <br> ${exception}
	</font>

	<div class="backgroundimage">

		<form id="regform1" action="finaldeactivate" onsubmit="return check()"
			method="post">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6"
					style="background: #ffffff; padding: 5px; margin-top: 100px; margin-bottom: 100px; border-radius: 10px;">
					<div style="text-align: center;" id="j1">
						<h1>We will miss you</h1>
						<p>Hope To See You Soon</p>
					</div>
					<div class="img-hover" style="text-align: center">
						<img src="${images}/sademoji.jpg" class="img-rounded"
							style="width: 250px; height: 250px;">
						<div class="middle">
							<div class="text"></div>
						</div>

					</div>
					<div class="row">
						<div class="" style="text-align: center;">
							<h1>Reason To Deactivate</h1>

						</div>
					</div>







					<div class="row">

						<div class="col-sm-2" style="text-align: left; margin-top: 10px">

						</div>
						<div class="col-sm-7 btn-group " data-toggle="buttons">
								<div class="radiostyle">
								<label class="btn btn-warning btndiv"> 
								<input type="radio" name="question" id="option1" > Did not like out service
								</label>
								</div>
								<div class="radiostyle">
								<label class="btn btn-warning btndiv" > 
								<input type="radio" name="question" id="option2"> Temporary Deactivate
								</label>
								</div>
								<div class="radiostyle">
								<label class="btn btn-warning btndiv">
								<input type="radio" name="question" id="option3" checked> It diverts your mind
								</label>
								</div>
								<div class="radiostyle">
							    <label class="btn btn-warning btndiv">
								<input type="radio" name="question" id="option4"> Not Worth
								</label>
								</div>
						</div>
						<div class="col-sm-3" style="margin-top: 20px"></div>

					</div>






					<div class="row" style="margin-top: 30px">

						<div class="col-sm-5" style="text-align: right;"></div>
						<div class="col-sm-5">

							<input type="submit" value="Deactivate" name="submit" id="submit"
								class="btn btn-danger" style="margin-bottom: 10px;">
						</div>
						<div class="col-sm-2" style="margin-top: 20px"></div>
					</div>
				</div>
				<div class="col-sm-3"></div>

			</div>
		</form>



	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
