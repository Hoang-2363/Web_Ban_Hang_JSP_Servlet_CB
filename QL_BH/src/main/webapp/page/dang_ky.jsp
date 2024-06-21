<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Siêu thị Ogani</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="page/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
<link href="page/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">


<!-- Customized Bootstrap Stylesheet -->
<link href="page/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="page/css/style.css" rel="stylesheet">

<link rel="icon" type="image/x-icon" href="page/img/title.ico">
<style>
.input-container .fa-eye {
	position: absolute;
	top: 75%;
	right: 255px;
	transform: translateY(-50%);
	font-size: 1.5em;
}
</style>
</head>

<body class="bg-info">
	<div class="container-fluid contact">
		<div class="container py-3">
			<div class="p-4 bg-light rounded">
				<div class="row g-4">
					<div class="col-lg-5">
						<div class="carousel-item active rounded">
							<img src="page/img/login.jpg"
								class="img-fluid w-100 bg-secondary rounded"
								style="margin-top: 140px;">
						</div>
					</div>
					<div class="col-lg-7">
						<form action="signup" class="mt-3" method="post">
							<h2 class="d-flex justify-content-center mb-3">Chào mừng bạn
								đến với siêu thị Ogani</h2>
							<label class="fs-5 fw-bold pb-1" for="hvt">Họ và tên</label> <input
								type="text" class="w-100 form-control py-3 mb-3 fw-bold" id="hvt"
								name="ten_kh" required> <label class="fs-5 fw-bold pb-1"
								for="sdt">Số điện thoại</label>&nbsp; <label
								class="fs-5 fw-bold pb-1 text-danger">${requestScope.error}</label>
							<input type="text" class="w-100 form-control py-3 mb-3 fw-bold" id="sdt"
								name="sdt" required> <label class="fs-5 fw-bold pb-1"
								for="dc">Địa chỉ</label> <input type="text"
								class="w-100 form-control py-3 mb-3 fw-bold" id="dc" name="dia_chi"
								required> <label class="fs-5 fw-bold pb-1" for="tk">Tài
								khoản</label> <input type="text" class="w-100 form-control py-3 mb-3 fw-bold"
								id="tk" name="tai_khoan" required> <label
								class="fs-5 fw-bold pb-1" for="mk">Mật khẩu</label>
							<div class="col-md-12 input-container">
								<input type="password" class="w-100 form-control py-3 mb-3 fw-bold"
									id="password_show" name="mat_khau" required> <i
									class="fa fa-eye fa-fw" id="toggle-password"></i>
							</div>
							<script>
								document
										.getElementById('toggle-password')
										.addEventListener(
												'click',
												function() {
													const passwordField = document
															.getElementById('password_show');
													const type = passwordField
															.getAttribute('type') === 'password' ? 'text'
															: 'password';
													passwordField.setAttribute(
															'type', type);
													this.classList
															.toggle('fa-eye-slash');
												});
							</script>
							<button
								class="w-100 btn form-control border-secondary py-2 bg-white text-primary fs-4 mt-3"
								type="submit">Đăng ký tài khoản</button>
						</form>
						<div class="d-flex justify-content-center fs-6 fw-bold mt-3">
							Bạn đã có tài khoản? &nbsp;<a href="login"
								class="text-decoration-underline">Đăng nhập!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- JavaScript Libraries -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="page/lib/easing/easing.min.js"></script>
	<script src="page/lib/waypoints/waypoints.min.js"></script>
	<script src="page/lib/lightbox/js/lightbox.min.js"></script>
	<script src="page/lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Template Javascript -->
	<script src="page/js/main.js"></script>
</body>

</html>