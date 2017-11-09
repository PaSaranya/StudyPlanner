<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>
	Update schedule for course '<c:out value="${ca.course.title}" />', 
	<c:out value="${ca.term.shortDescription}" />, <c:out value="${ca.campus.title}" /> campus
</h1>


<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>


<c:url value="/staff/caupdate" var="formAction"/>
<form:form method="POST" modelAttribute="ca" action="${formAction}" cssClass="form-horizontal top50" role="form">
	<fieldset>
		<form:input cssClass="hidden" path="id" />
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Campus</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="campus.code" cssClass="form-control noPadding">
					<form:options items="${campusList}" itemLabel="title" itemValue="code" />
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Term</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="term.id" cssClass="form-control noPadding">
					<form:options items="${termList}" itemLabel="shortDescription" itemValue="id" />
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Course</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="course.code" cssClass="form-control noPadding">
					<form:options items="${courseList}" itemLabel="title" itemValue="code" />
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
				<button type="submit" class="btn btn-default">Update</button>
				<a class="btn btn-default left30" data-toggle="modal" data-target="#deleteConfirmationModal">Delete</a>
				<a href='<s:url value="/staff/calist" />' class="btn btn-default left30">Back</a>
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
				<p>Are you sure you want to remove course '<c:out value="${ca.course.title}" />' from schedule 
				term <c:out value="${ca.term.number} ${ca.term.year}" />, <c:out value="${ca.campus.title}" /> campus?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href='<s:url value="/staff/cadelete/${ca.id}" />' 
					type="button" class="btn btn-danger">Delete</a>
			</div>
		</div>
	</div>
</div>