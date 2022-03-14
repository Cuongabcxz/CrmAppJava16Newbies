<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="newbies.java16.crmapp.util.UrlConst"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Project</title>
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
							<li class="breadcrumb-item"><a
								href='<c:url value="<%=UrlConst.HOMEPAGE%>"/>'>Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">
								Create Project</li>
						</ol>
					</nav>
					<h1 class="m-0">Create Project</h1>
				</div>
				<div class="ml-auto">
					<a href="" class="btn btn-light"><i
						class="material-icons icon-16pt text-muted mr-1">settings</i>
						Settings</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<!-- End Breadcrumb -->
		<div class="container page__container">
			<div class="card card-form">
				<div class="row no-gutters">
					<div class="col-lg-4 card-body">
						<p>
							<strong class="headings-color">Rules</strong>
						</p>
						<p class="text-muted">You must fill all of option!</p>
					</div>
					<div class="col-lg-8 card-form__body card-body">
						<form action='<c:url value="<%=UrlConst.PROJECTCREATE%>"></c:url>'method="post">
							<div class="form-group">
								<label for="projectName">Project name:</label> <input type="projectName"
									class="form-control" name="projectName" id="projectName">
							</div>
							<div class="form-group">
								 <label for="start_date">Start Date:</label>
                                 <input id="dateRangePickerSample01" name="start_day" type="text" class="form-control" 
                                 placeholder="Date example" data-toggle="daterangepicker" data-daterangepicker-drops="up" 
                                 data-daterangepicker-start-date="2021/03/06" data-daterangepicker-single-date-picker="true">
							</div>
							<div class="form-group">
								<label for="end_date">End Date:</label>
                                 <input id="dateRangePickerSample01" name="end_day" type="text" class="form-control" 
                                 placeholder="Date example" data-toggle="daterangepicker" data-daterangepicker-drops="up" 
                                 data-daterangepicker-start-date="2021/03/06" data-daterangepicker-single-date-picker="true">
							</div>
							<div class="form-group">
								<label for="address">Description:</label>
								<textarea type="text" cols="20" rows="5" class="form-control" name="description"
									id="description" aria-label="With textarea"></textarea>
							</div>
							<div class="form-group">
								<label for="role">Role</label> <select id="role" name="owner"
									data-toggle="select" class="form-control">
									<option value="0">ADMIN</option>
                            		<option value="1">MANAGER</option>
                            		<option value="2">STAFF</option>
								</select>
							</div>
							<p class="text-success">${message}</p>
							<button class="btn btn-primary w-25 justify-content-center"
								type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>