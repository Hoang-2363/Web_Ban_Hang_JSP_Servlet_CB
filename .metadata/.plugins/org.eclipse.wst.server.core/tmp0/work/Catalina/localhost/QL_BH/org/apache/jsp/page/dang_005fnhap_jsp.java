/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.24
 * Generated at: 2024-06-09 09:05:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class dang_005fnhap_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Siêu thị Ogani</title>\r\n");
      out.write("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("<meta content=\"\" name=\"keywords\">\r\n");
      out.write("<meta content=\"\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("<!-- Google Web Fonts -->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Icon Font Stylesheet -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://use.fontawesome.com/releases/v5.15.4/css/all.css\" />\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Libraries Stylesheet -->\r\n");
      out.write("<link href=\"page/lib/lightbox/css/lightbox.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"page/lib/owlcarousel/assets/owl.carousel.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("<link href=\"page/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Template Stylesheet -->\r\n");
      out.write("<link href=\"page/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"page/img/title.ico\">\r\n");
      out.write("<style>\r\n");
      out.write(".input-container .fa-eye {\r\n");
      out.write("	position: absolute;\r\n");
      out.write("	top: 44%;\r\n");
      out.write("	right: 265px;\r\n");
      out.write("	transform: translateY(-50%);\r\n");
      out.write("	font-size: 1.5em;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"bg-info\">\r\n");
      out.write("	");

	String status = (String) request.getAttribute("status");
	if (status != null && status.equals("failed")) {
	
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		function showErrorDialog() {\r\n");
      out.write("			alert(\"Tên đăng nhập hoặc mật khẩu không chính xác. Vui lòng thử lại.\");\r\n");
      out.write("		}\r\n");
      out.write("		window.onload = function() {\r\n");
      out.write("			showErrorDialog();\r\n");
      out.write("		};\r\n");
      out.write("	</script>\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("	<div class=\"container-fluid contact\">\r\n");
      out.write("		<div class=\"container py-5\">\r\n");
      out.write("			<div class=\"p-5 bg-light rounded\">\r\n");
      out.write("				<div class=\"row g-4\">\r\n");
      out.write("					<div class=\"col-lg-5\">\r\n");
      out.write("						<div class=\"carousel-item active rounded\">\r\n");
      out.write("							<img src=\"page/img/login.jpg\"\r\n");
      out.write("								class=\"img-fluid w-100 h-160 bg-secondary rounded\"\r\n");
      out.write("								alt=\"First slide\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-lg-7\">\r\n");
      out.write("						<form action=\"trangchu\" method=\"post\">\r\n");
      out.write("							<h2 class=\"d-flex justify-content-center mt-3 mb-4\">Chào\r\n");
      out.write("								mừng bạn đến với siêu thị Ogani</h2>\r\n");
      out.write("							<label class=\"fs-5 fw-bold pb-1\" for=\"tk\">Tài khoản</label> <input\r\n");
      out.write("								type=\"text\" class=\"w-100 form-control py-3 mb-4 fw-bold\" id=\"tk\"\r\n");
      out.write("								name=\"tai_khoan\" required> <label\r\n");
      out.write("								class=\"fs-5 fw-bold pb-1\" for=\"mk\">Mật khẩu</label>\r\n");
      out.write("							<div class=\"col-md-12 input-container\">\r\n");
      out.write("								<input type=\"password\"\r\n");
      out.write("									class=\"w-100 form-control py-3 mb-3 fw-bold\" id=\"password_show\"\r\n");
      out.write("									name=\"mat_khau\" required> <i class=\"fa fa-eye fa-fw\"\r\n");
      out.write("									id=\"toggle-password\"></i>\r\n");
      out.write("							</div>\r\n");
      out.write("							<script>\r\n");
      out.write("								document\r\n");
      out.write("										.getElementById('toggle-password')\r\n");
      out.write("										.addEventListener(\r\n");
      out.write("												'click',\r\n");
      out.write("												function() {\r\n");
      out.write("													const passwordField = document\r\n");
      out.write("															.getElementById('password_show');\r\n");
      out.write("													const type = passwordField\r\n");
      out.write("															.getAttribute('type') === 'password' ? 'text'\r\n");
      out.write("															: 'password';\r\n");
      out.write("													passwordField.setAttribute(\r\n");
      out.write("															'type', type);\r\n");
      out.write("													this.classList\r\n");
      out.write("															.toggle('fa-eye-slash');\r\n");
      out.write("												});\r\n");
      out.write("							</script>\r\n");
      out.write("							<input type=\"checkbox\" class=\"form-check-input\" id=\"ntk\">\r\n");
      out.write("							<label class=\"form-check-label fs-6 fw-bold\" for=\"ntk\">Nhớ\r\n");
      out.write("								tài khoản</label> <a href=\"forgot\"\r\n");
      out.write("								class=\"float-end fs-6 fw-bold text-decoration-underline\">Quên\r\n");
      out.write("								mật khẩu?</a>\r\n");
      out.write("							<button\r\n");
      out.write("								class=\"w-100 btn form-control border-secondary py-2 bg-white text-primary fs-4 mt-3\"\r\n");
      out.write("								type=\"submit\">Đăng nhập</button>\r\n");
      out.write("						</form>\r\n");
      out.write("						<div class=\"d-flex justify-content-center fs-6 fw-bold mt-3\">\r\n");
      out.write("							Bạn chưa có tài khoản? &nbsp;<a href=\"signup\"\r\n");
      out.write("								class=\"text-decoration-underline\">Tạo tài khoản mới!</a>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"d-flex justify-content-center fs-6 fw-bold mt-3\">\r\n");
      out.write("							<a href=\"trangchu\" class=\"text-decoration-underline\">Vào trang web không cần đăng nhập</a>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!-- JavaScript Libraries -->\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("	<script src=\"page/lib/easing/easing.min.js\"></script>\r\n");
      out.write("	<script src=\"page/lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("	<script src=\"page/lib/lightbox/js/lightbox.min.js\"></script>\r\n");
      out.write("	<script src=\"page/lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Template Javascript -->\r\n");
      out.write("	<script src=\"page/js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
