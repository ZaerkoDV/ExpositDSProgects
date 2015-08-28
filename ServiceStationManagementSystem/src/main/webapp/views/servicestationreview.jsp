<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
 <head>
     	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Service station page</title>
    	<!--
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	    -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		
<style>
</style>

</head>
<body>
 
 	<div class="container">
	    <nav class="navbar navbar-default">
		  <div class="container-fluid">
			<div class="navbar-header">Name service station ${serviceStation.serviceStationName}</div>
			<div>
				<ul class="nav nav-pills navbar-right">
					<li class="active"><a href="<spring:url value="/"/>">To start page</a></li>
					<li class="active"><a href="<spring:url value="/profile/incompleteclientneword"/>">Make order</a></li>
					<li class="active">
					  <a href="#demo" class="btn btn-primary" data-toggle="collapse">Show all my order</a>
					  <div id="demo" class="collapse">
					  
					    <form:form id="signInByEmailForm" commandName="client" action="/ServiceStationManagementSystem/servicestation/${serviceStation.idServiceStation}/servicestationreview" method="POST" class="navbar-form navbar-right">
					     	<fieldset>
					     	  <div class="form-group">
						    	  <div>
								      <form:input type="text" id="clientEmail" path="clientEmail" class="form-control" placeholder="Email"/>
								   </div>
								   <div>
										<p><form:button type="submit" class="btn btn-xs btn-primary">Sign In</</form:button></p>
								   </div>
								 </div>
							</fieldset>
						</form:form>
						
					  </div>
					</li>
				</ul>
			</div>
		  </div>
		</nav>
	</div>
     
      <h4>Information about service station: </h4>
        <div class="col-md-2">
          <p>Address: </p>
          <p>Phone number: </p>
          <p>Departments: </p>
          <p>Clients: </p>
        </div>
        <div class="col-md-4">
          <p>${serviceStation.serviceStationAddress}</p>
          <p>${serviceStation.serviceStationPhoneNumber}</p>
          <p>${countDepartment}</p>
          <p>${clientCount}</p>
        </div>
  
        <c:if test="${!empty listServiceStationCommentMark}">
          <table class="table table-hover">
           <thead>
             <tr>
                <th>Comment: </th>
                <th>Author: </th>
                <th>Mark: </th>
             </tr>
           </thead>
           </tbody>
	          <c:forEach items="${listServiceStationCommentMark}" var="serviceStationCommentMark">
	          <tr>
	            <td>${serviceStationCommentMark.comment}</td>
	            <td>${serviceStationCommentMark.client.clientFirstName} ${serviceStationCommentMark.client.clientLastName}</td>
	            <td>${serviceStationCommentMark.mark}</td>
	          </tr>
	          </c:forEach>
           </tbody>
          </table>
        </c:if>
      
  </body>
</html>