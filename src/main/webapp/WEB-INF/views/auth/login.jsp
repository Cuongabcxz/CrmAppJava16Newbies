<%@page import="newbies.java16.crmapp.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta name="decorator" content="no">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>

<link rel="shortcut icon"
	href='<c:url value="/assets/images/favicon.ico"></c:url>' />

<!-- Perfect Scrollbar -->
<link type="text/css"
	href='<c:url value="/assets/vendor/perfect-scrollbar.css"></c:url>'
	rel="stylesheet">

<!-- App CSS -->
<link type="text/css" href='<c:url value="/assets/css/app.css"></c:url>'
	rel="stylesheet">
<link type="text/css"
	href='<c:url value="/assets/css/app.rtl.css"></c:url>' rel="stylesheet">

<!-- Material Design Icons -->
<link type="text/css"
	href='<c:url value="/assets/css/vendor-material-icons.css"></c:url>'
	rel="stylesheet">
<link type="text/css"
	href='<c:url value="/assets/css/vendor-material-icons.rtl.css"></c:url>'
	rel="stylesheet">

<!-- Font Awesome FREE Icons -->
<link type="text/css"
	href='<c:url value="/assets/css/vendor-fontawesome-free.css"></c:url>'
	rel="stylesheet">
<link type="text/css"
	href='<c:url value="/assets/css/vendor-fontawesome-free.rtl.css"></c:url>'
	rel="stylesheet">
</head>
<body class="layout-login">
	<div class="layout-login__overlay"></div>
	<div class="layout-login__form bg-white" data-perfect-scrollbar>
		<div class="d-flex justify-content-center mt-2 mb-5 navbar-light">
			<a href="index.html" class="navbar-brand" style="min-width: 0"> <img
				class="navbar-brand-icon"
				src='<c:url value="/assets/images/logo.png"></c:url>' width="250"
				alt="Stack">
			</a>
		</div>

		<h4 class="m-0">Welcome back!</h4>
		<p class="mb-5">Login to access your account</p>

		<form action='<c:url value ="<%=UrlConst.LOGIN %>"></c:url>' method="post" novalidate>
			<div class="form-group">
				<label class="text-label" for="email_2">Email Address:</label>
				<div class="input-group input-group-merge">
					<input id="email_2" type="email" name="email" value="${email!=null?email:""}"
						class="form-control form-control-prepended"
						placeholder="john@doe.com">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<span class="far fa-envelope"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="text-label" for="password_2">Password:</label>
				<div class="input-group input-group-merge">
					<input id="password_2" type="password" name ="password" required=""
						class="form-control form-control-prepended"
						placeholder="Enter your password">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<span class="fa fa-key"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group mb-5">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" name="remember" checked
						id="remember"> <label class="custom-control-label"
						for="remember">Remember me</label>
						<p class="text-danger">${message}</p>
				</div>
			</div>
			<div class="form-group text-center">
				<button class="btn btn-primary mb-5" type="submit">Login</button>
				<br> <a href="">Forgot password?</a> <br> Don't have an
				account? <a class="text-body text-underline" href='<c:url value="<%=UrlConst.SIGNUP %>"></c:url>'>Sign
					up!</a>
			</div>
		</form>
	</div>


	<!-- jQuery -->
	<script src='<c:url value="/assets/vendor/jquery.min.js"></c:url>'></script>

	<!-- Bootstrap -->
	<script src='<c:url value="/assets/vendor/popper.min.js"></c:url>'></script>
	<script src='<c:url value="/assets/vendor/bootstrap.min.js"></c:url>'></script>

	<!-- Perfect Scrollbar -->
	<script
		src='<c:url value="/assets/vendor/perfect-scrollbar.min.js"></c:url>'></script>

	<!-- DOM Factory -->
	<script src='<c:url value="/assets/vendor/dom-factory.js"></c:url>'></script>

	<!-- MDK -->
	<script
		src='<c:url value="/assets/vendor/material-design-kit.js"></c:url>'></script>

	<!-- App -->
	<script src='<c:url value="/assets/js/toggle-check-all.js"></c:url>'></script>
	<script src='<c:url value="/assets/js/check-selected-row.js"></c:url>'></script>
	<script src='<c:url value="/assets/js/dropdown.js"></c:url>'></script>
	<script src='<c:url value="/assets/js/sidebar-mini.js"></c:url>'></script>
	<script src='<c:url value="/assets/js/app.js"></c:url>'></script>

	<!-- App Settings (safe to remove) -->
	<script src='<c:url value="/assets/js/app-settings.js"></c:url>'></script>
</body>
</html>