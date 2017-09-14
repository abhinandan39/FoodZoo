<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
   <%--  <%@import uri='https://fonts.googleapis.com/css?family=Josefin+Sans'%> --%>
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
<!-- <script>
$('.sad-face').click(function() {

	$(this).css('animation','sadAnimationOn 1.5s forwards ');
	$(this).css('z-index','0');
	$('.btn-body').css('background-color','#29b5cd');
	$('.happy-face').css('animation','happyAnimationOn 1.5s forwards ');
	$('.shadow').css('animation','happyAnimationOn 1.5s forwards ');
	$('.happy-face').css('z-index','1');
	$('.switch-status p').text('On');



});

$('.happy-face').click(function() {

	$(this).css('animation','sadAnimationOff 1.5s forwards ');
	$(this).css('z-index','0');
	$('.btn-body').css('background-color','#c6c6c6');
	$('.sad-face').css('animation','happyAnimationOff 1.5s forwards ');
	$('.shadow').css('animation','happyAnimationOff 1.5s forwards ');
	$('.sad-face').css('z-index','1');
	$('.switch-status p').text('Off')

});

</script> -->
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

 <!-- <div class="wrapper">
  <div class="switch-status">
    <p>Status</p>
  </div>
  <div class="btn-body">
  <img src="https://www.dropbox.com/s/fi7ygnyz1fynvdu/sad-face.png?raw=1" class="sad-face"/>
  <img src="https://www.dropbox.com/s/fi7ygnyz1fynvdu/sad-face.png?raw=1" class="happy-face"/>
  <img src="https://www.dropbox.com/s/kffllh54iluxwv8/img-shadow.png?raw=1" class="shadow"/>
  </div>
  
</div>
 -->
			


			<%-- <div class="col-sm-4 img-hover" style="text-align: center">
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
 --%>
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
<!-- <input type="radio" name="reason">
Did not like our service
<br>
<input type="radio" name="reason">
Temporary deactivate
<br>
<input type="radio" name="reason">
It diverts your mind
<br>
<input type="radio" name="reason">
Not worth
<br>
<input type="radio" name="reason">
<br>
<input type="submit" name="deactivate"> -->
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
</html>