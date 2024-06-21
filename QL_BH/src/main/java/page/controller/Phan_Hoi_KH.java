package page.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.dal.DAO_Hang_Hoa;
import page.dal.DAO_Khach_Hang;
import page.model.Gio_Hang;
import page.model.Hang_Hoa;
import page.model.TT_HH_Mua;

import java.io.IOException;
import java.util.List;

@WebServlet("/phanhoi")
public class Phan_Hoi_KH extends HttpServlet {
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
		request.getRequestDispatcher("page/phan_hoi_kh.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tin_nhan = request.getParameter("tin_nhan");
		String sdt = request.getParameter("sdt");

		DAO_Khach_Hang d = new DAO_Khach_Hang();
		d.them_PH(sdt, tin_nhan);
		request.getRequestDispatcher("page/phan_hoi_kh.jsp").forward(request, response);
	}

}
