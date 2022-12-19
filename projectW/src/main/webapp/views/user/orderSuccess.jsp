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
<title>Thông tin đặt hàng</title>
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">
<!-- CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
	<h1 style="text-align: center; margin: 16px 0">ĐẶT HÀNG THÀNH CÔNG</h1>
	<hr />
	<div class="row d-flex justify-content-center"
		style="margin-bottom: 12px">
		<div class="mx-4 col-8" style="border: 2px solid #cccccc">
			<h5 style="font-weight: 500; margin-bottom: 16px;">
				Mã đơn hàng: <strong>#${order._id}</strong>
			</h5>
			<div class="row">
				<div class="col-3">
					<h6>Ngày đặt đơn</h6>
				</div>
				<div class="col-3">
					<h6>Tổng tiền</h6>
				</div>
				<div class="col-3">
					<h6>Trạng thái</h6>
				</div>
				<div class="col-3">
					<h6>Ngày giao dự kiến</h6>
				</div>
			</div>
			<div class="row">
				<div class="col-3">
					<p>${order.createdAt}</p>
				</div>
				<div class="col-3">
					<p>
						<c:set var="total" value="${0}" />
						<c:forEach items="${orderItems}" var="Items">
							<c:set var="total"
								value="${total + Items.count_SP * Items.product.price}" />
						</c:forEach>
						${total } đồng
					</p>
				</div>
				<div class="col-3">
					<c:if test="${order.status == 'Cần xử lý' }">
						<p>Chờ xác nhận</p>
					</c:if>
					<c:if test="${order.status == 'Đã bán' }">
						<p>Giao hàng thành công</p>
					</c:if>
					<c:if test="${order.status != 'Cần xử lý' && order.status !='Đã bán' }">
						<p>${order.status}</p>
					</c:if>
				</div>
				<div class="col-3">
					<p>${order.deliveryAt}</p>
				</div>
			</div>
			<h6>Chi tiết đơn hàng</h6>
			<c:forEach items="${orderItems}" var="Items">
				<div class="row">
					<div class="tabe-responsive text-nowrap">
						<table class="table table-striped">
							<thead>
								<tr>
									<th></th>
									<th>Tên sản phẩm</th>
									<th>Đơn giá</th>
									<th>Số lượng</th>
									<th>Tổng</th>
								</tr>
							</thead>
							<tbody>
								<td><img
									src="${pageContext.request.contextPath}/${Items.product.image}"
									width="50" height="50" /></td>
								<td class="card-title">${Items.product.name }</td>
								<td class="card-text">${Items.product.price }</td>
								<td class="card-text">${Items.count_SP }</td>
								<td class="card-text">${Items.count_SP * Items.product.price }</td>
							</tbody>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="row d-flex justify-content-center"
		style="margin-bottom: 12px">
		<div class="mx-4 col-8">
			<div class="row">
				<div class="col-sm-12  col-md-6">
					<a class="btn btn-block btn-primary" href="welcome">Tiếp tục mua
						hàng</a>
				</div>
				<div class="col-sm-12 col-md-6 text-right">
					<a class="btn btn-block btn-success"
						href="myorder">Lịch sử đơn hàng</a>
				</div>
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
