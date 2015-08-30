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
	    <title>Mechanic change detail for client order</title>
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
			      <h2>Create detail for client order</h2>
			      <p></p>
			    </div>
			    <div>
			      <ul class="nav nav-pills navbar-right">
			        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/">To start page</a></li>
			        <li><a class="btn btn-primary" href="/ServiceStationManagementSystem/profile/${idEmployee}/${idDepartmentOrder}/mechaniccreateord">Edit order</a></li>
			      </ul>
			    </div>
		  </div>
	   </nav>
    
    	<div class="col-lg-6 col-lg-offset-3">
		 <div class="well">
     	  <form:form id="detailForm" method="POST" class="bs-example form-horizontal" commandName="detail">
    		 <fieldset>
    		 
     		    <div class="form-group">
			        <label for="detailName" class="col-lg-3 control-label">Detail name</label>
				    <div class="col-lg-9">
				        <form:input type="text" class="form-control" id="detailName" placeholder="Detail name" path="detailName" />
				    </div>
			    </div>
     
     			<div class="form-group">
			        <label for="detailManufacturer" class="col-lg-3 control-label">Manufacturer</label>
				    <div class="col-lg-9">
				        <form:input type="text" class="form-control" id="detailManufacturer" placeholder="Detail manufacturer" path="detailManufacturer" />
				    </div>
			    </div>
     
    			<div class="form-group">
				      <label for="detailCost" class="col-lg-3 control-label">Detail status</label>
				      <div class="col-lg-9">
				      <form:select class="form-control" path="detailStatus">
				      	 <form:option value="exist" label="exist" />
						 <form:option value="notexist" label="notexist" />
				      </form:select>
				   </div>
				</div>
     
     			<div class="form-group">
			        <label for="detailCost" class="col-lg-3 control-label">Detail cost</label>
				    <div class="col-lg-9">
				        <form:input type="text" class="form-control" id="detailCost" placeholder="Detail cost" path="detailCost" />
				    </div>
			    </div>
     
     			<div class="form-group">
			        <label for="detailWarrantyDay" class="col-lg-3 control-label">Warranty(day)</label>
				    <div class="col-lg-9">
				        <form:input type="text" class="form-control" id="detailWarrantyDay" placeholder="Detail warranty day" path="detailWarrantyDay" />
				    </div>
			    </div>
     
			    <div class="col-lg-9 col-lg-offset-3">
					<button class="btn btn-primary" data-toggle="modal"data-target="#themodal">Save detail</button>
					<div id="themodal" class="modal fade" data-backdrop="static">									
						   <div class="modal-dialog">
							   <div class="modal-content">				
								  <div class="modal-header">
									    <button type="button" class="close" data-dismiss="modal"aria-hidden="true">&times;</button>
										<h3>Create detail form</h3>
								  </div>					
								  <div class="modal-body">
									   <p>Are you sure you want to do this?</p>
									   <div class="progress progress-striped active">
										  <div id="doitprogress" class="progress-bar"></div>
									   </div>
								  </div>				
								  <div class="modal-footer">
										<a href="/profile/${idEmployee}/${idDepartmentOrder}/mechanicchangedetail" 
												class="btn btn-primary" data-dismiss="modal">No</a>
										<input type="submit" value="Yes" id="yesbutton"	class="btn btn-primary" data-loading-text="Saving.." 
												data-complete-text="Save Complete!">
								 </div>
							</div>
						 </div>
					</div>
				</div>
     
     		</fieldset>
     	   </form:form>
     	 </div>
       </div>
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