<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
					<li class="breadcrumb-item"><a href="index"><i class="bi bi-house-door"></i></a></li>
					<li class="breadcrumb-item">Locations</li>
					<li class="breadcrumb-item active">Remove</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title with Breadcrumbs -->
		
		<section class="section">
     		<div class="row">
        		<div class="col-xl-8">
        		
        			<div class="card"> <!-- Begin card -->
            			<div class="card-body"> <!-- Begin card-body -->
            				<h5 class="card-title">Location Removed</h5>
            				
            				<form method="post" action="add-location.do">
	            				<input type="hidden" name="name" id="name" value="${backup.name }">
	            				<input type="hidden" name="categoryId" id="categoryId" value="${backup.categoryId }">
	            				<input type="hidden" name="rangeId" id="rangeId" value="${backup.rangeId }">
	            				<input type="hidden" name="latitude" id="latitude" value="${backup.latitude }">
	            				<input type="hidden" name="longitude" id="longitude" value="${backup.longitude }">
	            				<input type="hidden" name="elevation" id="elevation" value="${backup.elevation }">
	            				<input type="hidden" class="form-control" name="new_cat_text" id="new_cat_text" value="">
	            				
	            				<div class="row">
									<div  class="col-lg-3 col-md-4 label ">Name</div>
									<div class="col-lg-9 col-md-8">${backup.name }</div>
								</div>
								
								<div class="row">
									<div class="col-lg-3 col-md-4 label ">Category</div>
									<div class="col-lg-9 col-md-8">${category.name }</div>
								</div>
								
								<div class="row">
									<div class="col-lg-3 col-md-4 label ">Range</div>
									<div class="col-lg-9 col-md-8">${range.name }</div>
								</div>
								
								<div class="row">
									<div class="col-lg-3 col-md-4 label ">Coordinates</div>
									<div class="col-lg-9 col-md-8">${backup.latitude }, ${backup.longitude }</div>
								</div>
								
								<div class="row">
									<div class="col-lg-3 col-md-4 label ">Elevation</div>
									<div class="col-lg-9 col-md-8"><fmt:formatNumber type="number" value="${ backup.elevation }" /> ft</div>
								</div>
								
								<div class="text-center">  <!-- Begin Buttons -->
									<button type="submit" class="btn btn-warning">Add Back To Database (new ID)</button>
	            				</div>  <!-- End Buttons -->
	            			</form>
            				
            				
            				
		        		</div> <!-- End card-body -->
	        		</div> <!-- End card -->
	        		
        		</div> <!-- End col-lg-6 -->
       		</div> <!-- End row -->
     	</section> <!-- End section -->
				        		
		
		

	</main>

	<jsp:include page="main_scripts.jsp" />
	<jsp:include page="format_loc_form_script.jsp" />
	<script>
		document.getElementById("locations-nav").className = "nav-content collapse show";
	</script>
</body>
</html>