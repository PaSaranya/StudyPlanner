<%-- Left side navigation menu for admin users.
Admin menu item should display 'Admin Users' button for superadmin user only 
(username = admin). Other admin users should not see that menu item --%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="col-sm-3 col-md-2 sidebar hidden-xs top60">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="<s:url value="/student/home" />"><span class="glyphicon glyphicon-home"></span> Home</a></li>
		<li><a href="<s:url value="/student/enrollmentlist" />"><span class="glyphicon glyphicon-book"></span> Plan</a></li>
	</ul>
</div>