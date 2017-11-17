<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>
	Allocate multiple courses available for enrollment (add course to the schedule)
</h1>

<% // Info and error messages. Hidden by deffault %>
<div id="infoMessage" class="bs-callout bs-callout-info <c:if test="${empty infoMessage}">hidden</c:if>">
	<c:out value="${infoMessage}" />
</div>

<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>

<c:choose>
	<c:when test="${empty courseList}">
		<c:url value="/staff/cacourselist" var="formAction"/>
	</c:when>
	<c:when test="${not empty courseList}">
		<c:url value="/staff/caupdatemultiple" var="formAction"/>
	</c:when>
</c:choose>
<form method="POST" action="${formAction}" class="form-horizontal top50 bottom40" role="form">
	<fieldset>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Campus</label>
			<div class="col-sm-5">
				<select name="campusID" class="form-control noPadding">
					<c:forEach items="${campusList}" var="campus">
						<option value="${campus.id}">${campus.title}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Term</label>
			<div class="col-sm-5">
				<select name="termID" class="form-control noPadding">
					<c:forEach items="${termList}" var="term">
						<option value="${term.id}">${term.shortDescription}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${empty courseList}">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-default">Select Courses</button>
					</div>
				</div>
			</c:when>
			<c:when test="${not empty courseList}">
				
				Courses table here
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-default">Allocate Selected Courses</button>
					</div>
				</div>
			</c:when>
		</c:choose>
		
	</fieldset>
</form>