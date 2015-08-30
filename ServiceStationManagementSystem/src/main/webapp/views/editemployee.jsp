<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- @author Artyom_Khomyakov -->
<!-- @author Denis Zaerko -->
<html lang="en">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Employee edit</title>
    	<!-- Bootstrap
    	<link href="resources/libs/bootstrap.min.css" rel="stylesheet">
	    <script src="resources/libs/jquery.min.js"/></script>
	    <script src="resources/libs/bootstrap.min.js"/></script>
	    -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>

 .well {
  top: 0px;
  left: 0px;
  margin-top: 0px;
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

<div class="col-lg-6 col-lg-offset-2">
		<div class="well">
			<div class="container">
				<div class="row">
				   <div class="col-lg-6">
			          <form:form id="employeeUpdateForm" method="POST" class="bs-example form-horizontal" commandName="employee">
			            <fieldset>
			             <legend>Registraction form</legend>
			             <div class="form-group">
			             	  <label for="employeFirstName" class="col-lg-3 control-label">First name</label>
				              <div class="col-lg-8">
				                <form:input type="text" class="form-control" id="employeFirstName" placeholder="First name" path="employeFirstName" />
				              	<form:errors path="employeFirstName" cssClass="error" />
				              </div>
			             </div>
			             <div class="form-group">
			            	  <label for="employeLastName" class="col-lg-3 control-label">Last name</label>
				              <div class="col-lg-8">
				                <form:input type="text" class="form-control" id="employeLastName" placeholder="Last name" path="employeLastName" />
				              	<form:errors path="employeLastName" cssClass="error" />
				              </div>
			              </div>
			              <div class="form-group">
			              	  <label for="employeMiddleName" class="col-lg-3 control-label">Middle name</label>
				              <div class="col-lg-8">
				                <form:input type="text" class="form-control" id="employeMiddleName" placeholder="Middle name" path="employeMiddleName" />
				              	<form:errors path="employeMiddleName" cssClass="error" />
				              </div>
			              </div>
			              
			             <div class="form-group">
						     <label for="employeFunction" class="col-lg-3 control-label">Function</label>
						     <div class="col-lg-8">
						      <form:select class="form-control" path="employeFunction">
						      	<form:option value="mechanic" label="mechanic" />
								<form:option value="director" label="director" />
						      </form:select>
						      </div>
						  </div>
							    
						  <div class="form-group">
						     <label for="employeTelephone" class="col-lg-3 control-label">Phone number</label>
				             <div class="col-lg-8">
				                <form:input type="text" class="form-control" id="employeTelephone" placeholder="Phone number" path="employeTelephone" />
				             	<form:errors path="employeTelephone" cssClass="error" />
				             </div>
				           </div>  
							                  
			              <div class="form-group">
							<label for="employeBirthday" class="col-lg-3 control-label">Date of birth</label>
							<div class="date form_date col-lg-8" data-date-format="dd/mm/yyyy" data-date-viewmode="years">
								<form:input type="text" class="form-control" id="employeBirthday" placeholder="Example 01/01/2000" path="employeBirthday"/>
								<form:errors path="employeBirthday" cssClass="error" />
							</div>
						  </div>
						 					 
			              <div class="form-group">
			              	 <label for="employeEmail" class="col-lg-3 control-label">Email</label>
				             <div class="col-lg-8">
				                <form:input type="email" class="form-control" id="employeEmail" placeholder="Email" path="employeEmail" />
				                <form:errors path="employeEmail" cssClass="error" />
				             </div>
			              </div>
			              
			              <div class="form-group">
						     <label for="wages" class="col-lg-3 control-label">Wages</label>
				             <div class="col-lg-8">
				                <form:input type="text" class="form-control" id="wages" placeholder="Wages" path="wages" />
				             	<form:errors path="wages" cssClass="error" />
				             </div>
				           </div>  
			              
			              <div class="col-lg-9 col-lg-offset-3">
						  <button class="btn btn-primary" data-toggle="modal"data-target="#themodal">Update</button>
							 <div id="themodal" class="modal fade" data-backdrop="static">									
								<div class="modal-dialog">
									<div class="modal-content">
											
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"aria-hidden="true">&times;</button>
											<h3>Registraction Form</h3>
										</div>
												
										<div class="modal-body">
											<p>Are you sure want to update?</p>
											<div class="progress progress-striped active">
												<div id="doitprogress" class="progress-bar"></div>
											</div>
										</div>
												
										  <div class="modal-footer">
											<a href="/ServiceStationManagementSystem/profile/${idDirector}/addemployee" class="btn btn-default" data-dismiss="modal">No</a>
											<input type="submit" value="Yes" id="yesbutton"	class="btn btn-primary" data-loading-text="Saving.." data-complete-text="Update Complete!">
										</div>
									</div>
								  </div>
							   </div>
							   <a class="btn btn-primary" href="<spring:url value="/profile/${idDirector}/directorpage"/>">To director page</a> 
						    </div>
		            
			          </fieldset>
				   </form:form>	
			      	       	       
        	   </div>
           </div>
         </div>
      </div>
    </div>
    
    <script>
		$(function() {
			$('#employeBirthday').datepicker();
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