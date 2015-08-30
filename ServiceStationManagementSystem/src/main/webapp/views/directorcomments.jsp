<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
   		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Comments</title>
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
		        		href="/ServiceStationManagementSystem/profile/${employee.idEmployee}/directorpage"> Director page</a>
		        	</li>
		      </ul>
		    </div>
	    </div>
	  </nav>
      
      <c:if test="${empty listServiceStationCommentMark}"> 
      	<h4>There are no comments</h4>
      </c:if> 
      
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
       
      </div>
</body>
</html>