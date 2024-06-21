package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import admin.model.Nhan_Vien;

import java.io.IOException;

import admin.dal.DAO_Nhan_Vien;

@WebServlet("/admin/trangchu")
public class Login_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("trang_admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tai_khoan = request.getParameter("tai_khoan");
		String mat_khau = request.getParameter("mat_khau");
		DAO_Nhan_Vien d = new DAO_Nhan_Vien();
		Nhan_Vien nv = d.check(tai_khoan, mat_khau);
		System.out.println(nv);
		HttpSession session = request.getSession();
		if (nv == null) {
			request.setAttribute("status", "failed");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			session.setAttribute("account", nv);
			request.getRequestDispatcher("trang_admin.jsp").forward(request, response);
		}
	}

}
