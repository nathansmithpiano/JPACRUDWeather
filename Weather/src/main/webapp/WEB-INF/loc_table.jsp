<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="card">
	<div class="card-body">
		<h5 class="card-title">${list.size() } locations found</h5>
		
		<!-- Table with stripped rows -->
		<table class="table datatable">
			
			<thead>
				<tr>
					<!-- <th scope="col">id</th> -->
					<th id="datatable_firstcol_buttons"></th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<!-- <th scope="col">Latitude</th> -->
					<!-- <th scope="col">Longitude</th> -->
					<th scope="col">Elevation</th>
					<th scope="col">Range</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list }" var="point">
					<tr>
						<td>
							<a href="loc?id=${point.id }">
								<button class="btn btn-light rounded-pill btn-sm">
									view
								</button>
							</a>
						</td>
						<th scope="row">${point.name }</th>
						<td>${categories.get(point.categoryId).name }</td>
						<%-- <td>${point.latitude }</td> --%>
						<%-- <td>${point.longitude }</td> --%>
						<td><fmt:formatNumber type="number" value="${ point.elevation }" />'</td>
						<td>${ranges.get(point.rangeId).name }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- End Table with stripped rows -->
	
	</div>
</div>