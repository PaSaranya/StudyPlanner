<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- This page can be used for multiple purposes. That depends on 'actionType' model attribute.
	1. addPrerequisites - add prerequisite courses to the given course
	2. addCompulsoryCourses - add compulsory courses to the given major
	3. addCoreCourses - add prerequisite courses to the given program
	4. addElectiveCourses - add prerequisite courses to the given program
--%>

<%-- Define heading, form action, cancel button href, pagination links 
	attribute depending on 'actionType' model attribute --%>
<c:choose>
	<c:when test='${actionType.equals("addPrerequisites")}'>
		<c:set var="heading" scope="request" value="Add Prerequisites"/>
		<c:url value="/staff/addprerequisites/${courseID}" var="formAction" />
		<c:url value="/staff/courseedit/${courseID}" var="cancelHrefAttribute" />
		<c:set value="/staff/prerequisitelist/${courseID}?" var="listHrefAttribute" scope="request" />
	</c:when>
	<c:when test='${actionType.equals("addCompulsoryCourses")}'>
		<c:set var="heading" scope="request" value="Add Major Compulsory Courses"/>
		<c:url value="/staff/addcompulsorycourses/${majorID}" var="formAction" />
		<c:url value="/staff/majoredit/${majorID}" var="cancelHrefAttribute" />
		<c:set value="/staff/compulsorycourseslist/${majorID}?" var="listHrefAttribute" scope="request" />
	</c:when>
	<c:when test='${actionType.equals("addCoreCourses")}'>
		<c:set var="heading" scope="request" value="Add Program Core Courses"/>
		<c:url value="/staff/addcorecourses/${programID}" var="formAction" />
		<c:url value="/staff/programedit/${programID}" var="cancelHrefAttribute" />
		<c:set value="/staff/corecourseslist/${programID}?" var="listHrefAttribute" scope="request" />
	</c:when>
	<c:when test='${actionType.equals("addElectiveCourses")}'>
		<c:set var="heading" scope="request" value="Add Program Elective Courses"/>
		<c:url value="/staff/addelectivecourses/${programID}" var="formAction" />
		<c:url value="/staff/programedit/${programID}" var="cancelHrefAttribute" />
		<c:set value="/staff/electivecourseslist/${programID}?" var="listHrefAttribute" scope="request" />
	</c:when>
	<c:when test='${actionType.equals("addCACourses")}'>
		<c:set var="heading" scope="request" value="Add Courses to the Schedule"/>
		<c:url value="/staff/addcacourses/${campusID}/${termID}" var="formAction" scope="request" />
		<c:url value="/staff/cacreatemultiple" var="cancelHrefAttribute" />
		<c:set value="/staff/cacourselist?campusID=${campusID}&termID=${termID}&" var="listHrefAttribute" scope="request" />
	</c:when>
</c:choose>

<%-- Conditional heading --%>
<h1><c:out value="${heading}"/></h1>
<p class="bottom30">
	This page displays all available courses. Please select at least one and click 'Add Selected' button.	
</p>

<%-- Table of courses with check boxes with conditional form action --%>
<form method="get" action="${formAction}" id="courseSelectForm">
	<c:if test="${resultList.pageSize > 10}">
		<input type="submit" class='btn btn-default bottom20' value="Add Selected" />
		<a class="btn btn-default left30 bottom20" href="${cancelHrefAttribute}">Cancel</a>
	</c:if>
	<table class="table table-bordered table-striped table-responsive">
		<thead>
			<tr>
				<th>Select</th>
				<th>#</th>
				<th>Code</th>
				<th>Title</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resultList.pageList}" var="course" varStatus="status">
				<tr>
					<td>
						<input type="checkbox" class="ckeckBox" name="courseIDs" value='<c:out value="${course.id}" />' />
					</td>
					<td><c:out value="${resultList.pageSize * resultList.page + status.count}" /></td>
					<td><c:out value="${course.code}" /></td>
					<td>
						<a href='${formAction}?courseIDs=${course.id}'>
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
	<input type="submit" class='btn btn-default' value="Add Selected" />
	<a class="btn btn-default left30" href="${cancelHrefAttribute}">Cancel</a>
</form>


<%-- Pagination --%>
<c:if test="${resultList.nrOfElements > 5}">
	<div class="row">
		<div class="col-md-8 col-sm-6 col-xs-6">
			<c:if test="${resultList.pageCount > 1}">
				<ul class="pagination">
					<%-- Previous button --%>
					<li<c:if test="${resultList.firstPage}"> class="disabled"</c:if>>
						<a href="
							<c:choose>
								<c:when test="${resultList.firstPage}">#</c:when>
								<c:when test="${! resultList.firstPage}"><s:url value="${listHrefAttribute}page=${resultList.page-1}" /></c:when>
							</c:choose>
						">&laquo;</a>
					</li>
					
					<%-- First page and dots --%>
					<c:if test="${resultList.pageCount > 5 && resultList.page > 2}">
						<li><a href='<s:url value="${listHrefAttribute}page=0" />'>1</a></li>
						<c:if test="${resultList.page != 3 && resultList.pageCount > 6}">
							<li class="disabled"><a href="#">...</a></li>
						</c:if>
					</c:if>
					
					<%-- Print numbers --%>
					<c:forEach begin="0" end="${resultList.pageCount-1}" varStatus="pageNumber">
						<c:if test="${
							pageNumber.index == resultList.page ||
							pageNumber.index == resultList.page - 1 ||
							pageNumber.index == resultList.page - 2 ||
							pageNumber.index == resultList.page + 1 ||
							pageNumber.index == resultList.page + 2 ||
							((resultList.page == 0 || resultList.page == 1) && pageNumber.index == resultList.page + 3) ||
							(resultList.page == 0 && pageNumber.index == resultList.page + 4) ||
							(resultList.page >= resultList.pageCount - 3 && pageNumber.index >= resultList.pageCount - 5)
						}">
							<li<c:if test="${resultList.page == pageNumber.index}"> class="active"</c:if>>
								<a href="<s:url value="${listHrefAttribute}page=${pageNumber.index}" />">${pageNumber.index+1}</a>
							</li>
						</c:if>
					</c:forEach>
					
					<%-- Last page and dots --%>
					<c:if test="${resultList.page < resultList.pageCount - 3 &&	resultList.pageCount > 5}">
						<c:if test="${resultList.page != resultList.pageCount - 4 && resultList.pageCount > 6}">
							<li class="disabled"><a href="#">...</a></li>
						</c:if>
						<li><a href='<s:url value="${listHrefAttribute}page=${resultList.pageCount-1}" />'>${resultList.pageCount}</a></li>
					</c:if>
					
					<%-- Next button --%>
					<li<c:if test="${resultList.lastPage}"> class="disabled"</c:if>>
						<a href="
							<c:choose>
								<c:when test="${resultList.lastPage}">#</c:when>
								<c:when test="${! resultList.lastPage}"><s:url value="${listHrefAttribute}page=${resultList.page+1}" /></c:when>
							</c:choose>
						">&raquo;</a>
					</li>
				</ul>
			</c:if>
		</div>
		<div class="col-md-4 col-sm-6 col-xs-6 top20">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="control-label col-xs-7" for="resultsPerPage">Results per page: </label>
					<div class="col-xs-4">
						<select class="form-control" id="resultsPerPage">
							<option<c:if test="${resultList.pageSize == 5}"> selected</c:if>>5</option>
							<option<c:if test="${resultList.pageSize == 10}"> selected</c:if>>10</option>
							<option<c:if test="${resultList.pageSize == 15}"> selected</c:if>>15</option>
							<option<c:if test="${resultList.pageSize == 20}"> selected</c:if>>20</option>
							<option<c:if test="${resultList.pageSize == 25}"> selected</c:if>>25</option>
							<option<c:if test="${resultList.pageSize == 30}"> selected</c:if>>30</option>
						</select>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<script>
		// Change page size after changing selection in #resultsPerPage drop down
		$(function() {
			$('#resultsPerPage').change(function(){
				var pageSize = $('#resultsPerPage').val();
				location.href = '<s:url value="${listHrefAttribute}pageSize=" />' + pageSize;
			});
			
			// Corses Form validation. There should be at least one course selected
			$('#courseSelectForm').bootstrapValidator({
				feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	'courseIDs': {
		        		validators: {
		                    choice: {
		                        min: 1,
		                        message: 'Please select at least one course to add'
		                    }
		                }
		        	}
		        }
			});
		});
	</script>
</c:if>