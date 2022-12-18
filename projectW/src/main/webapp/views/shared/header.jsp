<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="welcome">VĂN PHÒNG PHẨM</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<form action="searchproduct" method="get"
				class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control" name="keyword"
						aria-label="Small" aria-describedby="inputGroup-sizing-sm"
						placeholder="Nhập tên sản phẩm ..." value="${key }">
					<div class="input-group-append">
						<button type="submit" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<c:if test="${sessionScope.uId != null}">
					<a class="btn btn-success btn-sm ml-3" href="cart"> <i
						class="fa fa-shopping-cart"></i> Giỏ hàng <!--<span
						 class="badge badge-light">0</span> -->
					</a>
				</c:if>
				<c:if test="${sessionScope.uId == null}">
					<a class="btn btn-success btn-sm ml-3" href="login"> <i
						class="fa fa-shopping-cart"></i> Giỏ hàng<!-- <span
						 class="badge badge-light">0</span> -->
					</a>
				</c:if>
			</form>
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
				<c:if test="${sessionScope.uId != null}">
					<li class="nav-item" style="padding-top:3px;"><a href="user" > <!-- <img style="margin-right: 30px;"
			src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin"
			class="rounded-circle" width="150"> --> <img
							src="${pageContext.request.contextPath}/${sessionScope.avatar}"
							alt="Admin" class="rounded-circle" width="35" height="35" >
					</a></li>
					<li class="nav-item"><a class="nav-link" href="logout"
						onclick="return confirm('Bạn có thực sự muốn đăng xuất?')">Đăng
							xuất</a></li>
				</c:if>
				<c:if test="${sessionScope.uId == null}">
					<li class="nav-item"><a class="nav-link" href="login">Đăng
							nhập</a></li>
				</c:if>
			</ul>

			
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

