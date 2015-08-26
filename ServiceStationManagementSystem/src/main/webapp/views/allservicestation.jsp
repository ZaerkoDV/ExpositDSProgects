<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>All service satation list</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
			
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
/*
body {
	height: 100%;
	margin: 0;
    background: url(resources/img/background.jpg);
    background-size: 100% 250%; 
    background-repeat: repeat;
    display: compact;
}*/


.navbar-customt {
	opacity:1;
  	filter:alpha(opacity=100);
} 

</style>

</head>
<body>

	<div class="container">
	    <nav class="navbar navbar-custom">
		  <div class="container-fluid">
			<div class="navbar-header">	</div>
			<div>
				<ul class="nav nav-pills navbar-right">
					
					<li class="active"><a href="<spring:url value="/"/>">To start page</a></li>
					<li class="active"><a href="#">Help</a></li>
	
					<form class="navbar-form navbar-right">
						<input type="text" class="form-control" placeholder="Search">
					</form>
				</ul>
			</div>
		  </div>
		</nav>
	</div>
	  
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
   <div class="container">      
	<c:if test="${!empty listServiceStation}">      
	  <table class="table table-hover">
	     <thead>
		   	 <tr>
				<th>Logotype</th>
				<th>Name</th>
				<th>Address</th>
				<th>Telephone</th>
				<th>Go to page</th>
			 </tr>
		 </thead>
		 <tbody>
			<c:forEach var="listServiceStation" items="${listServiceStation}">
			    <tr>
				 <td>${listServiceStation.serviceStationLogotype}</td>
				 <td>${listServiceStation.serviceStationName}</td>
				 <td>${listServiceStation.serviceStationAddress}</td>
				 <td>${listServiceStation.serviceStationPhoneNumber}</td>
				 <td>
				  <a href="<c:url value='/station/${listServiceStation.idServiceStation}' />">
						<button	type="button" class="btn btn-link">Service station page</button>
				  </a>
				 </td>
				</tr>
			</c:forEach>
		  </tbody>
	   </table>
     </c:if > 
   </div>

</body>
</html>