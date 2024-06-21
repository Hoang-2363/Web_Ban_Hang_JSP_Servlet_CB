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
import page.model.Nha_CC;
import page.model.TT_HH_Mua;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hanghoa")
public class Hang_Hoa_List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sort = request.getParameter("sort");
		String gia = request.getParameter("gia_ban");
		String tu_khoa = request.getParameter("tu_khoa");

		Integer gia_int = null;

		String ma_lhh = request.getParameter("ma_lh");
		String[] ma_hang = request.getParameterValues("ma_ncc");
		String[] ma_hang_int = null;
		String port = "";
		if (ma_hang == null) {
			ma_hang_int = null;
			port = "";
		}

		Integer ma_lh;

		if (tu_khoa != null && !tu_khoa.equals("")) {
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			List<Hang_Hoa> list = d.TK_HH(tu_khoa);
			int page, numberpage = 6;
			int size = list.size();
			int num = (size % numberpage == 0 ? (size / 6) : ((size / 6) + 1));
			String xpage = request.getParameter("page");
			if (xpage == null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page - 1) * numberpage;
			end = Math.min(page * numberpage, size);

			List<Hang_Hoa> sp1 = d.getListByPage((ArrayList<Hang_Hoa>) list, start, end);
			request.setAttribute("data", sp1);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
		} else if (gia != null && !gia.equals("")) {
			gia_int = Integer.parseInt(gia);
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			List<Hang_Hoa> list = d.select_HH_Gia_Ban(gia_int);
			int page, numberpage = 6;
			int size = list.size();
			int num = (size % numberpage == 0 ? (size / 6) : ((size / 6) + 1));
			String xpage = request.getParameter("page");
			if (xpage == null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page - 1) * numberpage;
			end = Math.min(page * numberpage, size);

			List<Hang_Hoa> sp1 = d.getListByPage((ArrayList<Hang_Hoa>) list, start, end);
			request.setAttribute("data", sp1);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
			request.setAttribute("gia_ban", gia_int);
		} else if ("desc".equals(sort)) {
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			List<Hang_Hoa> list = d.select_HH_Gia_Giam();
			int page, numberpage = 6;
			int size = list.size();
			int num = (size % numberpage == 0 ? (size / 6) : ((size / 6) + 1));
			String xpage = request.getParameter("page");
			if (xpage == null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page - 1) * numberpage;
			end = Math.min(page * numberpage, size);

			List<Hang_Hoa> sp1 = d.getListByPage((ArrayList<Hang_Hoa>) list, start, end);
			request.setAttribute("data", sp1);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
		} else if ("asc".equals(sort)) {
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			List<Hang_Hoa> list = d.select_HH_Gia_Tang();
			int page, numberpage = 6;
			int size = list.size();
			int num = (size % numberpage == 0 ? (size / 6) : ((size / 6) + 1));
			String xpage = request.getParameter("page");
			if (xpage == null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page - 1) * numberpage;
			end = Math.min(page * numberpage, size);

			List<Hang_Hoa> sp1 = d.getListByPage((ArrayList<Hang_Hoa>) list, start, end);
			request.setAttribute("data", sp1);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
		} else if (ma_lhh != null) {
			ma_lh = Integer.valueOf(ma_lhh);
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			List<Hang_Hoa> list1 = d.select_HH_Ma_LHH(ma_lh);
			int page, numberpage = 6;
			int size = list1.size();
			int num = (size % numberpage == 0 ? (size / 6) : ((size / 6) + 1));
			String xpage = request.getParameter("page");
			if (xpage == null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page - 1) * numberpage;
			end = Math.min(page * numberpage, size);

			List<Hang_Hoa> sp1 = d.getListByPage((ArrayList<Hang_Hoa>) list1, start, end);
			request.setAttribute("data", sp1);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
			request.setAttribute("ma_lh", ma_lh);
		} else if (ma_hang != null) {
			ma_hang_int = new String[ma_hang.length];
			for (int i = 0; i < ma_hang_int.length; i++) {
				ma_hang_int[i] = ma_hang[i];
			}
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			List<Hang_Hoa> list2 = d.select_HH_Ma_NCC(ma_hang_int);
			int page, numberpage = 6;
			int size = list2.size();
			int num = (size % numberpage == 0 ? (size / 6) : ((size / 6) + 1));
			String xpage = request.getParameter("page");
			if (xpage == null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page - 1) * numberpage;
			end = Math.min(page * numberpage, size);

			List<Hang_Hoa> sp1 = d.getListByPage((ArrayList<Hang_Hoa>) list2, start, end);
			request.setAttribute("data", sp1);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
		} else {
			DAO_Hang_Hoa d = new DAO_Hang_Hoa();
			List<Hang_Hoa> list = d.select_HH();
			int page, numberpage = 6;
			int size = list.size();
			int num = (size % numberpage == 0 ? (size / 6) : ((size / 6) + 1));
			String xpage = request.getParameter("page");
			if (xpage == null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page - 1) * numberpage;
			end = Math.min(page * numberpage, size);

			List<Hang_Hoa> sp1 = d.getListByPage((ArrayList<Hang_Hoa>) list, start, end);
			request.setAttribute("data", sp1);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
		}

		DAO_Loai_HH d1 = new DAO_Loai_HH();
		List<Loai_HH> list1 = d1.selec_Loai_HH_SL();
		List<Nha_CC> list2 = d1.select_NCC();

		boolean[] ma_ncc_bl = new boolean[list2.size()];
		for (int i = 0; i < ma_ncc_bl.length; i++) {
			if (ischeck(list2.get(i).getMa_nha_cung_cap(), ma_hang_int)) {
				ma_ncc_bl[i] = true;
				port += "&ma_ncc=" + list2.get(i).getMa_nha_cung_cap();
			} else {
				ma_ncc_bl[i] = false;
				port += "";
			}
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
		request.setAttribute("data2", list2);
		request.setAttribute("data1", list1);
		request.setAttribute("ma_ncc_bol", ma_ncc_bl);
		request.setAttribute("port", port);
		request.setAttribute("sort", sort);
		request.setAttribute("tu_khoa", tu_khoa);
		request.getRequestDispatcher("page/shop.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean ischeck(String d, String[] ma_hang) {
		if (ma_hang == null) {
			return false;
		} else {
			for (int i = 0; i < ma_hang.length; i++) {
				if (ma_hang[i].equals(d)) {
					return true;
				}
			}
			return false;
		}
	}

}
