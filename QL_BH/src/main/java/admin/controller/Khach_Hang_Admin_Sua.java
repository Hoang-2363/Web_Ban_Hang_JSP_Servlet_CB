package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import page.model.Khach_Hang;

import java.io.IOException;

import admin.dal.DAO_Khach_Hang;
import admin.dal.LSX_Anh;

@WebServlet("/admin/suakhachhang")
@MultipartConfig
public class Khach_Hang_Admin_Sua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_kh = request.getParameter("ma_kh");
		int ma_kh_int = Integer.parseInt(ma_kh);
		DAO_Khach_Hang kh_DAO = new DAO_Khach_Hang();
		Khach_Hang kh = kh_DAO.getkhByMakh(ma_kh_int);
		request.setAttribute("kh", kh);
		request.getRequestDispatcher("khachhangsua.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ma_kh = request.getParameter("ma_kh");
		String ten_kh = request.getParameter("ten_kh");
		String anh = request.getParameter("anh");
		String sdt = request.getParameter("sdt");
		String dia_chi = request.getParameter("dia_chi");

		String image_new = null;
		Part part = request.getPart("file");
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\khachhang";

		int ma_kh_int;
		DAO_Khach_Hang kh_DAO = new DAO_Khach_Hang();
		try {
			ma_kh_int = Integer.parseInt(ma_kh);
			Khach_Hang kh1 = kh_DAO.getkhByMakh(ma_kh_int);
			if (!anh.equals(kh1.getAnh())) {
				LSX_Anh image = new LSX_Anh();
				image.Xoa_Anh(url + "\\" + kh1.getAnh());
				image_new = image.Ten_Anh(part, url);
				image.Luu_Anh(part, url);
			} else {
				image_new = anh;
			}
			Khach_Hang kh = new Khach_Hang(ma_kh_int, ten_kh, image_new, sdt, dia_chi);
			kh_DAO.sua_kh(kh);
			response.sendRedirect("khachhang");

		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
