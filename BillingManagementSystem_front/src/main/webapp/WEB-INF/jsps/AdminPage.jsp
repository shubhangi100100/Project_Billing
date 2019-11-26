<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> Hello Admin</title>
</head>
<body>
<jsp:include page="Header1.jsp"/>

<h1 align="center"> Welcome Admin</h1>

<core:if test="${not empty text1}">
		<div style="text-align: center;font-family: verdana;color:#000080" class="alert alert-success">${text1}
		</div>
		</core:if>
		<div align="center">
      <a href="getConfig">Configure Project</a>
      <a href="getAllocation">Allocate Project</a>
      <a href="viewReport">View Report</a>
      <jsp:include page="Footer.jsp"></jsp:include>
    </div>
  


</body>
</html>