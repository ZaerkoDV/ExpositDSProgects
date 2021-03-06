<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

#bg {
        position:fixed;
        top:-50%;
        left:-50%;
        width:200%;
        height:200%;
}
#bg img {
        position:absolute;
        top:0;
        left:0;
        right:0;
        bottom:0;
        margin:auto;
        min-width:50%;
        min-height:50%;
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

.rightmenu{
	position: relative;
	left: 1100px;

}

</style>  

</head>
 <body style="height: 200px; width: 1600px;">
 
 <div id="bg"><img src="resources/img/index.jpg" alt=""></div>
 
	<div class="container">
	   <nav class="navbar nav-tab">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Service Station Management System </a>	
			</div>
			<div>
				<ul class="nav nav-pills navbar-right">
					<form id="signInByLoginPasswordForm" action="/ServiceStationManagementSystem/index" method="POST" class="navbar-form navbar-right"><!-- commandName="clientSecurityFeature" -->
						<div class="form-group">
			
							<p>
							   <input type="text" id="loginInput" name="login" class="form-control" placeholder="Login" />
							</p>
							<p>
							   <input type="text" id="passwordInput" name="password" class="form-control" placeholder="Password" />
							</p>
							  <div class="checkbox">
					   			 <label><input type="checkbox" name="_spring_security_remember_me">Remember me</label>
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
   
   
   <div class="rightmenu" style="width: 1100px;">
	   <div class="col-md-3">
	      <ul class="nav nav-pills nav-stacked">
	        <li class="active"><a href="<spring:url value="/allservicestation"/>">All service station</a></li>
	      </ul>
	   </div>
	   <div class="clearfix visible-lg"></div>
   </div>
   
</body>
</html>
