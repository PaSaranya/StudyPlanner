<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>
	<c:out value="${major.title}" />  
</h1>
<div class="row">
	<div class="col-sm-8 col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">Major description</div>
			<div class="panel-body">
				<c:out value='${major.description}' />
			</div>
		</div>
	</div>
	<div class="col-sm-4 col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">Major details</div>
			<div class="panel-body">
				<strong>Code: </strong><c:out value="${major.code}" /><br />
				<strong>Program: </strong>
				<a href='<s:url value="/programs/${major.program.code}" />'>
					<c:out value="${major.program.title}" /><br />
				</a>
			</div>
		</div>
	</div>
</div>

<h2 class="top30">Compulsory courses</h2>
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
		<c:forEach items="${major.compulsoryCourses}" var="course" varStatus="status">
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