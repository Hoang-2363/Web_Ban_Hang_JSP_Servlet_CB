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
</head>

<body>
	<%
	String status = (String) request.getAttribute("status");
	if (status != null && status.equals("failed")) {
	%>
	<script>
		function showErrorDialog() {
			alert("Tên đăng nhập hoặc mật khẩu không chính xác. Vui lòng thử lại.");
		}
		window.onload = function() {
			showErrorDialog();
		};
	</script>
	<%
	}
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="text-center">
						<img src="../page/img/logo.png" alt="" width="220" height="100"
							style="margin: 30px 0px 30px 0px;">
					</div>
					<div class="panel-heading">
						<h1 class="text-center">Đăng nhập</h1>
					</div>
					<div class="panel-body">
						<form role="form" action="trangchu" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Tài khoản"
										name="tai_khoan" type="text" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Mật khẩu"
										name="mat_khau" type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me">Nhớ tài khoản
									</label>
								</div>
								<input type="submit" class="btn btn-lg btn-success btn-block"
									value="Đăng nhập" />
							</fieldset>
						</form>
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

	<!-- Custom Theme JavaScript -->
	<script src="js/startmin.js"></script>

</body>

</html>