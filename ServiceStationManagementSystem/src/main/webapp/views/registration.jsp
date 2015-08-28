<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>

    	<!-- Bootstrap
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	    -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
/*body {	
	height: 100%;
	margin: 0;
	background: url(resources/pictures/addClient.jpg);
	background-size: 100% 150%;
	background-repeat: no-repeat;
	display: compact;
}*/

 .well {
  top: 0px;
  left: 0px;
  margin-top: 50px;
  margin-left: 50px;
}

.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
 
</style>


</head>
<body>

   <div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
				   <div class="col-lg-6">
			          <form:form id="registrationForm" method="POST" class="bs-example form-horizontal" commandName="clientSecurityFeature">
			            <fieldset>
			             <legend>Registraction form</legend>
			             <div class="form-group">
			             	  <label for="clientfirstName" class="col-lg-3 control-label">First name</label>
				              <div class="col-lg-9">
				                <form:input type="text" class="form-control" id="clientfirstName" placeholder="First name" path="client.clientFirstName" />
				              	<form:errors path="client.clientFirstName" cssClass="error" />
				              </div>
			             </div>
			             <div class="form-group">
			            	  <label for="clientlastName" class="col-lg-3 control-label">Last name</label>
				              <div class="col-lg-9">
				                <form:input type="text" class="form-control" id="clientlastName" placeholder="Last name" path="client.clientLastName" />
				              	<form:errors path="client.clientLastName" cssClass="error" />
				              </div>
			              </div>
			              <div class="form-group">
			              	  <label for="clientMiddleName" class="col-lg-3 control-label">Middle name</label>
				              <div class="col-lg-9">
				                <form:input type="text" class="form-control" id="clientMiddleName" placeholder="Middle name" path="client.clientMiddleName" />
				              	<form:errors path="client.clientMiddleName" cssClass="error" />
				              </div>
			              </div>
			              <div class="form-group">
							<label for="dateOfBirth" class="col-lg-3 control-label">Date of birth</label>
							<div class="date form_date col-lg-9" data-date-format="dd/mm/yyyy" data-date-viewmode="years">
								<form:input type="text" class="form-control" id="dateOfBirth" placeholder="Date of birth" path="client.clientBirthday"/>
								<form:errors path="client.clientBirthday" cssClass="error" />
							</div>
						  </div>
						  <div class="form-group">
						     <label for="clientTelephone" class="col-lg-3 control-label">Phone number</label>
				             <div class="col-lg-9">
				                <form:input type="text" class="form-control" id="clientTelephone" placeholder="Phone number" path="client.clientTelephone" />
				             	<form:errors path="client.clientTelephone" cssClass="error" />
				             </div>
				           </div>
			              <div class="form-group">
			              	 <label for="clientEmail" class="col-lg-3 control-label">Email</label>
				             <div class="col-lg-9">
				                <form:input type="email" class="form-control" id="clientEmail" placeholder="Email" path="client.clientEmail" />
				                <form:errors path="client.clientEmail" cssClass="error" />
				             </div>
			              </div>
			              <div class="form-group">
					            <label for="clientLogin" class="col-lg-3 control-label">Login</label>
						         <div class="col-lg-9">
						             <form:input type="text" class="form-control" id="clientLogin" placeholder="Login" path="clientLogin" />
						         	 <form:errors path="clientLogin" cssClass="error" />
						         </div>
					       </div>
					       <div class="form-group">
					            <label for="clientPassword" class="col-lg-3 control-label">Password</label>
						        <div class="col-lg-9">
						           <form:input type="text" class="form-control" id="clientPassword" placeholder="Password" path="clientPassword" />
						       	   <form:errors path="clientPassword" cssClass="error" />
						       </div>
			               </div>
  
			              <div class="col-lg-9 col-lg-offset-3">
						  <button class="btn btn-primary" data-toggle="modal"data-target="#themodal">Save</button>
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
											<a href="/ServiceStationManagementSystem/registration" class="btn btn-default" data-dismiss="modal">No</a>
											<input type="submit" value="Yes" id="yesbutton"	class="btn btn-primary" data-loading-text="Saving.." data-complete-text="Save Complete!">
										</div>
									</div>
								  </div>
							   </div>
							   <a class="btn btn-primary" href="<spring:url value="/"/>">Return to start page</a> 
						    </div>
		            
			          </fieldset>
				   </form:form>	
			      	       	       
        	   </div>
           </div>
       </div>
    </div>
    
    <script>
		$(function() {
			$('#dateOfBirth').datepicker();
		});
	</script>

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