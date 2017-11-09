<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>jStudyPlanner student page</h3>
<p class="top30">
	This page should be secured to those who have ROLE_STUDENT
</p>
<p>
   Click To | <a href="<c:url value="/logout" />">Logout</a>
</p>
<p class="top30">
	Lorem ipsum dolor sit amet, consectetur adipiscing elit. In auctor ac est ac pharetra. 
	Maecenas in fringilla nulla, a vestibulum quam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; 
	Morbi id tincidunt dui. Donec nec diam blandit, tristique massa non, auctor sem. Donec iaculis lobortis pulvinar. 
	Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nam at aliquam nisi. 
	Pellentesque at ante dictum, iaculis velit vitae, tincidunt metus. Donec volutpat, lacus eget ultricies semper, 
	nisl dolor tempus lorem, vitae vulputate ipsum turpis vel tortor. Nam ornare dictum lacus, vitae volutpat neque ultricies vitae. 
	Vivamus ut nulla tellus. Suspendisse potenti. Cras venenatis orci tempor rhoncus vehicula. Fusce pellentesque orci dictum, 
	rhoncus arcu nec, porttitor erat. Sed sed urna et lacus tincidunt aliquam et sed lectus.
</p>
<div class="row">
	<div class="col-lg-6 col-md-8 col-sm-12 col-xs-12">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th colspan="2">My details</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Name</td>
						<td><c:out value="${student.firstName} ${student.lastName}" /></td>
					</tr>
					<tr>
						<td>Student type</td>
						<td><c:out value="${student.type}" /></td>
					</tr>
					<tr>
						<td>Program</td>
						<td><c:out value="${student.major.program.title}" /></td>
					</tr>
					<tr>
						<td>Major</td>
						<td><c:out value="${student.major.title}" /></td>
					</tr>
					<tr>
						<td>Campus</td>
						<td><c:out value="${student.campus.title}" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>