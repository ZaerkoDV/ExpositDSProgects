<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Overdue</title>

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
     <div class="row" style="padding-top: 50px;">
       <div class="col-md-2"></div>
       <div class="col-md-8">
         <div class="col-md-2" style="padding-top: 15px;"><a href="#"><button type="button" class="btn btn-default"> < Back</button></a></div>
         <h3>${Client.firstName} ${Client.lastName}</h3>
       </div>
       <div class="col-md-2"></div>
     </div>
     <div class="row" style="padding-top: 50px;">
       <h4>Requests list</h4>
       <div class="col-md-4" style="padding-top: 20px;">
		 <a href="/ServiceStationManagementSystem/profile/inprogress"><button type="button" class="btn btn-default">In progress</button></a>
         <a href="/ServiceStationManagementSystem/profile/done"><button type="button" class="btn btn-success">Done</button></a>
         <a href="/ServiceStationManagementSystem/profile/overdue"><button type="button" class="btn btn-danger">Overdue</button></a>
       </div>
     </div>
     <!--STATUS OVERDUE -->
     <div class="row" style="padding-top: 50px;">
     <!--  c:if test="${!empty listDepartmentOrder}" -->
       <table class="table table-striped">
        <tr>
          <th>${DepartmentOrder.id}</th>
          <th>Mechanic</th>
          <th>Deadline Date</th>
          <th>Renew contract</th>
          <th>Comments</th>
          <th>Delete</th>
        </tr>
         <!-- c:forEach items="${listDepartmentOrder}" var="DepartmentOrder" -->
        <tr>
          <td>1</td>
          <td>${DepartmentOrder.employee}</td>
          <td>${DepartmentOrder.endOrder}</td>
          <td><a href="<c:url value='/profile/overdue/renew/${DepartmentOrder.id}' />"><button type="button" class="btn btn-xs btn-success">Renew</button></a></td>
          <td><a href="<c:url value='/profile/overdue/addcomment/${ServiceStation.id}' />"><button type="button" class="btn btn-xs btn-primary">Add a comment</button></a></td>
          <td><a href="<c:url value='/profile/overdue/delete/${DepartmentOrder.id}' />"><button type="button" class="btn btn-xs btn-danger">Delete</button></a></td>
        </tr>
        <!-- /c:forEach -->
       </table>
       <!-- /c:if -->
     </div>
   </div>
  </body>
</html>