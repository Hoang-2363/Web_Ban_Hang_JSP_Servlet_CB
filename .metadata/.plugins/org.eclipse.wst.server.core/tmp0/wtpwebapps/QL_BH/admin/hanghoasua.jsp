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
						<h1 class="page-header">Sửa thông tin hàng hóa</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<div class="container-fluid">
				<c:set var="c" value="${requestScope.hh}" />
				<form class="form-horizontal form-material mx-2" action="suahanghoa"
					method="post" enctype="multipart/form-data">
					<div class="row">
						<!-- Column -->
						<div class="col-lg-3 col-xlg-3 col-md-5">
							<div class="card">
								<div class="card-body profile-card">
									<center class="mt-3">
										<img id="previewImage" src="../page/img/hanghoa/${c.anh}"
											class="rounded-circle" width="150" height="150" /> <br /> <br />
										<input type="file" id="fileInput" name="file"
											style="display: none;">
										<button type="button"
											onclick="document.getElementById('fileInput').click();">Chọn
											File</button>
										<input type="text" id="fileName" value="${c.anh}" readonly
											name="anh">
										<script>
											document
													.getElementById('fileInput')
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
									</center>

								</div>
							</div>
						</div>
						<!-- Column -->
						<div class="col-lg-9 col-xlg-9 col-md-7">
							<div class="card">
								<div class="card-body">
									<div class="form-group">
										<label class="col-md-12 mb-0">Mã hàng hóa: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.ma_hang}" readonly="readonly" name="ma_hang" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Tên hàng hóa: </label>
										<div class="col-md-12">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.ten_hang}" name="ten_hang" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-6 mb-0">Giá nhập: </label> <label
											class="col-md-6 mb-0">Giá bán: </label>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.gia_nhap}" name="gia_nhap" />
										</div>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.gia_ban}" name="gia_ban" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-6 mb-0">Số lượng tồn: </label> <label
											for="dvt" class="col-md-6 mb-0">Đơn vị tính:</label>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												value="${c.so_luong}" name="so_luong" />
										</div>
										<div class="col-md-6">
											<select class="form-control" id="dvt" name="don_vi_tinh">
												<c:forEach items="${requestScope.dvt}" var="dvt">
													<option value="${dvt}"
														<c:if test="${c.don_vi_tinh == dvt}">selected="selected"</c:if>>${dvt}</option>
												</c:forEach>
											</select>
										</div>

									</div>
									<div class="form-group">
										<label class="col-md-12 mb-0">Ghi chú</label>
										<div class="col-md-12">
											<textarea rows="3"
												class="form-control ps-0 form-control-line"
												value="${c.ghi_chu}" name="ghi_chu"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="ma_ncc" class="col-md-6 mb-0">Mã nhà cung
											cấp:</label> <label for="ma_lhh" class="col-md-6 mb-0">Mã
											loại hàng hóa:</label>
										<div class="col-md-6">
											<select class="form-control" id="ma_ncc"
												name="ma_nha_cung_cap">
												<c:forEach items="${requestScope.ncc}" var="ncc">
													<option value="${ncc}"
														<c:if test="${requestScope.ten_ncc == ncc}">selected="selected"</c:if>>${ncc}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-md-6">
											<select class="form-control" id="ma_lhh" name="ma_loai_hang">
												<c:forEach items="${requestScope.lhh}" var="lhh">
													<option value="${lhh}"
														<c:if test="${requestScope.ten_lhh == lhh}">selected="selected"</c:if>>${lhh}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-12 d-flex">
											<a class="btn btn-info mx-auto mx-md-0 text-white"
												href="hanghoa">Thoát</a> <input type="submit"
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