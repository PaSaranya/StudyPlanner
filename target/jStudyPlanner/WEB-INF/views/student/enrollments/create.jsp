<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>
	Add course to your plan
</h1>

<div id="errorMessage" class="bs-callout bs-callout-danger <c:if test="${empty errorMessage}">hidden</c:if>">
	<c:out value="${errorMessage}" />
</div>

<div id="infoMessage" class="bs-callout bs-callout-info <c:if test="${empty infoMessage}">hidden</c:if>">
	<c:out value="${infoMessage}" />
</div>

<c:url value="/student/enrollmentupdate" var="formAction"/>
<form:form method="POST" modelAttribute="enrollment" action="${formAction}" cssClass="form-horizontal top50" role="form">
	<fieldset>
	
		<div class="form-group">
			<label class="col-sm-2 control-label">Term</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="courseAvailability.term.id" cssClass="form-control noPadding" id="terms">
					<option value="">Select term</option>
					<form:options items="${termList}" itemLabel="shortDescription" itemValue="id" />
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Course</label>
			<div class="col-sm-5">
				<form:select multiple="false" path="courseAvailability.course.id" cssClass="form-control noPadding" id="courseSelect">
					<form:options items="${courseSet}" itemLabel="title" itemValue="id" />
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<button type="submit" class="btn btn-default disabled" id="addButton">Add Course</button>
			</div>
		</div>
		
	</fieldset>
</form:form>

<c:url var="getCoursesURL" value="/student/getCACoursesByTerm" />
<script type="text/javascript">
$(document).ready(function() { 
	$('#terms').change(
		function() {
			$.getJSON('${getCoursesURL}', {
				id : $(this).val(),
				ajax : 'true'
			}, function(data) {
				var html = '';
				var length = data.length;
				if (length != 0) {
					for ( var i = 0; i < length; i++) {
						html += '<option value="' + data[i].id + '">'
								+ data[i].title + '</option>';
					}
					html += '</option>';
					$('#courseSelect').html(html);
					$('#infoMessage').html('Please select course.');
					$('#infoMessage').removeClass('hidden');
					$('#errorMessage').addClass('hidden');
					$('#addButton').removeClass('disabled');
				} else {
					$('#courseSelect').html('');
					$('#errorMessage').html('There are no courses available in the selected term. Please select another one.');
					$('#errorMessage').removeClass('hidden');
					$('#infoMessage').addClass('hidden');
					$('#addButton').addClass('disabled');
				}
			});
		});
});
</script>