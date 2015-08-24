<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @author Artyom_Khomyakov -->
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Station</title>

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
      <div class="row" style="padding-top: 150px;">
           <div class="col-md-2"><a href="#"><button type="button" class="btn btn-default">Back</button></a></div>
           <div class="col-md-4"><h3>${serviceStation.serviceStationName}</h3></div>
           <div class="col-md-2"><a href="<c:url value='/station/${serviceStation.idServiceStation}/request/' />"><button type="button" class="btn btn-danger">Make a request</button></a></div>
      </div>
      <h4>Main information: </h4>
      <div class="row" style="padding-top: 50px;">
        <div class="col-md-2">
          <p>Address: </p>
          <p>Phone number: </p>
          <p>Mark: </p>
        </div>
        <div class="col-md-4">
          <p>${serviceStation.serviceStationAddress}</p>
          <p>${serviceStation.serviceStationPhoneNumber}</p>
          <!-- p>${serviceStationCommentMark.mark}</p -->
        </div>
      </div>
      <h4>Check status: </h4>
      <form class="form-inline">
        <div class="form-group">
          <input type="email" class="form-control" id="email" placeholder="email">
        </div>
        <a href="<c:url value='/station/${idServiceStation}/check' />"><button type="submit" class="btn btn-default">Check</button></a>
      </form>
      <div class="row" style="padding-top: 50px;">
        <c:if test="${!empty listServiceStationCommentMark}">
        <table class="table">
          <tr>
            <th>Comment: </th>
            <th>From: </th>
            <th>Mark: </th>
          </tr>
          <c:forEach items="${listServiceStationCommentMark}" var="ServiceStationCommentMark">
          <tr>
            <td>${ServiceStationCommentMark.comment}</td>
            <td>${ServiceStationCommentMark.client}</td>
            <td>${ServiceStationCommentMark.mark}</td>
          </tr>
          </c:forEach>
        </table>
        </c:if>
      </div>
  </body>
</html>