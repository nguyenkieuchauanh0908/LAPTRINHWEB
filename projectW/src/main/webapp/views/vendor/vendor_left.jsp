<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-12 col-md-3 col-xl-2 p-0 bg-dark ">
	<nav
		class="navbar navbar-expand-md navbar-dark bd-dark flex-md-column flex-row align-items-center py-2 sticky-top "
		id="sidebar">
		<div class="text-center" style="color: white">
			<h6 style="margin-top: 25px;">${sessionScope.uFirstname}
				${sessionScope.uLastname}</h6>
		</div>
		<a href="user"> <!-- <img style="margin-right: 30px;"
			src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin"
			class="rounded-circle" width="150"> --> <img
			src="${pageContext.request.contextPath}/${sessionScope.avatar}"
			 class="rounded-circle" width="150" height="150">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#nav" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse order-last" id="nav">
			<ul class="navbar-nav flex-column w-100 justify-content-center">
			
				<li class="nav-item"><a href=""
					class="nav-link pt-3 pb-3 ps-5 pe-5"> Trang chủ </a></li>

				<c:set var="status2" value="Cần xử lý" />
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/Vendor?status=${status2}"
					class="nav-link pt-3 pb-3 ps-5 pe-5"> Cần xử lý </a></li>
				<c:set var="status3" value="Đang giao hàng" />
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/Vendor?status=${status3}"
					class="nav-link pt-3 pb-3 ps-5 pe-5"> Đang giao hàng </a></li>
				<c:set var="status1" value="Đã bán" />
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/Vendor?status=${status1}"
					class="nav-link pt-3 pb-3 ps-5 pe-5"> Đã bán </a></li>
				<c:set var="status4" value="Đã hủy" />
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/Vendor?status=${status4}"
					class="nav-link pt-3 pb-3 ps-5 pe-5"> Bị hủy </a></li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/productList"
					class="nav-link pt-3 pb-3 ps-5 pe-5"> Quản lý sản phẩm </a></li>
				<li><a href="logout">
						<button
							style="float: right; margin-right: 70px; margin-top: 20px; background-color: #FF6347; border: none; text-align: center; padding: 5px 10px;"
							class="btn btn-info">
							<h6>Đăng xuất</h6>
						</button>
				</a></li>
			</ul>
		</div>
	</nav>
</div>