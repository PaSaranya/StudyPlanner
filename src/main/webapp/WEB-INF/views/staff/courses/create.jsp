<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<h1>
	Create new Course
</h1>

<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>

<c:url value="/staff/courseupdate" var="formAction"/>
<form:form method="POST" modelAttribute="course" action="${formAction}" cssClass="form-horizontal top50" role="form" id="courseForm">
	<fieldset>
		<div class="form-group">
			<label for="code" class="col-sm-2 control-label">Code</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" path="code" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">Title</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" path="title" />
			</div>
		</div>
		
		
		
		<div class="form-group">
			<label for="description" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-5">
				<form:textarea cssClass="form-control" path="description" cols="10" rows="5" />
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
				<a href='<s:url value="/staff/courselist" />' class="btn btn-default left30">Cancel</a>
			</div>
		</div>
		
	</fieldset>
</form:form>

<script>
	// Form validation. Displays error message
	$(function() {
		$('#courseForm').bootstrapValidator({
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
	        	code: {
	                validators: {
	                    notEmpty: {
	                        message: 'Course code is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 45,
			                message: 'Course code should not be longer then 45 characters'
			            }
	                }
	        	},
	        	title: {
	        		validators: {
	                    notEmpty: {
	                        message: 'Course title is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 255,
			                message: 'Course title should not be longer then 255 characters'
			            }
	                }
	        	},
	        	description: {
	        		validators: {
		        		stringLength: {
			                min: 0,
			                max: 4000,
			                message: 'Description should not be longer then 4000 characters'
			            }
	        		}
	            },
	        }
	    });
	});
</script>