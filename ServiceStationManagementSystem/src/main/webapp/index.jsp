<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main Page</title>

    <!-- Bootstrap
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	    -->
	   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	  <!-- Latest compiled and minified CSS -->


<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container">
    <div class="row">
      <div class="col-md-4">
          <h2>Service Stations</h2>
      </div>
      <div class="col-md-8" style="padding-top: 20px;">
         <form class="form-inline">
		  <div class="form-group">
		    <input type="login" class="form-control" id="exampleInputEmail3" placeholder="Login">
		  </div>
		  <div class="form-group">
		    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
		  </div>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox"> Remember me
		    </label>
		  </div>
		  <a href="#"><button type="submit" class="btn btn-success">Sign in</button></a>
          <a href="/ServiceStationManagementSystem/registration"><button type="button" class="btn btn-primary">Sign up</button></a>
		</form>
      </div>
    </div>
   <c:if test="${!empty listServiceStation}">  
    <table class="table table-hover" style="margin-top: 50px;">
  	<tr>
  		<th>Logotype</th>
  		<th>Name</th>
  		<th>Location</th>
  		<th>Mark</th>
  		<th>Go</th>
  	</tr>
  <c:forEach items="${listServiceStation}" var="ServiceStation"> 
  	<tr style="font-size: 18px;">
  		<td><img src="img/logo.png" alt="Logo" class="img-circle"></td>
  		<td>${ServiceStation.name}</td>
  		<td>${ServiceStation.location}</td>
  		<td>${ServiceStation.mark}</td>
  		<td><a href="<c:url value='/ServiceStationManagementSystem/station/${SercieStation.id}' />"><button type="button" class="btn btn-primary">Go</button></a></td>
  	</tr>
  </c:forEach> 
	</table>
    </c:if> 
    </div> 
  </body>
</html>