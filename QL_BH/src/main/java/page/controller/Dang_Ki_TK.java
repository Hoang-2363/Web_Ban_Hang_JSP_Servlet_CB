package page.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.dal.DAO_Khach_Hang;

import java.io.IOException;

@WebServlet("/signup")
public class Dang_Ki_TK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("page/dang_ky.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten_kh = request.getParameter("ten_kh");
		String sdt = request.getParameter("sdt");
		String dia_chi = request.getParameter("dia_chi");
		String tai_khoan = request.getParameter("tai_khoan");
		String mat_khau = request.getParameter("mat_khau");

		DAO_Khach_Hang d = new DAO_Khach_Hang();
		String sdt_new = d.sdt(sdt);
		if (sdt_new == null) {
			d.them_tk_kh(ten_kh, sdt, dia_chi, tai_khoan, mat_khau);
			request.getRequestDispatcher("page/dang_nhap.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "*" + sdt + " đã tồn tại!*");
			request.getRequestDispatcher("page/dang_ky.jsp").forward(request, response);
		}
	}

}
