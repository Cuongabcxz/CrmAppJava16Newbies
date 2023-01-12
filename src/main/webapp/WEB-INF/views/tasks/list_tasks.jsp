<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="newbies.java16.crmapp.util.UrlConst" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Task</title>
</head>
<body>
<!-- Header Layout Content -->
			<div class="container page__heading-container">
				<div class="page__heading">
					<div class="d-flex align-items-center">
						<div>
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb mb-0">
									<li class="breadcrumb-item"><a  href='<c:url value="${UrlConst.HOMEPAGE}"></c:url>'>Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">
										List Task</li>
								</ol>
							</nav>
							<h1 class="m-0">List Task</h1>
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
		<h3 style="text-align: center;">LIST OF TASKS</h3>
		<div class="card card-form">
			<div class="row no-gutters">
				<div class="col-lg-8 card-form__body border-left"
					style="flex: 100%; max-width: 100%">
					<div class="table-responsive border-bottom" data-toggle="lists"
						data-lists-values='["js-lists-values-employee-name"]'>
						<table class="table mb-0 thead-border-top-0">
							<thead>
								<tr>
									<th style="width: 120px;">Task name</th>
									<th style="width: 37px;">Description</th>
									<th style="width: 150px;">Start Date</th>
									<th style="width: 150px;">End Date</th>
									<th style="width: 40px;">Belong</th>
									<th style="width: 20px;">Status</th>
									<th style="width: 160px;">Change</th>
								</tr>
							</thead>
							<tbody class="list" id="staff">
								<c:forEach var="tasks" items="${tasks}">
									<tr class="selected">
										<td>
											<div class="media align-items-center">
												<div class="media-body">
													<span class="js-lists-values-task-name">${tasks.name}</span>
												</div>
											</div>
										</td>
										<td><small class="text-muted">${tasks.description}</small></td>
										<td><small class="text-muted">${tasks.startDate}</small></td>
										<td><small class="text-muted">${tasks.endDate}</small></td>
										<td><small class="text-muted">${tasks.projectName}</small></td>
										<c:choose>
										<c:when test="${tasks.statusId==1}">
										<td><small class="badge badge-pill badge-success">Finished</small></td>
										</c:when>
										<c:otherwise>
										<td><small class="badge badge-pill badge-warning">Unfinished</small></td>
										</c:otherwise>
										</c:choose>
										<td>
									<button type="button" style="float:left;margin-right:4px;" class="btn btn-warning " 
										data-toggle="modal" data-target="#modal-signup"><i class="material-icons">settings</i></button>
										<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-small" onclick="run()">
										<i class="material-icons">close</i></button>
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

                        <form action='<c:url value="<%=UrlConst.TASKUPDATE%>"></c:url>' method="post" novalidate>
                            <div class="form-group">
                                <%--@declare id="username"--%><label for="username">Task name:</label>
                                <select  name="taskName" style="padding: 5px; border-radius: 0.25rem;border: solid; border-color: cadetblue;">
                                <optgroup label="Task name">
                                <c:forEach var="tasks" items="${tasks}">
                                <option>${tasks.name}</option>
                                </c:forEach>
                                </optgroup>
                                </select>
                            </div>
                            <div class="form-group">
                                <%--@declare id="start_date"--%><label for="start_date">Start Date:</label>
                                 <input id="dateRangePickerSample01" name="start_day" type="text" class="form-control" 
                                 placeholder="Date example" data-toggle="daterangepicker" data-daterangepicker-drops="up" 
                                 data-daterangepicker-start-date="2021/03/06" data-daterangepicker-single-date-picker="true">
                            </div>
                             <div class="form-group">
                                <%--@declare id="end_date"--%><label for="end_date">End Date:</label>
                                 <input id="dateRangePickerSample01" name="end_day" type="text" class="form-control" 
                                 placeholder="Date example" data-toggle="daterangepicker" data-daterangepicker-drops="up" 
                                 data-daterangepicker-start-date="2021/03/06" data-daterangepicker-single-date-picker="true">
                            </div>
                            	<div class="form-group">
								<label style="position: relative;">Finished <input style="position: absolute;top:5px;left: 70px;" type="radio" name="status" value ="1" checked></label><br>
								<label style="position: relative;">Unfinished <input style="position: absolute;top:5px;left: 85px;" type="radio" name="status" value ="2" checked></label><br>
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