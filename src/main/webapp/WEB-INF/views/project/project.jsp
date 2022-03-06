<%@page import="newbies.java16.crmapp.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Project</title>
<link rel="shortcut icon" href='<c:url value="assets/images/favicon.ico"></c:url>'/>
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
										Manager Project</li>
								</ol>
							</nav>
							<h1 class="m-0">Manager Project</h1>
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
		<!-- Page Content -->
		<div class="card card-form">
			<div class="row no-gutters">
				<div class="col-lg-8 card-form__body border-left"
					style="flex: 100%; max-width: 100%">
					<div class="table-responsive border-bottom" data-toggle="lists"
						data-lists-values='["js-lists-values-employee-name"]'>
						<table class="table mb-0 thead-border-top-0">
							<thead>
								<tr>
									<th style="width: 120px;">Project name</th>
									<th style="width: 37px;">Status</th>
									<th style="width: 80px;">Start Date</th>
									<th style="width: 80px;">End Date</th>
									<th style="width: 24px;">Change</th>
								</tr>
							</thead>
							<tbody class="list" id="staff">
								<c:forEach var="projects" items="${projects}">
									<tr class="selected">
										<td>
											<div class="media align-items-center">
												<div class="media-body">
													<span class="js-lists-values-employee-name">${projects.name}</span>
												</div>
											</div>
										</td>
										<td><c:choose>
										<c:when test="${projects.nameOfManager.equals('admin')}"><span class="badge badge-warning">Chưa phân bổ</span></c:when>
										<c:otherwise><span class="badge badge-success">${projects.nameOfManager}</span></c:otherwise>
										</c:choose></td>
										<td><small class="text-muted">${projects.startDate}</small></td>
										<td><small class="text-muted">${projects.endDate}</small></td>
										<td>
										<button type="button" class="btn btn-warning " 
										data-toggle="modal" data-target="#modal-signup"><i class="material-icons">settings</i></button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	<!-- Sign Up Modal -->
    <div id="modal-signup" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="false">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="px-3">
                        <div class="d-flex justify-content-center mt-2 mb-4 navbar-light">
                            <a href="dashboard.html" class="navbar-brand" style="min-width: 0">
                                <img class="navbar-brand-icon" src="assets/images/logo.png" width="250" alt="Cybersoft">
                            </a>
                        </div>

                        <form action='<c:url value="<%=UrlConst.UPDATEPROJECT%>"></c:url>' method="post" novalidate>
                            <div class="form-group">
                                <label for="username">Project name:</label>
                                <select  name="projectName" style="padding: 5px; border-radius: 0.25rem;border: solid; border-color: cadetblue;">
                                <optgroup label="Project name">
                                <c:forEach var="projects" items="${projects}">
                                <option>${projects.name}</option>
                                </c:forEach>
                                </optgroup>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="username">Manager mail:</label>
                                <select  name="projectName" style="padding: 5px; border-radius: 0.25rem;border: solid; border-color: cadetblue;">
                                <optgroup label="Project name">
                                <c:forEach var="projects" items="${projects}">
                                <option>${projects.nameOfManager}</option>
                                </c:forEach>
                                </optgroup>
                                </select>
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
                            <div class="form-group text-center">
                            	<button type="button" class="btn btn-light" data-dismiss="modal" style="float:left;margin-right:10px">Close</button>
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
    <!-- // END .modal -->
</body>
</html>