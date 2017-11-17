<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>
	Create new student user
</h1>

<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>

<c:url value="/staff/studentupdate" var="formAction"/>
<form:form method="POST" modelAttribute="studentUser" action="${formAction}" cssClass="form-horizontal top50" role="form" id="studentForm">
	<fieldset>
		<div class="form-group">
			<label for="firstName" class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" path="firstName" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="lastName" class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" path="lastName" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" path="username" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-5">
				<form:password cssClass="form-control" path="password" showPassword="true" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="passwordConfirmation" class="col-sm-2 control-label">Password Confirmation</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" name="passwordConfirmation" value="<c:out value="${studentUser.password}" />" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-5">
				<form:input type="email" cssClass="form-control" path="email" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="phone" class="col-sm-2 control-label">Phone</label>
			<div class="col-sm-5">
				<form:input type="tel" cssClass="form-control" path="phone" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="type" class="col-sm-2 control-label">Type</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="type" cssClass="form-control noPadding">
					<form:option value="not defined" title="not defined"/>
			    	<form:option value="domestic" title="domestic"/>
			    	<form:option value="international" title="international"/>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<label class="checkbox-inline">
					<form:checkbox path="enabled" label="Enabled" value="1" />
				</label>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<button type="submit" class="btn btn-default">Create</button>
			</div>
		</div>
		
	</fieldset>
</form:form>

<script>
	// form validation. displays error message
	$(function() {
		$('#studentForm').bootstrapValidator({
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        live: 'enabled',
	        message: 'This value is not valid',
	        submitButtons: 'button[type="submit"]',
	        submitHandler: null,
	        trigger: null,
	        fields: {
	        	firstName: {
	                validators: {
	                    notEmpty: {
	                        message: 'First name is required and cannot be empty'
	                    }
	                }
	        	},
	        	lastName: {
	        		validators: {
	                    notEmpty: {
	                        message: 'Last name is required and cannot be empty'
	                    }
	                }
	        	},
	        	username: {
	                message: 'Username is not valid',
	                validators: {
	                    notEmpty: {
	                        message: 'Username is required and cannot be empty'
	                    },
	                    stringLength: {
	                        min: 4,
	                        max: 39,
	                        message: 'Username length should be between 3 and 40 characters'
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_\.]+$/,
	                        message: 'Username can only consist of alphabetical, number, dot and underscore'
	                    }
	                }
	            },
	            password: {
	            	message: 'Password is not valid',
	            	validators: {
	            		notEmpty: {
	                        message: 'Password is required and cannot be empty'
	                    },
	            		different: {
	                        field: 'username',
	                        message: 'Password should not be the same as username'
	                    },
	                    stringLength: {
	                        min: 8,
	                        max: 255,
	                        message: 'Password length should be between 8 and 255 characters'
	                    }
	                    // TODO add password regexp for variouis characters
	                    
	                    // TODO create top admin (top nav bar in phone view)
	            	}
	            },
	            passwordConfirmation: {
	            	validators: {
	            		identical: {
	                        field: 'password',
	                        message: 'Password confirmation doesn not match'
	                    }
	            	}
	            },
	        	email: {
	                validators: {
	                    notEmpty: {
	                        message: 'Email is required and cannot be empty'
	                    },
	                    emailAddress: {
	                        message: 'Email address is not valid'
	                    }
	                }
	            }
	        }
	    });
	});
</script>