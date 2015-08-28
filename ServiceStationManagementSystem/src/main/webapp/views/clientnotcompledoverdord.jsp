<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Not completed and overdue client order</title>
    	<!-- 
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	    -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		
<style>
/*
body {
	height: 100%;
	margin: 0;
    background: url(resources/img/background.jpg);
    background-size: 100% 100%; 
    background-repeat: repeat;
    display: compact;
}*/

</style>

</head>
<body>

      <div class="container">    
	     <nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Welcome ${client.clientFirstName} ${client.clientLastName} !</a>
		    </div>
		    <div>
		      <ul class="nav nav-pills navbar-right">
		        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
		        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/profile/${client.idClient}/clientdoneord">To done order</a></li>
		      </ul>
		    </div>
		  </div>
		 </nav>
	        
	     <div class="row" style="padding-top: 50px;">
	     <c:if test="${!empty listNotcompletedOverdueOrder}"><!-- last change -->
	       <table class="table table-striped">
	         <thead>
		        <tr>
		          <th>№</th>
		          <th>OrderDescription</th>
		          <th>Cost</th>
		          <th>Start</th>
		          <th>End</th>
		          <th>Status</th>
		          <th>Mechanic</th>
		        </tr>
	          </thead>
		      <tbody>
		        <c:forEach items="${listNotcompletedOverdueOrder}" var="order">
		        <tr>
		          <td>${order.idDepartmentOrder}</td>
		          <td>${order.orderDescription}</td>
		          <td>${order.orderCost}</td>
		          <td>${order.startOrder}</td>
		          <td>${order.endOrder}</td>
		          <td>${order.orderStatus}</td>
		          <td>${order.employee.employeLastName}</td>
		          <td>
		          	<a type="button" class="btn btn-xs btn-primary" 
		          		href="/ServiceStationManagementSystem/profile/${client.idClient}/${beforepage}/${order.department.serviceStation.idServiceStation}/addservicestationcomment">
		          	Add a comment 
		          	</a>
				  </td>		      
		          <td><a type="button" class="btn btn-xs btn-primary" 
		          		href="/ServiceStationManagementSystem/profile/${client.idClient}/${order.idDepartmentOrder}/renew">Renew order</a></td>
		          <td><a type="button" class="btn btn-xs btn-primary" 
		          	href="/ServiceStationManagementSystem/profile/${client.idClient}/${beforepage}/${order.idDepartmentOrder}/delete">Delete order</a></td>
		        </tr>
		        </c:forEach>
	         </tbody> 
	       </table>
	       </c:if>
	     </div>
      </div>
     
  </body>
</html>