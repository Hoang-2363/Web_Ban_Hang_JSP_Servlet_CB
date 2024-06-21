package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import page.model.Loai_HH;

import java.io.IOException;

import admin.dal.DAO_Loai_HH;
import admin.dal.LSX_Anh;

@WebServlet("/admin/sualoaihh")
@MultipartConfig
public class Loai_HH_Admin_Sua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_lhh = request.getParameter("ma_loai_hang");
		int ma_lhh_int = Integer.parseInt(ma_lhh);
		DAO_Loai_HH lhh_DAO = new DAO_Loai_HH();
		Loai_HH lhh = lhh_DAO.getLHHByMaLHH(ma_lhh_int);
		request.setAttribute("lhh", lhh);
		request.getRequestDispatcher("loaihanghoasua.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ma_loai_hang = request.getParameter("ma_loai_hang");
		String ten_loai_hang = request.getParameter("ten_loai_hang");
		String anh = request.getParameter("anh");
		String ghi_chu = request.getParameter("ghi_chu");

		String image_new = null;
		Part part = request.getPart("file");
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\loai_hh";

		int ma_lhh;
		DAO_Loai_HH lhh_DAO = new DAO_Loai_HH();
		try {
			ma_lhh = Integer.parseInt(ma_loai_hang);
			Loai_HH lhh_01 = lhh_DAO.getLHHByMaLHH(ma_lhh);
			if (!anh.equals(lhh_01.getAnh())) {
				LSX_Anh image = new LSX_Anh();
				image.Xoa_Anh(url + "\\" + lhh_01.getAnh());
				image_new = image.Ten_Anh(part, url);
				image.Luu_Anh(part, url);
			} else {
				image_new = anh;
			}
			Loai_HH loai_HH = new Loai_HH(ma_lhh, ten_loai_hang, image_new, ghi_chu);
			lhh_DAO.sua_LHH(loai_HH);
			response.sendRedirect("loaihanghoa");

		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
