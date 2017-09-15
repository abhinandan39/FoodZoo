<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<c:url var="css" value="/resources/css"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<c:url var="images" value="/resources/images"></c:url>
<title>Insert title here</title>
</head>
<style>

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
    margin-left: 800px;
    margin-top:50px;
    margin-bottom:100px;
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
#gif
{
margin-left:550px;
margin-top:100px;
}

.backgroundimage {
	background-image: url('${images}/food1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	opacity: 0.8;
}
 
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="backgroundimage">
<div id="gifback">
<img id="gif" class="nlSABoG9CSaJpsufv8WW9 _3vYn8QjoEvrXxHyqdn9ddZ _2XBDTIVigBJDybhZvL-hU3" src="https://media.giphy.com/media/3o7TKUUFxxtDcRYwCs/200w.webp" srcset="https://media.giphy.com/media/3o7TKUUFxxtDcRYwCs/200w.webp 200w,
            https://media.giphy.com/media/3o7TKUUFxxtDcRYwCs/giphy.webp 480w" sizes="500px" alt="">           
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
</div>
</div>
<jsp:include page="footer.jsp" ></jsp:include>


</body>
</html>