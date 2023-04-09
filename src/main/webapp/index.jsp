<%-- JSP Page Directive --%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookess Online BookStore</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
p {
	color: white;
	background-color: black;
	padding: 10px;
}

.heading {
	padding: 40px;
	font-size: 40px;
	background-color: beige;
	color: #3846a9;
}

.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: auto;
	width: 50%;
	height: 50%;
}

.img {
	maxwidth: 70%;
	height: 700px;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
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


					<%String userName= (String)session.getAttribute("userName");
					if(userName==null){
						%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a>
					</li>
					<%
				   }
				   %>

					<li class="nav-item"><a class="nav-link" href="books">Books</a>

					</li>
					<%
					if(userName!=null){
						%>

					<li class="nav-item"><a class="nav-link" href="lovedbooks">Loved
							Books</a></li>
					<li class="nav-item"><a class="nav-link" href="readlaterbooks">Read
							Later Books</a></li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
					</li>
					<!--  <li class="nav-item"><h5 class="nav-link" style="color: #2ecc71">Welcome <%=userName %></h5>-->
					</li>

					<%
				   }
				   %>


				</ul>
				<%if(userName!=null){
					%>
				<span class="navbar-text" style="color: #2ecc71">Welcome <%=userName %></span>
				<% }%>
			</div>
		</div>
	</nav>

	<h1 class='text-center heading'>Bookess- The Free Online BookStore</h1>
	<img src='resources/images/OnlineBooks.jpg' class='center' />

</body>
</html>