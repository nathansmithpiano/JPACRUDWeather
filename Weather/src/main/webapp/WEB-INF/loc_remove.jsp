<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="main_head.jsp" />
	
	<title>Remove Location</title>
</head>
<body>
	<jsp:include page="main_bodyheader.jsp" />
	<jsp:include page="main_sidebar.jsp" />

	<main id="main" class="main">

		<!-- Begin Page Title with Breadcrumbs -->
		<div class="pagetitle">
			<h1>Remove Location</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index">Home</a></li>
					<li class="breadcrumb-item">Locations</li>
					<li class="breadcrumb-item active">Remove Location</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title with Breadcrumbs -->

	</main>











	<jsp:include page="main_scripts.jsp" />
	<script>
		document.getElementById("addremove-nav").className = "nav-content collapse show";
	</script>
</body>
</html>