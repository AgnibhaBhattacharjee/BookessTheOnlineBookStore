<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"> 

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
					<li class="nav-item"><a class="nav-link" href="books">Books</a>

					</li>
					<li class="nav-item"><a class="nav-link" href="lovedbooks">Loved
							Books</a></li>
					<li class="nav-item"><a class="nav-link" href="readlaterbooks">Read
							Later Books</a></li>
					<!--  <li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/admin/task">Add
							New Task</a></li>
					<li class="nav-item"><a class="nav-link" href="users">View
							All Users</a></li>-->
					<%
					}
					
					%>
					<%String Name= (String)session.getAttribute("userName");
					if(Name!=null){
						%>
					<!--  <li class="nav-item"><h5 class="nav-link" style="color: #2ecc71">Welcome <%=Name %></h5>-->
					</li>
					<%
				   }
				   %>

				</ul>
				<%if(Name!=null){
					%>
				<span class="navbar-text" style="color: #2ecc71">Welcome <%=Name %></span>
				<% }%>
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
					if(email!=null){
						%>
					
					<th scope="col">Actions</th>
					<% }
					%>


					<!--<th scope="col">Assigned To</th>
					<th scope="col">EDIT/ DELETE</th>-->

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lovedBooks }" var="book">
					<tr>
						<td>${book.bookName }</td>
						<td>${book.bookGenres }</td>
						<td>${book.authorName }</td>
						<% String userName= (String)session.getAttribute("userName"); 
						if(userName!=null){
						%>
						<td><a href="removeFromLovedBooks?id=${book.id }"><button type="button" class="btn btn-link"><span class="bi bi-trash"></span></button></a></td>

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