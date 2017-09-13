<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form id="loginform" action="login" method="post">
	<input type="text" name="username" placeholder="Enter username" required />
	<input type="password" name="password" placeholder="Enter Password" required />
	<input type="submit" value="submit">
</form>
<span style="color:red;">${errormsg}</span>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>