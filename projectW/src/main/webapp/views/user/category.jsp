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
<title>Danh mục</title>
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
						<li class="breadcrumb-item">Danh mục</li>
						<li class="breadcrumb-item active" aria-current="page">${cate._name}</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12 col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Danh mục
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${listcate}" var="c">
							<li class="list-group-item"${tagactive==c._id ? "active":""}"><a
								href="category?cid=${c._id}">${c._name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col">
				<div class="row">
					<c:forEach items="${listprobycate}" var="p">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card">
								<img class="card-img-top"
									src="${pageContext.request.contextPath}${p.image}" width="200" height="200"
									alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title" ${tagactive==p._id ? "active":""}">
										<a href="productDetail?pid=${p._id}" title="View Product">${p.name }</a>
									</h4>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${p.price } đồng</p>
										</div>
										<div class="col">
											<a href="#" class="btn btn-success btn-block">Thêm vào giỏ hàng</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="col-12">
					<nav aria-label="...">
						<ul class="pagination">
							<c:if test="${tag == 1}">
								<li class="page-item disabled"><a class="page-link"
									href="#" tabindex="-1">Previous</a></li>
							</c:if>
							<c:if test="${tag > 1}">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/products?index=${tag-1}">Previous</a></li>
							</c:if>
							<c:forEach begin="1" end="${CountPa}" var="i">
								<c:if test="${i==tag}">
									<li class="page-item active"><a class="page-link" href="#">${i}
											<span class="sr-only">(current)</span>
									</a></li>
								</c:if>
								<c:if test="${i!=tag}">
									<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/products?index=${i}">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${tag == CountPa}">
								<li class="page-item disabled"><a class="page-link"
									href="#">Next</a></li>
							</c:if>
							<c:if test="${tag < CountPa}">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/products?index=${tag+1}">Next</a></li>
							</c:if>
						</ul>
					</nav>
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
