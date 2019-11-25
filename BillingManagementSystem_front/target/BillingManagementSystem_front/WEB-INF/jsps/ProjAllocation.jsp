<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<jsp:include page="Header1.jsp"/>
<form action="submitAllocation"  method="get">
<h1 align="center"> Project Allocation Page</h1>
				<label>Projects:</label>
			<select name="projectId">
			 	 <core:forEach items="${proj}" var="pOb">
					<option value="${pOb.projectId}">${pOb.projectName}</option>
				 </core:forEach>
			</select><br>
 			<div>
			<label>Role:</label>
				<select name="roleId">
				 	 <core:forEach items="${roles}" var="rOb">
						<option value="${rOb.roleId}">${rOb.roleName} </option>
					 </core:forEach>
				</select><br>
			</div>
 		<label>Location:</label>
			<div>
				<div class="custom-control custom-radio">	
					 <input type="radio" name="location" value="Onsite" checked> Onsite<br>
 					 <input type="radio" name="location" value="Offshore"> Offshore<br>
					
					
					
				</div>
			</div>	
			<label>	Employees:</label>
			<select name="employeeId">
			  
				 	 <core:forEach items="${emp}" var="rOb">
						<option value="${rOb.employeeId}">${rOb.employeeName} </option>
					 </core:forEach>
				</select><br>
				
			
				<div class="form-group">
				    <button type="submit" class="btn btn-primary">Submit</button>
				 </div>
			</form>
			</div>
			
			<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>