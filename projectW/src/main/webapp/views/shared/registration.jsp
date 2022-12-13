<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Đăng ký</title>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<style>
html, body {
	display: flex;
	justify-content: center;
	font-family: Roboto, Arial, sans-serif;
	font-size: 17px;
}

form {
	border: 5px solid #f1f1f1;
}

input[type=email],input[type=text], input[type=password] {
	width: 100%;
	padding: 7px 5px;
	margin: 1px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #8ebf42;
	color: white;
	padding: 14px 0;
	margin: 10px 0;
	border: none;
	cursor: grabbing;
	width: 100%;
	font-size:17px;
}

h1,h2 {
	text-align: center;
	fone-size: 18;
}

button:hover {
	opacity: 0.8;
}

.formcontainer {
	text-align: left;
	margin: 24px 50px 12px;
}

.container {
	padding: 7px 0;
	text-align: left;
}

span.psw {
	float: right;
	padding-top: -8px;
	padding-right: 15px;
	padding-bottom:3px;
}
/* Change styles for span on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
}
</style>
</head>
<body>
	<form action="registration" method=post>
		<h2>Đăng ký tài khoản</h2>
		<div class="formcontainer">
			<hr />
			<div class="container">
				<label for="uname"><strong>Họ</strong></label> <input
					type="text" placeholder="Ex: Nguyễn" name="fname" required>
			</div>
			<div class="container">
				<label for="uname"><strong>Tên</strong></label> <input
					type="text" placeholder="Ex: Kiều Châu Anh" name="lname" required>
			</div>
			<div class="container">
				<label for="uname"><strong>Email</strong></label> <input
					type="email" placeholder="Nhập email" name="email" required>
			</div>
			<div class="container">
				<label for="uname"><strong>Số điện thoại</strong></label> <input
					type="text" placeholder="Nhập email" name="phone" required>
			</div>
			<div class="container">
				<label for="uname"><strong>Địa chỉ</strong></label> <input
					type="text" placeholder="Ex: 306/63 Vuon Cau, Nhon Phu, Thu Duc" name="address" required>
			</div>
			<div class="container">	
				<label for="psw"><strong>Mật khẩu</strong></label> <input
					type="password" placeholder="Nhập mật khẩu" name="pass" required>
			</div>	
			<div class="container">	
				<label for="psw"><strong>Nhập lại mật khẩu</strong></label> <input
					type="password" placeholder="Nhập lại mật khẩu" name="re_pass" required>
			</div>	
			<button type="submit">Đăng ký</button>
			<div class="container" style="background-color: white">
				<span class="psw" style = "margin-bottom:10px;"><a href="login"> Đã có tài khoản</a></span>
			</div>
			</div>
	</form>
</body>
</html>