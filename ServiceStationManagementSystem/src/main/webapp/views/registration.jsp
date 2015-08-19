<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
 
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
          <form:form class="form-horizontal" method="post" commandName="client">
            <div class="form-group">
              <div class="col-sm-10">
                <form:input type="text" class="form-control" id="firstname" placeholder="First name" path="clientFirstName" />
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10">
                <form:input type="text" class="form-control" id="lastname" placeholder="Last name" path="clientLastName" />
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <form:input type="email" class="form-control" id="email" placeholder="Email" path="clientEmail" />
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <form:input type="text" class="form-control" id="login" placeholder="Login" path="clientLogin" />
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <form:input type="password" class="form-control" id="password" placeholder="Password" path="clientPassword" />
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-10">
                <input type="password" class="form-control" id="repassword" placeholder="Re-Password">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10">
                <form:input type="text" class="form-control" id="phone" placeholder="Phone number" path="clientTelephone" />
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <a href="#"><button type="button" class="btn btn-default">Back</button></a>
                <button type="submit" class="btn btn-default">Sign up</button>
              </div>
            </div>
        </form:form>
        </div>
        <div class="col-md-4"></div>
      </div>
    </div>
  </body>
</html>
