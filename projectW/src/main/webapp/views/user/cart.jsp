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
	<div class="container mb-4">

		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Sản phẩm</th>
								<th scope="col">Tình trạng</th>
								<th scope="col" class="text-center">Số lượng</th>
								<th scope="col" class="text-center">Giá</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<form action="cartremove" method="get">
								<c:forEach items="${getAllCartItem }" var="cI">
									<input hidden value="${cI.product._id }" name="productId" />
									<tr>
										<td><img
											src="${pageContext.request.contextPath}${cI.product.image}"
											width="50" height="50" /></td>
										<td>${cI.product.name}</td>
										<td><c:if test="${cI.product.quantity > 0 }">Còn hàng</c:if>
											<c:if test="${cI.product.quantity == 0 }">Hết hàng</c:if> <c:if
												test="${cI.product.quantity < 0 }">Hết hàng</c:if></td>
										<td>
											<div class="col d-flex flex-row align-items-center qty"
												style="justify-content: center">
												<!-- <input class="form-control" type="text"
										value="${cI.count_SP }" /> -->
												<c:if test="${cI.count_SP ==1 }">
													<a href="#" value="-" class="fa fa-minus text-danger"></a>
												</c:if>
												<c:if test="${cI.count_SP >1}">
													<a
														href="cartadd?MinusPro=${cI.product._id }&&MinusCart=${cI.cartId }"
														value="-" class="fa fa-minus text-danger"></a>
												</c:if>
												<h6 class="text-grey mt-1 mr-1 ml-1">
													<input type="text" name="quantity" value="${cI.count_SP}"
														style="width: 50px; text-align: center"
														readonly="readonly">
												</h6>
												<c:if test="${cI.product.quantity == cI.count_SP }">
													<a href="#" value="+" class="fa fa-plus text-success"></a>
												</c:if>
												<c:if test="${cI.product.quantity > cI.count_SP }">
													<a
														href="cartadd?PlusPro=${cI.product._id }&&PlusCart=${cI.cartId }"
														value="+" class="fa fa-plus text-success"></a>
												</c:if>
											</div>
										</td>
										<td class="text-right"
											style="display: flex; justify-content: center">${cI.product.price * cI.count_SP}
											đồng</td>
										<td class="text-right"><button type="submit"
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash"></i>
											</button></td>

									</tr>
								</c:forEach>
							</form>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><strong>Tổng</strong></td>
								<td class="text-right"><strong><c:set var="total"
											value="${0}" /> <c:forEach items="${getAllCartItem }"
											var="cI">
											<c:set var="total"
												value="${total + cI.count_SP * cI.product.price}" />
										</c:forEach> <span class="pull-right subtotal-cost">${total } đồng</span>
								</strong></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						<a class="btn btn-block btn-light" href="welcome">Tiếp tục mua
							hàng</a>
					</div>
					<div class="col-sm-12 col-md-6 text-right">
						<button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
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
