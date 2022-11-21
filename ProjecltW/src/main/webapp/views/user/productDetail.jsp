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
<title>Sản phẩm</title>
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
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="welcome">Trang chủ</a></li>
						<li class="breadcrumb-item"><a href="products">Sản phẩm</a></li>
						<li class="breadcrumb-item active" aria-current="page">${getPro.productname }</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<!-- Image -->
			<div class="col-12 col-lg-6">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<a href="" data-toggle="modal" data-target="#productModal"> <img
							class="img-fluid" src="https://dummyimage.com/800x800/55595c/fff" />
						</a>
					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<h4 class="card-title">${getPro.productname }</h4>
						<p>Tình trạng: ${Status}</p>
						<br />
						<p class="btn btn-danger btn-block">${getPro.price }đồng</p>
						<form method="get" action="cart.html">
							<div class="form-group">
								<label>Số lượng :</label>
								<div class="input-group mb-3">

									<input type="number" class="form-control text-center"
										id="quantity" name="quantity" min="1" max=${inven.quantity } value="1"
										step="1">

								</div>
							</div>
							<a href="cart.html"
								class="btn btn-success btn-lg btn-block text-uppercase"> <i
								class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
							</a>
						</form>
						<!-- 
						<div class="product_rassurance">
							<ul class="list-inline">
								<li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br />Fast
									delivery</li>
								<li class="list-inline-item"><i
									class="fa fa-credit-card fa-2x"></i><br />Secure payment</li>
								<li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br />+33
									1 22 54 65 60</li>
							</ul>
						</div>
						<div class="reviews_product p-3 mb-2 ">
							3 reviews <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> (4/5) <a class="pull-right"
								href="#reviews">View all reviews</a>
						</div>
						<div class="datasheet p-3 mb-2 bg-info text-white">
							<a href="" class="text-white"><i class="fa fa-file-text"></i>
								Download DataSheet</a>
						</div>
						 -->
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- Description -->
			<div class="col-12">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-align-justify"></i> Mô tả
					</div>
					<div class="card-body">
						<p class="card-text">${getPro.description }</p>
					</div>
				</div>
			</div>

			<!-- Reviews 
			<div class="col-12" id="reviews">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-comment"></i> Đánh giá
					</div>
					<div class="card-body">
						<div class="review">
							<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
							<meta itemprop="datePublished" content="01-01-2016">
							January 01, 2018 <span class="fa fa-star"></span> <span
								class="fa fa-star"></span> <span class="fa fa-star"></span> <span
								class="fa fa-star"></span> <span class="fa fa-star"></span> by
							Paul Smith
							<p class="blockquote">
								<p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                        </p>
                        <hr>
                    </div>
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar"
								aria-hidden="true"></span>
                        <meta itemprop="datePublished"
								content="01-01-2016">January 01, 2018

                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        by Paul Smith
                        <p class="blockquote">
                            
							<p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                        </p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
        -->
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
