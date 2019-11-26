<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>your report is here
</title>
</head>
<body>
<jsp:include page="Header2.jsp"/>
<h3>Employee Billing</h3><hr>

			

				<h5>Employee ID : ${eID}</h5>

				<h5> Name :<strong> ${name}</strong></h5>

				<h5>Month : ${mnth}</h5>

				<h5>Year: ${yr} </h5>

				<h5>Billing : <strong>$ ${bill}</strong></h5>
  <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>