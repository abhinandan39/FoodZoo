<!DOCTYPE html>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<title></title>
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


</head>
<body>

	<!--NavBar-->
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${not empty msg}">
		<div class="row" id="displaymessage" >
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

	<!-- Image Carousel -->
	<div class="container-fluid">

		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${images}/food1.jpg" class="tales">
					<div class="carousel-caption">
						<h1>foodzoo</h1>
						<p>welcome to fooodzoo.</p>
					</div>
				</div>

				<div class="item">
					<img src="${images}/food2.jpg" class="tales">
					<div class="carousel-caption">
						<h1>Today's special</h1>
						<p>welcome to fooodzoo.</p>
					</div>

				</div>

				<div class="item">
					<img src="${images}/food3.jpg" class="tales">
					<div class="carousel-caption">
						<h1>foodzoo</h1>
						<p>welcome to fooodzoo.</p>
					</div>
				</div>
				<div class="item">
					<img src="${images}/food31.jpg" class="tales">
					<div class="carousel-caption">
						<h1>foodzoo</h1>
						<p>welcome to fooodzoo.</p>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>


	<!-- Food Categories  -->
	<div class="container">
		<div class="row">
			<h3 id="cuisine">
				<span id=""> Cuisine </span>
			</h3>
			<!-- Food Categories -->


			<div class="col-sm-4 img-hover" style="text-align: center;">

				<img src="${images}/northindian.jpg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h4>North Indian</h4>
					</div>
				</div>

			</div>
			<div class="col-sm-4 img-hover" style="text-align: center;">
				<img src="${images}/southindian.jpg" class="img-rounded"
					style="width: 250px; height: 250px">

				<div class="middle">
					<div class="text">
						<h4>South Indian</h4>
					</div>
				</div>
			</div>
			<div class="col-sm-4 img-hover" style="text-align: center;">
				<img src="${images}/chinese.jpg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h4>Chinese</h4>
					</div>
				</div>
			</div>

		</div>
		<div class="row">

			<div class="col-sm-4 img-hover" style="text-align: center;">
				<img src="${images}/Italian.jpg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h4>italian</h4>
					</div>
				</div>
			</div>
			<div class="col-sm-4 img-hover" style="text-align: center;">
				<img src="${images}/dessert.jpeg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h4>Dessert</h4>
					</div>
				</div>
			</div>
			<div class="col-sm-4 img-hover" style="text-align: center;">
				<img src="${images}/thaifood.jpg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h4>Thai</h4>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Social Media Footer -->
	<jsp:include page="footer.jsp" />
	<script>
			
			$("#displaymessage").delay(2000).hide('slow');
			
	</script>
</body>
</html>