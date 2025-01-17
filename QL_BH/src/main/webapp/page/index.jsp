<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="page.dal.DAO_Loai_HH"%>
<%@ page import="page.model.Loai_HH"%>
<%@ page import="java.util.List"%>
<%@ page import="page.dal.DAO_Hang_Hoa"%>
<%@ page import="page.model.Hang_Hoa"%>
<%@ page import="page.model.Gio_Hang"%>
<%@ page import="page.model.TT_HH_Mua"%>

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
								<a href="dathang" class="dropdown-item fs-5">Thanh toán</a> <a
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
						<%
						DAO_Hang_Hoa d5 = new DAO_Hang_Hoa();
						List<Hang_Hoa> list5 = d5.select_HH();
						Cookie[] arr = request.getCookies();
						String txt = "";
						if (arr != null) {
							for (Cookie o : arr) {
								if (o.getName().equals("gio_hang")) {
							txt += o.getValue();
								}
							}
						}
						Gio_Hang gio_hang = new Gio_Hang(txt, list5);
						List<TT_HH_Mua> listItems = gio_hang.getItems();
						int n;
						if (listItems != null) {
							n = listItems.size();
						} else {
							n = 0;
						}
						request.setAttribute("size", n);
						%>

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


	<!-- Hero Start -->
	<div class="container-fluid py-5 mb-5 hero-header"
		style="background: linear-gradient(rgba(248, 223, 173, 0.1), rgba(248, 223, 173, 0.1)), url(page/img/hero-img.jpg);">
		<div class="container py-5">
			<div class="row g-5 align-items-center">
				<div class="col-md-12 col-lg-7">
					<h4 class="mb-3 text-secondary">100% Đảm bảo chất lượng hàng
						hóa</h4>
					<h1 class="mb-5 display-3 text-primary">Tất cả các mặt hàng
						đều có tại siêu thị Ogani</h1>
					<div class="position-relative mx-auto">
						<input
							class="form-control border-2 border-secondary w-75 py-3 px-4 rounded-pill"
							type="text" placeholder="Thông tin hàng hóa ...">
						<button type="submit"
							class="btn btn-primary border-2 border-secondary py-3 px-4 position-absolute rounded-pill text-white h-100"
							style="top: 0; right: 25%;">Tìm kiếm</button>
					</div>
				</div>
				<div class="col-md-12 col-lg-5">
					<div id="carouselId" class="carousel slide position-relative"
						data-bs-ride="carousel">
						<%
						DAO_Loai_HH loai_HH = new DAO_Loai_HH();
						List<Loai_HH> list = loai_HH.selec_Loai_HH();
						request.setAttribute("list", list);
						%>
						<div class="carousel-inner" role="listbox">
							<c:forEach var="d" items="${list}" varStatus="status">
								<div
									class="carousel-item ${status.first ? 'active' : ''} rounded">
									<img src="page/img/loai_hh/${d.anh}"
										class="img-fluid w-100 h-100 bg-secondary rounded"
										alt="First slide"> <a
										class="btn px-4 py-2 text-white rounded">${d.ten_loai_hang}</a>
								</div>
							</c:forEach>
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselId" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselId" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Hero End -->


	<!-- Featurs Section Start -->
	<div class="container-fluid featurs py-5">
		<div class="container py-5">
			<div class="row g-4">
				<div class="col-md-6 col-lg-3">
					<div class="featurs-item text-center rounded bg-light p-4">
						<div
							class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
							<i class="fas fa-car-side fa-3x text-white"></i>
						</div>
						<div class="featurs-content text-center">
							<h5>Miễn phí vận chuyển</h5>
							<p class="mb-0">Đơn hàng trên 1 triệu</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="featurs-item text-center rounded bg-light p-4">
						<div
							class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
							<i class="fas fa-user-shield fa-3x text-white"></i>
						</div>
						<div class="featurs-content text-center">
							<h5>Thanh toán bảo mật</h5>
							<p class="mb-0">Bảo đảm 100%</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="featurs-item text-center rounded bg-light p-4">
						<div
							class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
							<i class="fas fa-exchange-alt fa-3x text-white"></i>
						</div>
						<div class="featurs-content text-center">
							<h5>Hoàn trả trong 30 ngày</h5>
							<p class="mb-0">Đảm bảo tiền 30 ngày</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<div class="featurs-item text-center rounded bg-light p-4">
						<div
							class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
							<i class="fa fa-phone-alt fa-3x text-white"></i>
						</div>
						<div class="featurs-content text-center">
							<h5>Hỗ trợ 24/7</h5>
							<p class="mb-0">Hỗ trợ nhanh chóng mọi lúc</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Featurs Section End -->

	<!-- Featurs Start -->
	<div class="container-fluid service py-5">
		<div class="container py-5">
			<div class="row g-4 justify-content-center">
				<div class="col-md-6 col-lg-4">
					<a href="hanghoa">
						<div
							class="service-item bg-secondary rounded border border-secondary">
							<img src="page/img/loai_hh/thit_haisan.png"
								class="img-fluid rounded-top w-100" alt="">
							<div class="px-4 rounded-bottom">
								<div class="service-content bg-primary text-center p-4 rounded">
									<h5 class="text-white">Thịt - Hải sản tươi</h5>
									<h3 class="mb-0">Đang Sale sập sàn</h3>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a href="hanghoa">
						<div class="service-item bg-dark rounded border border-dark">
							<img src="page/img/loai_hh/banh_keo.png"
								class="img-fluid rounded-top w-100" alt="">
							<div class="px-4 rounded-bottom">
								<div class="service-content bg-light text-center p-4 rounded">
									<h5 class="text-primary">Bánh kẹo</h5>
									<h3 class="mb-0">Chính hãng nổi tiếng</h3>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a href="hanghoa">
						<div class="service-item bg-primary rounded border border-primary">
							<img src="page/img/loai_hh/sua.png"
								class="img-fluid rounded-top w-100" alt="">
							<div class="px-4 rounded-bottom">
								<div
									class="service-content bg-secondary text-center p-4 rounded">
									<h5 class="text-white">Sữa</h5>
									<h3 class="mb-0">Chỉ từ 5000VNĐ</h3>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Featurs End -->


	<!-- Banner Section Start-->
	<div class="container-fluid banner bg-secondary my-5">
		<div class="container py-5">
			<div class="row g-4 align-items-center">
				<div class="col-lg-6">
					<div class="py-4">
						<h1 class="display-3 text-white">Rau - Củ - Trái cây tươi
							ngon trong cửa hàng Ogani</h1>
						<a href="hanghoa"
							class="banner-btn btn border-2 border-white rounded-pill text-dark py-3 px-5">Mua
							ngay</a>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="position-relative">
						<img src="page/img/loai_hh/20240610130551_rau_cu_qua.png"
							class="img-fluid w-100 rounded" alt=""
							style="width: 636px; height: 583px;">
						<div
							class="d-flex align-items-center justify-content-center bg-white rounded-circle position-absolute"
							style="width: 250px; height: 250px; top: 350px; left: 0;">
							<h1 style="font-size: 100px;">10</h1>
							<div class="d-flex flex-column">
								<span class="h2 mb-0">000VNĐ</span> <span
									class="h4 text-muted mb-0">kg</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner Section End -->


	<!-- Bestsaler Product Start -->
	<div class="container-fluid py-5">
		<div class="container py-5">
			<div class="text-center mx-auto mb-5" style="max-width: 700px;">
				<h1 class="display-4">Sản phẩm bán chạy nhất</h1>
			</div>
			<%
			DAO_Hang_Hoa hanghoa = new DAO_Hang_Hoa();
			List<Hang_Hoa> listhh = hanghoa.top6_SP_BC();
			request.setAttribute("listhh", listhh);
			%>
			<div class="row g-4">
				<c:forEach var="d1" items="${listhh}" varStatus="status">
					<div class="col-md-6 col-lg-6 col-xl-3">
						<div class="text-center">
							<img src="page/img/hanghoa/${d1.anh}"
								class="img-fluid rounded border border-secondary" alt=""
								style="width: 500px; height: 350px;">
							<div
								class="py-2 border border-secondary border-top-0 rounded-bottom">
								<a href="thongtinhh?ma_hang=${d1.ma_hang}" class="h3">${d1.ten_hang}</a>
								<div class="d-flex my-3 justify-content-center">
									<i class="fas fa-star text-primary"></i> <i
										class="fas fa-star text-primary"></i> <i
										class="fas fa-star text-primary"></i> <i
										class="fas fa-star text-primary"></i> <i
										class="fas fa-star text-primary"></i>
								</div>
								<p
									class="text-dark fs-6 fw-bold mb-2 d-flex justify-content-start ms-4">Mã
									hàng hóa: HH_${d1.ma_hang}</p>
								<p
									class="text-dark fs-6 fw-bold mb-2 d-flex justify-content-start ms-4">Số
									lượng tồn: ${d1.so_luong}</p>
								<p
									class="text-dark fs-6 fw-bold mb-2 d-flex justify-content-start ms-4">Ghi
									chú: ${d1.ghi_chu}</p>
								<h4 class="mb-3">
									<fmt:formatNumber value="${d1.gia_ban}" type="number" />
									đ / ${d1.don_vi_tinh}
								</h4>
								<a href="themhhgiohang?ma_hang=${d1.ma_hang}&so_luong=1"
									onclick="err('${d1.ten_hang}', ${d1.so_luong})"
									class="btn border border-secondary rounded-pill px-3 text-primary"><i
									class="fa fa-shopping-bag me-2 text-primary"></i> Thêm vào giỏ
									hàng</a>
							</div>
						</div>
					</div>
				</c:forEach>
				<script>
                    function err(ten_hang, so_luong) {
                    	if(so_luong == 0){
                    		alert(ten_hang + " còn tồn " + so_luong + ". Vui lòng chọn mặt hàng khác");
                    	}
                    }
                </script>
			</div>
		</div>
	</div>
	<!-- Bestsaler Product End -->


	<!-- Fact Start -->
	<div class="container-fluid py-5">
		<div class="container">
			<div class="bg-light p-5 rounded">
				<div class="row g-4 justify-content-center">
					<div class="col-md-6 col-lg-6 col-xl-3">
						<div class="counter bg-white rounded p-5">
							<i class="fa fa-users text-secondary"></i>
							<h4>Khách hàng hài lòng</h4>
							<h1>10</h1>
						</div>
					</div>
					<div class="col-md-6 col-lg-6 col-xl-3">
						<div class="counter bg-white rounded p-5">
							<i class="fa fa-signal text-secondary"></i>
							<h4>Chất lượng dịch vụ</h4>
							<h1>99%</h1>
						</div>
					</div>
					<div class="col-md-6 col-lg-6 col-xl-3">
						<div class="counter bg-white rounded p-5">
							<i class="fa fa-file text-secondary"></i>
							<h4>Giấy chứng nhận chất lượng</h4>
							<h1>3</h1>
						</div>
					</div>
					<div class="col-md-6 col-lg-6 col-xl-3">
						<div class="counter bg-white rounded p-5">
							<i class="fa fa-sitemap text-secondary"></i>
							<h4>Hàng hóa có sẵn</h4>
							<h1>33</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Fact Start -->


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