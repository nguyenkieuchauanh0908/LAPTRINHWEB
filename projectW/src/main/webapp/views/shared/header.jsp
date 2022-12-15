<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="welcome">STATIONERY</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<li class="nav-item"><a class="nav-link" href="welcome">Trang
						chủ</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Danh mục </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<c:forEach items="${listcate }" var="p">
							<a class="dropdown-item  ${tagactive==p._id ? "
								active":""}" href="category?cid=${p._id }">${p._name}</a>
						</c:forEach>


						<!-- <div class="dropdown-divider"></div> -->

					</div></li>
				<li class="nav-item"><a class="nav-link" href="products">Sản
						phẩm</a></li>
				<li class="nav-item"><a class="nav-link" href="contact.html">Liên
						hệ</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Đăng
						nhập</a></li>
			</ul>

			<form class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control" aria-label="Small"
						aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
					<div class="input-group-append">
						<button type="button" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
					class="fa fa-shopping-cart"></i> Cart <span
					class="badge badge-light">0</span>
				</a>
			</form>
		</div>
	</div>
</nav>
<!--
<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">E-COMMERCE CATEGORY</h1>
		<p class="lead text-muted mb-0">Le Lorem Ipsum est simplement du
			faux texte employé dans la composition et la mise en page avant
			impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie
			depuis les années 1500, quand un peintre anonyme assembla ensemble
			des morceaux de texte pour réaliser un livre spécimen de polices de
			texte...</p>
	</div>
</section>
  -->
<div class="item">
	<img class="d-block w-100"
		src="https://img.freepik.com/free-vector/back-school-sale-background_23-2149027990.jpg?w=1060&t=st=1670136486~exp=1670137086~hmac=7122993f39cbcd2df61dff187f2f535528de8677bdac2b22bde2d311fa6429f6"
		alt="">
</div>
