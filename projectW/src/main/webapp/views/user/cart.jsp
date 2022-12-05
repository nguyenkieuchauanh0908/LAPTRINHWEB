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
								<th scope="col">Product</th>
								<th scope="col">Available</th>
								<th scope="col" class="text-center">Quantity</th>
								<th scope="col" class="text-right">Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img src="https://dummyimage.com/50x50/55595c/fff" />
								</td>
								<td>Product Name Dada</td>
								<td>In stock</td>
								<td><input class="form-control" type="text" value="1" /></td>
								<td class="text-right">124,90 €</td>
								<td class="text-right"><button
										class="btn btn-sm btn-danger">
										<i class="fa fa-trash"></i>
									</button></td>
							</tr>
							<tr>
								<td><img src="https://dummyimage.com/50x50/55595c/fff" />
								</td>
								<td>Product Name Toto</td>
								<td>In stock</td>
								<td><input class="form-control" type="text" value="1" /></td>
								<td class="text-right">33,90 €</td>
								<td class="text-right"><button
										class="btn btn-sm btn-danger">
										<i class="fa fa-trash"></i>
									</button></td>
							</tr>
							<tr>
								<td><img src="https://dummyimage.com/50x50/55595c/fff" />
								</td>
								<td>Product Name Titi</td>
								<td>In stock</td>
								<td><input class="form-control" type="text" value="1" /></td>
								<td class="text-right">70,00 €</td>
								<td class="text-right"><button
										class="btn btn-sm btn-danger">
										<i class="fa fa-trash"></i>
									</button></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>Sub-Total</td>
								<td class="text-right">255,90 €</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>Shipping</td>
								<td class="text-right">6,90 €</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><strong>Total</strong></td>
								<td class="text-right"><strong>346,90 €</strong></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						<button class="btn btn-block btn-light">Continue Shopping</button>
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
