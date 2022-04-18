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
					<li class="breadcrumb-item"><a href="index"><i class="bi bi-house-door"></i></a></li>
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
				                
				                
				                <fieldset class="row g-3"> <!-- Begin Category Radio -->
				                	<div class="col-12">
			                			<label for="categoryId" class="form-label">Category</label>
			                			
			                			<c:set var="countc" value="0" scope="page" />
			                			<c:forEach items="${categories }" var="cat">
			                				<c:set var="countc" value="${countc + 1}" scope="page"/>
			                				
			                				<c:choose>
			                					<c:when test="${countc == 1 }">
			                						<div class="form-check"> <!--  First category radio needs required -->
					                					<%-- <input class="form-check-input" type="radio" name="category" 
					                						id="category${countc }" value="${cat.key}" required> --%>
					                					<input class="form-check-input" type="radio" name="categoryId" 
					                						id="category${cat.key }" value="${cat.key}" required onClick="regularCategory()">
			            								<label class="form-check-label" for="category${cat.key }">
							                        		${cat.value.name }
						        						</label>
				        							</div>
			                					</c:when>
			                					<c:otherwise>
			                						<div class="form-check"> <!--  Other categories are normal (no required attribute) -->
					                					<%-- <input class="form-check-input" type="radio" name="category" 
					                						id="category${countc }" value="${cat.key }"> --%>
				                						<input class="form-check-input" type="radio" name="categoryId" 
					                						id="category${cat.key }" value="${cat.key }" onClick="regularCategory()">
			            								<label class="form-check-label" for="category${cat.key }">
							                        		${cat.value.name }
						        						</label>
				        							</div>
			                					</c:otherwise>
			                				</c:choose>
			                			</c:forEach>
			                			<!-- OTHER disabled - complicated with id / object mapping -->
			                			<div class="form-check">  <!-- Other option with text field -->
			                				<label class="form-check-label" onClick="newCategory()">New Category
			                				<input class="form-check-input" type="radio" name="categoryId" id="new_category" value="-1">
			                				<!-- <label class="form-check-label" for="other">New Category</label> -->
			                				<input type="text" class="form-control" name="new_cat_text" id="new_cat_text"></label>
			                			</div>
				        			</div>
				        		</fieldset> <!-- End Category Radio -->
				        		
				        		
				        		<div class="row g-3"> <!-- Begin Range Select -->
                  					<label class="col-sm-2 col-form-label" for="rangeId">Range</label>
                  					<div class="col-sm-10">
				                    	<select name="rangeId" id="rangeSelect" class="form-select" aria-label="Default select example" required>
				                    		<option value="">Select a range</option>
				                    		<c:forEach items="${ranges }" var="range">
				                    			<option value="${range.key }">${range.value.name }</option>
				                    		</c:forEach>
				                    	</select>
				                  	</div>
				                </div> <!-- End Range Select -->
				        		
				        		
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
		document.getElementById("locations-nav").className = "nav-content collapse show";
		document.getElementById("loc-add-nav").className = "active";
		document.getElementById("rangeSelect").selected = false;
	</script>
</body>
</html>