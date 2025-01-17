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
						<h1 class="page-header">Hóa đơn bán hàng</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example" style="font-size: 1.2em;">
										<thead>
											<tr>
												<th style="width: 30px;">STT</th>
												<th style="width: 60px;">Mã hóa đơn</th>
												<th style="width: 110px;">Tên khách hàng</th>
												<th style="width: 110px;">Tên nhân viên</th>
												<th style="width: 150px;">Thời gian đặt hđ</th>
												<th style="width: 100px;">Tổng tiền hđ</th>
												<th style="width: 100px;">Trạng thái</th>
												<th style="width: 260px;">Xử lý hóa đơn</th>
												<th></th>
											</tr>
										</thead>
										<tbody style="text-align: center;">
											<c:forEach items="${requestScope.data}" var="d"
												varStatus="status">
												<tr class="odd gradeX">
													<td style="vertical-align: middle;">${status.index + 1}</td>
													<td style="vertical-align: middle;">HDBH_${d.ma_hd_bh}</td>
													<td style="vertical-align: middle;">${d.ten_kh}</td>
													<td style="vertical-align: middle;">${d.ten_nv}</td>
													<td style="vertical-align: middle;">${d.ngay_xuat_hd}</td>
													<td style="vertical-align: middle;"><fmt:formatNumber
															value="${d.tong_tien}" type="number" />đ</td>
													<td style="vertical-align: middle;">${d.trang_thai}</td>
													<td style="vertical-align: middle;">
														<a href="/QL_BH/admin/hdbanhang?duyethd=1&ma_hd_bh=${d.ma_hd_bh}&id_nv=${sessionScope.account.id_nv}"
														   class="btn btn-danger text-white"
														   <c:if test='${d.trang_thai != "Đang xử lý"}'>disabled</c:if>>
														   Duyệt hđ
														</a>&nbsp;&nbsp;&nbsp; 
														<a href="/QL_BH/admin/hdbanhang?duyethd=2&ma_hd_bh=${d.ma_hd_bh}"
														class=" btn btn-success text-white" <c:if test='${d.trang_thai != "Đang giao hàng"}'>disabled</c:if>>Giao hàng
															thành công</a></td>
													<td style="vertical-align: middle;"><a href="xcthoadonbh?ma_hd_bh=${d.ma_hd_bh}"
														class="btn btn-info text-white">Xem chi tiết</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
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