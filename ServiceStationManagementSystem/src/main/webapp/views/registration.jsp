<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>

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
<body>
    <div class="container">
      <div class="row" style="padding-top: 50px;">
        <div class="col-md-4"></div>
        <div class="col-md-4">
          <h3>Registration</h3>
          <form class="form-horizontal">
            <div class="form-group">
              <div class="col-sm-10">
                <input type="text" class="form-control" id="firstname" placeholder="First name">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10">
                <input type="text" class="form-control" id="lastname" placeholder="Last name">
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <input type="email" class="form-control" id="email" placeholder="Email">
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <input type="text" class="form-control" id="login" placeholder="Login">
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="Password">
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="Re-Password">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10">
                <input type="text" class="form-control" id="phone" placeholder="Phone number">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <a href="#"><button type="button" class="btn btn-default">Back</button></a>
                <button type="submit" class="btn btn-default">Sign up</button>
              </div>
            </div>
        </form>
        </div>
        <div class="col-md-4"></div>
      </div>
    </div>
  </body>
</html>
