package page.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.dal.DAO_Hang_Hoa;
import page.dal.DAO_Loai_HH;
import page.model.Gio_Hang;
import page.model.Hang_Hoa;
import page.model.Loai_HH;
import page.model.TT_HH_Mua;

import java.io.IOException;
import java.util.List;

@WebServlet("/thongtinhh")
public class Thong_Tin_HH extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_hang = request.getParameter("ma_hang");
		Integer ma_h = 0;
		try {
			ma_h = Integer.parseInt(ma_hang);
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			Hang_Hoa list = d.select_HH_NCC_LHH_Ma_LHH(ma_h);
			List<Hang_Hoa> list1 = d.SP_Tuong_tu(ma_h);

			request.setAttribute("data", list);
			request.setAttribute("data1", list1);
			DAO_Loai_HH d1 = new DAO_Loai_HH();
			List<Loai_HH> list2 = d1.selec_Loai_HH_SL();
			request.setAttribute("ma_lh", list2);
		} catch (Exception e) {
			System.out.println(e);
		}
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
		request.getRequestDispatcher("page/thongtinhanghoa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
