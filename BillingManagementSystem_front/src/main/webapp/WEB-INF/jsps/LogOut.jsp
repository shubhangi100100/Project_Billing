<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
     <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
    history.forward();
 </script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Home Page</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
		<div style="text-align: center;font-family: verdana;color:#000080" class="alert alert-success">
				You have been logged Out Succesfully. To Login <a href="login">Click Here</a> 
		</div>

		
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>