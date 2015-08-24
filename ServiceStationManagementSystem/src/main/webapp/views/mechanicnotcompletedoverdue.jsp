<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @author Artyom_Khomyakov -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Not done/Overdue</title>

    
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
         <a href="/ServiceStationManagementSystem/mechanicpage/${employee.idEmployee}/notcompleted"><button type="button" class="btn btn-warning">Not done/Overdue</button></a>
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
        <c:if test="${empty listNotDoneOverdue}">
       <h4 style="padding-top: 50px;">No orders in progress</h4>
       </c:if> 
      <c:if test="${empty listNotDoneOverdue}">
      <h4>In progress</h4>
         <table class="table table-striped">
        <tr>
          <th>№</th>
          <th>Description</th>
          <th>Client</th>
          <th>Deadline date</th>
          <th>Cost</th>
          <th>Details</th>
          <th>Order item</th>
          <th>Finish</th>
        </tr>
         <c:forEach items="${listNotDoneOverdue}" var="notDoneOverdue">
        <tr>
          <td>1</td>
          <td>${notDoneOverdue.orderDescription}</td>
          <td>${notDoneOverdue.client.getClientFirstName()} ${serviceStationCommentMark.client.getClientMiddleName()}</td>
          <td>${notDoneOverdue.endOrder}</td>
          <form:form commandName="finish" method="post" action="${pageContext.request.contextPath}/mechanicpage/${employee.idEmployee}/notdone/finish/${notDoneOverdue.idDepartmentOrder}">
          <td>
          <form:input path="costWork" type="text" class="form-control" id="exampleInputName2" />
          </td>
          <td>
          <!--  c:if test="${!empty listDetail}" -->
          <select class="form-control">
          <!-- c:forEach items="${listDetail}" var="Detail" -->
            <option>${Detail.detailName}</option>
            <!-- /c:forEach -->
          </select>
          <!-- /c:if -->
          </td>
          <td><a href="<c:url value='/mechanicpage/${employee.idEmployee}/notdone/order/${notDoneOverdue.idDepartmentOrder}' />"><button type="button" class="btn btn-xs btn-success">Order</button></a></td>
          <td><a href="<c:url value='/mechanicpage/${employee.idEmployee}/notdone/finish/${notDoneOverdue.idDepartmentOrder}' />"><button type="submit" class="btn btn-xs btn-primary">Finish</button></a></td>
        </tr>
        </form:form>
         </c:forEach>
       </table> 
       	</c:if>
         </div>
    </div>
  </body>
</html>