<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<style>
th, tbody {
	text-align: center;
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
					<li class="active">
                        <a href="#"><i class="fa fa-wpforms fa-fw"></i> Hóa đơn<span
						class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="hdbanhang" class="active">Bán hàng</a></li>
							<li><a href="hd_nh.html">Nhập hàng</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Thống kê<span
						class="fa arrow"></span></a>
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
						<h1 class="page-header">Chi tiết hóa đơn bán hàng</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-xlg-12 col-md-12  ">
						<div class="card">
							<div class="card-body">
								<c:set var="c1" value="${requestScope.data1}" />
								<form class="form-horizontal form-material mx-2">
									<div class="form-group">
										<label class="col-md-6 mb-0">Mã hóa đơn: </label> <label
											class="col-md-6 mb-0">Tên khách hàng: </label>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												readonly value="${c1.ma_hd_bh}" />
										</div>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												readonly value="${c1.ten_kh}" />
										</div>
									</div>
									<div class="form-group">
										<label for="example-email" class="col-md-6">Tên nhân
											viên:</label> <label class="col-md-6 mb-0">Thời gian đặt
											hàng:</label>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line"
												name="example-email" id="example-email" required readonly
												value="${c1.ten_nv}" />
										</div>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												readonly value="${c1.ngay_xuat_hd}" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-6 mb-0">Tổng tiền:</label> <label
											class="col-md-6 mb-0">Trạng thái:</label>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												readonly
												value="<fmt:formatNumber
															value="${c1.tong_tien}" type="number" />đ" />
										</div>
										<div class="col-md-6">
											<input type="text" placeholder=""
												class="form-control ps-0 form-control-line" required
												readonly value="${c1.trang_thai}" />
										</div>
									</div>
									<h3 class="center">Danh sách hàng hóa đã mua</h3>
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="dataTables-example" style="font-size: 1.2em;">
											<thead>
												<tr>
													<th style="width: 30px; text-align: center;">STT</th>
													<th style="width: 60px; text-align: center;">Mã hàng
														hóa</th>
													<th style="width: 210px; text-align: center;">Tên hàng
														hóa</th>
													<th style="width: 60px; text-align: center;">Số lượng</th>
													<th style="width: 60px; text-align: center;">Giá bán</th>
													<th style="width: 100px; text-align: center;">Thành
														tiền</th>
												</tr>
											</thead>
											<tbody style="text-align: center;">
												<c:forEach items="${requestScope.data2}" var="c2"
													varStatus="status">
													<tr class="odd gradeX">
														<td style="vertical-align: middle;">${status.index + 1}</td>
														<td style="vertical-align: middle;">HH_${c2.ma_hang}</td>
														<td style="vertical-align: middle;">${c2.ten_hang}</td>
														<td style="vertical-align: middle;">${c2.so_luong}</td>
														<td style="vertical-align: middle;">${c2.gia_ban}</td>
														<td style="vertical-align: middle;">${c2.thanh_tien}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="form-group">
										<div class="col-sm-12 d-flex">
											<a href="hdbanhang"
												class="btn btn-info mx-auto mx-md-0 text-white"> Thoát</a>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>

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