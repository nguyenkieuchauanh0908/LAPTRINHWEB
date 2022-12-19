<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li class="nav-item"><a href="welcomeAdmin"
					class="nav-link pt-3 pb-3 ps-5 pe-5">Trang chủ</a></li>
				<li class="nav-item"><a href="userList"
					class="nav-link pt-3 pb-3 ps-5 pe-5">Khách hàng</a></li>
				<li class="nav-item"><a href="employeeList"
					class="nav-link pt-3 pb-3 ps-5 pe-5">Nhân viên</a></li>
				<li class="nav-item"><a href="productList"
					class="nav-link pt-3 pb-3 ps-5 pe-5">Sản phẩm</a></li>
				<li class="nav-item"><a href="categoryList"
					class="nav-link pt-3 pb-3 ps-5 pe-5">Loại sản phẩm</a></li>
				<li class="nav-item"><a href="orderList"
					class="nav-link pt-3 pb-3 ps-5 pe-5">Đơn hàng</a></li>
				<li><a href="logout">
						<button onclick="return confirm('Bạn có thực sự muốn đăng xuất?')"
							style="float: right; margin-right: 70px; margin-top: 20px; background-color: #FF6347; border: none; text-align: center; padding: 5px 10px;"
							class="btn btn-info">
							<h6>Đăng xuất</h6>
						</button>
				</a></li>
			</ul>

		</div>

	</nav>
</div>