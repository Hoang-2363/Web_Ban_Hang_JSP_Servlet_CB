package page.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.dal.DAO_Hang_Hoa;
import page.model.Hang_Hoa;
import page.model.TT_HH_Mua;
import page.model.Gio_Hang;

import java.io.IOException;
import java.util.List;

@WebServlet("/giohangxuly")
public class Gio_Hang_TSX extends HttpServlet {
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
					o.setMaxAge(0);
					response.addCookie(o);
				}
			}
		}
		Gio_Hang cart = new Gio_Hang(txt, list);
		String so_luong_raw = request.getParameter("so_luong");
		String ma_hang_raw = request.getParameter("ma_hang");
		Integer num = null;
		try {
			Hang_Hoa hh = hhd.select_HH_NCC_LHH_Ma_LHH(Integer.parseInt(ma_hang_raw));
			int numStore = hh.getSo_luong();
			num = Integer.valueOf(so_luong_raw);
			if (num == -1 && cart.getSo_LuongByMa_hang(Integer.parseInt(ma_hang_raw)) <= 1) {
				cart.xoa_HH_Mua(Integer.parseInt(ma_hang_raw));
			} else if (num == -1 && cart.getSo_LuongByMa_hang(Integer.parseInt(ma_hang_raw)) > 1) {
				cart.addHH_Mua(Integer.parseInt(ma_hang_raw), num);
			} else {
				if (num == 1 && cart.getSo_LuongByMa_hang(Integer.parseInt(ma_hang_raw)) >= numStore) {
					cart.xoa_HH_Mua(Integer.parseInt(ma_hang_raw));
				} else {
					cart.addHH_Mua(Integer.parseInt(ma_hang_raw), num);
				}
			}

		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		List<TT_HH_Mua> items = cart.getItems();
		txt = "";
		if (!items.isEmpty()) {
			txt = items.get(0).getHang_hoa().getMa_hang() + ":" + items.get(0).getSo_luong();
			for (int i = 1; i < items.size(); i++) {
				txt += "*" + items.get(i).getHang_hoa().getMa_hang() + ":" + items.get(i).getSo_luong();
			}
		}

		Cookie c = new Cookie("gio_hang", txt);
		c.setMaxAge(5 * 60);
		response.addCookie(c);
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
		request.getRequestDispatcher("page/gio_hang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		DAO_Hang_Hoa hhd = new DAO_Hang_Hoa();
//		List<Hang_Hoa> list = hhd.select_HH();
//		Cookie[] arr = request.getCookies();
//		String txt = "";
//		if (arr != null) {
//			for (Cookie o : arr) {
//				if (o.getName().equals("gio_hang")) {
//					txt += o.getValue();
//					o.setMaxAge(0);
//					response.addCookie(o);
//				}
//			}
//		}
//		String ma_hang = request.getParameter("ma_hang");
//		String[] ma_hang_s = txt.split("\\*");
//		StringBuilder out = new StringBuilder();
//		for (String ma_hang_ : ma_hang_s) {
//			String[] s = ma_hang_.split(":");
//			if (!s[0].equals(ma_hang)) {
//				if (out.length() > 0) {
//					out.append("*");
//				}
//				out.append(ma_hang_);
//			}
//		}
//		if (!out.isEmpty()) {
//			Cookie c = new Cookie("gio_hang", out.toString());
//			c.setMaxAge(5 * 60);
//			response.addCookie(c);
//		}
//		Gio_Hang cart = new Gio_Hang(out.toString(), list);
//		request.setAttribute("cart", cart);
//		request.getRequestDispatcher("page/gio_hang.jsp").forward(request, response);
		
		DAO_Hang_Hoa hhd = new DAO_Hang_Hoa();
		List<Hang_Hoa> list = hhd.select_HH();
		Cookie[] arr = request.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("gio_hang")) {
					txt += o.getValue();
					o.setMaxAge(0);
					response.addCookie(o);
				}
			}
		}
		Gio_Hang cart = new Gio_Hang(txt, list);
		String ma_hang_raw = request.getParameter("ma_hang");
		cart.xoa_HH_Mua(Integer.parseInt(ma_hang_raw));
		List<TT_HH_Mua> items = cart.getItems();
		txt = "";
		if (!items.isEmpty()) {
			txt = items.get(0).getHang_hoa().getMa_hang() + ":" + items.get(0).getSo_luong();
			for (int i = 1; i < items.size(); i++) {
				txt += "*" + items.get(i).getHang_hoa().getMa_hang() + ":" + items.get(i).getSo_luong();
			}
		}

		Cookie c = new Cookie("gio_hang", txt);
		c.setMaxAge(5 * 60);
		response.addCookie(c);
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
		request.getRequestDispatcher("page/gio_hang.jsp").forward(request, response);
	}

}
