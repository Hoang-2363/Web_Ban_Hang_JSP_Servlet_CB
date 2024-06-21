package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import admin.dal.DAO_Hang_Hoa;
import admin.dal.LSX_Anh;

@WebServlet("/admin/xoahanghoa")
public class Hang_Hoa_Admin_Xoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_hh = request.getParameter("ma_hang");
		int ma_hh_int = Integer.parseInt(ma_hh);
		DAO_Hang_Hoa kh_DAO = new DAO_Hang_Hoa();
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\hanghoa\\";

		LSX_Anh image = new LSX_Anh();
		image.Xoa_Anh(url + kh_DAO.anh_hh(ma_hh_int));
		kh_DAO.xoa_HH(ma_hh_int);
		response.sendRedirect("hanghoa");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
