<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Stylesheet (CSS) & JSP Tag
     Library -->
<!DOCTYPE html>
<html>
<head>
<title>Student List</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>Students List</h3>
		<a href="/StudentManagementDemo/student/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add
			Student</a>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Student Id</th>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Students}" var="student">
					<tr>
						<td><c:out value="${student.id}"></c:out></td>
						<td><c:out value="${student.name}"></c:out></td>
						<td><c:out value="${student.department}"></c:out></td>
						<td><c:out value="${student.country}"></c:out></td>
						<td><a href="/StudentManagementDemo/student/showFormForUpdate?id=${student.id}"
							class="btn btn-info btn-sm">Update</a>
							<a
							href="/StudentManagementDemo/student/delete?id=${student.id}"
							class="btn btn-danger btn-sm"
							onclick="if(!(confirm('Are you sure to delete this student?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
				<!-- Tag lib For loop -->
			</tbody>
		</table>
	</div>
</body>
</html>