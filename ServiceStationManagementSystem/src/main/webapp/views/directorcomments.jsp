<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Income</title>

    
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
        <div class="col-md-4">
         <a href="/ServiceStationManagementSystem/directorpage/income"><button type="button" class="btn btn-success">Income</button></a>
         <a href="/ServiceStationManagementSystem/directorpage/costs"><button type="button" class="btn btn-danger">Costs</button></a>
         <a href="/ServiceStationManagementSystem/directorpage/comments"><button type="button" class="btn btn-primary">Comments</button></a>
         <a href="/ServiceStationManagementSystem/directorpage/report"><button type="button" class="btn btn-warning">Report</button></a>
        </div>
        <div class="col-md-4"></div>
        <div class="col-md-4">
          <div class="col-md-2" style="padding-top: 10px;"><p>Director:</p></div>
          <div class="col-md-6" style="padding-top: 10px;"><p>${Employee.firstName} ${Employee.lastName}</p></div>
          <div class="col-md-4"><a href="#"><button type="button" class="btn btn-default">Logout</button></a></div>
        </div>
      </div>
      <!-- c:if test="${empty listServiceStationCommentMark}" --> 
      <!-- h4>There are no comments</h4 -->
      <!-- /c:if --> 
      <!-- c:if test="${!empty listServiceStationCommentMark}" -->  
      <h4>Comments</h4>
         <table class="table table-striped">
        <tr>
          <th>№</th>
          <th>Comment</th>
          <th>From</th>
          <th>To</th>
          <th>Mark</th>
        </tr>
        <!--  c:forEach items="${listServiceStationCommentMark}" var="ServiceStationCommentMark" --> 
        <tr>
          <td>1</td>
          <td>${ServiceStationCommentMark.comment}</td>
          <td>${ServiceStationCommentMark.client}</td>
          <td>${ServiceStationCommentMark.serviceStation}</td>
          <td>${ServiceStationCommentMark.mark}</td>
        </tr>
        <!--  /c:forEach -->
       </table>
       <!-- /c:if --> 
      </div>
    </div>
  </body>
</html>