<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<title>MEIMEI</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/synaptic/1.0.6/bundle.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="container-fluid" id="content">
		<div class="row min-vh-100 flex-column flex-md-row">
			<div class="col-12 col-md-3 col-xl-2 p-0 bg-dark ">
				<nav
					class="navbar navbar-expand-md navbar-dark bd-dark flex-md-column flex-row align-items-center py-2 sticky-top "
					id="sidebar">
					<div class="text-center" style="color: white">
						<h2>Trang quản lý cửa hàng </h2>
					</div>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#nav"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse order-last" id="nav">
						<ul class="navbar-nav flex-column w-100 justify-content-center">
							<li class="nav-item"><a href=""
								class="nav-link pt-3 pb-3 ps-5 pe-5"> Trang chủ </a></li>
							<c:set var="status1" value="Đã giao"/>
							<li class="nav-item"><a href="${pageContext.request.contextPath}/Vendor?status=${status1}"
								class="nav-link pt-3 pb-3 ps-5 pe-5"> Đã bán </a></li>
							<c:set var="status2" value="Cần xử lý"/>
							<li class="nav-item"><a href="${pageContext.request.contextPath}/Vendor?status=${status2}"
								class="nav-link pt-3 pb-3 ps-5 pe-5"> Cần xử lý </a></li>
								<c:set var="status3" value="Đang giao hàng"/>
							<li class="nav-item"><a href="${pageContext.request.contextPath}/Vendor?status=${status3}"
								class="nav-link pt-3 pb-3 ps-5 pe-5"> Đang giao hàng </a></li>
							<c:set var="status4" value="Đã hủy"/>
							<li class="nav-item"><a href="${pageContext.request.contextPath}/Vendor?status=${status4}"
								class="nav-link pt-3 pb-3 ps-5 pe-5"> Bị hủy </a></li>
						</ul>
					</div>
				</nav>
			</div>
			<div class="container-fluid col-12 col-md-9 col-xl-10">
				<section id="table">
					<div class="container">
						<div class="table-wrapper">
							<div class="table-title">
								<div class="row">
									<div class="col-sm-6">
										<h2>
											<b>Đơn hàng cần xử lý</b>
										</h2>
									</div>
								</div>
							</div>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th style="width: 100px">Mã đơn hàng</th>
										<th style="width: 150px">Tên khách hàng</th>
										<th>Ngày đặt hàng</th>
										<th>Ngày xác nhận</th>
										<th>Ngày giao dự kiến</th>
										<th>Trạng thái</th>
										<th>Chức năng</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items = "${orderlist}" var = "order" >
								<tr>
										<td>${order._id }</td>
										<td>${order.user.lastname} ${order.user.firstname}</td>
										<td>${order.createdAt}</td>
										<td>111</td>
										<td>2222</td>
										<td>
											<p>${order.status}</p>
										</td>
										<td><button class="btn btn-info" onclick="loadVendorOrderdetail(${order._id})">Xem</button></td>
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
	
	<script src ="../Buider/js/vendor.js" type="text/javascript"></script>
</body>