<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<!-- DataTables CSS -->
<link href="css/dataTables/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="css/dataTables/dataTables.responsive.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/startmin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

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

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Thêm nhà cung cấp mới</h1>
						<h3 style="color: red">${requestScope.error}</h3>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<div class="container-fluid">
				<form class="form-horizontal form-material mx-2"
					action="themnhacungcap">
					<div class="row">
						<div class="col-lg-12 col-xlg-12 col-md-12">
							<div class="card">
								<div class="card-body">
									<div class="form-group">
										<label class="col-md-12 mb-0">Mã nhà cung cấp: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.ma_nha_cung_cap}" name="ma_nha_cung_cap" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Tên nhà cung cấp: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.ten_nha_cung_cap}" name="ten_nha_cung_cap" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Địa chỉ: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.dia_chi}" name="dia_chi" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Số điện thoại: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.sdt}" name="sdt" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Email: </label>
										<div class="col-md-12">
											<input type="email" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.email}" name="email" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-12 d-flex">
											<a class="btn btn-info mx-auto mx-md-0 text-white"
												href="nhacungcap">Thoát</a> <input type="submit"
												class="btn btn-success mx-auto mx-md-0 text-white"
												value="Thêm nhà cung cấp" />
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
	</div>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="js/dataTables/jquery.dataTables.min.js"></script>
	<script src="js/dataTables/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/startmin.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>

</html>