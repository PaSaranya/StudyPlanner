<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>
	Allocate course available for enrollment (add course to the schedule)
</h1>

<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>

<c:url value="/staff/caupdate" var="formAction"/>
<form:form method="POST" modelAttribute="ca" action="${formAction}" cssClass="form-horizontal top50" role="form">
	<fieldset>
	
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
				<button type="submit" class="btn btn-default">Create</button>
				<a href='<s:url value="/staff/calist" />' class="btn btn-default left30">Cancel</a>
			</div>
		</div>
		
	</fieldset>
</form:form>