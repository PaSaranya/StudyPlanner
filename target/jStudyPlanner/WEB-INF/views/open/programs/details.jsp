<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>
	<c:out value="${program.title}" />  
</h1>
<div class="row bottom30">
	<div class="col-sm-8 col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">Program description</div>
			<div class="panel-body">
				<c:out value='${program.description}' />
			</div>
		</div>
	</div>
	<div class="col-sm-4 col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">Program details</div>
			<div class="panel-body">
				<strong>Code: </strong><c:out value="${program.code}" /><br />
				<strong>Career: </strong><c:out value="${program.career}" /><br />
				<strong>Number of courses: </strong><c:out value="${program.numberOfCourses}" /><br />
			</div>
		</div>
	</div>
</div>

<c:choose>
	<c:when test="${fn:length(majors) > 0}">
		<h2><c:out value="${program.code}" /> majors</h2>
		<table class="table table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>#</th>
					<th>Code</th>
					<th>Title</th>
					<th>Program</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${majors}" var="major" varStatus="status">
					<tr>
						<td><c:out value="${status.count}"/></td>
						<td><c:out value="${major.code}" /></td>
						<td>
							<a href='<s:url value="/majors/${major.code}" />'>
								<c:out value="${major.title}" />
							</a>
						</td>
						<td><c:out value="${major.program.title}" /></td>
						<td data-toggle="tooltip" data-placement="left" title="<c:out value='${major.description}' />">
							<c:out value="${major.getDescriptionPreview(100)}" />&nbsp;...
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	
	<c:otherwise>
		<p>Program doesn't have any majors. Please contact system administrator.</p>
	</c:otherwise>
</c:choose>

<h2 class="top30">Core courses</h2>
<table class="table table-bordered table-striped table-responsive">
	<thead>
		<tr>
			<th>#</th>
			<th>Code</th>
			<th>Title</th>
			<th class="hidden-xs">Description</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${program.coreCourses}" var="course" varStatus="status">
			<tr>
				<td><c:out value="${status.count}"/></td>
				<td><c:out value="${course.code}" /></td>
				<td>
					<a href='<s:url value="/courses/${course.code}" />'>
						<c:out value="${course.title}" />
					</a>
				</td>
				<td class="hidden-xs" data-toggle="tooltip" data-placement="left" title="<c:out value='${course.description}' />">
					<c:out value="${course.getDescriptionPreview(100)}" />&nbsp;...
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<h2 class="top30">Elective courses</h2>
<table class="table table-bordered table-striped table-responsive">
	<thead>
		<tr>
			<th>#</th>
			<th>Code</th>
			<th>Title</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${program.electiveCourses}" var="course" varStatus="status">
			<tr>
				<td><c:out value="${status.count}"/></td>
				<td><c:out value="${course.code}" /></td>
				<td>
					<a href='<s:url value="/courses/${course.code}" />'>
						<c:out value="${course.title}" />
					</a>
				</td>
				<td data-toggle="tooltip" data-placement="left" title="<c:out value='${course.description}' />">
					<c:out value="${course.getDescriptionPreview(100)}" />&nbsp;...
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>