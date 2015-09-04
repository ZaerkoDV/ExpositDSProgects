<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Mechanic notcompleted and overdue order</title>
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
			        href="/ServiceStationManagementSystem/profile/${employee.idEmployee}/mechanicdoneord">
			        Mechanic done order</a></li>
			        <li><a class="btn btn-primary" 
			        href="/ServiceStationManagementSystem/profile/${employee.idEmployee}/mechanicselectcomments">Comments</a></li>
			      </ul>
			    </div>
		    </div>
		  </nav>
    
    	  <table class="table table-hover">
           <thead>
             <tr>
               <th>№</th>
		        <th>OrderDescription</th>
		        <th>Cost</th>
		        <th>Start</th>
		        <th>End</th>
		        <th>Status</th>
		        <th>Client</th>
		        <th>Client email</th>
             </tr>
           </thead>
           </tbody>
             <c:if test="${!empty listNotcompletedOverdueOrder}">
		       <c:forEach items="${listNotcompletedOverdueOrder}" var="notcomletedoverdueorder">
		         <tr>
		           <td>${notcomletedoverdueorder.idDepartmentOrder}</td>
			        <td>${notcomletedoverdueorder.orderDescription}</td>
			        <td>${notcomletedoverdueorder.orderCost}</td>
			        <td>${notcomletedoverdueorder.startOrder}</td>
			        <td>${notcomletedoverdueorder.endOrder}</td>
			        <td>${notcomletedoverdueorder.orderStatus}</td>
			        <td>${notcomletedoverdueorder.client.clientFirstName} ${notcomletedoverdueorder.client.clientLastName}</td>
			        <td>${notcomletedoverdueorder.client.clientEmail}</td>
			        <td><a type="button" class="btn btn-xs btn-primary" 
		          		href="/ServiceStationManagementSystem/profile/${employee.idEmployee}/${notcomletedoverdueorder.idDepartmentOrder}/mechaniccreateord">Edit order</a>
		          	</td>     
		         </tr>
		        </c:forEach>
	         </c:if>	  
           </tbody>
          </table>
 
  </div>
</body>
</html>