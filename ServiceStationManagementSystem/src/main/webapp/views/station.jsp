<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @author Artyom_Khomyakov -->
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Station</title>

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
    <div class="row">
      <div class="col-md-4">
      </div>
      <div class="col-md-8" style="padding-top: 20px;">
        <form class="form-inline">
          <div class="form-group">
            <input type="login" class="form-control" id="exampleInputEmail3" placeholder="Login">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
          </div>
          <div class="checkbox">
            <label>
              <input type="checkbox"> Remember me
            </label>
          </div>
          <a href="#"><button type="submit" class="btn btn-success">Sign in</button></a>
          <a href="#"><button type="button" class="btn btn-primary">Sign up</button></a>
        </form>
      </div>
      <div class="row" style="padding-top: 150px;">
           <div class="col-md-2"><a href="#"><button type="button" class="btn btn-default">Back</button></a></div>
           <div class="col-md-4"><h3>${ServiceStation.name}</h3></div>
           <div class="col-md-2"><a href="<c:url value='/station/${ServiceStation.id}/request/' />"><button type="button" class="btn btn-danger">Make a request</button></a></div>
      </div>
      <h4>Main information: </h4>
      <div class="row" style="padding-top: 50px;">
        <div class="col-md-2">
          <p>Address: </p>
          <p>Phone number: </p>
          <p>Mark: </p>
        </div>
        <div class="col-md-4">
          <p>${ServiceStation.adress}</p>
          <p>${ServiceStation.phoneNumber}</p>
          <p>${ServiceStation.mark}</p>
        </div>
      </div>
      <h4>Check status: </h4>
      <form class="form-inline">
        <div class="form-group">
          <input type="email" class="form-control" id="email" placeholder="email">
        </div>
        <a href="<c:url value='/station/${stationId}/check' />"><button type="submit" class="btn btn-default">Check</button></a>
      </form>
      <div class="row" style="padding-top: 50px;">
        <c:if test="${!empty listServiceStationCommentMark}">
        <table class="table">
          <tr>
            <th>Comment: </th>
            <th>From: </th>
            <th>Mark: </th>
          </tr>
          <c:forEach items="${listServiceStationCommentMark}" var="ServiceStationCommentMark">
          <tr>
            <td>${ServiceStationCommentMark.comment}</td>
            <td>${ServiceStationCommentMark.client}</td>
            <td>${ServiceStationCommentMark.mark}</td>
          </tr>
          </c:forEach>
        </table>
        </c:if>
      </div>
  </body>
</html>