<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<c:url var="css" value="/resources/css"></c:url>
	<c:url var="images" value="/resources/images"></c:url>
<title>Insert title here</title>
</head>
<style>
 * {
  box-sizing: border-box;
 
}

html, body {
  height: 100%;
  font-family: 'Josefin Sans', sans-serif;
}

.wrapper {
  height: 500px;
  width: 350px;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
}

.wrapper .switch-status p {
  font-size: 50px;
  text-align: center;
  color: #888;
  margin: 0 0 60px 0;
}

.wrapper p {
  font-size: 21px;
  padding-top: 50px;
  text-align: center;
  color: #666;
}

.wrapper p a {
  font-weight: bold;
  color: #29B5CD;
}

.wrapper .btn-body {
  width: 350px;
  height: 120px;
  border-radius: 60px;
  background-color: #c6c6c6;
  box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3) inset;
  position: relative;
  transition: all 1s ease-in-out;
}

.wrapper .btn-body img {
  width: 200px;
  position: absolute;
  cursor: pointer;
  top: -50px;
  left: -50px;
}

.wrapper .btn-body img.sad-face {
  z-index: 1;
}

.wrapper .btn-body img.happy-face {
  z-index: 0;
}

.wrapper .btn-body img.shadow {
  -webkit-filter: drop-shadow(0px 5px 5px black);
          filter: drop-shadow(0px 5px 5px black);
}

@-webkit-keyframes sadAnimationOn {
  from {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: -50px;
    opacity: 1;
  }
  to {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
    left: 250px;
    opacity: 0;
  }
}

@keyframes sadAnimationOn {
  from {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: -50px;
    opacity: 1;
  }
  to {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
    left: 250px;
    opacity: 0;
  }
}

@-webkit-keyframes happyAnimationOn {
  from {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: -50px;
    opacity: 0;
  }
  to {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
    left: 250px;
    opacity: 1;
  }
}

@keyframes happyAnimationOn {
  from {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: -50px;
    opacity: 0;
  }
  to {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
    left: 250px;
    opacity: 1;
  }
}

@-webkit-keyframes sadAnimationOff {
  from {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
    left: 250px;
    opacity: 1;
  }
  to {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
    left: -50px;
    opacity: 0;
  }
}

@keyframes sadAnimationOff {
  from {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: 250px;
    opacity: 1;
  }
  to {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: -50px;
    opacity: 0;
  }
}

@-webkit-keyframes happyAnimationOff {
  from {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: 250px;
    opacity: 0;
  }
  to {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: -50px;
    opacity: 1;
  }
}

@keyframes happyAnimationOff {
  from {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: 250px;
    opacity: 0;
  }
  to {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
    left: -50px;
    opacity: 1;
  }
} 

/* Full-width input fields */
#username1,#password1{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
#button1{
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
    margin-left: 700px;
    margin-top:350px;
    margin-bottom:350px;
}
#button2 {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
    margin-left:200px;
}

/* Float deactivate buttons and add an equal width */
.deactivate{margin-left: 200px;width:50%}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: 	grey;
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
#close {
    position: absolute;
    right: 35px;
    top: 15px;
    color: #000;
    font-size: 40px;
    font-weight: bold;
}

#close:hover,
#close:focus {
    color: red;
    cursor: pointer;
}

/* Clear floats */
/* .clearfix::after {
    content: "";
    clear: both;
    display: table;
} */

/* Change styles for deactivate button on extra small screens */
@media screen and (max-width: 300px) {
     .deactivate{
       width: 50%;
       margin-left: 70px;

    }
    
}
#footer1
{
margin-top: 400px;
}


</style>
<body>
<jsp:include page="header.jsp"></jsp:include>


<button id="button1" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Deactivate</button>
<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" id="close" title="Close Modal">×</span>
  <form class="modal-content" action="question">
    <div class="container">
      <label><b>Username</b></label>
      <input type="text" placeholder="Enter UserName" name="username" id="username1" required>

      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="password1" required>
          <div >
        
        <button id="button2" type="submit" class="deactivate">Deactivate</button>
      </div>
      <%-- <span>${deactivateerror}</span> --%>
</div>
         
</form>
</div>


<jsp:include page="footer.jsp" ></jsp:include>


</body>
</html>