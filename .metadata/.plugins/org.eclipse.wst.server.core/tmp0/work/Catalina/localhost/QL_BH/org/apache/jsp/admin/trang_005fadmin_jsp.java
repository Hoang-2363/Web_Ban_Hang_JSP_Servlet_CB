/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.24
 * Generated at: 2024-06-19 05:29:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class trang_005fadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<title>Siêu thị Organi</title>\r\n");
      out.write("<!-- Icon Title -->\r\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"../page/img/title.ico\">\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap Core CSS -->\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- MetisMenu CSS -->\r\n");
      out.write("<link href=\"css/metisMenu.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Timeline CSS -->\r\n");
      out.write("<link href=\"css/timeline.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom CSS -->\r\n");
      out.write("<link href=\"css/startmin.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Morris Charts CSS -->\r\n");
      out.write("<link href=\"css/morris.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom Fonts -->\r\n");
      out.write("<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("		<!-- Navigation -->\r\n");
      out.write("		<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-left navbar-top-links\">\r\n");
      out.write("				<li><a href=\"http://localhost:8000/QL_BH/\"><i\r\n");
      out.write("						class=\"fa fa-home fa-fw\"></i> Website</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("\r\n");
      out.write("			<ul class=\"nav navbar-right navbar-top-links\">\r\n");
      out.write("				<li class=\"dropdown\"><a class=\"dropdown-toggle\"\r\n");
      out.write("					data-toggle=\"dropdown\" href=\"#\"> <i class=\"fa fa-user fa-fw\"></i>\r\n");
      out.write("						Xin chào, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.account.ho_ten_nv}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<b class=\"caret\"></b>\r\n");
      out.write("				</a>\r\n");
      out.write("					<ul class=\"dropdown-menu dropdown-user\">\r\n");
      out.write("						<li><a href=\"thongtintk\"><i class=\"fa fa-user fa-fw\"></i>\r\n");
      out.write("								Thông tin tài khoản</a></li>\r\n");
      out.write("\r\n");
      out.write("						<li class=\"divider\"></li>\r\n");
      out.write("						<li><a href=\"dangxuat\"><i class=\"fa fa-sign-out fa-fw\"></i>\r\n");
      out.write("								Đăng xuất</a></li>\r\n");
      out.write("					</ul></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			<!-- /.navbar-top-links -->\r\n");
      out.write("		</nav>\r\n");
      out.write("\r\n");
      out.write("		<aside class=\"sidebar navbar-default\" role=\"navigation\">\r\n");
      out.write("			<div class=\"sidebar-nav navbar-collapse\">\r\n");
      out.write("				<ul class=\"nav\" id=\"side-menu\">\r\n");
      out.write("					<li class=\"text-center\"><img src=\"../page/img/logo.png\"></li>\r\n");
      out.write("					<li><a href=\"trangchu\" class=\"active\"><i\r\n");
      out.write("							class=\"fa fa-dashboard fa-fw\"></i> Tổng quan</a></li>\r\n");
      out.write("\r\n");
      out.write("					<li><a href=\"hanghoa\"><i class=\"fa fa-table fa-fw\"></i>\r\n");
      out.write("							Hàng hóa</a></li>\r\n");
      out.write("					<li><a href=\"nhacungcap\"><i class=\"fa fa-cubes fa-fw\"></i>\r\n");
      out.write("							Nhà cung cấp</a></li>\r\n");
      out.write("					<li><a href=\"loaihanghoa\"><i class=\"fa fa-sitemap fa-fw\"></i>\r\n");
      out.write("							Loại hàng hóa</a></li>\r\n");
      out.write("					<li><a href=\"#\"><i\r\n");
      out.write("							class=\"fa fa-wpforms fa-fw\"></i> Hóa đơn<span class=\"fa arrow\"></span></a>\r\n");
      out.write("						<ul class=\"nav nav-second-level\">\r\n");
      out.write("							<li><a href=\"hdbanhang\">Bán hàng</a></li>\r\n");
      out.write("							<li><a href=\"hd_nh.html\">Nhập hàng</a></li>\r\n");
      out.write("						</ul></li>\r\n");
      out.write("					<li><a href=\"#\"><i class=\"fa fa-bar-chart-o fa-fw\"></i>\r\n");
      out.write("							Thống kê<span class=\"fa arrow\"></span></a>\r\n");
      out.write("						<ul class=\"nav nav-second-level\">\r\n");
      out.write("							<li><a href=\"tk_dt_bh.html\">Doanh thu bán hàng</a></li>\r\n");
      out.write("							<li><a href=\"tk_cp_nh.html\">Chi phí nhập hàng</a></li>\r\n");
      out.write("							<li><a href=\"tk_kh.html\">Khách hàng</a></li>\r\n");
      out.write("							<li><a href=\"tk_sp.html\">Sản phẩm</a></li>\r\n");
      out.write("						</ul></li>\r\n");
      out.write("					<li><a href=\"khachhang\"><i class=\"fa fa-users fa-fw\"></i>\r\n");
      out.write("							Khách hàng</a></li>\r\n");
      out.write("					<li><a href=\"nhan_vien.jsp\"><i class=\"fa fa-user fa-fw\"></i>\r\n");
      out.write("							Nhân viên</a></li>\r\n");
      out.write("					<li><a href=\"thongtintk\"><i\r\n");
      out.write("							class=\"fa fa-user-circle fa-fw\"></i> Thông tin tài khoản</a></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("		</aside>\r\n");
      out.write("		<!-- /.sidebar -->\r\n");
      out.write("\r\n");
      out.write("		<div id=\"page-wrapper\">\r\n");
      out.write("			<div class=\"container-fluid\">\r\n");
      out.write("				<div class=\"row\">\r\n");
      out.write("					<div class=\"col-lg-12\">\r\n");
      out.write("						<h1 class=\"page-header\">Tổng quan</h1>\r\n");
      out.write("					</div>\r\n");
      out.write("					<!-- /.col-lg-12 -->\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- /.row -->\r\n");
      out.write("				<div class=\"row\">\r\n");
      out.write("					<div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("						<div class=\"panel panel-primary\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<div class=\"row\">\r\n");
      out.write("									<div class=\"col-xs-3\">\r\n");
      out.write("										<i class=\"fa fa-comments fa-5x\"></i>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-xs-9 text-right\">\r\n");
      out.write("										<div class=\"huge\">26</div>\r\n");
      out.write("										<div>Sản phẩm</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<a href=\"#\">\r\n");
      out.write("								<div class=\"panel-footer\">\r\n");
      out.write("									<span class=\"pull-left\">Xem chi tiết</span> <span\r\n");
      out.write("										class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\r\n");
      out.write("\r\n");
      out.write("									<div class=\"clearfix\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</a>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("						<div class=\"panel panel-green\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<div class=\"row\">\r\n");
      out.write("									<div class=\"col-xs-3\">\r\n");
      out.write("										<i class=\"fa fa-tasks fa-5x\"></i>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-xs-9 text-right\">\r\n");
      out.write("										<div class=\"huge\">12</div>\r\n");
      out.write("										<div>Khách hàng</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<a href=\"#\">\r\n");
      out.write("								<div class=\"panel-footer\">\r\n");
      out.write("									<span class=\"pull-left\">Xem chi tiết</span> <span\r\n");
      out.write("										class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\r\n");
      out.write("\r\n");
      out.write("									<div class=\"clearfix\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</a>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("						<div class=\"panel panel-yellow\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<div class=\"row\">\r\n");
      out.write("									<div class=\"col-xs-3\">\r\n");
      out.write("										<i class=\"fa fa-shopping-cart fa-5x\"></i>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-xs-9 text-right\">\r\n");
      out.write("										<div class=\"huge\">124</div>\r\n");
      out.write("										<div>Hóa đơn bán hàng</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<a href=\"#\">\r\n");
      out.write("								<div class=\"panel-footer\">\r\n");
      out.write("									<span class=\"pull-left\">Xem chi tiết</span> <span\r\n");
      out.write("										class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\r\n");
      out.write("\r\n");
      out.write("									<div class=\"clearfix\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</a>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("						<div class=\"panel panel-red\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<div class=\"row\">\r\n");
      out.write("									<div class=\"col-xs-3\">\r\n");
      out.write("										<i class=\"fa fa-support fa-5x\"></i>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"col-xs-9 text-right\">\r\n");
      out.write("										<div class=\"huge\">13</div>\r\n");
      out.write("										<div>Hóa đơn nhập hàng</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<a href=\"#\">\r\n");
      out.write("								<div class=\"panel-footer\">\r\n");
      out.write("									<span class=\"pull-left\">Xem chi tiết</span> <span\r\n");
      out.write("										class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\r\n");
      out.write("\r\n");
      out.write("									<div class=\"clearfix\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</a>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<div class=\"row\">\r\n");
      out.write("					<div class=\"col-lg-12\">\r\n");
      out.write("						<div class=\"panel panel-default\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<i class=\"fa fa-bar-chart-o fa-fw\"></i> Area Chart Example\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"panel-body\">\r\n");
      out.write("								<div id=\"morris-area-chart\"></div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"panel panel-default\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<i class=\"fa fa-bar-chart-o fa-fw\"></i> Bar Chart Example\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"panel-body\">\r\n");
      out.write("								<div class=\"row\">\r\n");
      out.write("									<div class=\"col-lg-12\">\r\n");
      out.write("										<div id=\"morris-bar-chart\"></div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-lg-12\">\r\n");
      out.write("						<div class=\"panel panel-default\">\r\n");
      out.write("							<div class=\"panel-heading\">\r\n");
      out.write("								<i class=\"fa fa-bar-chart-o fa-fw\"></i> Donut Chart Example\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"panel-body\">\r\n");
      out.write("								<div id=\"morris-donut-chart\"></div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!-- jQuery -->\r\n");
      out.write("	<script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Bootstrap Core JavaScript -->\r\n");
      out.write("	<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Metis Menu Plugin JavaScript -->\r\n");
      out.write("	<script src=\"js/metisMenu.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Morris Charts JavaScript -->\r\n");
      out.write("	<script src=\"js/raphael.min.js\"></script>\r\n");
      out.write("	<script src=\"js/morris.min.js\"></script>\r\n");
      out.write("	<script src=\"js/morris-data.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Custom Theme JavaScript -->\r\n");
      out.write("	<script src=\"js/startmin.js\"></script>\r\n");
      out.write("\r\n");
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
