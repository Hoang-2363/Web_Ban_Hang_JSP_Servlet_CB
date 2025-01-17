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
		<h1 class="text-center text-white display-6">Theo dõi đơn hàng</h1>
		<ol class="breadcrumb justify-content-center mb-0">
			<li class="breadcrumb-item"><a href="trangchu">Trang chủ</a></li>
			<li class="breadcrumb-item active text-white">Theo dõi đơn hàng</li>
		</ol>
	</div>
	<!-- Single Page Header End -->


	<!-- Fruits Shop Start-->
	<div class="container-fluid fruite py-5">
		<div
			class="container py-5 <c:if test='${ten_kh != null}'>visually-hidden</c:if>">
			<h1 class="mb-5">Vui lòng đăng nhập</h1>
			<a
				class="w-100 btn form-control border-secondary py-2 bg-white text-primary fs-4 mt-5"
				href="login">Đăng nhập hệ thống</a>
		</div>
		<div
			class="container py-5 <c:if test='${ten_kh == null}'>visually-hidden</c:if>">
			<h1>Đơn hàng đã đặt đang xử lý</h1>
			<c:forEach items="${sessionScope.list2}" var="c1">
				<div
					class="row g-5 mt-5 border-top border-4 border-primary <c:if test='${c1.ma_hd_bh == null}'>visually-hidden</c:if>">
					<div class="col-lg-6">
						<div class="d-flex ps-5 rounded bg-white">
							<i class="fa fa-shopping-cart fa-2x text-primary me-4"></i>
							<div>
								<div class="fs-4 fw-bold">Mã hóa đơn đặt hàng:
									HDBH_${c1.ma_hd_bh}</div>
							</div>
						</div>
						<div class="d-flex ps-5 pt-4 rounded bg-white mb-4 ms-1">
							<i class="fas fa-clock fa-2x text-primary me-4"></i>
							<div>
								<div class="fs-4 fw-bold">Ngày đặt hàng:
									${c1.ngay_xuat_hd}</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row g-5">
					<div class="container-fluid">
						<div
							class="row <c:if test='${c1.ma_hd_bh == null}'>visually-hidden</c:if>">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<div class="container-fluid  p-2 align-items-center">
									<div class="d-flex justify-content-around">
										<button class="btn text-white rounded-circle"
											data-bs-toggle="tooltip" style="background-color: green;">
											<i class="fas fa-check"></i>
										</button>
										<span class="w-50 p-1 mx-n1 rounded mt-auto mb-auto"
											style="background-color: green;"></span>
										<button class="btn text-white rounded-circle"
											data-bs-toggle="tooltip" style="background-color: green;">
											<i class="fas fa-check"></i>
										</button>
										<c:if test='${c1.trang_thai == "Đang xử lý"}'>
											<span class="w-50 p-1 mx-n1 rounded mt-auto mb-auto"
												style="background-color: gray;"></span>
											<button class="btn text-white rounded-circle"
												data-bs-toggle="tooltip" style="background-color: gray;">
												<i class="fas fa-check"></i>
											</button>
											<span class="w-50 p-1 mx-n1 rounded mt-auto mb-auto"
												style="background-color: gray;"></span>
											<button class="btn text-white rounded-circle"
												data-bs-toggle="tooltip" style="background-color: gray;">
												<i class="fas fa-check"></i>
											</button>
										</c:if>

										<c:if test='${c1.trang_thai == "Đang giao hàng"}'>
											<span class="w-50 p-1 mx-n1 rounded mt-auto mb-auto"
												style="background-color: green;"></span>
											<button class="btn text-white rounded-circle"
												data-bs-toggle="tooltip" style="background-color: green;">
												<i class="fas fa-check"></i>
											</button>
											<span class="w-50 p-1 mx-n1 rounded mt-auto mb-auto"
												style="background-color: gray;"></span>
											<button class="btn text-white rounded-circle"
												data-bs-toggle="tooltip" style="background-color: gray;">
												<i class="fas fa-check"></i>
											</button>
										</c:if>

										<c:if test='${c1.trang_thai == "Giao hàng thành công"}'>
											<span class="w-50 p-1 mx-n1 rounded mt-auto mb-auto"
												style="background-color: green;"></span>
											<button class="btn text-white rounded-circle"
												data-bs-toggle="tooltip" style="background-color: green;">
												<i class="fas fa-check"></i>
											</button>
											<span class="w-50 p-1 mx-n1 rounded mt-auto mb-auto"
												style="background-color: green;"></span>
											<button class="btn text-white rounded-circle"
												data-bs-toggle="tooltip" style="background-color: green;">
												<i class="fas fa-check"></i>
											</button>
										</c:if>

									</div>
								</div>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
				</div>
				<div class="row g-5">
					<div class="container-fluid">
						<div
							class="row <c:if test='${c1.ma_hd_bh == null}'>visually-hidden</c:if>">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<div class="container-fluid  p-2 align-items-center">
									<div class="d-flex justify-content-around">
										<div class="row me-4 ms-5">
											<i class="fas fa-clipboard-check fa-2x col-md-2 mt-4 me-2"
												style="color: #007bff;"></i>
											<div class="fs-4 fw-bold col-md-7">Xác thực đặt hàng</div>
										</div>
										<div class="row ms-3">
											<i class="fas fa-boxes fa-2x col-md-2 mt-4 me-3"
												style="color: gold;"></i>
											<div class="fs-4 fw-bold col-md-7">Đang xử lý</div>
										</div>
										<div class="row ms-5">
											<i class="fas fa-truck fa-2x col-md-2 mt-4 me-3"
												style="color: #ff0814;"></i>
											<div class="fs-4 fw-bold col-md-7">Đang giao hàng</div>
										</div>
										<div class="row ms-3">
											<i class="fas fa-home fa-2x col-md-2 mt-4 me-2"
												style="color: #49c700;"></i>
											<div class="fs-4 fw-bold col-md-7">Giao hàng thành công</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-1"></div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div
			class="container py-5 <c:if test='${ten_kh == null}'>visually-hidden</c:if>">
			<h1 class="mb-5">Danh sách đơn hàng đã đặt</h1>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr class="fs-3">
							<th scope="col" style="width: 5%; text-align: center;">STT</th>
							<th scope="col" style="width: 15%; text-align: center;">Mã
								hóa đơn</th>
							<th scope="col" style="width: 25%; text-align: center;">Thời
								gian đặt hàng</th>
							<th scope="col" style="width: 23%; text-align: center;">Tổng
								tiền hóa đơn</th>
							<th scope="col" style="text-align: center;">Trạng thái</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="d2" items="${sessionScope.hdbhtm}"
							varStatus="status">
							<tr class="fs-4" style="text-align: center; font-weight: bold;">
								<td style="width: 5%;">
									<p class="mb-2 mt-3">${status.index + 1}</p>
								</td>
								<td>
									<p class="mb-2 mt-3">HDBH_${d2.ma_hd_bh}</p>
								</td>
								<td style="width: 16%;">
									<p class="mb-2 mt-3">${d2.ngay_xuat_hd}</p>
								</td>
								<td style="width: 15%;">
									<p class="mb-2 mt-3">
										<fmt:formatNumber value="${d2.tong_tien}" type="number" />
										đ
									</p>
								</td>
								<td>
									<p class="mb-2 mt-3 text-white rounded-pill"
										<c:if
										test='${d2.trang_thai == "Giao hàng thành công"}'>
										style="background-color: #43b800;"
									</c:if>
										<c:if
										test='${d2.trang_thai == "Đang giao hàng"}'>
										style="background-color: #b10000;"
									</c:if>
										<c:if
										test='${d2.trang_thai == "Đang xử lý"}'>
										style="background-color: #cfb000;"
									</c:if>>${d2.trang_thai}</p>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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