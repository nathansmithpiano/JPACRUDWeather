<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="main_head.jsp" />
	
	<title>Weather index.jsp</title>
</head>
<body>
	<jsp:include page="main_bodyheader.jsp" />
	<jsp:include page="main_sidebar.jsp" />

	<main id="main" class="main">

		<!-- Begin Page Title with Breadcrumbs -->
		<div class="pagetitle">
			<h1>Home</h1>
			<!-- <nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index"><i class="bi bi-house-door"></i></a></li>
					<li class="breadcrumb-item active">Home</li>
				</ol>
			</nav> -->
		</div>
		<!-- End Page Title with Breadcrumbs -->

	</main>

	<%-- ${DEBUG } --%>










	<script>
		document.getElementById("home-nav").className = "nav-link";
	</script>
	<jsp:include page="main_scripts.jsp" />
</body>
</html>