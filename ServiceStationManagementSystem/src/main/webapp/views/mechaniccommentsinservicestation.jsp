<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Mechanic comments in service ststion</title>
 <!--  
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
 --> 	    	   
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
  	  <nav class="navbar navbar-default">
		  <div class="container-fluid">
			    <div class="navbar-header">
			      <h2>Comments in service station ${serviceStation.serviceStationName} for you</h2>
			      <p></p>
			    </div>
			    <div>
			      <ul class="nav nav-pills navbar-right">
			         <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
			         <li><a class="btn btn-primary" 
			         href="/ServiceStationManagementSystem/profile/${idEmployee}/mechanicselectcomments">Select comment</a></li>
			      </ul>
			    </div>
		  </div>
	  </nav>

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
	          <c:forEach items="${listServiceStationCommentMark}" var="review">
	          <tr>
	            <td>${review.comment}</td>
	            <td>${review.client.clientFirstName} ${review.client.clientLastName}</td>
	            <td>${review.mark}</td>
	          </tr>
	          </c:forEach>
           </tbody>
          </table>
      </c:if>
      
</body>
</html>