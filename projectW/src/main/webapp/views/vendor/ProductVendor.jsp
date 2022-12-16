<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/web/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>MEIMEI</title>

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
	<div class="container-fluid col-12 col-md-9 col-xl-10">
		<section id="table">
			<div class="container">
				<div class="table-wrapper">
					<div class="table-title">
						<div class="row">
							<div class="col-sm-6">
								<h2>
									<b>Quản lý sản phẩm</b>
								</h2>
							</div>
						</div>
					</div>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th style="width: 100px">Mã sản phẩm</th>
								<th style="width: 150px">Tên sản phẩm</th>
								<th>Mô tả sản phẩm</th>
								<th>Giá bán</th>
								<th>Số lưọng</th>
								<th>Ngày tạo</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${orderlist}" var="order">
								<tr>
									<td>${order._id }</td>
									<td>${order.user.lastname}${order.user.firstname}</td>
									<td>${order.createdAt}</td>
									<td>111</td>
									<td>2222</td>
									<td>
										<p>${order.status}</p>
									</td>
									<td><button class="btn btn-info"
											onclick="loadVendorOrderdetail(${order._id})">Xem</button></td>
								</tr>
							</c:forEach>


						</tbody>

					</table>
					<div class="clearfix"></div>
				</div>
			</div>
		</section>
	</div>


	<script src="./Builder/js/vendor.js" type="text/javascript"></script>
</body>