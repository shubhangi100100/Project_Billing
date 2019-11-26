<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View developer report</title>
</head>
<body>
<jsp:include page="Header2.jsp"/>
<div align="center">
<form action="saveReport"  method="get">

					<div>

						<label>Employee :</label>

						<select name="employeeId">

						 	 <core:forEach items="${aList}" var="pOb">

								<option value="${pOb.eObj.employeeId}" >${pOb.eObj.employeeName}</option>

							 </core:forEach>

						</select><br>

					</div>
					<div>

						<label>Month :</label>

						<select  name="month" required="true">

							<option value="january">January</option>

							<option value="february">February</option>

							<option value="march">March</option>

							<option value="april">April</option>

							<option value="may">May</option>

							<option value="june">June</option>

							<option value="july">July</option>

							<option value="august">August</option>

							<option value="september">September</option>

							<option value="october">October</option>

							<option value="november">November</option>

							<option value="december">December</option>

						</select>

						<br>

					</div>

					

					
<!-- 
					<div>
					<label>Year :</label>
		<f:select path="year" id="year" cssClass="form-control" required="true">

			<f:option value="0">Select year</f:option>
			<script type="text/javascript">
			for(y=2019;y<2020;y++){
				var optn = document.createElement("OPTION");
				optn.text=y;
				optn.value=y;
				
				if(y==2019){
					optn.selected=true;
				}
				document.getElementById('year').options.add(optn);
			}
		</script>
		</f:select>
		</div>
			-->
		
		
				 	<label>Year :</label>

					<input type="number" name="year" size="30"  placeholder="Select Year" required/><br>

					</div>


					<div class="form-group">

							    <button type="submit" class="btn btn-primary">Submit</button>

					</div>

				</form>
				</div>
</body>
</html>