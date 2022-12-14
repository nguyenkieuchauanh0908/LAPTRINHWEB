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
											<b>Quản lý loại sản phẩm</b>
										</h2>
									</div>
								</div>
							</div>
							<div>
								<form action="searchCategoryAdmin" method="get"
									style="float: right;">
									<div class="input-group" style="padding-top: 0px;">
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
										<a href="categoryAdd"
											style="float: right; background-color: #FF6347; border: none; text-align: center; border-radius: 6px;"
											class="btn btn-info"> Thêm </a>
									</div>
								</form>
							</div>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th style="width: 300px">Mã loại</th>
										<th style="width: 830px">Loại sản phẩm</th>
										<th>Sửa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${categoryList}" var="category">
										<tr>
											<td><div class="py-3">${category._id}</div></td>
											<td><div class="py-3">${category._name}</div></td>
											<td><div class="py-3"><a href="categoryUpdate?cid=${category._id}">
													<button class="btn btn-info">Sửa</button>
											</a></div></td>
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
												href="${pageContext.request.contextPath}/categoryList?index=${tag-1}">Previous</a></li>
										</c:if>
										<c:forEach begin="1" end="${CountPa}" var="i">
											<c:if test="${i==tag}">
												<li class="page-item active"><a class="page-link"
													href="#">${i} <span class="sr-only">(current)</span>
												</a></li>
											</c:if>
											<c:if test="${i!=tag}">
												<li class="page-item"><a class="page-link"
													href="${pageContext.request.contextPath}/categoryList?index=${i}">${i}</a></li>
											</c:if>
										</c:forEach>
										<c:if test="${tag == CountPa}">
											<li class="page-item disabled"><a class="page-link"
												href="#">Next</a></li>
										</c:if>
										<c:if test="${tag < CountPa}">
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}/categoryList?index=${tag+1}">Next</a></li>
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