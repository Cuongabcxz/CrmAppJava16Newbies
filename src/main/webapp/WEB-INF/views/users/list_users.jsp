<%@page import="newbies.java16.crmapp.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
<link rel="shortcut icon" href='<c:url value="/assets/images/favicon.ico"></c:url>'/>
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
	<!-- Header Layout Content -->
			<div class="container page__heading-container">
				<div class="page__heading">
					<div class="d-flex align-items-center">
						<div>
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb mb-0">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">
										List Users</li>
								</ol>
							</nav>
							<h1 class="m-0">List Users</h1>
						</div>
						<div class="ml-auto">
							<a href="" class="btn btn-light"><i
								class="material-icons icon-16pt text-muted mr-1">settings</i>
								Settings</a>
						</div>
					</div>
				</div>
			</div>
	<div class="container">
		<table class="table  table-hover">
			<h3 style="text-align: center;">LIST OF EMPLOYEES</h3>
			<thead>
				<tr>
					<th style="width: 10px;" >ID</th>
					<th style="width: 120px;" >Name</th>
					<th style="width: 120px;" >Email</th>
					<th style="width: 120px;" >Address</th>
					<th style="width: 120px;" >Phone</th>
					<th style="width: 220px;" >Action</th>
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
									action='<c:url value="<%=UrlConst.USERDELETE%>"></c:url>'
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

						<form action='<c:url value="<%=UrlConst.USERUPDATE %>"></c:url>'
							method="post" name="form">
							<div class="form-group">
								<input class="form-control" type="hidden" name="id">
							</div>
							<div class="form-group">
								<%--@declare id="username"--%><label for="username">Name:</label>
								<input class="form-control"
									type="text" name="username" />
							</div>
							<div class="form-group">
								<%--@declare id="email"--%><label for="email">Email Address:</label> <input
									class="form-control" type="text" name="email" />
							</div>
							<div class="form-group" type="hidden">
								<%--@declare id="password"--%><label for="password">Password:</label> <input
									class="form-control" type="password" name="password"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<%--@declare id="address"--%><label for="address">Address:</label> <input
									class="form-control" type="text" name="address" />
							</div>
							<div class="form-group">
								<%--@declare id="phone"--%><label for="phone">Phone:</label> <input class="form-control"
									id="text" name="phone" />
							</div>
							<div class="form-group">
								<%--@declare id="role_id"--%><label for="role_id">Role:</label> <select id="role"
									name="role_id" data-toggle="select" class="form-control">
										<option value="1">ADMIN</option>
                            			<option value="2">MANAGER</option>
                            			<option value="3">STAFF</option>						
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