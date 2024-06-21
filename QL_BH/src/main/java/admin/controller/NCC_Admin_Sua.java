package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Nha_CC;

import java.io.IOException;

import admin.dal.DAO_NCC;

@WebServlet("/admin/suanhacungcap")
public class NCC_Admin_Sua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_ncc = request.getParameter("ma_ncc");
		DAO_NCC ncc_DAO = new DAO_NCC();
		Nha_CC ncc = ncc_DAO.getNCCByMaNCC(ma_ncc);
		request.setAttribute("ncc", ncc);
		request.getRequestDispatcher("nhacungcapsua.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ma_nha_cung_cap = request.getParameter("ma_nha_cung_cap");
		String ten_nha_cung_cap = request.getParameter("ten_nha_cung_cap");
		String dia_chi = request.getParameter("dia_chi");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		DAO_NCC ncc_DAO = new DAO_NCC();
		try {
			Nha_CC ncc = new Nha_CC(ma_nha_cung_cap, ten_nha_cung_cap, dia_chi, sdt, email);
			ncc_DAO.sua_NCC(ncc);
			response.sendRedirect("nhacungcap");

		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}

}
