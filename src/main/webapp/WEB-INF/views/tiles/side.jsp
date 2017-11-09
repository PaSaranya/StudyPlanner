<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="col-sm-3 col-md-2 sidebar hidden-xs top60">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="<s:url value="/home" />"><span class="glyphicon glyphicon-home"></span> Home</a></li>
		<li><a href="<s:url value="/about" />"><span class="glyphicon glyphicon-file"></span> About</a></li>
		<li><a href="<s:url value="/campuses/list" />"><span class="glyphicon glyphicon-book"></span> Campuses</a></li>
		<li><a href="<s:url value="/programs/list" />"><span class="glyphicon glyphicon-book"></span> Programs</a></li>
		<li><a href="<s:url value="/majors/list" />"><span class="glyphicon glyphicon-stats"></span> Majors</a></li>
		<li><a href="<s:url value="/courses/list" />"><span class="glyphicon glyphicon-list-alt"></span> Courses</a></li>
	</ul>
</div>