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
			<div class="col-12 col-md-3 col-xl-2 p-0 bg-dark ">
				<nav
					class="navbar navbar-expand-md navbar-dark bd-dark flex-md-column flex-row align-items-center py-2 sticky-top "
					id="sidebar">
					<div class="text-center" style="color: white">
						<h2 style="margin-top:25px;">Trang Admin </h2>
					</div>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#nav"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse order-last" id="nav">
						<ul class="navbar-nav flex-column w-100 justify-content-center">
						<li class="nav-item"><a href=""
								class="nav-link pt-3 pb-3 ps-5 pe-5">Trang chủ</a></li>
								<li class="nav-item"><a href="userList"
								class="nav-link pt-3 pb-3 ps-5 pe-5">Khách hàng</a></li>
								<li class="nav-item"><a href="employeeList"
								class="nav-link pt-3 pb-3 ps-5 pe-5">Nhân viên</a></li>
								<li class="nav-item"><a href="productList"
								class="nav-link pt-3 pb-3 ps-5 pe-5">Sản phẩm</a></li>
								<li class="nav-item"><a href="categoryList"
								class="nav-link pt-3 pb-3 ps-5 pe-5">Loại sản phẩm</a></li>
								<li class="nav-item"><a href="orderList"
								class="nav-link pt-3 pb-3 ps-5 pe-5">Đơn hàng</a></li>
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
										<h2 style="margin-top:30px;">
											<b>Quản lý loại sản phẩm</b>
										</h2>
									</div>
								</div>
							</div>
							<a href="categoryAdd">							
							<button style = "float:right;margin-right:30px;margin-top:-10px;background-color: #FF6347;border: none;text-align:center;padding:5px 10px;" class="btn btn-info"><h6>Thêm</h6></button>
							</a>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th style="width: 300px">Mã loại</th>
										<th style="width: 830px">Loại sản phẩm</th>
										<th>Sửa</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items = "${categoryList}" var = "category" >
								<tr>
										<td>${category._id}</td>
										<td>${category._name}</td>
										<td>
											<a href="categoryUpdate?cid=${category._id}">
											<button class="btn btn-info">Sửa</button>
											</a>
										</td>
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