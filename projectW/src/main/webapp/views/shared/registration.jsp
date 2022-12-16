<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Đăng ký</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" 
	type="text/css"
>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<style>
html, body {
	justify-content: center;
	font-family: Roboto, Arial, sans-serif;
	font-size: 17px;
}

input[type=email],input[type=text], input[type=password] {
    width: 100%;
	padding: 6px 12px;
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
	cursor: pointer;
	width: 100%;
	font-size:17px;
}

h1,h2 {
	text-align: center;
}
.form-container {
	text-align: left;
	margin: 0 32px;
}

.container {
    display: flex;
	text-align: left;
    margin-bottom: 8px;
}
</style>
</head>
<body >
	<form style="border: 2px solid #e4e4e4; border-radius: 8px; width: 40%; margin: 0 auto;" action="registration" method=post st>
		<h3 style="text-align: center;" class="my-2">Đăng ký tài khoản</h3>
		<div class="form-container">
			<div class="form-group">
                    <label for="uname"><strong>Họ</strong></label> 
                    <input class="form-control" type="text" placeholder="Ex: Nguyễn" name="fname" required>
			</div>
			<div class="form-group">
                    <label for="uname"><strong>Tên</strong></label> 
                    <input class="form-control" type="text" placeholder="Ex: Kiều Châu Anh" name="lname" required>
			</div>
			<div class="form-group">
                    <label for="uname"><strong>Email</strong></label> 
                    <input class="form-control" type="email" placeholder="Nhập email" name="email" required>
			</div>
			<div class="form-group">
                    <label for="uname"><strong>Số điện thoại</strong></label> 
                    <input class="form-control" type="text" placeholder="Nhập email" name="phone" required>
			</div>
			<div class="form-group">
                    <label for="uname"><strong>Địa chỉ</strong></label> 
                    <input class="form-control" type="text" placeholder="Ex: 306/63 Vuon Cau, Nhon Phu, Thu Duc" name="address" required>
			</div>
			<div class="form-group">	
                    <label for="psw"><strong>Mật khẩu</strong></label> 
                    <input class="form-control" type="password" placeholder="Nhập mật khẩu" name="pass" required>
			</div>	
			<div class="form-group">	
                    <label for="psw"><strong>Nhập lại mật khẩu</strong></label> 
                    <input class="form-control" type="password" placeholder="Nhập lại mật khẩu" name="re_pass" required>
                    <div class="text-${messageType }">${message }</div>
                    <div style = "text-align: end; margin: 8px 0;"><a href="login"> Đã có tài khoản</a></span>
			</div>	
			<div class="form-group"><input class="w-100 btn btn-primary" type="submit" value="Đăng ký" /></div>
			</div>
			</div>
	</form>
</body>
</html>