<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="html1">
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

</head>


<style>
#body1, #html1 {
	height: 100%;
}

.parallax {
	/* The image used */
	background-image: url('${images}/food1.jpg');
	/* Full height */
	height: 100%;
	/* Create the parallax scrolling effect */
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	
} 
</style>
</head>


<body id="body1">
	<jsp:include page="header.jsp"></jsp:include>

	<div class="parallax"></div>
	<div id="aboutus1" style="color: gray;">
		<p>
		<h1>About Us</h1>

		<p
			style="text-align: justify; margin-top: 10px; margin-bottom: 80px; margin-left: 20px; margin-right: 20px;">
			Foodzoo was founded in August 2017, by serial entrepreneurs Abhinandan Gupta,
		    Priyanshi Tiwari and Parul Sharma. Foodzoo is one of the
			fastest growing food experience companies in the country. Not only
			are we obsessed with our customers, but we are also passionate about
			our food and our technology. Foodzoo is bringing good food to the
			hands of many and creating culinary experiences worth remembering.
			With a wonderful balance between the cuisines of modern Indian,
			authentic European, delicious Mediterranean and flavourful Asian,
			Foodzoo is a truly global brand, reaching for the skies while still
			deeply rooted in India.</p>
		<div class="container">



			<div class="col-sm-4 img-hover" style="text-align: center">
				<img src="${images}/a.jpg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h1>Abhinandan</h1>
					</div>
				</div>


			</div>


			<div class="col-sm-4 img-hover" style="text-align: center">
				<img src="${images}/p.jpg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h1>Priyanshi</h1>
					</div>
				</div>
			</div>




			<div class="col-sm-4 img-hover" style="text-align: center">
				<img src="${images}/pa.jpg" class="img-rounded"
					style="width: 250px; height: 250px">
				<div class="middle">
					<div class="text">
						<h1>Parul</h1>
					</div>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>