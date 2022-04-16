<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="main_head.jsp" />
	
	<title>All Locations</title>
</head>
<body>
	<jsp:include page="main_bodyheader.jsp" />
	<jsp:include page="main_sidebar.jsp" />

	<main id="main" class="main">

		<!-- Begin Page Title with Breadcrumbs -->
		<div class="pagetitle">
			<h1>All Locations</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index">Home</a></li>
					<li class="breadcrumb-item">Locations</li>
					<li class="breadcrumb-item active">All Locations</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title with Breadcrumbs -->
		
		<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${list.size() } locations found</h5>
              <%-- <p>The database contains ${list.size() } locations.</p> --%>

              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <!-- <th scope="col">id</th> -->
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Latitude</th>
                    <th scope="col">Longitude</th>
                    <th scope="col">Elevation</th>
                    <th scope="col">Range</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${list }" var="point">
                  	<tr>
                  		<%-- <th scope="row">${point.id }</th> --%>
                  		<th scope="row">
                  			<a href="loc-single.do?id=${point.id }">${point.name }</a>
                  		</th>
                  		<td>${point.category }</td>
                  		<td>${point.latitude }</td>
                  		<td>${point.longitude }</td>
                  		<td><fmt:formatNumber type="number" value="${ point.elevation }" />'</td>
                  		<td>${point.mountainRange }</td>
                  	</tr>
                  </c:forEach>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>
		
		

	</main>











	<jsp:include page="main_scripts.jsp" />
	<script>
		document.getElementById("locations-nav").className = "nav-content collapse show";
	</script>
</body>
</html>