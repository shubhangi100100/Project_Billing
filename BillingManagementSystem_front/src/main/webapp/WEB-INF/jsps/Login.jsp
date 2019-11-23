<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title> Login Form</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div align="center" class="container">
  
  <form action="OpenPage" method="post" >
    <div class="form-group">
      <label for="ID"> ID:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter ID" name="userid">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    </div>
   <!--  <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    --> 
    <button type="submit" class="btn btn-default">Submit</button>
    <jsp:include page="Footer.jsp"></jsp:include>
  </form>
</div>

</body>
</html>