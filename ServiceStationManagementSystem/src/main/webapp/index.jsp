<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
 <head>
 	<title>Welcome on index page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
  
    <link href="resources/libs/bootstrap.min.css" rel="stylesheet">
    <script src="resources/libs/jquery.min.js"/></script>
    <script src="resources/libs/bootstrap.min.js"/></script>
<!--
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 -->
<style>

body {
	height: 100%;
	margin: 0;
    background: url(resources/img/index.jpeg);
    background-size: 100% 200%; 
    background-repeat: no-repeat;
    display: compact;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}


</style>  

</head>
 <body>
 
	<div class="container">
	   <nav class="navbar navbar-custom">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Service Station Management System</a>	
			</div>
			<div>
				<ul class="nav nav-pills navbar-right">
					<form id="loginForm" action="/ServiceStationManagementSystem/index" method="POST" class="navbar-form navbar-right"><!-- commandName="clientSecurityFeature" -->
						<div class="form-group">
							<p>
								<input type="text" id="loginInput" name="login" class="form-control" placeholder="Login" />
								<!--<errors path="clientLogin" cssClass="error"/>-->
							</p>
							<p>
								<input type="text" id="passwordInput" name="password" class="form-control" placeholder="Password" />
								<!--<errors path="clientPassword" cssClass="error"/>-->
							</p>
							  <div class="checkbox">
					   			 <label><input type="checkbox" name="_spring_security_remember_me"> Remember me</label>
					 		  </div>
							<p>
								<button  type="submit" class="btn btn-primary">Sign In</button>
								<a class="btn btn-primary" href="<spring:url value="/registration"/>">Sign Up</a> 
							</p>
						</div>
					</form>			
				</ul>
			</div>
		</div>
	  </nav>
   </div>


   <div class="container">   
	    <!--
		<div class="col-lg-6">
			<div class="col-md-6"></div>
			    <sec:authorize access="isAuthenticated()">
				  <div class="col-md-2" style="margin-top: 30px;">
				      <a href="<c:url value="/ServiceStationManagementSystem/profile" />">${ClientSecurityFeature.clientLogin}</a><br>
					  <a href="<c:url value="/ServiceStationManagementSystem/logout" />" style="margin-left: 50px;">
					  <button type="button" class="btn btn-default">Logout</button></a>	
					  if ok
				  </div>
			    </sec:authorize>
			    <sec:authorize access="!isAuthenticated()">
				  <div class="col-md-2" style="padding-top: 20px;">
					<c:url value="/j_spring_security_check" var="loginUrl"/>
					if fail
				  </div>
		      </sec:authorize>
		</div>
	    -->
	  <!--c:if test="${!empty listServiceStation}"-->      
	   <table class="table table-hover">
	        <thead>
		   	   <tr>
				  <th>Logotype</th>
				  <th>Name</th>
				  <th>Address</th>
				  <th>Mark</th>
				  <th>Go</th>
			   </tr>
		   </thead>
		   <tbody>
		      <!--c:forEach items="${listServiceStation}" var="ServiceStation"-->
				<tr style="font-size: 18px;">
					<td><img src="resources/img/logo.png" alt="Logo" class="img-circle"></td>
					<td>${ServiceStation.name}</td>
					<td>${ServiceStation.location}</td>
					<td>${ServiceStation.mark}</td>
					<td>
					  <a href="<c:url value='/station/${ServiceStation.id}' />">
						<button	type="button" class="btn btn-primary">Go</button>
					  </a>
				 	</td>
				</tr>			
			<!--/c:forEach-->
		   </tbody>
	   </table>
     <!--/c:if --> 
   </div>

</body>
</html>
