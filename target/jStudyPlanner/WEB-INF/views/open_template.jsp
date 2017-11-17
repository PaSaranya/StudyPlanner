<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en"><!-- TODO: insert locale -->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- TODO: insert meta - description, shortcut icon -->
	<meta name="description" content="">
	<link rel="shortcut icon" href="../../assets/ico/favicon.ico">
	
	<title>Home</title>
	
	<!-- Bootstrap core CSS, form validator, datepicker -->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrapValidator.min.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/datepicker.css" />">
	<!-- Custom theme CSS -->
	<link rel="stylesheet" href="<c:url value="/resources/css/general.css" />">
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="<c:url value="/resources/js/html5shiv.js" />"></script>
		<script src="<c:url value="/resources/js/respond.min.js" />"></script>
    <![endif]-->

	<!-- jQuery, Bootstrap, Validator, Datepicker and custom JavaScript -->
	<script	type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrapValidator.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/general.js" />"></script>
</head>
<body>
	<!-- Header begin -->
	<t:insertAttribute name="header" /> <!--<co id="co_tile_header" />-->
	<!-- Header end -->
	
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar begin -->
			<t:insertAttribute name="side" /> <!--<co id="co_tile_side" />-->
			<!-- Sidebar end -->
			
			<!-- Login Form begin -->
			<t:insertAttribute name="loginForm" /> <!--<co id="co_tile_loginForm" />-->
			<!-- Login Form end -->
			
			<div class="col-sm-9 col-md-10 main top60 bottom30">
				<!-- Page content begin -->
				<t:insertAttribute name="content" /> <!--<co id="co_tile_content" />-->
				<!-- Page content end -->
			</div>
		</div>
	</div>
</body>
</html>
