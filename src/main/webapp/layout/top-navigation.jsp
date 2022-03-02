<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="newbies.java16.crmapp.util.UrlConst"%>
<div id="header" class="mdk-header bg-dark js-mdk-header m-0" data-fixed
	data-effects="waterfall">
	<div class="mdk-header__content">
		<div
			class="navbar navbar-expand-sm navbar-main navbar-light bg-light pr-0"
			id="navbar" data-primary>
			<div class="container">
				<!-- Navbar toggler -->

				<button
					class="navbar-toggler navbar-toggler-right d-block d-md-none"
					type="button" data-toggle="sidebar">
					<span class="navbar-toggler-icon"></span>
				</button>

				<!-- Navbar Brand -->
				<a href='<c:url value="${UrlConst.HOMEPAGE}"></c:url>' class="navbar-brand"> <img
					class="navbar-brand-icon" src="assets/images/logo.png" height="50"
					alt="Cybersoft" />
				</a> <span class="mr-3"></span>
				<ul
					class="nav navbar-nav d-none d-sm-flex border-left navbar-border navbar-height align-items-center">
					<li class="nav-item dropdown"><a href="#account_menu"
						class="nav-link dropdown-toggle" data-toggle="dropdown"
						data-caret="false"> <span class="avatar avatar-sm"> <span
								class="avatar-title rounded-circle bg-warning">${user.name}</span>
						</span>
					</a>
						<div id="account_menu" class="dropdown-menu dropdown-menu-right">
							<div class="dropdown-item-text dropdown-item-text--lh">
								<div>
									<strong>${user.name}</strong>
								</div>
								<div>${user.email}</div>
							</div>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item active"
								href='<c:url value="${UrlConst.HOMEPAGE}"></c:url>'>
								Homepage </a> <a class="dropdown-item" href="#"> My profile </a> <a
								class="dropdown-item" href="#"> Edit account </a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href='<c:url value="${UrlConst.LOGOUT}"></c:url>'>Logout</a>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="mdk-header-layout__content page">
	<div class="page__header mb-0">
		<div class="container page__container">
			<div
				class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
				<button class="navbar-toggler navbar-toggler-right"
					data-toggle="collapse" data-target="#navbarsExample03"
					type="button">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="navbar-collapse collapse" id="navbarsExample03">
					<ul class="nav navbar-nav flex">
						<li class="nav-item" style="margin-right:10px"><a class="nav-link active"
							href='<c:url value="${UrlConst.HOMEPAGE}"></c:url>'> Home</a></li>
						<li class="nav-item dropdown"><a href="#"
							class="nav-link dropdown-toggle" data-toggle="dropdown">
								Project </a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#"> Manage Project </a> <a
									class="dropdown-item" href="#"> Project Create Project </a>
							</div></li>
						<li class="nav-item dropdown"><a href="#"
							class="nav-link dropdown-toggle" data-toggle="dropdown" <c:if test="${user.role!=1}">hidden</c:if>> User
						</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#"> User List </a> 
								<a class="dropdown-item" href="#"> Create User </a>
							</div></li>
						<li class="nav-item"><a class="nav-link" href="#">Task</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>