<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="main_head.jsp" />
	
	<title>CO 13ers</title>
</head>
<body>
	<jsp:include page="main_bodyheader.jsp" />
	<jsp:include page="main_sidebar.jsp" />

	<main id="main" class="main">

		<!-- Begin Page Title with Breadcrumbs -->
		<div class="pagetitle">
			<h1>Colorado 13ers</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index"><i class="bi bi-house-door"></i></a></li>
					<li class="breadcrumb-item">Locations</li>
					<li class="breadcrumb-item active">Colorado 13ers</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title with Breadcrumbs -->

		<section class="section">
	      <div class="row">
	        <div class="col-lg-12">
	
	          <jsp:include page="loc_table.jsp" />
	
	        </div>
	      </div>
	    </section>
	    
		
	</main>


	<jsp:include page="main_scripts.jsp" />
	<script>
		document.getElementById("locations-nav").className = "nav-content collapse show";
		document.getElementById("loc-co13ers-nav").className = "active";
	</script>
</body>
</html>