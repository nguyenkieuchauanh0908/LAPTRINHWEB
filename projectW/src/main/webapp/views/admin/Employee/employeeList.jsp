<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Admin</title>

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/synaptic/1.0.6/bundle.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="./Builder/css/main.css">
<link rel="stylesheet" href="./Builder/css/purchase.css">
</head>

<body>
	<div class="container-fluid" id="content">
		<div class="row min-vh-100 flex-column flex-md-row">
			<!-- menu bar -->
			<%@ include file="/views/admin/menuAdmin.jsp"%>
			<!-- end menu bar -->
			<div class="container-fluid col-12 col-md-9 col-xl-10">
				<section id="table">
					<div class="container">
						<div class="table-wrapper">
							<div class="table-title">
								<div class="row">
									<div class="col-sm-6">
										<h2 style="margin-top: 30px;">
											<b>Quản lý nhân viên</b>
										</h2>
									</div>
								</div>
							</div>
							<div>
								<form action="searchEmployeeAdmin" method="get"
									style="float: right;">
									<div class="input-group" style="padding-top: 0px;">
										<div class="form-outline">
											<input id="search-focus" type="search" id="form2"
												class="form-control" placeholder="Tìm kiếm..."
												name="keyword" value="${key}" />
										</div>
										<button
											style="float: right; border-radius: 6px; margin-right: 10px; margin-left: 10px; background-color: #228B22; hover: Green; border: none; text-align: center;"
											class="btn btn-info" type="submit">
											<h6>Tìm kiếm</h6>
										</button>
										<a href="userAdd"
											style="float: right; background-color: #FF6347; border: none; text-align: center; border-radius: 6px;"
											class="btn btn-info"> Thêm </a>
									</div>
								</form>
							</div>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th style="width: 150px">Mã NV</th>
										<th style="width: 170px">Tên nhân viên</th>
										<th>Số điện thoại</th>
										<th>Email</th>
										<th>Vai trò</th>
										<th style="width: 200px">Địa chỉ</th>
										<th>Sa thải</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${employeeList}" var="user">
										<tr>
											<td>${user._id}</td>
											<td>${user.lastname} ${user.firstname}</td>
											<td>${user.phone}</td>
											<td>${user.email}</td>
											<td class="center"><c:choose>
													<c:when test="${user._role == 0}">Quản trị viên
													</c:when>
													<c:when test="${user._role == 1}">Khách hàng
													</c:when>
													<c:otherwise>Nhân viên
													</c:otherwise>
												</c:choose></td>
											<td>${user.addresses}</td>
											<td>
												<form
													action="${pageContext.request.contextPath}/employeeDelete"
													method="post">
													<input type="hidden" name="uid" value="${user._id}">
													<button type="submit" class="btn btn-info">Xóa</button>
												</form>
											</td>
										</tr>
									</c:forEach>


								</tbody>

							</table>
							<div class="col-12">
								<nav aria-label="...">
									<ul class="pagination">
										<c:if test="${tag == 1}">
											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1">Previous</a></li>
										</c:if>
										<c:if test="${tag > 1}">
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}/employeeList?index=${tag-1}">Previous</a></li>
										</c:if>
										<c:forEach begin="1" end="${CountPa}" var="i">
											<c:if test="${i==tag}">
												<li class="page-item active"><a class="page-link"
													href="#">${i} <span class="sr-only">(current)</span>
												</a></li>
											</c:if>
											<c:if test="${i!=tag}">
												<li class="page-item"><a class="page-link"
													href="${pageContext.request.contextPath}/employeeList?index=${i}">${i}</a></li>
											</c:if>
										</c:forEach>
										<c:if test="${tag == CountPa}">
											<li class="page-item disabled"><a class="page-link"
												href="#">Next</a></li>
										</c:if>
										<c:if test="${tag < CountPa}">
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}/employeeList?index=${tag+1}">Next</a></li>
										</c:if>
									</ul>
								</nav>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</section>
			</div>
		</div>

	</div>

	<script src="./Builder/js/vendor.js" type="text/javascript"></script>
</body>