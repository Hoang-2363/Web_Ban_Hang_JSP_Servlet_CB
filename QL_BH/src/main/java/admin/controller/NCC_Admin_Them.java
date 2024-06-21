package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Nha_CC;

import java.io.IOException;

import admin.dal.DAO_NCC;

@WebServlet("/admin/themnhacungcap")
public class NCC_Admin_Them extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("nhacungcapthem.jsp").forward(request, response);
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
		Nha_CC ncc = new Nha_CC(ma_nha_cung_cap, ten_nha_cung_cap, dia_chi, sdt, email);
		try {
			Nha_CC ncc1 = ncc_DAO.getNCCByMaNCC(ma_nha_cung_cap);
			Nha_CC ncc2 = ncc_DAO.getNCCByTenNCC(ten_nha_cung_cap, sdt, email);
			if (ncc1 == null && ncc2 == null) {
				ncc_DAO.them_NCC(ncc);
				response.sendRedirect("nhacungcap");
			} else {
				request.setAttribute("error", ten_nha_cung_cap + " hoặc " + sdt + " hoặc " + email + " đã tồn tại!");
				request.getRequestDispatcher("nhacungcapthem.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
