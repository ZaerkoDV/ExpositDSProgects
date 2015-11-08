<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Comments to service station</title>
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
		      <a class="navbar-brand" href="#">Welcome ${employee.employeFirstName} ${employee.employeLastName} !</a>
		    </div>
		    <div>
		      <ul class="nav nav-pills navbar-right">
		        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
		        	<li><a class="btn btn-primary" 
		        	href="/ServiceStationManagementSystem/profile/${employee.idEmployee}/${employee.directorOfServiceStation}/directorcomments"> Service station comments</a></li>
		        	<li><a class="btn btn-primary" 
		        	href="/ServiceStationManagementSystem/profile/${employee.idEmployee}/${employee.directorOfServiceStation}/directorgeneratereport">Financical report</a></li>
		     		<li><a class="btn btn-primary" 
		     		href="/ServiceStationManagementSystem/profile/${employee.idEmployee}/addemployee">Add employee</a></li>
		      </ul>
		    </div>
	    </div>
	  </nav>

		<table class="table table-hover">
           <thead>
             <tr>
                <th>№</th>
		        <th>First name</th>
		        <th>Last name</th>
		        <th>Middle name</th>
		        <th>Function</th>
		        <th>Telephone</th>
		        <th>Birthday</th>
		        <th>Email</th>
		        <th>Wages</th>
             </tr>
           </thead>
           <tbody>
           
              <c:if test="${!empty listEmployeeForServiceStation}">
		         <c:forEach items="${listEmployeeForServiceStation}" var="employee">
		          <tr>
		              <td>${employee.idEmployee}</td>
			          <td>${employee.employeFirstName}</td>
			          <td>${employee.employeLastName}</td>
			          <td>${employee.employeMiddleName}</td>
			          <td>${employee.employeFunction}</td>
			          <td>${employee.employeTelephone}</td>
			          <td>${employee.employeBirthday}</td>
			          <td>${employee.employeEmail}</td>
			          <td>${employee.wages}</td>
			          <td><a type="button" class="btn btn-xs btn-primary" 
		          		href="/ServiceStationManagementSystem/profile/${idDirector}/directorpage/${employee.idEmployee}/delete">Delete</a>
		          	 </td>
		          	 <td>
			          	 <a type="button" class="btn btn-xs btn-primary" 
		          		   href="/ServiceStationManagementSystem/profile/${idDirector}/directorpage/${employee.idEmployee}/editemployee">Edit</a>
			        </td>     
		          </tr>
		         </c:forEach>
	          </c:if>	
	         
	        </tbody>
	      </table>    	    
	</div>
</body>
</html>