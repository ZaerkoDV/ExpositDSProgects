<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @author Artyom_Khomyakov -->
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>In progress</title>

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
          <button type="submit" class="btn btn-success">Sign in</button>
          <a href="registration.html"><button type="button" class="btn btn-primary">Sign up</button></a>
        </form>
      </div>
      <div class="row" style="padding-top: 150px;">
           <div class="col-md-2"><a href="station.html"><button type="button" class="btn btn-default"> < Back</button></a></div>
           <div class="col-md-4"><h3>${ServiceStation.name}</h3></div>
           
      </div>
      <h4>Make a request: </h4>
      <div class="row" style="padding-top: 50px;">
        <div class="col-md-4">
        <!--FOR NOT SIGN UP -->
          <p>Leave your phone number</p>
          <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Phone number">
          <p style="padding-top: 20px;">Leave your email</p>
          <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
        <!-- -->
          <p style="padding-top: 20px;">Description</p>
          <textarea class="form-control" rows="3"></textarea>
          <a href="<c:url value='/station/${stationId}/request/send' />"><button type="button" class="btn btn-primary" style="margin-top: 30px;">Send</button></a>
        </div>
      </div>
  </div>
  </body>
</html>