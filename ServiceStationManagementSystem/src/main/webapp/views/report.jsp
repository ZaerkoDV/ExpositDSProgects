<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Financial report</title>

    
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
    <div class="row" style="padding-top: 150px;">
    <div class="col-md-4"><a href="#"><button type="button" class="btn btn-default" > < Back</button></a></div>
    <div class="col-md-4">
    
    <h4>Make a financial report</h4>
      <select class="form-control">
      <!--  c:forEach items="${listServiceStation}" var="ServiceStation" --> 
        <option>Select station</option>
        <option>${ServiceStation.name}</option>
      <!--  /c:forEach -->
      </select><br>
      <!-- c:if test="${!empty listDepartamentOrder}" -->  
      <select class="form-control">
      <!--  c:forEach items="${listDepartamentOrder}" var="DepartamentOrder" --> 
        <option>From</option>
        <option>${DepartamentOrder.endOrder}</option>
      <!--  /c:forEach -->
      </select><br>
      <select class="form-control">
      <!--  c:forEach items="${listDepartamentOrder}" var="DepartamentOrder" --> 
        <option>To</option>
        <option>${DepartamentOrder.endOrder}</option>
      <!--  /c:forEach -->
      </select><br>
        <a href="<c:url value='/directorpage/report/download' />"><button type="button" class="btn btn-lg btn-success" style="margin-top: 30px; margin-left: 100px;">Download PDF</button></a>
      </div>
      <div class="col-md-4"></div>
    </div>
  </div>
  </body>
</html>