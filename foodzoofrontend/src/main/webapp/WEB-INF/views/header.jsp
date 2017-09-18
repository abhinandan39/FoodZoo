
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
.navbar-right{
	padding-right:10px;
}

.dropdown {
	position: relative;
	cursor: default;
	margin-top: 12px;
	color: #404040;
	text-align: center;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	cursor: default;
	opacity:0.9;
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
	right:0;
	left:auto;
	display: block;
}

.barss {
	margin-top: 3px;
}

.search {
	
}


#sessionuser{
	margin-top:14px;
} 
.search-form .form-group {
  float: right !important;
  transition: all 0.35s, border-radius 0s;
  width: 32px;
  height: 32px;
  margin-top:12px;
  background-color: #fff;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
  border-radius: 25px;
  border: 1px solid #ccc;
}
.search-form .form-group input.form-control {
  padding-right: 20px;
  border: 0 none;
  background: transparent;
  box-shadow: none;
  display:block;
}
.search-form .form-group input.form-control::-webkit-input-placeholder {
  display: none;
}
.search-form .form-group input.form-control:-moz-placeholder {
  /* Firefox 18- */
  display: none;
}
.search-form .form-group input.form-control::-moz-placeholder {
  /* Firefox 19+ */
  display: none;
}
.search-form .form-group input.form-control:-ms-input-placeholder {
  display: none;
}
.search-form .form-group:hover,
.search-form .form-group.hover {
   
  width: 100%;
  border-radius: 4px 25px 25px 4px;
}
.search-form .form-group:focus,
.search-form .form-group.focus {
   
  width: 100%;
  border-radius: 4px 25px 25px 4px;
}
.search-form .form-group span.form-control-feedback {
  position: absolute;
  top: -1px;
  right: -2px;
  z-index: 2;
  display: block;
  width: 34px;
  height: 34px;
  line-height: 34px;
  text-align: center;
  color: #000;
  left: initial;
  font-size: 14px;
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
			<li class="nav-item ${homeactive}"><a class="nav-link" href="home">Home
					<span class="glyphicon glyphicon-home"></span>
			</a></li>

			<li class="nav-item ${contactactive}"><a class="nav-link" href="contact">Contact
					<span class="glyphicon glyphicon-user"></span>
			</a></li>
			<li class="nav-item ${aboutusactive}"><a class="nav-link" href="aboutus">About
					Us <i class="fa fa-info-circle" aria-hidden="true"></i></i>
			</a></li>

			<li class="nav-item barss">
				<div class="dropdown menn">
					
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
			</ul>
        	<div class="col-sm-2 col-md-2">
	            <form action="" class="search-form">
	                <div class="form-group has-feedback">
	            		<label for="search" class="sr-only">Search</label>
	            		<input type="text" class="form-control" name="search" id="search" placeholder="Cuisine, Dishes">
	              		<span class="glyphicon glyphicon-search form-control-feedback"></span>
	            	</div>
	            </form>
        	</div>
        		

		<ul class="nav navbar-nav navbar-right">
			
			
			
			<c:if test="${ empty sessionusername}">
				<li class="nav-item ${cartactive}"><a href=""><span
					class="glyphicon glyphicon-shopping-cart"></span> Cart </a></li>
				<li class="nav-item ${registeractive}"><a href="signup"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li class="nav-item ${loginactive}"><a href="loginhere"><span
						class="glyphicon glyphicon-log-in"></span> Log In</a></li>
				
			</c:if>
			
			<c:if test="${not empty sessionusername}">
				<li class="nav-item" id="sessionuser">
				 ${sessionusername}
					<span class="glyphicon glyphicon-user">  </span> 
				</li>
				<c:if test="${adminRole == 'ROLE_ADMIN' }">
				<li class="nav-item barss" style="margin-left:9px;">
				<div class="dropdown">
				 <span> Manage <i class="fa fa-cog" aria-hidden="true"></i></span> 
						 	 <div class="dropdown-content">
						     <p><a href="manageCategory"> Categories </a></p>
					     	 <p><a href="manageSupplier"> Suppliers </a></p>
					     	 <p><a href="manageProduct"> Products </a></p>
			   		 		 </div>
				</div>
				</li>
				</c:if>
				<li class="nav-item ${cartactive}"><a href="">
				Cart
				<span class="glyphicon glyphicon-shopping-cart"></span>  </a></li>
				<li class="nav-item"><a href="logout"><span class="glyphicons glyphicons-log-out"></span> Logout </a></li>
				<c:if test="${sessionrole == 'ROLE_USER'}">
				<li class="nav-item barss">
				<div class="dropdown">
				 <span> Settings <i class="fa fa-cog" aria-hidden="true"></i></span>
						 	 <div class="dropdown-content">
						     <p><a href="profile">Profile</a></p>
					     	 <p><a href="deactivate">Deactivate</a></p>
			   		 		 </div>
				</div>
				</li>
				</c:if>
				<c:if test="${sessionrole == 'ROLE_ADMIN'}">
				<li class="nav-item barss">
				<div class="dropdown">
				 <span> Settings <i class="fa fa-cog" aria-hidden="true"></i></span>
						 	 <div class="dropdown-content">
						     <p><a href="profile">Profile</a></p>
					     	 <p><a href="deactivate">Deactivate</a></p>
					     	 <p><a href="adminPanel">Admin Panel</a></p>
			   		 		 </div>
				</div>
				</li>
				</c:if>
				
						
		     	</c:if>
			
		</ul>

	</div>
	</nav>
</body>
</html>
