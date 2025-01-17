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

@WebServlet("/themhhgiohang")
public class Them_HH_Gio_Hang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
		String so_luong_raw = request.getParameter("so_luong");
		String ma_hang_raw = request.getParameter("ma_hang");
		String thongtinct = request.getParameter("thongtinct");
		DAO_Hang_Hoa dao_hh = new DAO_Hang_Hoa();
		Hang_Hoa hh_01 = dao_hh.select_HH_NCC_LHH_Ma_LHH(Integer.parseInt(ma_hang_raw));
		int n;
		if (Integer.parseInt(so_luong_raw) > hh_01.getSo_luong()) {
			Cookie c = new Cookie("gio_hang", txt);
			c.setMaxAge(5 * 60);
			response.addCookie(c);
			Gio_Hang cart = new Gio_Hang(txt, list);
			List<TT_HH_Mua> listItems = cart.getItems();
			if (listItems != null) {
				n = listItems.size();
			} else {
				n = 0;
			}
		} else {
			if (txt.isEmpty()) {
				txt = ma_hang_raw + ":" + so_luong_raw;
			} else {
				txt = txt + "*" + ma_hang_raw + ":" + so_luong_raw;
			}
			int so_luong_da_mua = 0;
			String[] s = txt.split("\\*");
			for (String i : s) {
				String[] n_01 = i.split(":");
				int ma_hang_dm = Integer.parseInt(n_01[0]);
				int so_luong = Integer.parseInt(n_01[1]);
				if (ma_hang_dm == Integer.parseInt(ma_hang_raw)) {
					so_luong_da_mua += so_luong;
				}
			}
			if (so_luong_da_mua > hh_01.getSo_luong()) {
				txt = txt + "*" + ma_hang_raw + ":" + -1;
				Cookie c = new Cookie("gio_hang", txt);
				c.setMaxAge(5 * 60);
				response.addCookie(c);
				Gio_Hang cart = new Gio_Hang(txt, list);
				List<TT_HH_Mua> listItems = cart.getItems();
				if (listItems != null) {
					n = listItems.size();
				} else {
					n = 0;
				}
			} else {
				Cookie c = new Cookie("gio_hang", txt);
				c.setMaxAge(5 * 60);
				response.addCookie(c);
				Gio_Hang cart = new Gio_Hang(txt, list);
				List<TT_HH_Mua> listItems = cart.getItems();
				if (listItems != null) {
					n = listItems.size();
				} else {
					n = 0;
				}
			}
		}
		if (thongtinct == "1") {
			int m;
			if (Integer.parseInt(so_luong_raw) > hh_01.getSo_luong()) {
				Cookie c = new Cookie("gio_hang", txt);
				c.setMaxAge(5 * 60);
				response.addCookie(c);
				Gio_Hang cart = new Gio_Hang(txt, list);
				List<TT_HH_Mua> listItems = cart.getItems();
				if (listItems != null) {
					m = listItems.size();
				} else {
					m = 0;
				}
			} else {
				if (txt.isEmpty()) {
					txt = ma_hang_raw + ":" + so_luong_raw;
				} else {
					txt = txt + "*" + ma_hang_raw + ":" + so_luong_raw;
				}
				Cookie c = new Cookie("gio_hang", txt);
				c.setMaxAge(5 * 60);
				response.addCookie(c);
				Gio_Hang cart = new Gio_Hang(txt, list);
				List<TT_HH_Mua> listItems = cart.getItems();
				if (listItems != null) {
					m = listItems.size();
				} else {
					m = 0;
				}
				Integer ma_h = 0;
				try {
					ma_h = Integer.parseInt(ma_hang_raw);
					DAO_Hang_Hoa d = new DAO_Hang_Hoa();
					Hang_Hoa list11 = d.select_HH_NCC_LHH_Ma_LHH(ma_h);
					List<Hang_Hoa> list22 = d.SP_Tuong_tu(ma_h);

					request.setAttribute("data", list11);
					request.setAttribute("data1", list22);
					DAO_Loai_HH d11 = new DAO_Loai_HH();
					List<Loai_HH> list222 = d11.selec_Loai_HH_SL();
					request.setAttribute("ma_lh", list222);
				} catch (Exception e) {
					System.out.println(e);
				}
				DAO_Hang_Hoa d5 = new DAO_Hang_Hoa();
				List<Hang_Hoa> list5 = d5.select_HH();
				Cookie[] arr11 = request.getCookies();
				String txt1 = "";
				if (arr11 != null) {
					for (Cookie o : arr11) {
						if (o.getName().equals("gio_hang")) {
							txt1 += o.getValue();
						}
					}
				}
				Gio_Hang gio_hang = new Gio_Hang(txt1, list5);
				List<TT_HH_Mua> listItems1 = gio_hang.getItems();
				if (listItems1 != null) {
					m = listItems1.size();
				} else {
					m = 0;
				}
			}
			request.setAttribute("size", m);
			request.getRequestDispatcher("thongtinhh?ma_hang=" + ma_hang_raw).forward(request, response);
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
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
