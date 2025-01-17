<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Siêu thị Organi</title>
<!-- Icon Title -->
<link rel="icon" type="image/x-icon" href="../page/img/title.ico">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/startmin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
<style>
.input-container .fa-eye {
	position: absolute;
	top: 50%;
	right: 30px;
	transform: translateY(-50%);
	font-size: 1.5em;
}
</style>
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<ul class="nav navbar-nav navbar-left navbar-top-links">
				<li><a href="http://localhost:8000/QL_BH/"><i
						class="fa fa-home fa-fw"></i> Website</a></li>
			</ul>

			<ul class="nav navbar-right navbar-top-links">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						Xin chào, ${sessionScope.account.ho_ten_nv}<b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="thongtintk"><i class="fa fa-user fa-fw"></i>
								Thông tin tài khoản</a></li>

						<li class="divider"></li>
						<li><a href="dangxuat"><i class="fa fa-sign-out fa-fw"></i>
								Đăng xuất</a></li>
					</ul></li>
			</ul>
			<!-- /.navbar-top-links -->
		</nav>

		<aside class="sidebar navbar-default" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="text-center"><img src="../page/img/logo.png"></li>
					<li><a href="trangchu" class="active"><i
							class="fa fa-dashboard fa-fw"></i> Tổng quan</a></li>

					<li><a href="hanghoa"><i class="fa fa-table fa-fw"></i>
							Hàng hóa</a></li>
					<li><a href="nhacungcap"><i class="fa fa-cubes fa-fw"></i>
							Nhà cung cấp</a></li>
					<li><a href="loaihanghoa"><i class="fa fa-sitemap fa-fw"></i>
							Loại hàng hóa</a></li>
					<li><a href="#"><i
							class="fa fa-wpforms fa-fw"></i> Hóa đơn<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="hdbanhang">Bán hàng</a></li>
							<li><a href="hd_nh.html">Nhập hàng</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
							Thống kê<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="tk_dt_bh.html">Doanh thu bán hàng</a></li>
							<li><a href="tk_cp_nh.html">Chi phí nhập hàng</a></li>
							<li><a href="tk_kh.html">Khách hàng</a></li>
							<li><a href="tk_sp.html">Sản phẩm</a></li>
						</ul></li>
					<li><a href="khachhang"><i class="fa fa-users fa-fw"></i>
							Khách hàng</a></li>
					<li><a href="nhan_vien.jsp"><i class="fa fa-user fa-fw"></i>
							Nhân viên</a></li>
					<li><a href="thongtintk"><i
							class="fa fa-user-circle fa-fw"></i> Thông tin tài khoản</a></li>
				</ul>
			</div>
		</aside>
		<!-- /.sidebar -->

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Thông tin tài khoản</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<div class="container-fluid">
				<form class="form-horizontal form-material mx-2" action="thongtintk"
					method="post" enctype="multipart/form-data">
					<div class="row">
						<!-- Column -->
						<div class="col-lg-3 col-xlg-3 col-md-5">
							<div class="card">
								<div class="card-body profile-card">
									<center class="mt-3">
										<center class="mt-3">
											<img id="previewImage"
												src="image/${sessionScope.account.anh}"
												class="rounded-circle" width="150" height="150" /> <br />
											<br /> <input type="file" id="fileInput" name="file"
												style="display: none;">
											<button type="button"
												onclick="document.getElementById('fileInput').click();">Chọn
												File</button>
											<input type="text" id="fileName"
												value="${sessionScope.account.anh}" readonly name="anh">
											<script>
												document
														.getElementById(
																'fileInput')
														.addEventListener(
																'change',
																function() {
																	var file = this.files[0];
																	if (file) {
																		var reader = new FileReader();
																		reader.onload = function(
																				e) {
																			document
																					.getElementById('previewImage').src = e.target.result;
																		};
																		reader
																				.readAsDataURL(file);
																		document
																				.getElementById('fileName').value = file.name;
																	}
																});
											</script>
								</div>
							</div>
						</div>
						<!-- Column -->
						<div class="col-lg-9 col-xlg-9 col-md-7">
							<div class="card">
								<div class="card-body">
									<div class="form-group">
										<label class="col-md-12 mb-0">Họ và tên: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${sessionScope.account.ho_ten_nv}" name="ho_ten_nv" />
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line hidden" required
												value="${sessionScope.account.id_nv}" name="id_nv" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Chức vụ: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${sessionScope.account.chuc_vu}" name="chuc_vu"
												readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Địa chỉ: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${sessionScope.account.dia_chi}" name="dia_chi" />
										</div>
									</div>
									<div class="form-group">
										<label for="example-email" class="col-md-12">Gmail</label>
										<div class="col-md-12">
											<input type="email" placeholder=""
												class="form-control ps-0 form-control-line"
												id="example-email" required
												value="${sessionScope.account.email}" name="email" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-12 mb-0">Số điện thoại</label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${sessionScope.account.sdt}" name="sdt" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Tài khoản</label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${sessionScope.account.tai_khoan}" name="tai_khoan" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Mật khẩu</label>
										<div class="col-md-12 input-container">
											<input type="password"
												class="form-control ps-0 form-control-line" required
												id="password_show" value="${sessionScope.account.mat_khau}"
												name="mat_khau" /> <i class="fa fa-eye fa-fw"
												id="toggle-password"></i>
										</div>
									</div>
									<script>
										document
												.getElementById(
														'toggle-password')
												.addEventListener(
														'click',
														function() {
															const passwordField = document
																	.getElementById('password_show');
															const type = passwordField
																	.getAttribute('type') === 'password' ? 'text'
																	: 'password';
															passwordField
																	.setAttribute(
																			'type',
																			type);
															this.classList
																	.toggle('fa-eye-slash');
														});
									</script>

									<div class="form-group">
										<div class="col-sm-12 d-flex">
											<input type="submit"
												class="btn btn-success mx-auto mx-md-0 text-white"
												value="Cập nhật thông tin" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Column -->
					</div>
				</form>
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/startmin.js"></script>

</body>

</html>