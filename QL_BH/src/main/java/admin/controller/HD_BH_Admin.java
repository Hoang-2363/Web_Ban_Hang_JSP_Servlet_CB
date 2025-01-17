package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Hoa_Don_BH;

import java.io.IOException;
import java.util.List;

import admin.dal.DAO_Hoa_Don_BH;

@WebServlet("/admin/hdbanhang")
public class HD_BH_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String duyethd = request.getParameter("duyethd");
		String ma_hd_bh = request.getParameter("ma_hd_bh");
		String id_nv = request.getParameter("id_nv");
		if (duyethd != null && duyethd.equals("1") && ma_hd_bh != null && id_nv != null) {
			DAO_Hoa_Don_BH d = new DAO_Hoa_Don_BH();
			d.cap_nhat_dang_gh(id_nv, ma_hd_bh);
			List<Hoa_Don_BH> list = d.selec_HD_BH();
			request.setAttribute("data", list);
		} else if (duyethd != null && duyethd.equals("2") && ma_hd_bh != null) {
			DAO_Hoa_Don_BH d = new DAO_Hoa_Don_BH();
			d.cap_nhat_ghtc(ma_hd_bh);
			List<Hoa_Don_BH> list = d.selec_HD_BH();
			request.setAttribute("data", list);
		} else {
			DAO_Hoa_Don_BH d = new DAO_Hoa_Don_BH();
			List<Hoa_Don_BH> list = d.selec_HD_BH();
			request.setAttribute("data", list);
		}
		request.getRequestDispatcher("hd_bh.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
