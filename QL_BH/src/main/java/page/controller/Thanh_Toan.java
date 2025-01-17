package page.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import page.dal.DAO_Gio_Hang;
import page.dal.DAO_Hang_Hoa;
import page.model.Gio_Hang;
import page.model.Hang_Hoa;
import page.model.Hoa_Don_BH;
import page.model.TT_HH_Mua;

import java.io.IOException;
import java.util.List;

@WebServlet("/dathang")
public class Thanh_Toan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_Hang_Hoa hhd = new DAO_Hang_Hoa();
		List<Hang_Hoa> list = hhd.select_HH();
		Cookie[] arr = request.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("gio_hang")) {
					txt += o.getValue();
				}
			}
		}
		page.model.Gio_Hang cart = new page.model.Gio_Hang(txt, list);
		request.setAttribute("cart", cart);

		DAO_Hang_Hoa d5 = new DAO_Hang_Hoa();
		List<Hang_Hoa> list5 = d5.select_HH();
		Gio_Hang gio_hang = new Gio_Hang(txt, list5);
		List<TT_HH_Mua> listItems = gio_hang.getItems();
		int n;
		if (listItems != null) {
			n = listItems.size();
		} else {
			n = 0;
		}
		request.setAttribute("size", n);
		request.getRequestDispatcher("page/hoadonbh.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_kh = request.getParameter("ma_kh");
		DAO_Gio_Hang hdd = new DAO_Gio_Hang();
		DAO_Hang_Hoa hhd = new DAO_Hang_Hoa();
		List<Hang_Hoa> list = hhd.select_HH();
		Cookie[] arr = request.getCookies();
		HttpSession session = request.getSession();

		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("gio_hang")) {
					txt += o.getValue();
				}
			}
		}
		page.model.Gio_Hang cart = new page.model.Gio_Hang(txt, list);
		if (ma_kh.isEmpty())
			request.getRequestDispatcher("page/dang_nhap.jsp").forward(request, response);
		else {
			hdd.them_HD(ma_kh, cart);
			Cookie c = new Cookie("gio_hang", "");
			c.setMaxAge(0);
			response.addCookie(c);
			Hoa_Don_BH hdbh = hdd.mn_HDBH_Ma_KH(Integer.parseInt(ma_kh));
			session.setAttribute("hdbh", hdbh);
			response.sendRedirect("trangchu");
		}
	}

}
