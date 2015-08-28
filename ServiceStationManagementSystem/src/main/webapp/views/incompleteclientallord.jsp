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
	    <title>All client(incomplet login) order</title>
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
			      <a class="navbar-brand" href="#">Welcome ${client.clientFirstName} ${client.clientLastName} !</a>
			    </div>
			    <div>
			      <ul class="nav nav-pills navbar-right">
			        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
			        <li><a class="btn btn-primary" 
			        href="<spring:url value="/allservicestation"/>">All service station</a></li>
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
		          <th>Mechanic</th>
             </tr>
           </thead>
           </tbody>
           
              <c:if test="${!empty listNotCompletedOverdueClientOrder}">
		         <c:forEach items="${listNotCompletedOverdueClientOrder}" var="notcomletedoverdueorder">
		          <tr>
		              <td>${notcomletedoverdueorder.idDepartmentOrder}</td>
			          <td>${notcomletedoverdueorder.orderDescription}</td>
			          <td>${notcomletedoverdueorder.orderCost}</td>
			          <td>${notcomletedoverdueorder.startOrder}</td>
			          <td>${notcomletedoverdueorder.endOrder}</td>
			          <td>${notcomletedoverdueorder.orderStatus}</td>
			          <td>${notcomletedoverdueorder.employee.employeLastName}</td>
			          <td><a type="button" class="btn btn-xs btn-primary" 
		          		href="/ServiceStationManagementSystem/profile/${client.idClient}/${beforepage}/${notcomletedoverdueorder.idDepartmentOrder}/delete">Delete order</a>
		          	 </td>     
		          </tr>
		         </c:forEach>
	          </c:if>	
	                    
	          <c:if test="${!empty listDoneClientOrder}">
		         <c:forEach items="${listDoneClientOrder}" var="doneorder">
		          <tr>
		              <td>${doneorder.idDepartmentOrder}</td>
			          <td>${doneorder.orderDescription}</td>
			          <td>${doneorder.orderCost}</td>
			          <td>${doneorder.startOrder}</td>
			          <td>${doneorder.endOrder}</td>
			          <td>${doneorder.orderStatus}</td>
			          <td>${doneorder.employee.employeLastName}</td>
			          <td>
			          	 <a type="button" class="btn btn-xs btn-primary" 
		          		   href="/ServiceStationManagementSystem/profile/${client.idClient}/${beforepage}/${doneorder.department.serviceStation.idServiceStation}/addservicestationcomment">
		          		  Add a comment 
		          		</a>
			          </td>
		          </tr>
		         </c:forEach>
	          </c:if>
	         
           </tbody>
          </table>
          
     </div>
  </body>
</html>