<%@page import="newbies.java16.crmapp.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<script>
		function show() {
			var row_id = event.target.parentNode.parentNode.parentNode.id;
			var data = document.getElementById(row_id).querySelectorAll(
					".row-data");
			var id = data[0].innerHTML;
			var name = data[1].innerHTML;
			var email = data[2].innerHTML;
			var address = data[3].innerHTML;
			var phone = data[4].innerHTML;
			document.form.id.value = id;
			document.form.username.value = name;
			document.form.email.value = email;
			document.form.address.value = address;
			document.form.phone.value = phone;
		}
	</script>
	<br>
	<button type="button" class="btn btn-primary d-inline-flex"
		data-toggle="modal" data-target="#modal-signup"
		style="float: right; margin-right: 24%;">Insert Account</button>
	<div id="modal-signup" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true" data-backdrop="false">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<div class="px-3">
						<div class="d-flex justify-content-center mt-2 mb-4 navbar-light">
							<a href="dashboard.html" class="navbar-brand"
								style="min-width: 0"> <img class="navbar-brand-icon"
								src="assets/images/logo.png" width="250" alt="Cybersoft">
							</a>
						</div>

						<form action='<c:url value="${UrlConst.USERLIST }"></c:url>'
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
								<label for="address">Address:</label> <input
									class="form-control" type="text" required="" id="address"
									name="address" placeholder="Enter your address" />
							</div>
							<div class="form-group">
								<label for="phone">Phone:</label> <input class="form-control"
									type="phone" required="" id="text" name="phone"
									placeholder="Enter your phone number" />
							</div>
							<div class="form-group">
								<label for="role_id">Role Id:</label> <select id="role"
									name="role_id" data-toggle="select" class="form-control">
									<option selected="" value="1">Admin</option>									
								</select>
							</div>
							<div class="form-group text-center">
								<button class="btn btn-primary" type="submit">Create
									Account</button>
							</div>
							
						</form>
					</div>
				</div>
				<!-- // END .modal-body -->
			</div>
			<!-- // END .modal-content -->
		</div>
		<!-- // END .modal-dialog -->
	</div>
	<div class="container">
		<table class="table  table-hover">
			<h3 style="text-align: center;">DANH SÁCH NHÂN VIÊN</h3>
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Address</th>
					<th scope="col">Phone</th>
					<th scope="col">Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="item">
					<tr id="${item.id}">
						<td class="row-data">${item.id}</td>
						<td class="row-data">${item.name }</td>
						<td class="row-data">${item.email }</td>
						<td class="row-data">${item.address }</td>
						<td class="row-data">${item.phone }</td>
						<td>
							<div class="button-list d-flex flex-wrap" style="display: inline-block;">
								<input type="button" class="btn btn-primary" data-toggle="modal"
									data-target="#modal-edit" value="update" onclick="show()" />
								<form
									action="<%=request.getContextPath() + UrlConst.USERDELETE%>"
									method="get">
									<input type="hidden" name="id" value="${item.id}"></input>
									<button type="submit" class="btn btn-danger">Delete</button>
								</form>
							</div>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>


	<div id="modal-edit" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true" data-backdrop="false">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<div class="px-3">
						<div class="d-flex justify-content-center mt-2 mb-4 navbar-light">
							<a href="dashboard.html" class="navbar-brand"
								style="min-width: 0"> <img class="navbar-brand-icon"
								src="assets/images/logo.png" width="250" alt="Cybersoft">
							</a>
						</div>

						<form action="<%=request.getContextPath() + UrlConst.USERLIST%>"
							method="post" name="form">
							<div class="form-group">

								<input class="form-control" type="hidden" name="id">
							</div>
							<div class="form-group">
								<label for="username">Name:</label> <input class="form-control"
									type="text" name="username" />
							</div>
							<div class="form-group">
								<label for="email">Email Address:</label> <input
									class="form-control" type="text" name="email" />
							</div>
							<div class="form-group" type="hidden">
								<label for="password">Password:</label> <input
									class="form-control" type="password" name="password"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<label for="address">Address:</label> <input
									class="form-control" type="text" name="address" />
							</div>
							<div class="form-group">
								<label for="phone">Phone:</label> <input class="form-control"
									id="text" name="phone" />
							</div>
							<div class="form-group">
								<label for="role_id">Role Id:</label> <select id="role"
									name="role_id" data-toggle="select" class="form-control">
									<option selected="" value="1">Admin</option>							
								</select>
							</div>
							<div class="form-group text-center">
								<button class="btn btn-primary" type="submit">Update</button>
							</div>
						</form>
					</div>
				</div>
				<!-- // END .modal-body -->
			</div>
			<!-- // END .modal-content -->
		</div>
		<!-- // END .modal-dialog -->
	</div>



</body>
</html>