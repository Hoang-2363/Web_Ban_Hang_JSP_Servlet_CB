<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
</head>

<body>

	<!-- Spinner Start -->
	<div id="spinner"
		class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
		<div class="spinner-grow text-primary" role="status"></div>
	</div>
	<!-- Spinner End -->


	<!-- Navbar start -->
	<div class="container-fluid fixed-top">
		<div class="container topbar bg-primary d-none d-lg-block">
			<div class="d-flex justify-content-between">
				<div class="top-info ps-2 fw-bold">
					<small class="me-3"><i
						class="fas fa-map-marker-alt me-2 text-secondary"></i> <a
						href="https://www.google.com/maps/search/89+%C4%90.+L%C3%AA+%C4%90%E1%BB%A9c+Th%E1%BB%8D,+M%E1%BB%B9+%C4%90%C3%ACnh,+T%E1%BB%AB+Li%C3%AAm,+H%C3%A0+N%E1%BB%99i/@21.0283486,105.7669354,17z/data=!3m1!4b1?hl=vi-VN&entry=ttu"
						class="text-white">89 Đ. Lê Đức Thọ, Mỹ Đình, Từ Liêm, Hà Nội</a></small>
					<small class="me-3"><i
						class="fas fa-envelope me-2 text-secondary"></i><a
						href="https://www.google.com/intl/vi/gmail/about/"
						class="text-white">ogani@gmail.com</a></small>
				</div>
				<div class="top-link pe-2 fw-bold">
					<a href="trangchu" class="text-white"><small
						class="text-white mx-2">Chính sách bảo mật</small>/</a> <a
						href="trangchu" class="text-white"><small
						class="text-white mx-2">Điều khoản sử dụng</small>/</a> <a
						href="trangchu" class="text-white"><small
						class="text-white ms-2">Bán hàng và hoàn tiền</small></a>
				</div>
			</div>
		</div>
		<div class="container px-0">
			<nav class="navbar navbar-light bg-white navbar-expand-xl">
				<a href="trangchu" class="navbar-brand">
					<h1 class="text-primary display-6">Ogani</h1>
				</a>
				<button class="navbar-toggler py-2 px-3" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
					<span class="fa fa-bars text-primary"></span>
				</button>
				<div class="collapse navbar-collapse bg-white" id="navbarCollapse">
					<div class="navbar-nav mx-auto fw-bold">
						<a href="trangchu" class="nav-item nav-link fs-5">Trang chủ</a> <a
							href="hanghoa" class="nav-item nav-link fs-5">Hàng hóa</a>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle fs-5"
								data-bs-toggle="dropdown">Danh mục</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="giohang" class="dropdown-item active fs-5">Giỏ hàng</a>
								<a href="dathang" class="dropdown-item fs-5">Thanh toán</a><a
									href="theodoidh" class="dropdown-item fs-5">Theo dõi đơn
									hàng</a> <a href="tinnhankh" class="dropdown-item fs-5">Phản
									hồi khách hàng</a>
							</div>
						</div>
						<a href="phanhoi" class="nav-item nav-link fs-5">Liên hệ</a>
					</div>
					<div class="d-flex m-3 me-0">
						<button
							class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4"
							data-bs-toggle="modal" data-bs-target="#searchModal">
							<i class="fas fa-search text-primary"></i>
						</button>
						<a href="giohang" class="position-relative me-4 my-auto"> <i
							class="fa fa-cart-plus fa-2x"></i> <span
							class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
							style="top: -5px; left: 25px; height: 20px; min-width: 20px;">${requestScope.size}</span>
						</a>
						<c:set var="ten_kh" value="${sessionScope.kh.ten_kh}" />
						<div
							class="nav-item dropdown <c:if test='${ten_kh != null}'>visually-hidden</c:if>">
							<a href="khachhang" class="nav-link dropdown-toggle my-auto"
								data-bs-toggle="dropdown"> <i class="fas fa-user fa-2x"></i>
							</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="login" class="dropdown-item active fs-5">Đăng nhập</a>
							</div>
						</div>
						<div
							class="nav-item dropdown <c:if test='${ten_kh == null}'>visually-hidden</c:if>">
							<a href="#" class="nav-link dropdown-toggle my-auto"
								data-bs-toggle="dropdown"> <i class="fas fa-user fa-2x"></i>
								<span class="fw-bold fs-4">${sessionScope.kh.ten_kh}</span>
							</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="khachhang" class="dropdown-item active fs-5">Thông
									tin tài khoản</a> <a href="logout" class="dropdown-item fs-5">Đăng
									xuất</a>
							</div>
						</div>

					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Navbar End -->


	<!-- Single Page Header start -->
	<div class="container-fluid page-header py-5"
		style="background: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)), url(page/img/cart-page-header-img.jpg);">
		<h1 class="text-center text-white display-6">Thanh toán</h1>
		<ol class="breadcrumb justify-content-center mb-0">
			<li class="breadcrumb-item"><a href="trangchu">Trang chủ</a></li>
			<li class="breadcrumb-item active text-white">Thanh toán</li>
		</ol>
	</div>
	<!-- Single Page Header End -->


	<!-- Fruits Shop Start-->
	<div class="container-fluid fruite py-5">
		<div class="container py-5">
			<h1 class="mb-4">Chi tiết hóa đơn thanh toán</h1>
			<div class="row g-5">
				<div class="col-md-12 col-lg-5 col-xl-5">
					<form action="dathang" class="row g-3" method="post">
						<div class="form-item">
							<input type="hidden" class="w-100 form-control py-3 mb-4 fw-bold"
								value="${sessionScope.kh.ma_kh}" name="ma_kh"> <label
								class="form-label my-1 fs-5 fw-bold">Tên khách hàng</label> <input
								type="text" class="w-100 form-control py-3 mb-4 fs-5 fw-bold"
								value="${sessionScope.kh.ten_kh}" readonly="readonly"
								name="ten_kh">
						</div>
						<div class="form-item" style="margin-top: 20px;">
							<label class="form-label my-1 fs-5 fw-bold">Địa chỉ</label> <input
								type="text" class="w-100 form-control py-3 mb-4 fs-5 fw-bold"
								value="${sessionScope.kh.dia_chi}" name="dia_chi"
								readonly="readonly">
						</div>
						<div class="form-item" style="margin-top: 20px;">
							<label class="form-label my-1 fs-5 fw-bold">Số điện thoại</label>
							<input type="text" value="${sessionScope.kh.sdt}" name="sdt"
								class="w-100 form-control py-3 mb-4 fs-5 fw-bold"
								readonly="readonly">
						</div>
						<div
							class="row g-4 text-center align-items-center justify-content-center pt-4">
							<button type="submit"
								class="btn border-secondary py-3 px-4 text-uppercase w-100 text-primary">Đặt
								hàng</button>
						</div>
					</form>
				</div>
				<div class="col-md-12 col-lg-7 col-xl-7">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr class="fs-5">
									<th scope="col" style="width: 15%; text-align: center;">Ảnh</th>
									<th scope="col" style="text-align: center;">Tên hàng hóa</th>
									<th scope="col" style="width: 15%; text-align: center;">Giá
										bán</th>
									<th scope="col" style="width: 15%; text-align: center;">Số
										lượng</th>
									<th scope="col" style="width: 20%; text-align: center;">Thành
										tiền</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="o" value="${requestScope.cart}" />
								<c:set var="t" value="0" />
								<c:forEach items="${o.items}" var="i">
									<tr class="fs-5" style="text-align: center; font-weight: bold;">
										<th scope="row">
											<div class="d-flex align-items-center mt-2">
												<img src="page/img/hanghoa/${i.hang_hoa.anh}"
													class="img-fluid rounded-circle"
													style="width: 90px; height: 90px;" alt="">
											</div>
										</th>
										<td class="py-5">${i.hang_hoa.ten_hang}</td>
										<td class=" py-5" style="width: 15%;"><fmt:formatNumber
												type="number" value="${i.gia_ban}" /></td>
										<td class="py-5" style="width: 15%;">${i.so_luong}</td>
										<td class="py-5" style="width: 20%;"><fmt:formatNumber
												type="number" value="${(i.gia_ban*i.so_luong)}" /></td>
									</tr>
								</c:forEach>
								<tr>
									<th scope="row"></th>
									<td class="py-2">
										<p class="mb-0 text-dark text-uppercase py-3 fs-5 fw-bold">Tổng
											tiền hóa đơn:</p>
									</td>
									<td class="py-2"></td>
									<td class="py-2"></td>
									<td class="py-2">
										<div class="py-3 border-bottom border-top">
											<p class="mb-0 text-dark fs-4 fw-bold">
												<fmt:formatNumber type="number" value="${o.tong_Tien_GH}" />
												đ
											</p>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Fruits Shop End-->


	<!-- Footer Start -->
	<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
		<div class="container py-5">
			<div class="pb-4 mb-4"
				style="border-bottom: 1px solid rgba(226, 175, 24, 0.5);">
				<div class="row g-4">
					<div class="col-lg-3">
						<a href="#">
							<h1 class="text-primary mb-0">Ogani</h1>
							<p class="text-secondary mb-0">Siêu thị trực tuyến</p>
						</a>
					</div>
					<div class="col-lg-9">
						<div class="d-flex justify-content-end pt-3">
							<a
								class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle"
								href=""><i class="fab fa-twitter"></i></a> <a
								class="btn btn-outline-secondary me-2 btn-md-square rounded-circle"
								href=""><i class="fab fa-facebook-f"></i></a> <a
								class="btn btn-outline-secondary me-2 btn-md-square rounded-circle"
								href=""><i class="fab fa-youtube"></i></a> <a
								class="btn btn-outline-secondary btn-md-square rounded-circle"
								href=""><i class="fab fa-linkedin-in"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row g-5">
				<div class="col-lg-4 col-md-6">
					<div class="d-flex flex-column text-start footer-item">
						<h4 class="text-light mb-3">Thông tin cửa hàng</h4>
						<a class="btn-link" href="">Chính sách bảo mật</a> <a
							class="btn-link" href="">Điều khoản và điều kiện</a> <a
							class="btn-link" href="">Chính sách hoàn trả</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="d-flex flex-column text-start footer-item">
						<h4 class="text-light mb-3">Tài khoản</h4>
						<a class="btn-link" href="">Tài khoản của tôi</a> <a
							class="btn-link" href="">Hàng hóa</a> <a class="btn-link" href="">Giỏ
							hàng</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="footer-item">
						<h4 class="text-light mb-3">Liên hệ</h4>
						<p>Địa chỉ: 89 Đ. Lê Đức Thọ, Mỹ Đình, Từ Liêm, Hà Nội</p>
						<p>Email: ogani@gmail.com</p>
						<p>Điện thoại: 0359782629</p>
						<p>Thanh toán được chấp nhận</p>
						<img src="page/img/payment.png" class="img-fluid" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->

	<!-- Copyright Start -->
	<div class="container-fluid copyright bg-dark py-4">
		<div class="container">
			<div class="row">
				<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
					<span class="text-light"><a href="index.html"><i
							class="fas fa-copyright text-light me-2"></i>Trang web </a>, Mọi
						quyền được bảo lưu.</span>
				</div>
				<div class="col-md-6 my-auto text-center text-md-end text-white">
					Được thiết kế bởi <a class="border-bottom"
						href="https://vi.wikipedia.org/wiki/Oracle_Corporation">
						Oracle Corporation</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Copyright End -->



	<!-- Back to Top -->
	<a href="#"
		class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
		class="fa fa-arrow-up"></i></a>


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
</html>