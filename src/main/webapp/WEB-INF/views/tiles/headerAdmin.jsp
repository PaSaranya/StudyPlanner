<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href='<s:url value="/admin/home" />'>jStudyPlanner</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="visible-xs"><a href='<s:url value="/admin/home" />'>Home</a></li>
				<security:authorize access="hasRole('ROLE_SUPERADMIN')">
					<li class="visible-xs"><a href='<s:url value="/admin/adminlist" />'>Admin Users</a></li>
				</security:authorize>
				<li class="visible-xs"><a href='<s:url value="/admin/stafflist" />'>Staff</a></li>
				<li class="visible-xs"><a href='<s:url value="/admin/studentlist" />'>Students</a></li>
				<li class="visible-xs"><a href='<s:url value="/admin/campuslist" />'>Campuses</a></li>
				
				<li class="divider">&nbsp;</li>
				
				<security:authorize access="isAnonymous()">
		    		<li><a href="#" data-toggle="modal" data-target="#loginForm">Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href='<c:url value="/logout" />'>Logout</a></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</div>