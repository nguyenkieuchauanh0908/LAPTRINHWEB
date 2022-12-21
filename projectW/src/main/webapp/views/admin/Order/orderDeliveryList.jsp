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
											<b>Quản lý đơn hàng</b>
										</h2>
									</div>
								</div>
							</div>
							<div>
								<form action="" method="get" style="float: right;">
									<div class="input-group" style="padding-top: 0px;">
										<c:if test="${sessionScope.role == 0}">
											<!-- Nếu là admin thì mới cho thêm sản phẩm -->
											<a href="orderProcessingList"
												style="float: left; background-color: #63d9f1; border: none; text-align: center;border-radius: 0px;"
												class="btn btn-info"> Cần xử lý </a>
										</c:if>
										<c:if test="${sessionScope.role == 0}">
											<!-- Nếu là admin thì mới cho thêm sản phẩm -->
											<a href="orderDeliveryList"
												style="float: left; background-color: #63d9f1; border: none; text-align: center;"
												class="btn btn-info"> Đang giao hàng </a>
										</c:if>
										<c:if test="${sessionScope.role == 0}">
											<!-- Nếu là admin thì mới cho thêm sản phẩm -->
											<a href="orderSuccessList"
												style="float: left; background-color: #63d9f1; border: none; text-align: center; "
												class="btn btn-info"> Thành công </a>
										</c:if>
										<c:if test="${sessionScope.role == 0}">
											<!-- Nếu là admin thì mới cho thêm sản phẩm -->
											<a href="orderCancelList"
												style="float: left; background-color: #63d9f1; border: none; text-align: center;"
												class="btn btn-info"> Bị hủy </a>
										</c:if>
										<c:if test="${sessionScope.role == 0}">
											<!-- Nếu là admin thì mới cho thêm sản phẩm -->
											<a href="orderList"
												style="float: left;margin-right:400px; background-color: #63d9f1; border: none; text-align: center;"
												class="btn btn-info"> Toàn bộ </a>
										</c:if>
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
									</div>
								</form>
							</div>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th style="width: 100px">Mã đơn</th>
										<th style="width: 150px">Mã KH</th>
										<th style="width: 900px">Trạng thái</th>
										<th style="margin-right: 30px">Chi tiết</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orderList}" var="order">
										<tr>
											<td>${order._id}</td>
											<td>${order.userId}</td>
											<td>${order.status}</td>
											<td><button class="btn btn-info"
													onclick="loadVendorOrderdetail(${order._id})">Xem</button></td>
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
												href="${pageContext.request.contextPath}/orderDeliveryList?index=${tag-1}">Previous</a></li>
										</c:if>
										<c:forEach begin="1" end="${CountPa}" var="i">
											<c:if test="${i==tag}">
												<li class="page-item active"><a class="page-link"
													href="#">${i} <span class="sr-only">(current)</span>
												</a></li>
											</c:if>
											<c:if test="${i!=tag}">
												<li class="page-item"><a class="page-link"
													href="${pageContext.request.contextPath}/orderDeliveryList?index=${i}">${i}</a></li>
											</c:if>
										</c:forEach>
										<c:if test="${tag == CountPa}">
											<li class="page-item disabled"><a class="page-link"
												href="#">Next</a></li>
										</c:if>
										<c:if test="${tag < CountPa}">
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}/orderDeliveryList?index=${tag+1}">Next</a></li>
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