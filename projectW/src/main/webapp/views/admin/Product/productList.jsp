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
			<c:choose>
				<c:when test="${sessionScope.role == 0}">
					<!-- Nếu là admin -->
					<!-- menu bar -->
					<%@ include file="/views/admin/menuAdmin.jsp"%>
					<!-- end menu bar -->
				</c:when>
				<c:otherwise>
					<!-- menu bar -->
					<%@ include file="/views/vendor/vendor_left.jsp"%>
					<!-- end menu bar -->
				</c:otherwise>
			</c:choose>
			<div class="container-fluid col-12 col-md-9 col-xl-10">
				<section id="table">
					<div class="container">
						<div class="table-wrapper">
							<div class="table-title">
								<div class="row">
									<div class="col-sm-6">
										<h2 style="margin-top: 30px;">
											<b>Quản lý sản phẩm</b>
										</h2>
									</div>
								</div>
							</div>
							<div></div>
							<div>
								<form action="searchProductAdmin" method="get"
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
										<c:if test="${sessionScope.role == 0}">
											<!-- Nếu là admin thì mới cho thêm sản phẩm -->
											<a href="productAdd"
												style="float: right; background-color: #FF6347; border: none; text-align: center; border-radius: 6px;"
												class="btn btn-info"> Thêm </a>
										</c:if>
									</div>
								</form>
							</div>
							<table class="table table-striped table-hover" style="top: 20px;">
								<thead>
									<tr>
										<th style="width: 100px;">Mã SP</th>
										<th style="width: 20px">Hình</th>
										<th style="width: 200px">Tên sản phẩm</th>
										<th style="width: 200px">Gía bán</th>
										<th style="width: 200px">Đã bán</th>
										<th style="width: 300px">Loại sản phẩm</th>
										<th style="width: 300px"><c:choose>
												<c:when test="${sessionScope.role == 0}">
													<!-- Nếu là admin -->
													Trạng thái SP
												</c:when>
												<c:when test="${sessionScope.role == 2}">
													<!-- Nếu là vendor -->
													Số lượng
												</c:when>
											</c:choose></th>
										<th style="width: 400px">Trạng thái kinh doanh</th>
										<th>Sửa</th>
										<c:if test="${sessionScope.role == 0}">
											<!-- Nếu là admin thì mới cột xóa sản phẩm -->
											<th>Xóa</th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${producList}" var="product">
										<tr>
											<td><div class="py-3">${product._id}</div></td>
											<td>
												<div class="py-3">
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/${product.image}"
														width="20" height="20" alt="Card image cap">
												</div>
											</td>
											<td>
												<div class="py-3">${product.name}</div>
											</td>
											<td>
												<div class="py-3">${product.price}</div>
											</td>
											<td>
												<div class="py-3">${product.sold}</div>
											</td>
											<td class="center"><div class="py-3">
<<<<<<< HEAD
													<c:forEach items="${listcate }" var="c">
														<c:if test="${product.categoryId == c._id}">
															<div class="py-3">${c._name}</div>
														</c:if>
													</c:forEach>
													<%-- <c:choose>
													<c:when test="${product.categoryId == 1 }">Sách giáo khoa
=======
													<c:choose>
														<c:when test="${product.categoryId == 1 }">Sách giáo khoa
>>>>>>> main
													</c:when>
														<c:when test="${product.categoryId  == 2 }">Truyện tranh
													</c:when>
														<c:when test="${product.categoryId  == 3}">Tiểu thuyết
													</c:when>
														<c:when test="${product.categoryId == 4 }">Sách tham khảo
													</c:when>
														<c:when test="${product.categoryId  == 5}">Vở ô ly
													</c:when>
														<c:when test="${product.categoryId  == 6}">Vở kẻ ngang
													</c:when>
														<c:when test="${product.categoryId  == 7}">Sổ các loại
													</c:when>
														<c:when test="${product.categoryId  == 8}">Cặp càng cua
													</c:when>
														<c:when test="${product.categoryId  == 9}">Cặp trình ký
													</c:when>
														<c:when test="${product.categoryId  == 10}">Giấy in - photo
													</c:when>
														<c:when test="${product.categoryId  == 11}">Túi đựng tài liệu
													</c:when>
														<c:when test="${product.categoryId  == 12}">Bút bi
													</c:when>
														<c:when test="${product.categoryId  == 13}">Bút chì
													</c:when>
														<c:when test="${product.categoryId  == 14}">Bút máy
													</c:when>
														<c:when test="${product.categoryId  == 15}">Dụng cụ học sinh
													</c:when>
														<c:when test="${product.categoryId  == 16}">Ba lô - Túi - Cặp
													</c:when>
														<c:when test="${product.categoryId  == 17}">Bảng - Bàn học 
													</c:when>
														<c:when test="${product.categoryId  == 18}">Kệ sách, vở 
													</c:when>

														<c:otherwise>Khác
													</c:otherwise>
<<<<<<< HEAD
												</c:choose></div> --%></td>
=======
													</c:choose>
												</div></td>
>>>>>>> main
											<td class="center"><div class="py-3">
													<c:choose>
														<c:when test="${sessionScope.role == 0}">
															<!-- Nếu là admin -->
															<c:if test="${product.quantity > 0}">Còn hàng
														</c:if>
															<c:if test="${product.quantity <= 0}">Hết hàng
														</c:if>
														</c:when>
														<c:otherwise>
															<!-- Nếu là vendor -->
													${product.quantity}
													</c:otherwise>
													</c:choose>
												</div></td>
											<td class="center"><div class="py-3">
													<c:choose>
														<c:when test="${product.isDeleted eq false}">Đang kinh doanh
													</c:when>
														<c:otherwise>Ngưng bán
													</c:otherwise>
													</c:choose>
												</div></td>
											<td><div class="py-3">
													<a href="productUpdate?pid=${product._id}">
														<button class="btn btn-info">Sửa</button>
													</a>
												</div></td>
											<c:if test="${sessionScope.role == 0}">
												<!-- Nếu là admin thì mới cột xóa sản phẩm -->
												<td>
													<div class="py-3">
														<form
															onsubmit="return confirm('Bạn có chắc muốn xóa sản phẩm này?');"
															action="${pageContext.request.contextPath}/productDelete"
															method="post">
															<input type="hidden" name="pid" value="${product._id}">
															<button type="submit" class="btn btn-info">Xóa</button>
														</form>
													</div>
												</td>
											</c:if>

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
												href="${pageContext.request.contextPath}/productList?index=${tag-1}">Previous</a></li>
										</c:if>
										<c:forEach begin="1" end="${CountPa}" var="i">
											<c:if test="${i==tag}">
												<li class="page-item active"><a class="page-link"
													href="#">${i} <span class="sr-only">(current)</span>
												</a></li>
											</c:if>
											<c:if test="${i!=tag}">
												<li class="page-item"><a class="page-link"
													href="${pageContext.request.contextPath}/productList?index=${i}">${i}</a></li>
											</c:if>
										</c:forEach>
										<c:if test="${tag == CountPa}">
											<li class="page-item disabled"><a class="page-link"
												href="#">Next</a></li>
										</c:if>
										<c:if test="${tag < CountPa}">
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}/productList?index=${tag+1}">Next</a></li>
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