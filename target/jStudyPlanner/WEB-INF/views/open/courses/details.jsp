<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>
	<c:out value="${course.title}" />
</h1>
<div class="row">
	<div class="col-sm-8 col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">Course description</div>
			<div class="panel-body">
				<c:out value='${course.description}' />
			</div>
		</div>
	</div>
	<div class="col-sm-4 col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">Course details</div>
			<div class="panel-body">
				<strong>Code: </strong><c:out value="${course.code}" /><br />
			</div>
		</div>
	</div>
</div>

<c:choose>
	<c:when test="${fn:length(course.prerequisites) > 0}">
		<h2 class="top30">Prerequisites</h2>
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
				<c:forEach items="${course.prerequisites}" var="course" varStatus="status">
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
	</c:when>
	
	<c:otherwise>
		<p>Course doesn't have any prerequisites.</p>
	</c:otherwise>
</c:choose>