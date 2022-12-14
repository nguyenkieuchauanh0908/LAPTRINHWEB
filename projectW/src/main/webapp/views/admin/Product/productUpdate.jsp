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
				<h2 style="margin-top: 30px; margin-left: 60px;">
					<b>Cập nhật thông tin sản phẩm</b>
				</h2>
				<div class="row">
					<div class="col-md-11">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="" style="padding: 70px; margin-top: -50px;">
										<form method="post" action="productUpdate"
											enctype=multipart/form-data>
											<div class="form-group">
												<label>Tên sản phẩm</label> <input style="margin-top: 15px;"
													class="form-control" name="pname" type="text"
													value="${product.name}" />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label for="category-id">Loại sản phẩm</label>
												<div class="col-sm-10" style="width: 100%">
													<select required id="categoryId" name="categoryId"
														class="form-select form-control">
														<c:forEach var="category" items="${cateList}">
															<option
																${product.categoryId == category._id ? "selected" : ""}
																value="${category._id}">${category._name}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label style="margin-top: 15px;">Gía bán</label> <input
													style="margin-top: 15px;" class="form-control" name="price"
													type="text" value="${product.price}" />
											</div>
											<div class="form-group">
												<label style="margin-top: 15px;">Mô tả về sản phẩm</label> <input
													style="margin-top: 15px;" class="form-control"
													name="description" type="text"
													value="${product.description}" />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label for="isDeleted">Trạng thái kinh doanh</label>
												<div class="col-sm-10" style="width: 100%">
													<select required id="isDeleted" name="isDeleted"
														class="form-select form-control">
														<option
															${product.isDeleted == product.isDeleted ? "selected" : ""}
															value="${product.isDeleted eq false }">
															<c:choose>
																<c:when test="${product.isDeleted eq false}">Ngưng bán
																</c:when>
																<c:otherwise>Đang kinh doanh
																</c:otherwise>
															</c:choose>
														</option>
														<option
															${product.isDeleted == product.isDeleted ? "selected" : ""}
															value="${product.isDeleted eq true }">
															<c:choose>
																<c:when test="${product.isDeleted eq true}">Ngưng bán
																</c:when>
																<c:otherwise>Đang kinh doanh
																</c:otherwise>
															</c:choose>
														</option>

													</select>
												</div>
											</div>
											<div class="form-group">
												<label style="margin-top: 15px;">Hình ảnh</label> <input
													style="margin-top: 15px;" class="form-control"
													value="${product.image}" name="image" type="file" /> <img
													class="card-img-top"
													src="${pageContext.request.contextPath}/${product.image}"
													width="100px" height="100px" alt="Card image cap">
											</div>

											<button type="submit" class="btn btn-primary"
												style="width: 100px; margin-top: 20px; padding-right: 7px;">Cập
												nhật</button>
											<a href="productList">
												<button
													style="float: right; border: none; text-align: center; margin-top: 15px;"
													class="btn btn-success">
													<h6>Về lại danh sách</h6>
												</button>
											</a>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- End Form Elements -->
					</div>
				</div>

			</div>
		</div>

	</div>

	<script src="./Builder/js/vendor.js" type="text/javascript"></script>
</body>