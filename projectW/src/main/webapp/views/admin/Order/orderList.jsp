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
											<b>Quản lý đơn hàng</b>
										</h2>
									</div>
								</div>
							</div>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th style="width: 100px">Mã đơn</th>
										<th style="width: 150px">Mã khách hàng</th>
										<th style="width: 900px">Trạng thái</th>
										<th style="margin-right: 30px">Chi tiết</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items = "${orderList}" var = "order" >
								<tr>
										<td>${order._id}</td>
										<td>${order.userId}</td>
										<td>${order.status}</td>
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
	
	<script src ="./Builder/js/vendor.js" type="text/javascript"></script>
</body>