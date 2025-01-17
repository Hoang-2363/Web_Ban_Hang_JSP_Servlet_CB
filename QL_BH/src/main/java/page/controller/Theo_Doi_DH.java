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
import page.model.Khach_Hang;
import page.model.TT_HH_Mua;

import java.io.IOException;
import java.util.List;

@WebServlet("/theodoidh")
public class Theo_Doi_DH extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_Gio_Hang d = new DAO_Gio_Hang();
		HttpSession session = request.getSession();
		Khach_Hang kh = (Khach_Hang) session.getAttribute("kh");
		if(kh == null) {
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
			request.getRequestDispatcher("page/theodoi_dh.jsp").forward(request, response);
		} else {
			List<Hoa_Don_BH> list1 = d.select_HH_BH_Ma_KH(kh.getMa_kh());
			List<Hoa_Don_BH> list2 = d.select_HH_BH_Ma_KH_Chua_GTC(kh.getMa_kh());
			System.out.println(kh.getMa_kh());
			
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
			session.setAttribute("hdbhtm", list1);
			session.setAttribute("list2", list2);
			request.getRequestDispatcher("page/theodoi_dh.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
