<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="newbies.java16.crmapp.util.UrlConst"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
<link rel="shortcut icon"
	href='<c:url value="assets/images/favicon.ico"></c:url>' />
</head>
<body>
	<!-- Header Layout Content -->
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">
								Create Users</li>
						</ol>
					</nav>
					<h1 class="m-0">Create Users</h1>
				</div>
				<div class="ml-auto">
					<a href="" class="btn btn-light"><i
						class="material-icons icon-16pt text-muted mr-1">settings</i>
						Settings</a>
				</div>
			</div>
		</div>

		<div class="card card-form container">
			<div class="row no-gutters" style="position: relative; left: 300px;">
				<div class="col-lg-4 card-body">
					<form action='<c:url value="<%=UrlConst.USERCREATE%>"></c:url>'
						method="post">
						<div class="form-group">
							<label for="username">Name:</label> <input class="form-control"
								type="text" id="username" name="username"
								placeholder="Enter your name" />
						</div>
						<div class="form-group">
							<label for="email">Email Address:</label> <input
								class="form-control" type="email" id="email" name="email"
								placeholder="Enter your email address" />
						</div>
						<div class="form-group">
							<label for="password">Password:</label> <input
								class="form-control" type="password" id="password"
								name="password" placeholder="Enter your password" />
						</div>
						<div class="form-group">
							<label for="address">Address:</label> <input class="form-control"
								type="text" required="" id="address" name="address"
								placeholder="Enter your address" />
						</div>
						<div class="form-group">
							<label for="phone">Phone:</label> <input class="form-control"
								type="phone" required="" id="text" name="phone"
								placeholder="Enter your phone number" />
						</div>
						<div class="form-group">
							<label for="role_id">Role Id:</label> <select id="role"
								name="role_id" data-toggle="select" class="form-control">
								<option value="0">ADMIN</option>
								<option value="1">MANAGER</option>
								<option value="2">STAFF</option>
							</select>
						</div>
						<div class="form-group text-center">
							<p class="text-success">${message1}</p>
							<p class="text-danger">${message2}</p>
							<button class="btn btn-primary" type="submit">Create
								Account</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>