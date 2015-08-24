<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @author Artyom_Khomyakov -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Done</title>

    
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	    
	   
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
        <div class="col-md-6">
         <a href="/ServiceStationManagementSystem/mechanicpage/${employee.idEmployee}/notcompleted"><button type="button" class="btn btn-warning">Not Done/Overdue</button></a>
         <a href="/ServiceStationManagementSystem/mechanicpage/${employee.idEmployee}/done"><button type="button" class="btn btn-success">Done</button></a>
         <a href="/ServiceStationManagementSystem/mechanicpage/${employee.idEmployee}/comments"><button type="button" class="btn btn-primary">Comments</button></a>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-4">
          <div class="col-md-4" style="padding-top: 10px;"><p>Employee:</p></div>
          <div class="col-md-4" style="padding-top: 10px;"><p>${employee.employeFirstName} ${employee.employeLastName}</p></div>
          <div class="col-md-4"><a href="/logout"><button type="button" class="btn btn-default">Logout</button></a></div>
        </div>
      </div>
      <div class="row" style="padding-top: 50px;">
  <h4>Done</h4>
    <c:if test="${!empty listDone}">
         <table class="table table-striped">
        <tr>
          <th>№</th>
          <th>Description</th>
          <th>Client</th>
          <th>Date end</th>
          <th>Cost</th>
        </tr>
        <c:forEach items="${listDone}" var="Done">
        <tr>
          <td>1</td>
          <td>${Done.orderDescription}</td>
          <td>${Done.client}</td>
          <td>${Done.endOrder}</td>
          <td>${Done.workCost} + ${Done.orderCost}</td>
        </tr>
         </c:forEach>
       </table>
        </c:if>
        </div>
    </div>
  </body>
</html>