<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Configuration</title>
</head>
<body>
<div align="center">
<jsp:include page="Header.jsp"/>
<h1> Configuration Page</h1>


<f:form action="saveConfig" modelAttribute="pObj" method="post" id="projectform">


<label>Projects:</label>
		<f:select path="projectId" >

			 	 <core:forEach items="${proj}" var="pOb">

					<f:option value="${pOb.projectId}">${pOb.projectName}</f:option>

				 </core:forEach>

			</f:select></br>
			

			


			<div><label>Role:</label>

				<f:select path="roleId" >

				 	 <core:forEach items="${roles}" var="rOb">

						<f:option value="${rOb.roleId}">${rOb.roleName} </f:option>

					 </core:forEach>

				</f:select></div>

			
			

			<div><label>Location:</label></br>

			

				<div class="custom-control custom-radio">	

					<f:radiobutton path="location" value="Onsite" class="custom-control-input" id="Onsite"/>

					<label class="custom-control-label" for="Onsite">Onsite</label>

				</div>

				<div class="custom-control custom-radio">

					<f:radiobutton path="location" value="Offshore" class="custom-control-input" id="Offshore" checked = "checked"/>

					<label class="custom-control-label" for="Offshore">Offshore</label>

				</div>

			</div>	

			<br><div class="form-group">

	    			<label>Per Hour Billing  : </label> <f:input type="number" path="perHourBilling" size="30" cssClass="form-control" placeholder="Enter Per Hour Billing" required="required"/>
		   

			 </div>

			

			<div class="form-group">

			    <button type="submit" class="btn btn-primary">Submit</button>

			 </div>


</f:form>

</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>