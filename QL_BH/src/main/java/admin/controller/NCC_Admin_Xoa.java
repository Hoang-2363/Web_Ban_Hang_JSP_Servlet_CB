package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import admin.dal.DAO_NCC;

@WebServlet("/admin/xoanhacungcap")
public class NCC_Admin_Xoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_ncc = request.getParameter("ma_ncc");
		DAO_NCC ncc_DAO = new DAO_NCC();
		ncc_DAO.xoa_NCC(ma_ncc);
		response.sendRedirect("nhacungcap");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
