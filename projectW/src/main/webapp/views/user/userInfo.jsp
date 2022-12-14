<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/Bootstrap-4-Ecommerce-Theme-master/css/style.css" />"
	rel="stylesheet" type="text/css">
</head>
<body>
	<c:choose>
		<c:when test="${getUser._role == 1}"><%@ include
				file="/views/shared/header.jsp"%>
		</c:when>
	</c:choose>
	<div class="container" style="margin-top: 50px; margin-bottom: 30px;">
		<div class="main-body">
			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img id="avatar"
										src="${pageContext.request.contextPath}/${sessionScope.avatar}"
										alt="Admin" class="rounded-circle" width="150" height="150">
								<div class="mt-3">
									<a class="btn btn-outline-primary" href="edituserinfo">Sửa
										thông tin</a>
								</div>
								<div class="mt-3">
									<a class="btn btn-outline-danger" href="forgetPassword">Thay
										đổi mật khẩu</a>
								</div>
								<div class="mt-3">
									<c:choose>
										<c:when test="${getUser._role == 1}">
											<a class="btn btn-outline-secondary" href="myorder">Lịch
												sử đơn hàng</a>
										</c:when>
										<c:when test="${getUser._role == 0 }">
											<!-- Nếu là admin thì thay nút 'lịch sử đơn hàng' thành nút 'Về trang chủ' -->
											<a class="btn btn-success" href="welcomeAdmin">Trang chủ</a>
										</c:when>
										<c:when test="${getUser._role == 2 }">
											<!-- Nếu là admin thì thay nút 'lịch sử đơn hàng' thành nút 'Về trang chủ' -->
											<a class="btn btn-success" href="Vendor">Trang chủ</a>
										</c:when>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Họ tên</h6>
								</div>
								<div class="col-sm-9 text-secondary">${getUser.firstname}
									${getUser.lastname}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Email</h6>
								</div>
								<div class="col-sm-9 text-secondary">${getUser.email}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Số điện thoại</h6>
								</div>
								<div class="col-sm-9 text-secondary">${getUser.phone}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Địa chỉ</h6>
								</div>
								<div class="col-sm-9 text-secondary">${getUser.addresses }</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Mật khẩu</h6>
								</div>
								<div class="col-sm-9 text-secondary">******</div>
							</div>
							<hr>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- end content -->

	<!-- Footer -->
	<c:choose>
		<c:when test="${getUser._role == 1}"><%@ include
				file="/views/shared/footer.jsp"%>
		</c:when>
	</c:choose>

	<!-- end footer -->

	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>
</html>