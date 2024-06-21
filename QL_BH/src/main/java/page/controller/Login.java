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
import page.dal.DAO_Khach_Hang;
import page.model.Gio_Hang;
import page.model.Hang_Hoa;
import page.model.Hoa_Don_BH;
import page.model.Khach_Hang;
import page.model.TT_HH_Mua;

import java.io.IOException;
import java.util.List;

@WebServlet("/trangchu")
public class Login extends HttpServlet {
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
		request.getRequestDispatcher("page/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tai_khoan = request.getParameter("tai_khoan");
		String mat_khau = request.getParameter("mat_khau");
		DAO_Khach_Hang d = new DAO_Khach_Hang();
		Khach_Hang kh = d.dang_nhap(tai_khoan, mat_khau);
		HttpSession session = request.getSession();

		if (kh == null) {
			request.setAttribute("status", "failed");
			request.getRequestDispatcher("page/dang_nhap.jsp").forward(request, response);
		} else {
			session.setAttribute("kh", kh);
			DAO_Gio_Hang hdd = new DAO_Gio_Hang();
			Hoa_Don_BH hdbh = hdd.mn_HDBH_Ma_KH(kh.getMa_kh());
			List<Hoa_Don_BH> list = hdd.select_HH_BH_Ma_KH(kh.getMa_kh());
			session.setAttribute("hdbh", hdbh);
			session.setAttribute("hdbhtm", list);
			request.getRequestDispatcher("page/index.jsp").forward(request, response);
		}
	}

}
