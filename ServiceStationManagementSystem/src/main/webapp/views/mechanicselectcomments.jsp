<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
   <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Select comments</title>
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
			      <h2>Comments in service station for mechanic</h2>
			      <p></p>
			    </div>
			    <div>
			      <ul class="nav nav-pills navbar-right">
			         <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
			         <li><a class="btn btn-primary" 
			         href="/ServiceStationManagementSystem/profile/${idEmployee}/mechanicnotcompletedoverdord">Notcompleted/overdue order</a></li>
			      </ul>
			    </div>
		  </div>
	   </nav>
     
      <form:form id="mechanicCommentForm" method="POST" class="bs-example form-horizontal" commandName="serviceStationCommentMark">
      		<div class="form-group">
				  <div class="col-xs-4">
				  <p style="padding-top: 20px;">Select service station</p>
				     <form:select class="form-control input-sm" path="serviceStation.idServiceStation">		     
				     	 <c:forEach items="${listServiceStation}" var="serviceStation">
					      	<form:option value="${serviceStation.idServiceStation}" label="ServiceStation: ${serviceStation.serviceStationName}" />
						 </c:forEach>
				     </form:select>
				  </div>
			  </div>
     
		      <div class="col-lg-9 col-lg-offset-3">
					<button class="btn btn-primary" data-toggle="modal"data-target="#themodal">Show comment</button>
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
									<a href="/profile/${idEmployee}/mechanicselectcomments" 
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