<%-- Left side navigation menu for staff users. --%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="col-sm-3 col-md-2 sidebar hidden-xs top60">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="<s:url value="/staff/home" />"><span class="glyphicon glyphicon-home"></span> Home</a></li>
		<li><a href="<s:url value="/staff/termlist" />"><span class="glyphicon glyphicon-book"></span> Terms</a></li>
		<li><a href="<s:url value="/staff/programlist" />"><span class="glyphicon glyphicon-book"></span> Programs</a></li>
		<li><a href="<s:url value="/staff/majorlist" />"><span class="glyphicon glyphicon-book"></span> Majors</a></li>
		<li><a href="<s:url value="/staff/courselist" />"><span class="glyphicon glyphicon-book"></span> Courses</a></li>
		<li><a href="<s:url value="/staff/studentlist" />"><span class="glyphicon glyphicon-book"></span> Students</a></li>
		<li><a href="<s:url value="/staff/calist" />"><span class="glyphicon glyphicon-book"></span> Schedule</a></li>
		<li><a href="<s:url value="/staff/enrollmentlist" />"><span class="glyphicon glyphicon-book"></span> Enrollments</a></li>
	</ul>
</div>