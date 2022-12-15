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
<title>Trang chủ</title>
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

	<!-- header -->
	<%@ include file="/views/shared/header.jsp"%>
	<!-- end header -->

	<!-- content -->
	<div class="container">
		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Sản phẩm</span>
					<!--<span
						class="badge badge-secondary badge-pill">3</span>-->
				</h4>
				<ul class="list-group mb-3 sticky-top">
					<c:forEach items="${getAllCartItem }" var="cI">
						<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">${cI.product.name}</h6>
								<small class="text-muted">Số lượng: ${cI.count_SP}</small>
							</div> <span class="text-muted">${cI.product.price * cI.count_SP}</span>
						</li>
					</c:forEach>
					<li class="list-group-item d-flex justify-content-between"><c:set
							var="total" value="${0}" /> <c:forEach
							items="${getAllCartItem }" var="cI">
							<c:set var="total"
								value="${total + cI.count_SP * cI.product.price}" />
						</c:forEach> <span>Tổng: </span> <strong>${total } đồng</strong></li>
				</ul>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Thanh toán</h4>
				<form class="needs-validation mb-5" action="order" method="get">
					<div class="mb-3">
						<label for="phone">Số điện thoại</label> <input type="text"
							class="form-control" name="phone" id="phone" value="${infoUser.phone}"
							required="required" />
						<div class="invalid-feedback">Please enter a valid email
							address for shipping updates.</div>
					</div>
					<div class="mb-3">
						<label for="address">Địa chỉ</label> <input type="text"
							class="form-control" name="address" id="address" value="${infoUser.addresses}"
							required="required">
						<div class="invalid-feedback">Please enter your shipping
							address.</div>
					</div>
					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Đặt
						hàng</button>
				</form>
			</div>
		</div>
	</div>
	<!-- end content -->

	<!-- Footer -->
	<%@ include file="/views/shared/footer.jsp"%>
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
