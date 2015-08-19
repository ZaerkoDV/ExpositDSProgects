<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main Page</title>


    <!-- Bootstrap-->
   
    <link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	  
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

 
  </head>
  <body>
    <div class="container">
    <div class="row">
      <div class="col-md-4">
          <h2>Service Stations</h2>
      </div>
      <div class="col-md-6">
      </div>
      <!-- sec:authorize access="isAuthenticated()" >
      <div class="col-md-2" style="margin-top: 30px;">
      <a href="<c:url value="/ServiceStationManagementSystem/profile" />">${ClientSecurityFeature.clientLogin}</a><br>
      <a href="<c:url value="/ServiceStationManagementSystem/logout" />" style="margin-left: 50px;"><button type="button" class="btn btn-default">Logout</button></a>
      </div>
      <!-- /sec:authorize -->
      <!-- sec:authorize access="!isAuthenticated()" -->
      <div class="col-md-2" style="padding-top: 20px;">
      <c:url value="/j_spring_security_check" var="loginUrl" />
         <form class="form-inline" action="${loginUrl}" method="post">
		  <div class="form-group">
		    <input type="login" class="form-control" id="exampleInputEmail3" name="j_username" placeholder="Login">
		  </div><br>
		  <div class="form-group" style="margin-top: 5px;">
		    <input type="password" class="form-control" id="exampleInputPassword3" name="j_password" placeholder="Password">
		  </div><br>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox" name="_spring_security_remember_me"> Remember me
		    </label>
		  </div><br>
		  <a href="<c:url value="/ServiceStationManagementSystem/login" />"><button type="submit" class="btn btn-default">Sign in</button></a>
          <a href="<c:url value="/registration" />"><button type="button" class="btn btn-default">Sign up</button></a><br>
		</form>
      </div>
      <!-- /sec:authorize -->
    </div>
   <!-- c:if test="${!empty listServiceStation}" -->  
    <table class="table table-hover" style="margin-top: 50px;">
  	<tr>
  		<th>Logotype</th>
  		<th>Name</th>
  		<th>Location</th>
  		<th>Mark</th>
  		<th>Go</th>
  	</tr>
  <!--  c:forEach items="${listServiceStation}" var="ServiceStation" --> 
  	<tr style="font-size: 18px;">
  		<td><img src="resources/img/logo.png" alt="Logo" class="img-circle"></td>
  		<td>${ServiceStation.serviceStationName}</td>
  		<td>${ServiceStation.serviceStationAddress}</td>
  		<td>${ServiceStation.mark}</td>
  		<td><a href="<c:url value='/station/${ServiceStation.idServiceStation}' />"><button type="button" class="btn btn-primary">Go</button></a></td>
  	</tr>
  <!--  /c:forEach --> 
	</table>
    <!-- /c:if --> 
    </div> 
  </body>
</html>