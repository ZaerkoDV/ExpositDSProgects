<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>

<!--
	   <link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	   <script src="resources/libs/jquery.min.js"/></script>
	   <script src="resources/libs/bootstrap.min.js"/></script>
-->	
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	


	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Service Station Management System Login success</h3>
		</div>
		<div class="panel-body">
		<div class="alert alert-dismissable alert-info">
              <button type="button" class="close" data-dismiss="alert">�</button>
              <strong>Well done!</strong> You successfully logged-into the system. Now you can explore the complete features!
            </div>
		</div>
	</div>
	<div></div>
	<div></div>
	<a class="btn btn-primary" href="<spring:url value="/"/>">Login as different user?</a>
	<a class="btn btn-primary" href="<spring:url value="/"/>">Exit to start page</a>
</body>
</html>