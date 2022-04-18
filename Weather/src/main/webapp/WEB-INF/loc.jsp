<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="main_head.jsp" />
	
	<title>${point.name }</title>
</head>
<body>
	<jsp:include page="main_bodyheader.jsp" />
	<jsp:include page="main_sidebar.jsp" />

	<main id="main" class="main">

		<!-- Begin Page Title with Breadcrumbs -->
		<div class="pagetitle">
			<h1>${point.name }</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index">Home</a></li>
					<li class="breadcrumb-item">Locations</li>
					<li class="breadcrumb-item active">${point.name }</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title with Breadcrumbs -->
		
		<!-- Begin Location Page -->
		<section class="section profile">
			<div class="row">
			
				<div class="col-xl-4"> <!-- Begin top left snapshot -->
					<div class="card">
						<div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
							<img src="assets/img/mountain-icon-large.png" class="rounded-circle">
							<h2>${point.name }</h2>
						
						</div>
					</div>
				</div> <!-- End top left snapshot -->
				
				<div class="col-xl-8">
					<div class="card">
						<div class="card-body pt-3"> <!-- Begin Top Right Card -->
						
						<!-- TODO: get tabs to hide/show like on template, 
							Should be able to work!
							likely need to re-do form using same layout at template? > -->
							
							<!-- <ul class="nav nav-tabs nav-tabs-bordered"> Begin Top Right Card Tabs
								<li class="nav-item">
									<button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">
										Overview
									</button>
								</li>
								<li class="nav-item">
                  					<button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">
                  						Edit Details
                  					</button>
                				</li>
                				<li class="nav-item">
                  					<button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-remove">
                  						Remove
                  					</button>
                				</li>
							</ul> End Top Right Card Tabs -->
							
							
							<%-- <div class="tab-content pt-2"> <!-- Begin Details -->
								<div class="tab-pane fade show active profile-overview" id="profile-overview">
									<h5 class="card-title">Location Details</h5>
									
									<div class="row">
										<div class="col-lg-3 col-md-4 label ">Name</div>
										<div class="col-lg-9 col-md-8">${point.name }</div>
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
										<div class="col-lg-9 col-md-8">${point.latitude }, ${point.longitude }</div>
									</div>
									
									<div class="row">
										<div class="col-lg-3 col-md-4 label ">Elevation</div>
										<div class="col-lg-9 col-md-8"><fmt:formatNumber type="number" value="${ point.elevation }" /> ft</div>
									</div>
								
								</div>
							</div> <!-- End Details --> --%>
							
							<div class="tab-pane fade show active pt-3" id="profile-edit"> <!-- Begin Edit -->
								<form method="post" action="update-location.do">
								<input type="hidden" name="id" id="id" value="${point.id }"/>
									<div class="row mb-3"> <!-- Begin Location Name -->
										<label for="name" class="col-md-4 col-lg-3 col-form-label">Location Name</label>
										<div class="col-md-8 col-lg-9">
											<input type="text" class="form-control" id="name" name="name" value="${point.name }"required>
										</div>
									</div> <!-- End Location Name -->
									
									<!-- <fieldset class="row mb-3">  -->
									<!-- Begin Category Radio -->
									 <div class="row mb-3">
										<label for="categoryId" class="col-md-4 col-lg-3 col-form-label">Category</label>
				                		<div class="col-md-8 col-lg-9">
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
					        		</div>
					        		<!-- End Category Radio -->
					        		
					        		
					        		<div class="row mb-3"> <!-- Begin Range Select -->
	                  					<label class="col-md-4 col-lg-3 col-form-label" for="rangeId">Range</label>
	                  					<div class="col-md-8 col-lg-9">
					                    	<select name="rangeId" class="form-select" aria-label="Default select example">
					                    		<c:forEach items="${ranges }" var="range">
					                    			<option id="range${range.key }" value="${range.key }">${range.value.name }</option>
					                    		</c:forEach>
					                    	</select>
					                  	</div>
					                </div> <!-- End Range Select -->
					        		
					        		
					        		<div class="row mb-3"> <!-- Begin Latitude -->
					        			<div class="col-6">
						        			<label for="latitude" class="col-md-4 col-6 col-form-label">Latitude</label>
						        			<input type="text" class="form-control" id="latitude" name="latitude" value="${point.latitude }" required>
					        			</div>
					        			<div class="col-6">
					        				<label for="longitude" class="col-md-4 col-6 col-form-label">Longitude</label>
					        				<input type="text" class="form-control" id="longitude" name="longitude" value="${point.longitude }" required>
					        			</div>
					        		</div> <!-- End Latitude -->
					        		

					        		<div class="row mb-3"> <!-- Begin Elevation -->
										<label for="elevation" class="col-md-4 col-lg-3 col-form-label">Elevation (ft)</label>
										<div class="col-md-8 col-lg-9">
											<input type="text" class="form-control" id="elevation" name="elevation" value="${point.elevation }">
										</div>
									</div> <!-- End Elevation -->
					        		
					        		<div class="text-center">  <!-- Begin Buttons -->
						                <button type="submit" class="btn btn-primary">Save Changes</button>
					                </div>  <!-- End Buttons -->
								</form>
								<div class="text-center"> 
									<a href="remove-location.do?id=${point.id }">
					                	<button class="btn btn-danger">Permanently Remove Location</button>
					                </a>
					            </div>
							</div> <!-- End Edit -->
							
						</div>
					</div>
					
				</div>
			</div>
		</section>
		

	</main>

	<jsp:include page="main_scripts.jsp" />
	<jsp:include page="format_loc_form_script.jsp" />
	<script>
		document.getElementById("locations-nav").className = "nav-content collapse show";
		document.getElementById("category" + ${point.categoryId}).checked=true;
		document.getElementById("range" + ${point.rangeId}).selected=true;
	</script>
</body>
</html>