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
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
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
										<h2 style="margin-top:30px;">
											<b>Quản lý người dùng</b>
										</h2>								
									</div>
								</div>
							</div>
							<a href="">							
							<button style = "float:right;margin-right:30px;margin-top:-10px;background-color: #FF6347;border: none;text-align:center;padding:5px 10px;" class="btn btn-info"><h6>Lọc</h6></button>
							</a>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th style="width: 100px">Mã khách hàng</th>
										<th style="width: 170px">Tên khách hàng</th>
										<th>Số điện thoại</th>
										<th>Email</th>
										<th>Vai trò</th>
										<th style="width: 200px">Địa chỉ</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${userList}" var="user">
								<tr>
										<td>${user._id}</td>
										<td>${user.lastname} ${user.firstname}</td>
										<td>${user.phone}</td>
										<td>${user.email}</td>
										<td class="center">
											<c:choose>
													<c:when test="${user._role == 0}">Quản trị viên
													</c:when>
													<c:when test="${user._role == 1}">Khách hàng
													</c:when>
													<c:otherwise>Nhân viên
													</c:otherwise>
											</c:choose>
										</td>
										<td>${user.addresses}</td>
										
									</tr>
								</c:forEach>
									

								</tbody>

							</table>
							<div class="clearfix"></div>
						</div>
					</div>
				</section>
			</div>
		</div>

	</div>
	
	<script src ="./Builder/js/vendor.js" type="text/javascript"></script>
</body>