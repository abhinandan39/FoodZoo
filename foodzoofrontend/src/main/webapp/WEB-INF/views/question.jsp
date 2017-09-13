<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
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


<div class="row">
<div class="container">
<div class="col-sm-12">
<form action="finaldeactivate">
<input type="hidden" name="username">
Reason to Deactivate:
<input type="radio" name="reason">
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
<input type="submit" name="deactivate">
<jsp:include page="footer.jsp"></jsp:include>
</form>
</div>
</div>
</div>
</body>
</html>