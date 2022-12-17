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
<style>
.rating {
	display: flex;
	flex-direction: row-reverse;
	justify-content: center;
}

.rating>input {
	display: none;
}

.rating>label {
	position: relative;
	width: 1em;
	font-size: 6vw;
	color: #FFD600;
	cursor: pointer;
}

.rating>label::before {
	content: "\2605";
	position: absolute;
	opacity: 0;
}

.rating>label:hover:before, .rating>label:hover ~ label:before {
	opacity: 1 !important;
}

.rating>input:checked ~ label:before {
	opacity: 1;
}

.rating:hover>input:checked ~ label:before {
	opacity: 0.4;
}
</style>
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
						<li class="breadcrumb-item active" aria-current="page">${getPro.name }</li>
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
							class="img-fluid"
							src="${pageContext.request.contextPath}/${getPro.image}"
							width="800" height="800" />
						</a>
					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<h2 class="card-title">${getPro.name }</h2>
						<p>
							Tình trạng:
							<c:if test="${getPro.quantity > 0 }">Còn hàng</c:if>
							<c:if test="${getPro.quantity == 0 }">Hết hàng</c:if>
							<c:if test="${getPro.quantity < 0 }">Hết hàng</c:if>
						</p>
						<br />
						<p class="btn btn-danger btn-block">${getPro.price }đồng</p>
						<form method="post" action="cartadd">
							<input hidden value="${getPro._id }" name="productId" />
							<div class="form-group">
								<label>Số lượng :</label>
								<div class="input-group mb-3">

									<input type="number" class="form-control text-center"
										id="quantity" name="quantity" min="1" max=${getPro.quantity }
										value="1" step="1">

								</div>
							</div>
							<button type="submit"
								class="btn btn-success btn-lg btn-block text-uppercase">
								<i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
							</button>

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

			<!-- Reviews         -->
			<div class="col-12" id="reviews">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-comment"></i> Đánh giá
					</div>
					<div class="card-body">
						<c:forEach items="${listReview }" var="review">
							<div class="review">
								<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
								${review.createdAt}
								<c:forEach begin="1" end="${review.stars}" var="s">
									<span class="fa fa-star"></span> 
								</c:forEach>
								by ${review.user.firstname} ${review.user.lastname}
								<p class="blockquote">
								<p class="mb-0">${review.content }</p>
							</div>
							<hr>

						</c:forEach>
					</div>
					<hr>
					<c:if test="${sessionScope.uId != null}">
						<div class="col-md-12">
							<form accept-charset="UTF-8" action="productDetail" method="post">
								<input hidden name="pid" value="${getPro._id }">
								<textarea class="form-control animated" cols="50"
									id="new-review" name="comment"
									placeholder="Nhập đánh giá của bạn..." rows="5"></textarea>
								<div class="rating">

									<input type="radio" name="rating" value="5" id="5"><label
										for="5">☆</label> <input type="radio" name="rating" value="4"
										id="4"><label for="4">☆</label> <input type="radio"
										name="rating" value="3" id="3"><label for="3">☆</label>
									<input type="radio" name="rating" value="2" id="2"><label
										for="2">☆</label> <input type="radio" name="rating" value="1"
										id="1"><label for="1">☆</label>
								</div>
								<div class="text-right">

									<button class="btn btn-success btn-lg" type="submit">Save</button>
								</div>
							</form>
						</div>
					</c:if>
					<c:if test="${sessionScope.uId == null}">
						<p>Đăng nhập và để lại đánh giá cho sản phẩm</p>
					</c:if>
				</div>
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
