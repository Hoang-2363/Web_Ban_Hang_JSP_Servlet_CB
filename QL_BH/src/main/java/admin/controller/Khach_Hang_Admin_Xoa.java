package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Khach_Hang;

import java.io.IOException;

import admin.dal.DAO_Khach_Hang;
import admin.dal.LSX_Anh;

@WebServlet("/admin/xoakhachhang")
@MultipartConfig
public class Khach_Hang_Admin_Xoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_kh = request.getParameter("ma_kh");
		int ma_kh_int = Integer.parseInt(ma_kh);
		DAO_Khach_Hang kh_DAO = new DAO_Khach_Hang();
		Khach_Hang kh = kh_DAO.getkhByMakh(ma_kh_int);
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\khachhang\\";

		LSX_Anh image = new LSX_Anh();
		image.Xoa_Anh(url + kh.getAnh());
		kh_DAO.xoa_kh(ma_kh_int);
		response.sendRedirect("khachhang");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
