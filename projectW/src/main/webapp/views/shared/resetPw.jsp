<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Đặt lại mật khẩu</title>
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
	padding: 16px 8px;
	margin: 8px 0;
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

h1 {
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
	padding: 20px 0;
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
	<form action="ResetPassword" method=post>
		<h1>Đặt lại mật khẩu</h1>
		<div class="formcontainer">
			<hr />
			<div class="container">
				<label for="uname"><strong>Mã xác nhận</strong></label> <input
					type="text" placeholder="Vui lòng kiểm tra email" name="code" required>
				<label for="psw"><strong>Mật khẩu</strong></label> <input
					type="password" placeholder="Nhập password" name="pass" required>
				<label for="psw"><strong>Nhập lại mật khẩu</strong></label> <input
					type="password" placeholder="Nhập lại password" name="re_pass" required>
			</div>
			<button type="submit">Hoàn tất</button>
			</div>
	</form>
</body>
</html>