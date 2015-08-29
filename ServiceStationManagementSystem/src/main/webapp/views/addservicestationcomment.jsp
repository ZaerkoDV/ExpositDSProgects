<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Comments to service station</title>
    	<!--
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	    -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		
</head>
<body>
   
  <div class="container">    
	  <nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Welcome ${client.clientFirstName} ${client.clientLastName} !</a>
		    </div>
		    <div>
		      <ul class="nav nav-pills navbar-right">
		        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
		          <c:if test="${beforepage !='incompleteclientallord'}">
		        	<li><a class="btn btn-primary" href="/ServiceStationManagementSystem/profile/${client.idClient}/clientnotcompledoverdord"> Back notcompleted/overdue order page</a></li>
		        	<li><a class="btn btn-primary" href="/ServiceStationManagementSystem/profile/${client.idClient}/clientdoneord">Return done order page</a></li>
		     	 </c:if>
		      </ul>
		    </div>
	    </div>
	  </nav>
    
     <h4>Add a comment to service station ${serviceStation.serviceStationName} </h4>  
     <form:form id="servicestationcommentForm" method="POST" class="bs-example form-horizontal" commandName="serviceStationCommentMark">
        
       <div class="form-group">
		   <p style="padding-top: 20px;">Comment</p>
		   <div class="col-lg-9">
		       <form:textarea type="text" class="form-control" id="comment" placeholder="Your comment" path="comment" />
		   </div>
	   </div>
	   
	   <div class="form-group">
	   	   <p style="padding-top: 20px;">Who can see</p>
	   	   <div class="radio">
		        <label style="padding-right: 20px;">
		          <form:radiobutton id="radios1" path="viewStatus" value="all" checked= "checked"/>
		          All
		        </label>
		        <label style="padding-right: 20px;">
		          <form:radiobutton id="radios2" path="viewStatus" value="mechanic" checked= "checked"/>
		          Mechanic 
		        </label>
		        <label style="padding-right: 20px;">
		          <form:radiobutton id="radios3" path="viewStatus" value="director" checked= "checked"/>
		          Director only
		        </label>
           </div>
	     </div>
	   	 
		 <div class="form-group">
		   <div class="col-xs-2">
		     <p style="padding-top: 20px;">Add mark</p>
		      <form:select class="form-control input-sm" path="mark">
		      	<form:option value="1" label="1" />
				<form:option value="2" label="2" />
				<form:option value="3" label="3" />
				<form:option value="4" label="4" />
				<form:option value="5" label="5" />
				<form:option value="5" label="6" />
				<form:option value="5" label="7" />
				<form:option value="5" label="8" />
				<form:option value="5" label="9" />
				<form:option value="5" label="10" />
		      </form:select>
		     </div>
		  </div>
		  
		  <div class="col-lg-9 col-lg-offset-3">
			 <button class="btn btn-primary" data-toggle="modal"data-target="#themodal">Save comment</button>
			 <div id="themodal" class="modal fade" data-backdrop="static">									
			     <div class="modal-dialog">
					<div class="modal-content">				
						<div class="modal-header">
						    <button type="button" class="close" data-dismiss="modal"aria-hidden="true">&times;</button>
							<h3>Registraction Form</h3>
						</div>					
						<div class="modal-body">
						   <p>Are you sure you want to do this?</p>
						   <div class="progress progress-striped active">
							  <div id="doitprogress" class="progress-bar"></div>
						   </div>
						</div>				
						<div class="modal-footer">
							<a href="/profile/${client.idClient}/${beforepage}/${serviceStation.idServiceStation}/addservicestationcomment" 
									class="btn btn-primary" data-dismiss="modal">No</a>
							<input type="submit" value="Yes" id="yesbutton"	class="btn btn-primary" data-loading-text="Saving.." 
									data-complete-text="Save Complete!">
					  </div>
				  </div>
			   </div>
		   </div>
		</div>
		
     </form:form>
   </div>
   
   <script type="text/javascript">
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");		
			
			yesButton.click(function() {		
				yesButton.button("loading");

				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};
				setTimeout(countDown, 100);
			});
		});
	</script>
   
</body>
</html>