
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<c:url var="images" value="/resources/images"></c:url>
<c:url var="css" value="/resources/css"></c:url>
<link rel="stylesheet" href="${css}/headstyle.css">
<style>
.navbar .nav>li>a:hover {
	background-color: #1f7a1f;
	color: white;
}

.navbar .nav>.active>a {
	background-color: #1f7a1f;
	opacity: 0.7;
	color: white;
}

.dropdown {
	position: relative;
	margin-top: 12px;
	color: #404040;
	text-align: center;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: white;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
	z-index: 1;
}

.dropdown:hover {
	color: green;
}

.dropdown-content>p {
	padding: 5px;
	color: black;
}

.dropdown-content>p:hover {
	color: green;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.barss {
	margin-top: 3px;
}

.search {
	margin-top: 0px;
}

.searchbutton {
	
}
</style>
</head>
<body>

	<nav class="navbar navbar-light bg-faded ">
	<div class="container-fluid">
		<div class="navbar-header">
			<img src="${images}/foodlogo.png" height="50px">
		</div>
		<ul class="nav navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="home">Home
					<span class="glyphicon glyphicon-home"></span>
			</a></li>

			<li class="nav-item"><a class="nav-link" href="contact">Contact
					<span class="glyphicon glyphicon-user"></span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="aboutus">About
					Us <i class="fa fa-info-circle" aria-hidden="true"></i></i>
			</a></li>

			<li class="nav-item barss">
				<div class="dropdown">
					<span> Menu <i class="fa fa-bars" aria-hidden="true"></i></span>
					<div class="dropdown-content">
						<p>North Indian</p>
						<p>South Indian</p>
						<p>Thailand</p>
						<p>Italian</p>
						<p>Dessert</p>
					</div>
				</div>
			</li>
			<li class="nav-item search">
				<form class='navbar-form'>
					<div class='input-group'>
						<input class='form-control' type='text' name='search'
							placeholder='Cuisine, Dishes' /> <span class="input-group-btn">
							<button type='submit' class='btn btn-default searchbutton'>
								<span class='glyphicon glyphicon-search'></span>
							</button>
						</span>

					</div>
				<!-- 	<div class='form-group'>
						<input class='form-control' type='text' name='search'
							placeholder='Cuisine, Dishes' /> 
							<button type='submit' class='btn btn-default searchbutton'>
								<span class='glyphicon glyphicon-search'></span>
							</button>
						

					</div> -->
				</form>
			</li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href=""><span
					class="glyphicon glyphicon-shopping-cart"></span> Cart </a></li>
			<li><a href="signup"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>
			<li><a href="signup"><span
					class="glyphicon glyphicon-log-in"></span> Log In</a></li>

		</ul>

	</div>
	</nav>
</body>
</html>
