<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @author Artyom_Khomyakov -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order detail</title>

    
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
    <!--  c:if test="${empty listDetail}" -->
    <!-- h4>No details in stock </h4-->
    <!-- /c:if -->
    <!--  c:if test="${!empty listDetail}" -->
    <h4>Order detail</h4>
    <p style="padding-top: 50px;">Details in stock: </p>
        <select class="form-control">
         <!-- c:forEach items="${listDetail}" var="Detail" -->
          <option>${Detail.detailName}</option>
          <!-- /c:forEach -->
        </select>
        <a href="#"><button type="button" class="btn btn-success" style="margin-top: 30px;">Take</button></a>
      <!-- /c:if -->
      </div>
      <div class="col-md-4"></div>
    </div>
  </div>
  </body>
</html>