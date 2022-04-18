<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="main_head.jsp" />
	
	<title>Add Location</title>
</head>
<body>
	<jsp:include page="main_bodyheader.jsp" />
	<jsp:include page="main_sidebar.jsp" />

	<main id="main" class="main">

		<!-- Begin Page Title with Breadcrumbs -->
		<div class="pagetitle">
			<h1>Add Location</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index">Home</a></li>
					<li class="breadcrumb-item">Locations</li>
					<li class="breadcrumb-item active">Add Location</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title with Breadcrumbs -->
		
		<section class="section">
     		<div class="row">
        		<div class="col-lg-6">
        		
        			<div class="card"> <!-- Begin card -->
            			<div class="card-body"> <!-- Begin card-body -->
            				<h5 class="card-title">Location Details</h5>
            				
            				
            				<form class="row g-3" method="post" action="add-location.do"> <!-- Begin Vertical Form -->
            				
                				<div class="col-12"> <!-- Begin Location Name -->
				                	<label for="name" class="form-label">Location Name</label>
				                	<input type="text" class="form-control" id="name" name="name" required>
				                </div> <!-- End Location Name -->
				                
				                <fieldset class="row g-3"> <!-- Begin CategoryRadio -->
				                	<div class="col-6">
			                			<label for="category" class="form-label">Category</label>
			                			
			                			<c:set var="count" value="0" scope="page" />
			                			<c:forEach items="${categories }" var="cat">
			                				<c:set var="count" value="${count + 1}" scope="page"/>
			                				
			                				<c:choose>
			                					<c:when test="${count == 1 }">
			                						<div class="form-check"> <!--  First category radio needs required -->
					                					<input class="form-check-input" type="radio" name="category" 
					                						id="category${count }" value="${cat.id }" required>
<%-- 					                					<input class="form-check-input" type="radio" name="category" 
					                						id="category${count }" value="${cat.id }" onClick="regularCategory()" required> --%>
			            								<label class="form-check-label" for="category${count }">
							                        		${cat.name }
						        						</label>
				        							</div>
			                					</c:when>
			                					<c:otherwise>
			                						<div class="form-check"> <!--  Other categories are normal (no required attribute) -->
					                					<input class="form-check-input" type="radio" name="category" 
					                						id="category${count }" value="${cat.id }">
				                						<%-- <input class="form-check-input" type="radio" name="category" 
					                						id="category${count }" value="${cat.id }" onClick="regularCategory()"> --%>
			            								<label class="form-check-label" for="category${count }">
							                        		${cat.name }
						        						</label>
				        							</div>
			                					</c:otherwise>
			                				</c:choose>
			                			</c:forEach>
			                			<!-- OTHER disabled - complicated with id / object mapping -->
			                			<!-- <div class="form-check">  Other option with text field
			                				<label class="form-check-label" onClick="otherCategory()">
			                				<input class="form-check-input" type="radio" name="category" id="other_category" value="other">Other
			                				<label class="form-check-label" for="other">Other</label>
			                				<input type="text" class="form-control" name="other" id="other_text"></label>
			                			</div> -->
				        			</div>
				        		</fieldset> <!-- End Category Radio -->
				        		
				        		<div class="col-6"> <!-- Begin Latitude -->
				        			<label for="latitude" class="form-label">Latitude</label>
				        			<input type="text" class="form-control" id="latitude" name="latitude" placeholder="39.7392" required>
				        		</div> <!-- End Latitude -->
				        		
				        		<div class="col-6"> <!-- Begin Longitude -->
				        			<label for="longitude" class="form-label">Longitude</label>
				        			<input type="text" class="form-control" id="longitude" name="longitude" placeholder="104.9903" required>
				        		</div> <!-- End Longitude -->
				        		
				        		<div class="col-12"> <!-- Begin Elevation -->
				        			<label for="elevation" class="form-label">Elevation (feet)</label>
				        			<input type="text" class="form-control" id="elevation" name="elevation">
				        		</div> <!-- End Elevation -->
				        		
				        		<div class="text-center">  <!-- Begin Buttons -->
					                <button type="submit" class="btn btn-primary">Submit</button>
					                <button type="reset" class="btn btn-secondary">Reset</button>
				                </div> <!-- End Buttons -->
				        		
			        		</form> <!-- End Vertical Form -->
		        		</div> <!-- End card-body -->
	        		</div> <!-- End card -->
	        		
        		</div> <!-- End col-lg-6 -->
       		</div> <!-- End row -->
     	</section> <!-- End section -->
				        		
		
		

	</main>

	<jsp:include page="main_scripts.jsp" />
	<jsp:include page="format_loc_form_script.jsp" />
	<script>
		document.getElementById("addremove-nav").className = "nav-content collapse show";
	</script>
</body>
</html>