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
					<b>Thêm mới nhân viên</b>
				</h2>
				<div class="row">
					<div class="col-md-11">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="" style="padding: 70px; margin-top: -50px;">
										<form onsubmit="return confirm('Bạn có chắc muốn thêm nhân viên này?');" method="post" action="userAdd">
											<div class="form-group">
												<label>Họ</label> <input class="form-control"
													placeholder="Nguyễn" name="fname" type="text" required />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label>Tên</label> <input class="form-control"
													placeholder="Kiều Châu Anh" name="lname" required />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label>Email</label> <input class="form-control"
													placeholder="abc@gmail.com" type="email" name="email"
													required />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label>Số điện thoại</label> <input class="form-control"
													placeholder="0966732000" type="text" name="phone_number"
													required />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label>Địa chỉ</label> <input class="form-control"
													placeholder="123 An Phu Dong, Ho Chi Minh city"
													name="address" required />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label>Mật khẩu</label> <input class="form-control"
													placeholder="Enter password" type="password"
													name="password" required />
											</div>
											<div class="form-group" style="margin-top: 15px;">
												<label>Vai trò hệ thống</label>
												<div class="checkbox" style="margin-top: 10px;">
													<label style="padding: 15px;"><input type="radio"
														value="2" name="role" />Nhân viên</label>
												</div>
											</div>
											<button type="submit" class="btn btn-primary"
												style="width: 100px; margin-top: 10px; padding-right: 7px;">Thêm
											</button>
											<button type="reset" class="btn btn-warning"
												style="width: 100px; margin-top: 10px;">Reset</button>

										</form>
										<a href="employeeList">
											<button
												style="float: right; border: none; text-align: center; margin-top: 15px;"
												class="btn btn-success">
												<h6>Về lại danh sách</h6>
											</button>
										</a>

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