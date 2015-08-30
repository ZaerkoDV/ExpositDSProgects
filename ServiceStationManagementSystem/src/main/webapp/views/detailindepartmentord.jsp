<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Details in department order</title>
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
			      <h2>Details in department order:</h2>
			      <p></p>
			    </div>
			    <div>
			      <ul class="nav nav-pills navbar-right">
			        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
			        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/profile/${idEmployee}/${idDepartmentOrder}/mechaniccreateord">Edit order</a></li>
			      </ul>
			    </div>
		    </div>
	  	</div>
	  	
	    <div class="container">      
		 <c:if test="${!empty listDetail}">      
		  <table class="table table-hover">
		     <thead>
			   	 <tr>
					<th>detailName</th>
					<th>detailManufacturer</th>
					<th>detailStatus</th>
					<th>detailCost</th>
					<th>detailWarrantyDay</th>
				 </tr>
			 </thead>
			 <tbody>
				<c:forEach items="${listDetail}" var="detail">
				    <tr>
					  <td>${detail.detailName}</td>
					  <td>${detail.detailManufacturer}</td>
					  <td>${detail.detailStatus}</td>
					  <td>${detail.detailCost}</td>
					  <td>${detail.detailWarrantyDay}</td>
					  <td>
					    <a href="<c:url value='/profile/${idEmployee}/${idDepartmentOrder}/detailindepartmentord/${detail.idDetail}/delete' />">
							<button	type="button" class="btn btn-xs btn-primary" >Delete</button>
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