<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>
	<c:out value="${campus.title}" />  
</h1>
<div class="row">
	<div class="col-sm-8 col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">Campus description</div>
			<div class="panel-body">
				<c:out value='${campus.description}' />
			</div>
		</div>
	</div>
	<div class="col-sm-4 col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">Campus details</div>
			<div class="panel-body">
				<strong>Code: </strong><c:out value="${campus.code}" /><br />
				<strong>Address: </strong><c:out value="${campus.address}" /><br />
				<strong>Phone: </strong><c:out value="${campus.phone}" /><br />
			</div>
		</div>
	</div>
</div>