<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<h1>
	Create new Major
</h1>

<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>

<p>Click Save button to save major and then add compulsory courses.</p>

<c:url value="/staff/majorupdate" var="formAction"/>
<form:form method="POST" modelAttribute="major" action="${formAction}" cssClass="form-horizontal top50" role="form" id="majorForm">
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
			<label for="program" class="col-sm-2 control-label">Program</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="program.code" cssClass="form-control noPadding">
					<form:options items="${programList}" itemLabel="title" itemValue="code" />
				</form:select>
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
				<button type="submit" class="btn btn-default">Save</button>
				<a href='<s:url value="/staff/majorlist" />' class="btn btn-default left30">Cancel</a>
			</div>
		</div>
		
	</fieldset>
</form:form>

<script>
	// Form validation. Displays error message
	$(function() {
		$('#majorForm').bootstrapValidator({
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
	                        message: 'Major code is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 45,
			                message: 'Major code should not be longer then 45 characters'
			            }
	                }
	        	},
	        	title: {
	        		validators: {
	                    notEmpty: {
	                        message: 'Major title is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 255,
			                message: 'Major title should not be longer then 255 characters'
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