<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>completed</title>
</head>
<body>
<jsp:include page="AdminHeader.jsp"/>
<div align="center">

<core:if test="${not empty msg}">
		<div style="text-align: center;font-family: verdana;color:#000080" class="alert alert-success">${msg}
		</div>
		</core:if>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>