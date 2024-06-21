package page.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.dal.DAO_Khach_Hang;

import java.io.IOException;

@WebServlet("/forgot")
public class Quen_MK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("page/quen_mk.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten_kh = request.getParameter("ten_kh");
		String sdt = request.getParameter("sdt");
		String tai_khoan = request.getParameter("tai_khoan");
		String mat_khau_moi = request.getParameter("mat_khau_moi");
		String mat_khau_moi_nl = request.getParameter("mat_khau_moi_nl");

		DAO_Khach_Hang d = new DAO_Khach_Hang();
		String sdt_new = d.sdt(sdt);
		String ht_KH_new = d.ho_ten_KH(ten_kh, sdt, tai_khoan);
		String ten_TK_new = d.ten_TK(ten_kh, sdt, tai_khoan);

		if (sdt_new == null) {
			request.setAttribute("error2", "*" + sdt + " không tồn tại!*");
			request.getRequestDispatcher("page/quen_mk.jsp").forward(request, response);
		} else if (ht_KH_new == null) {
			request.setAttribute("error1", "*" + ten_kh + " không tồn tại!*");
			request.getRequestDispatcher("page/quen_mk.jsp").forward(request, response);
		} else if (ten_TK_new == null) {
			request.setAttribute("error3", "*" + tai_khoan + " không tồn tại!*");
			request.getRequestDispatcher("page/quen_mk.jsp").forward(request, response);
		} else if (!mat_khau_moi.equals(mat_khau_moi_nl)) {
			request.setAttribute("error4", "*Mật khẩu không trùng nhau!*");
			request.getRequestDispatcher("page/quen_mk.jsp").forward(request, response);
		} else {
			d.doi_mk(ten_kh, sdt, tai_khoan, mat_khau_moi);
			request.getRequestDispatcher("page/dang_nhap.jsp").forward(request, response);
		}
	}

}
