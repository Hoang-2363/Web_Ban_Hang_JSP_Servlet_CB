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
								<a href="dathang" class="dropdown-item fs-5">Thanh toán</a> <a
									href="theodoidh" class="dropdown-item fs-5">Theo dõi đơn
									hàng</a><a href="tinnhankh" class="dropdown-item fs-5">Phản hồi
									khách hàng</a>
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
		<h1 class="text-center text-white display-6">Hàng hóa</h1>
		<ol class="breadcrumb justify-content-center mb-0">
			<li class="breadcrumb-item"><a href="trangchu">Trang chủ</a></li>
			<li class="breadcrumb-item active text-white">Hàng hóa</li>
		</ol>
	</div>
	<!-- Single Page Header End -->


	<!-- Fruits Shop Start-->
	<div class="container-fluid fruite py-5">
		<div class="container py-5">
			<h1 class="mb-4">Danh sách hàng hóa</h1>
			<div class="row g-4">
				<div class="col-lg-12">
					<div class="row g-4">
						<div class="col-xl-3">
							<c:set var="tu_khoa" value="${requestScope.tu_khoa}" />
							<form action="hanghoa">
								<div class="input-group w-100 mx-auto d-flex">
									<input type="text" class="form-control p-3"
										<c:if test='${tu_khoa == ""}'> placeholder="Thông tin hàng hóa ..."</c:if>
										<c:if test='${tu_khoa != null}'> value="${tu_khoa}"</c:if>
										aria-describedby="search-icon-1" name="tu_khoa">
									<button id="search-icon-1" class="input-group-text p-3"
										type="submit">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</form>
						</div>
						<div class="col-6"></div>
						<div class="col-xl-3">
							<div
								class="bg-light ps-3 py-3 rounded d-flex justify-content-between mb-4">
								<label for="fruits">Sắp xếp:</label>
								<c:set var="sort" value="${requestScope.sort}" />
								<select id="fruits" onchange="navigateToPage()" name="fruitlist"
									class="form-select-sm bg-light me-3">
									<option value="hanghoa">Mặc định</option>
									<option value="hanghoa?sort=desc"
										<c:if test='${sort == "desc"}'> selected</c:if>>Giá
										giảm dần</option>
									<option value="hanghoa?sort=asc"
										<c:if test='${sort == "asc"}'> selected</c:if>>Giá
										tăng dần</option>
								</select>

								<script>
								function navigateToPage() {
								    const selectElement = document.getElementById('fruits');
								    const selectedValue = selectElement.value;
								
								    window.location.href = selectedValue;
								}
								</script>
							</div>
						</div>
					</div>
					<div class="row g-4">
						<div class="col-lg-3">
							<div class="row g-4">
								<div class="col-lg-12">
									<div class="mb-3">
										<h4>Loại hàng hóa</h4>
										<ul class="list-unstyled fruite-categorie">
											<c:set var="ma_lh" value="${requestScope.ma_lh}" />
											<c:forEach var="d1" items="${requestScope.data1}">
												<li>
													<div
														class="d-flex justify-content-between fruite-name fw-bold fs-5">
														<a href="hanghoa?ma_lh=${d1.ma_loai_hang}"><i
															class="fas fa-apple-alt me-2"></i>${d1.ten_loai_hang}</a> <span>${d1.count}</span>
													</div>
												</li>
											</c:forEach>

										</ul>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="mb-3">
										<c:set var="gia_ban" value="${requestScope.gia_ban}" />
										<form id="myForm" action="hanghoa" method="GET">
											<input type="hidden" id="rangeValue" name="gia_ban">
											<h4 class="mb-2">Giá</h4>
											<input type="range" class="form-range w-100" id="rangeInput"
												min="0" max="2000000"
												value="<c:if test='${gia_ban == null}'>0</c:if><c:if test='${gia_ban != null}'>${gia_ban}</c:if>"
												oninput="updateOutput(this.value)" onchange="submitForm()">
											<output id="amount" name="amount" for="rangeInput"
												class="fw-bold fs-5">
												<c:if test='${gia_ban == null}'>0</c:if>
												<c:if test='${gia_ban != null}'>${gia_ban}</c:if>
												đ
											</output>

											<script>
										        function updateOutput(value) {
										            const formattedValue = new Intl.NumberFormat().format(value) + ' đ';
										            document.getElementById('amount').innerText = formattedValue;
										            document.getElementById('rangeValue').value = value;
										        }
										
										        function submitForm() {
										            document.getElementById('myForm').submit();
										        }
										
										        document.addEventListener('DOMContentLoaded', (event) => {
										            updateOutput(document.getElementById('rangeInput').value);
										        });
										    </script>
										</form>

									</div>
								</div>
								<c:set var="data2" value="${requestScope.data2}" />
								<c:set var="ma_ncc_bol" value="${requestScope.ma_ncc_bol}" />
								<form action="hanghoa">
									<div class="col-lg-12">
										<div class="mb-3">
											<h4>Nhà cung cấp</h4>
											<c:forEach begin="0" end="${data2.size()-1}" var="i">
												<div class="mb-2">
													<div class="row">
														<div class="col-1 pt-2">
															<input type="checkbox" class="me-2" name="ma_ncc"
																value="${data2.get(i).getMa_nha_cung_cap()}"
																${ma_ncc_bol[i]?"checked":""}
																onclick="this.form.submit()">
														</div>
														<div class="col-11">
															<label class="fs-5 fw-bold">${data2.get(i).getTen_nha_cung_cap()}</label>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-lg-9">
							<div class="row g-4 justify-content-start">
								<c:forEach var="d" items="${requestScope.data}">
									<div class="col-md-6 col-lg-6 col-xl-4">
										<a class="rounded position-relative fruite-item"
											href="thongtinhh?ma_hang=${d.ma_hang}">
											<div class="fruite-img border border-secondary">
												<img src="page/img/hanghoa/${d.anh}"
													class="img-fluid w-100 rounded-top" alt="">
											</div>
											<div
												class="p-4 border border-secondary border-top-0 rounded-bottom">
												<h4
													class="d-flex justify-content-center text-dark fs-3 fw-bold">${d.ten_hang}</h4>
												<p class="text-dark fs-6 fw-bold mb-2">Mã hàng hóa:
													HH_${d.ma_hang}</p>
												<p class="text-dark fs-6 fw-bold mb-2">Số lượng tồn:
													${d.so_luong}</p>
												<p class="text-dark fs-6 fw-bold mb-2">Ghi chú:
													${d.ghi_chu}</p>
												<p
													class="text-dark fs-5 fw-bold mb-2 d-flex justify-content-center">
													<fmt:formatNumber value="${d.gia_ban}" type="number" />
													đ / ${d.don_vi_tinh}
												</p>
												<div class="d-flex justify-content-center flex-lg-wrap">
													<a href="themhhgiohang?ma_hang=${d.ma_hang}&so_luong=1"
														onclick="err('${d.ten_hang}', ${d.so_luong})"
														class="btn border border-secondary rounded-pill px-3 text-primary mt-2"><i
														class="fa fa-shopping-bag me-2 text-primary"></i> Thêm vào
														giỏ hàng</a>
												</div>
											</div>
										</a>
									</div>
								</c:forEach>
								
										<script>
                                            function err(ten_hang, so_luong) {
                                            	if(so_luong == 0){
                                            		alert(ten_hang + " còn tồn " + so_luong + ". Vui lòng chọn mặt hàng khác");
                                            	}
                                            }
                                        </script>
								<div class="col-12">
									<div class="pagination d-flex justify-content-center mt-5">
										<c:set var="page" value="${requestScope.page}" />
										<c:set var="port" value="${requestScope.port}" />
										<c:forEach begin="1" end="${requestScope.num}" var="i">
											<c:choose>
												<c:when
													test='${ma_lh == null && port == null && gia_ban == null && sort == null && tu_khoa == ""}'>
													<a class="${i == page ? 'active' : ''} rounded"
														href="<c:if test='${i == 1}'>hanghoa</c:if><c:if test='${i != 1}'>hanghoa?page=${i}</c:if>">${i}</a>
												</c:when>
												<c:when
													test='${ma_lh != null && gia_ban == null && sort == null && tu_khoa == null}'>
													<a class="${i == page ? 'active' : ''} rounded"
														href="<c:if test='${i == 1}'>hanghoa?ma_lh=${ma_lh}</c:if><c:if test='${i != 1}'>hanghoa?page=${i}&ma_lh=${ma_lh}</c:if>">${i}</a>
												</c:when>
												<c:when
													test='${gia_ban != null && ma_lh == null && sort == null && tu_khoa == null}'>
													<a class="${i == page ? 'active' : ''} rounded"
														href="<c:if test='${i == 1}'>hanghoa?gia_ban=${gia_ban}</c:if><c:if test='${i != 1}'>hanghoa?page=${i}&gia_ban=${gia_ban}</c:if>">${i}</a>
												</c:when>
												<c:when
													test='${sort != null && ma_lh == null && gia_ban == null && tu_khoa == null}'>
													<a class="${i == page ? 'active' : ''} rounded"
														href="<c:if test='${i == 1}'>hanghoa?sort=${sort}</c:if><c:if test='${i != 1}'>hanghoa?page=${i}&sort=${sort}</c:if>">${i}</a>
												</c:when>
												<c:when
													test='${sort == null && ma_lh == null && gia_ban == null && tu_khoa != null}'>
													<a class="${i == page ? 'active' : ''} rounded"
														href="<c:if test='${i == 1}'>hanghoa?tu_khoa=${tu_khoa}</c:if><c:if test='${i != 1}'>hanghoa?page=${i}&tu_khoa=${tu_khoa}</c:if>">${i}</a>
												</c:when>
												<c:otherwise>
													<a class="${i == page ? 'active' : ''} rounded"
														href="<c:if test='${i == 1}'>hanghoa?${port}</c:if><c:if test='${i != 1}'>hanghoa?page=${i}${port}</c:if>">${i}</a>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</div>
								</div>
							</div>
						</div>
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