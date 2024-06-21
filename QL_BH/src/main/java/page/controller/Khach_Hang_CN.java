package page.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import page.dal.DAO_Hang_Hoa;
import page.dal.DAO_Khach_Hang;
import page.model.Gio_Hang;
import page.model.Hang_Hoa;
import page.model.Khach_Hang;
import page.model.TT_HH_Mua;

import java.io.IOException;
import java.util.List;

@WebServlet("/khachhang")
public class Khach_Hang_CN extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_Hang_Hoa d5 = new DAO_Hang_Hoa();
		List<Hang_Hoa> list5 = d5.select_HH();
		Cookie[] arr = request.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("gio_hang")) {
					txt += o.getValue();
				}
			}
		}
		Gio_Hang gio_hang = new Gio_Hang(txt, list5);
		List<TT_HH_Mua> listItems = gio_hang.getItems();
		int n;
		if (listItems != null) {
			n = listItems.size();
		} else {
			n = 0;
		}
		request.setAttribute("size", n);
		request.getRequestDispatcher("page/khach_hang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten_kh = request.getParameter("ten_kh");
		String sdt = request.getParameter("sdt");
		String anh = request.getParameter("anh");
		String dia_chi = request.getParameter("dia_chi");
		String tai_khoan = request.getParameter("tai_khoan");
		String mat_khau = request.getParameter("mat_khau");
		String ma_kh = request.getParameter("ma_kh");

		HttpSession session = request.getSession();
		DAO_Khach_Hang d = new DAO_Khach_Hang();
		int ma_kh_int = Integer.parseInt(ma_kh);
		d.cap_nhat(ten_kh, sdt, anh, dia_chi, tai_khoan, mat_khau, ma_kh_int);

		Khach_Hang kh = new Khach_Hang(ma_kh_int, ten_kh, anh, sdt, dia_chi, tai_khoan, mat_khau);
		
		DAO_Hang_Hoa d5 = new DAO_Hang_Hoa();
		List<Hang_Hoa> list5 = d5.select_HH();
		Cookie[] arr = request.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("gio_hang")) {
					txt += o.getValue();
				}
			}
		}
		Gio_Hang gio_hang = new Gio_Hang(txt, list5);
		List<TT_HH_Mua> listItems = gio_hang.getItems();
		int n;
		if (listItems != null) {
			n = listItems.size();
		} else {
			n = 0;
		}
		request.setAttribute("size", n);
		session.setAttribute("kh", kh);
		request.getRequestDispatcher("page/khach_hang.jsp").forward(request, response);
	}

}
