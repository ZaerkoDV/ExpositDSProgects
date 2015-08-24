<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @author Artyom_Khomyakov -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main Page</title>

    
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
    
    <h4>Add a comment</h4>
        <p style="padding-top: 20px;">Comment</p>
          <textarea class="form-control" rows="3"></textarea>
        <p style="padding-top: 20px;">Who can see</p>
        <div class="radio">
        <label style="padding-right: 20px;">
          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
          All
        </label>
        <label style="padding-right: 20px;">
          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
          Mechanic 
        </label>
        <label>
          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
          Director only
        </label>
      </div>
      <p style="padding-top: 20px;">Add mark</p>
      <select class="form-control">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
       <button type="button" class="btn btn-primary" style="margin-top: 30px;">Send</button>
      </div>
      <div class="col-md-4"></div>
    </div>
  </div>
  </body>
</html>