<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">BOOKESS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
					<%
						String id = (String) session.getAttribute("email");
						String Name = (String) session.getAttribute("userName");
						if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a>
					</li>
					<%
						}
						if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="lovedbooks">Loved
							Books</a></li>
					<li class="nav-item"><a class="nav-link" href="readlaterbooks">Read
							Later Books</a></li>

					<!--  <li class="nav-item"><h5 class="nav-link" style="color: #2ecc71">Welcome <%=Name%></h5>-->
					</li>




					<!--  <li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/admin/task">Add
							New Task</a></li>
					<li class="nav-item"><a class="nav-link" href="users">View
							All Users</a></li>-->
					<%
						}
					%>

				</ul>
				<%
					if (Name != null) {
				%>
				<span class="navbar-text" style="color: #2ecc71">Welcome <%=Name%></span>
				<%
					}
				%>
			</div>
		</div>
	</nav>
	<!--<c:choose>
	<c:when test="${mode==login}">
	<div class="container text-center mt-3">
	<h3 >Welcome, ${user.userName}</h3>
	</div>
	</c:when>
	</c:choose>-->

	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Book Genres</th>
					<th scope="col">Author name</th>
					<%
						String email = (String) session.getAttribute("email");
						if (email != null) {
					%>
					<th scope="col">Add to Loved Books</th>
					<th scope="col">Add to Read Later</th>
					<%
						}
					%>


					<!--<th scope="col">Assigned To</th>
					<th scope="col">EDIT/ DELETE</th>-->

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books }" var="book">
					<tr>
						<td>${book.bookName }</td>
						<td>${book.bookGenres }</td>
						<td>${book.authorName }</td>
						<%
							String userName = (String) session.getAttribute("userName");
								if (userName != null) {
						%>
						<td><a href="addToLovedBooks?id=${book.id }"><svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
  								<path
										d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" />
						</svg></a></td>
						<td><a href="addToRaedLaterBooks?id=${book.id }"><svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-bookmarks" viewBox="0 0 16 16">
  								<path
										d="M2 4a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v11.5a.5.5 0 0 1-.777.416L7 13.101l-4.223 2.815A.5.5 0 0 1 2 15.5V4zm2-1a1 1 0 0 0-1 1v10.566l3.723-2.482a.5.5 0 0 1 .554 0L11 14.566V4a1 1 0 0 0-1-1H4z" />
  								<path
										d="M4.268 1H12a1 1 0 0 1 1 1v11.768l.223.148A.5.5 0 0 0 14 13.5V2a2 2 0 0 0-2-2H6a2 2 0 0 0-1.732 1z" />
						</svg></a></td>
						<%
							}
						%>

						<!--<c:if test="${task.taskcompleted}">
							<td>YES</td>
						</c:if>
							
						<c:if test="${!task.taskcompleted }">
							<td>NO</td>
						</c:if>
							
						<c:if test="${task.email == null}">
							<td>NOT ASSIGNED</td>
						</c:if>
						<td>${task.email }</td>
						<td><a href="${pageContext.servletContext.contextPath }/admin/edit/${task.taskid }">Edit</a>
						<a href="${pageContext.servletContext.contextPath }/admin/delete/${task.taskid }"><i class="fa fa-trash"></i></a></td>
					</tr>-->
				</c:forEach>


			</tbody>
		</table>
	</div>



</body>
</html>