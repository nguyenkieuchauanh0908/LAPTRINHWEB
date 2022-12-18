<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/web/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Nhân viên bán hàng</title>

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
			<%@ include file="/views/vendor/vendor_left.jsp"%>
			<div class="container-fluid col-12 col-md-9 col-xl-10">
				<section id="table">
					<div class="container">
						<div class="table-wrapper">
							<div class="table-title">
								<div class="row">
									<div class="col-sm-6">
										<h2>
											<b>${statusName }</b>
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
									<c:forEach items="${orderlist}" var="order">
										<tr>
											<td>${order._id }</td>
											<td>${order.user.lastname} ${order.user.firstname}</td>
											<td>${order.createdAt}</td>
											<td>${order.updatedAt}</td>
											<td>${order.deliveryAt}</td>
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
				<div class="panel panel-footer text-center slick">
					<nav aria-label="Page navigation example ">
						<div class="product_indicators" style="text-align: center">
							<c:if test="${tag>1}">
								<button class="prev"
									onclick="location.href='${pageContext.request.contextPath }/Vendor?index=${tag-6}&status=${statusOrder}'">&#10094;</button>
							</c:if>
							<c:forEach begin="1" end="${endP}" var="i">
								<button id='slick-dot'
									class='${tag==(6*(i-1)+1)?"active_product":"" } '
									onclick="location.href='${pageContext.request.contextPath}/Vendor?index=${6*(i-1)+1}&status=${statusOrder}'">${i}</button>

							</c:forEach>
							<c:if test="${((tag-1)/6+1)<endP}">
								<button class="next"
									onclick="location.href='${pageContext.request.contextPath}/Vendor?index=${tag+6}&status=${statusOrder}'">&#10095;</button>
							</c:if>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<script src="./Builder/js/vendor.js" type="text/javascript"></script>
</body>