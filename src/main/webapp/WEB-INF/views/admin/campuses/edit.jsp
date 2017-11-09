<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<h1>
	Update/delete campus '<c:out value="${campus.title}" />'
</h1>


<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>


<c:url value="/admin/campusupdate" var="formAction"/>
<form:form method="POST" modelAttribute="campus" action="${formAction}" cssClass="form-horizontal top50" role="form" id="campusForm">
	<fieldset>
		<form:input cssClass="hidden" path="id" />
		
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
			<label for="address" class="col-sm-2 control-label">Address</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" path="address" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="phone" class="col-sm-2 control-label">Phone</label>
			<div class="col-sm-5">
				<form:input type="tel" cssClass="form-control" path="phone" />
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
				<button type="submit" class="btn btn-default">Update</button>
				<a class="btn btn-default left30" data-toggle="modal" data-target="#deleteConfirmationModal">Delete</a>
			</div>
		</div>
		
	</fieldset>
</form:form>

<!-- Delete Confirmation Modal -->
<div class="modal fade" id="deleteConfirmationModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="modalLabel">Confirmation</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to delete <c:out value="${campus.title}" />?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href='<s:url value="/admin/campusdelete/${campus.code}" />' 
					type="button" class="btn btn-danger">Delete</a>
			</div>
		</div>
	</div>
</div>

<script>
	// form validation. displays error message
	$(function() {
		$('#campusForm').bootstrapValidator({
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
	                        message: 'Campus code is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 45,
			                message: 'Campus code should not be longer then 45 characters'
			            }
	                }
	        	},
	        	title: {
	        		validators: {
	                    notEmpty: {
	                        message: 'Campus title is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 255,
			                message: 'Campus title should not be longer then 255 characters'
			            }
	                }
	        	},
	        	description: {
	        		validators: {
		        		stringLength: {
			                min: 0,
			                max: 4000,
			                message: 'Campus description should not be longer then 4000 characters'
			            }
	        		}
	            },
	        }
	    });
	});
</script>