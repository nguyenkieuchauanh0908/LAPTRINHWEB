<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Chỉnh sửa thông tin cá nhân</title>
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
		<c:when test="${getUserEdit._role == 1}"><%@ include
				file="/views/shared/header.jsp"%>
		</c:when>
	</c:choose>
	<!-- content -->
	<form method="post" action="edituserinfo">
		<div class="container" style="margin-top: 50px; margin-bottom: 30px;">
			<div class="main-body">
				<div class="row gutters-sm">
					<div class="col-md-4 mb-3">
						<div class="card">
							<div class="card-body">
								<div class="d-flex flex-column align-items-center text-center">
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
										alt="Admin" class="rounded-circle" width="150">
									<p class="text-danger">${alert }</p>
									<div class="form-group mt-3">
										<div class="">
											<input type="submit" value="Lưu"
												class="btn btn-outline-danger" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-8">
						<div class="card mb-3">
							<div class="card-body">
								<div class="row">
									<div class="form-group col-2">
										<div class="form-group">
											<input class="form-control" type="hidden" name="id" id="id"
												value="${getUserEdit._id }" readonly="readonly">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Họ</h6>
									</div>
									<div class="form-group col-sm-6">
										<input class="form-control" type="text" name="firstname"
											id="firstname" value="${getUserEdit.firstname }"
											required="required">
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Tên</h6>
									</div>
									<div class="form-group col-sm-6">
										<input class="form-control" type="text" name="lastname"
											id="firstname" value="${getUserEdit.lastname }"
											required="required">
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Email</h6>
									</div>
									<div class="form-group col-sm-6">
										<input class="form-control" type="text" name="email"
											id="firstname" value="${getUserEdit.email }"
											required="required">
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Số điện thoại</h6>
									</div>
									<div class="form-group col-sm-6">
										<input class="form-control" type="text" name="phone"
											id="firstname" value="${getUserEdit.phone }"
											required="required">
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Địa chỉ</h6>
									</div>
									<div class="form-group col-sm-6">
										<input class="form-control" type="text" name="addresses"
											id="firstname" value="${getUserEdit.addresses }"
											required="required">
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Mật khẩu</h6>
									</div>
									<div class="form-group col-sm-6 text-secondary">******</div>
								</div>
								<hr>
							</div>
						</div>
					</div>


					<%-- <div class="col-md-8">
						<div class="form-horizontal">

							<div class="row">
								<div class="form-group col-2">
									<label>ID</label>
									<div class="form-group">
										<input class="form-control" type="text" name="id" id="id"
											value="${getUserEdit._id }" readonly="readonly">
									</div>
								</div>
								<div class="form-group col-5">
									<label>Tên</label>
									<div class="form-group">
										<input class="form-control" type="text" name="firstname"
											id="firstname" value="${getUserEdit.firstname }"
											required="required">
									</div>
								</div>

								<div class="form-group col-5">
									<label>Họ</label>
									<div class="form-group">
										<input class="form-control" type="text" name="lastname"
											id="lastname" value="${getUserEdit.lastname }"
											required="required">
									</div>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="form-group col-6">
									<label>Số điện thoại</label>
									<div class="form-group">
										<input class="form-control" type="text" name="phone"
											id="phone" value="${getUserEdit.phone }" required="required">
									</div>
								</div>

								<div class="form-group col-6">
									<label>Email</label>
									<div class="form-group">
										<input class="form-control" type="email" name="email"
											id="email" value="${getUserEdit.email }" readonly="readonly">
									</div>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="form-group col-4">
									<label>Địa chỉ</label>
									<div class="">
										<input class="form-control" type="text" name="addresses"
											id="addresses" value="${getUserEdit.addresses }"
											required="required">
									</div>
								</div>
							</div>
						</div>
					</div> --%>
					<!-- 				</form> -->
				</div>

			</div>
		</div>
	</form>
	<!-- end content -->

	<!-- Footer -->
	<c:choose>
		<c:when test="${getUserEdit._role == 1}"><%@ include
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
