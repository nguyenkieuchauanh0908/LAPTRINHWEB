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
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/images/banner/ico_1.ico">
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
	<div class="item mb-3"
		style="box-shadow: 0px 0px 11px 1px rgb(0 0 0/ 10%)">
		<img class="d-block w-100"
			src="${pageContext.request.contextPath}/images/banner/banner_1.jpg"
			width="1535" height="365" alt="">
	</div>
	<!-- content -->

	<div class="container">
		<div class="row">
			<div class="col">
				<div id="carouselExampleIndicators" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100"
								src="${pageContext.request.contextPath}/images/banner/banner_2.jpg"
								width="855" height="365" alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="${pageContext.request.contextPath}/images/banner/banner_3.jpg"
								width="855" height="365" alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="${pageContext.request.contextPath}/images/banner/banner_4.png"
								width="855" height="365" alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-12 col-md-3">
				<div class="card">
					<div class="card-header bg-success text-white text-uppercase">
						<i class="fa fa-heart"></i> Bán chạy nhất
					</div>
					<img class="card-img-top"
						src="${pageContext.request.contextPath}/${list1product.image}"
						style="width: 250px; height: 150px;" alt="Card image cap">
					<div class="card-body">
						<h4 class="card-title text-center"${tagactive==list1product._id ? "active":""}">
							<a style="
									overflow: hidden; 
									text-overflow: ellipsis; 
									-webkit-line-clamp: 2; 
									-webkit-box-orient: vertical; 
									display: -webkit-box; 
									height: 60px"
							 	href="productDetail?pid=${list1product._id}"
								title="View Product">${list1product.name}
							</a>
						</h4>
						<div class="row">
							<div class="col">
								<p class="btn btn-danger btn-block">${list1product.price}
									đồng</p>
							</div>
							<div class="col"${tagactive==list1product._id ? "active":""}">
								<a href="productDetail?pid=${list1product._id}"
									class="btn btn-success btn-block">Xem</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container mt-3">
		<div class="row">
			<div class="col-sm">
				<div class="card">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-star"></i> Bán chạy
					</div>
					<div class="card-body">
						<div class="row">
							<c:forEach items="${list4product}" var="p">
								<div class="col-sm">
									<div class="card">
										<img class="card-img-top"
											src="${pageContext.request.contextPath}/${p.image}"
											width="200" height="200" alt="Card image cap">
										<div class="card-body"${tagactive==p._id ? "active":""}">
											<h4 class="card-title">
												<a
													style="overflow: hidden; text-overflow: ellipsis; -webkit-line-clamp: 2; -webkit-box-orient: vertical; display: -webkit-box; height: 60px;"
													href="productDetail?pid=${p._id}" title="View Product">${p.name}</a>
											</h4>
											<div class="row">
												<div class="col">
													<p class="btn btn-danger btn-block">${p.price}đồng</p>
												</div>
												<div class="col">
													<c:if test="${sessionScope.uId != null}">
														<a href="cartadd?pid=${p._id}"
															class="btn btn-success btn-block">Thêm vào giỏ hàng</a>
													</c:if>
													<c:if test="${sessionScope.uId == null}">
														<a href="login" class="btn btn-success btn-block">Thêm
															vào giỏ hàng</a>
													</c:if>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container mt-3 mb-4">
		<div class="col-sm">
			<div class="card">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-star"></i> Mới nhất
				</div>
				<div class="card-body">
					<div class="row">
						<c:forEach items="${list4last}" var="p">
							<div class="col-sm">
								<div class="card">
									<img class="card-img-top"
										src="${pageContext.request.contextPath}/${p.image}" width="200" height="200" 
										alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title"${tagactive==p._id ? "active":""}">
											<a style="
												overflow: hidden; 
												text-overflow: ellipsis; 
												-webkit-line-clamp: 2; 
												-webkit-box-orient: vertical; 
												display: -webkit-box; 
												height: 60px"
												href="productDetail?pid=${p._id}" title="View Product">${p.name}</a>
										</h4>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${p.price}đồng</p>
											</div>
											<div class="col">
												<c:if test="${sessionScope.uId != null}">
													<a href="cartadd?pid=${p._id}"
														class="btn btn-success btn-block">Thêm vào giỏ hàng</a>
												</c:if>
												<c:if test="${sessionScope.uId == null}">
													<a href="login" class="btn btn-success btn-block">Thêm
														vào giỏ hàng</a>
												</c:if>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
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
