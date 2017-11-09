<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<h1>
	Update/delete program '<c:out value="${program.title}" />'
</h1>

<% // Info and error messages. Hidden by deffault %>
<div id="infoMessage" class="bs-callout bs-callout-info <c:if test="${empty infoMessage}">hidden</c:if>">
	<c:out value="${infoMessage}" />
</div>

<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>


<c:url value="/staff/programupdate" var="formAction"/>
<form:form method="POST" modelAttribute="program" action="${formAction}" cssClass="form-horizontal top50" role="form" id="programForm">
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
			<label for="career" class="col-sm-2 control-label">Career</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="career" cssClass="form-control noPadding">
					<form:option value="not defined" title="not defined"/>
			    	<form:option value="undergraduate" title="undergraduate"/>
			    	<form:option value="postgraduate" title="postgraduate"/>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="numberOfCourses" class="col-sm-2 control-label">Number Of Courses</label>
			<div class="col-sm-5">
				<form:input type="tel" cssClass="form-control" path="numberOfCourses" />
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
				<a href='<s:url value="/staff/programlist" />' class="btn btn-default left30">Back</a>
			</div>
		</div>
		
	</fieldset>
</form:form>


<% // Core courses table and buttons %>
<div class="row">
	<div class="col-md-6">
		<h3>
			<c:choose>
				<c:when test="${not empty program.coreCourses}">Core courses</c:when>
				<c:when test="${empty program.coreCourses}">There are no core courses</c:when>
			</c:choose>
		</h3>
		
		<c:url value="/staff/removecorecourses/${program.id}" var="coreCoursesFormAction"/>
		<form:form method="POST" action="${coreCoursesFormAction}" id="coreCoursesForm">
			<table class='table table-bordered table-striped table-responsive 
				<c:if test="${empty program.coreCourses}">hidden</c:if>'>
				<thead>
					<tr>
						<th>Select</th>
						<th>#</th>
						<th>Code</th>
						<th>Title</th>
						<th>Enabled</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${program.coreCourses}" var="course" varStatus="status">
						<tr>
							<td>
								<input type="checkbox" class="ckeckBox" name="courseIDs" value='<c:out value="${course.id}" />' />
							</td>
							<td><c:out value="${status.count}" /></td>
							<td><c:out value="${course.code}" /></td>
							<td data-toggle="tooltip" data-placement="left" title='<c:out value="${course.description}" />'>
								<c:out value="${course.title}" />
							</td>
							<td>
								<c:choose>
									<c:when test="${course.enabled == 1}">Yes</c:when>
									<c:when test="${course.enabled == 0}">No</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href='<s:url value="/staff/corecourseslist/${program.id}" />' class="btn btn-default bottom30">Add Core Courses</a>
			<input type="submit" class='btn btn-default left30 bottom30 <c:if test="${empty program.coreCourses}">hidden</c:if>'
				value="Remove Selected" />
		</form:form>
	</div>
</div>


<% // Core courses table and buttons %>
<div class="row">
	<div class="col-md-6">
		<h3>
			<c:choose>
				<c:when test="${not empty program.electiveCourses}">Elective courses</c:when>
				<c:when test="${empty program.electiveCourses}">There are no elective courses</c:when>
			</c:choose>
		</h3>
		
		<c:url value="/staff/removeelectivecourses/${program.id}" var="electiveCoursesFormAction"/>
		<form:form method="POST" action="${electiveCoursesFormAction}" id="electiveCoursesForm">
			<table class='table table-bordered table-striped table-responsive 
				<c:if test="${empty program.electiveCourses}">hidden</c:if>'>
				<thead>
					<tr>
						<th>Select</th>
						<th>#</th>
						<th>Code</th>
						<th>Title</th>
						<th>Enabled</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${program.electiveCourses}" var="course" varStatus="status">
						<tr>
							<td>
								<input type="checkbox" class="ckeckBox" name="courseIDs" value='<c:out value="${course.id}" />' />
							</td>
							<td><c:out value="${status.count}" /></td>
							<td><c:out value="${course.code}" /></td>
							<td data-toggle="tooltip" data-placement="left" title='<c:out value="${course.description}" />'>
								<c:out value="${course.title}" />
							</td>
							<td>
								<c:choose>
									<c:when test="${course.enabled == 1}">Yes</c:when>
									<c:when test="${course.enabled == 0}">No</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href='<s:url value="/staff/electivecourseslist/${program.id}" />' class="btn btn-default bottom30">Add Elective Courses</a>
			<input type="submit" class='btn btn-default left30 bottom30 <c:if test="${empty program.electiveCourses}">hidden</c:if>'
				value="Remove Selected" />
		</form:form>
	</div>
</div>


<!-- Delete Confirmation Modal -->
<div class="modal fade" id="deleteConfirmationModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="modalLabel">Confirmation</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to delete <c:out value="${program.title}" />?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href='<s:url value="/staff/programdelete/${program.code}" />' 
					type="button" class="btn btn-danger">Delete</a>
			</div>
		</div>
	</div>
</div>

<script>
	// form validation. displays error message
	$(function() {
		$('#programForm').bootstrapValidator({
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
	                        message: 'Program code is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 45,
			                message: 'Program code should not be longer then 45 characters'
			            }
	                }
	        	},
	        	title: {
	        		validators: {
	                    notEmpty: {
	                        message: 'Program title is required and cannot be empty'
	                    },
	                    stringLength: {
			                min: 1,
			                max: 255,
			                message: 'Program title should not be longer then 255 characters'
			            }
	                }
	        	},
	        	numberOfCourses: {
	        		validators: {
	        			notEmpty: {
	                        message: 'Number of courses is required and cannot be empty'
	                    },
	        			integer: {
	                        message: 'This should be a positive integer number'
	                    },
	                    between: {
	                        min: 1,
	                        max: 100,
	                        message: 'Number of courses should be between 1 and 100'
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
		
		// Core Courses Form validation. There should be at least one course selected
		$('#coreCoursesForm').bootstrapValidator({
			feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	'courseIDs': {
	        		validators: {
	                    choice: {
	                        min: 1,
	                        message: 'Please select at least one course to remove'
	                    }
	                }
	        	}
	        }
		});
		
		// Elective Courses Form validation. There should be at least one course selected
		$('#electiveCoursesForm').bootstrapValidator({
			feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	'courseIDs': {
	        		validators: {
	                    choice: {
	                        min: 1,
	                        message: 'Please select at least one course to remove'
	                    }
	                }
	        	}
	        }
		});
	});
</script>